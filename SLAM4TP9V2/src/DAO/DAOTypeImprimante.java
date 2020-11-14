package DAO;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modele.TypeImprimante;

public class DAOTypeImprimante extends DAO<TypeImprimante,String> {
	
	public Vector<TypeImprimante> findAll() {

		String req = "SELECT * FROM TYPE";
		
		Vector<TypeImprimante> vTypeImp = new Vector<TypeImprimante>();
		
		try {
			ResultSet resultat = PostGreConnection.getInstance().createStatement().executeQuery(req);

			while (resultat.next() )
			{
				char codeType = resultat.getString("codetype").charAt(0);
				String libelleType = resultat.getString("libelletype");
				TypeImprimante typeImp = new TypeImprimante(codeType, libelleType);
				vTypeImp.add(typeImp);
			}
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return vTypeImp;
		
	}
	
	public TypeImprimante find(String id) {
		
		String req = "SELECT * FROM TYPE where codetype ='"+id+"'";
		TypeImprimante typeImp = new TypeImprimante();
		
		try {
			ResultSet resultat = PostGreConnection.getInstance().createStatement().executeQuery(req);
			while (resultat.next() )
			{
				char codeType = resultat.getString("codetype").charAt(0);
				String libelleType = resultat.getString("libelletype");
				typeImp = new TypeImprimante(codeType, libelleType);
			}
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return typeImp;
		
	}

	@Override
	public void create(TypeImprimante var) {
		
		String lib = var.getLibType();
		char type = var.getCodeType();

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("INSERT INTO type VALUES (?,?)");
			stmt.setString(2, lib);
			stmt.setString(1, Character.toString(type));
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void update(TypeImprimante var) {

		String lib = var.getLibType();
		char type = var.getCodeType();

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("update type set libelletype = ? where codetype = ?");
			stmt.setString(1, lib);
			stmt.setString(2, Character.toString(type));
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void delete(TypeImprimante var) {
		
		char type = var.getCodeType();

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("delete from type where codetype = ?");
			stmt.setString(1, Character.toString(type));
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
