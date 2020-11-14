package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modele.Cartouche;
import Modele.Imprimante;
import Modele.TypeImprimante;

public class DAOImprimante extends DAO<Imprimante,String> {
	
	public Vector<Imprimante> findAll(){

		String req = "SELECT * FROM IMPRIMANTE NATURAL JOIN TYPE";
		
		Vector<Imprimante> vImp = new Vector<Imprimante>();
		
		try {
			Connection con = PostGreConnection.getInstance();
			Statement stat = con.createStatement();
			ResultSet resultat = stat.executeQuery(req);

			while (resultat.next() )
			{
				String ref = resultat.getString("refimprimante");
				String des = resultat.getString("desimprimante");
				char codeType = resultat.getString("codetype").charAt(0);
				String libelleType = resultat.getString("libelletype");
				TypeImprimante typeImp = new TypeImprimante(codeType, libelleType);
				Imprimante imp = new Imprimante(ref, typeImp, des, new ArrayList<Cartouche>());
				vImp.add(imp);
			}
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return vImp;
		
	}
	
	public int getNbCartoucheCompatible(String ref) {
		
		String req = "SELECT COUNT(*) AS nbcartouche FROM ACCEPTER WHERE refimprimante ='" + ref +"'";
		
		int nb = 0;
		
		try {
			ResultSet resultat = PostGreConnection.getInstance().createStatement().executeQuery(req);

			while (resultat.next() )
			{
				nb = resultat.getInt("nbcartouche");
			}
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}
		
		return nb;
	}

	@Override
	public Imprimante find(String id) {
		
		String req = "SELECT * FROM IMPRIMANTE where refimprimante ="+id+"'";
		
		Imprimante vImp = new Imprimante();
		DAOTypeImprimante daotype = new DAOTypeImprimante();
		
		try {
			Connection con = PostGreConnection.getInstance();
			Statement stat = con.createStatement();
			ResultSet resultat = stat.executeQuery(req);

			while (resultat.next() )
			{
				String ref = resultat.getString("refimprimante");
				String des = resultat.getString("desimprimante");
				TypeImprimante codeType = daotype.find(resultat.getString("codetype"));
				vImp = new Imprimante(ref, codeType, des, new ArrayList<Cartouche>());
			}
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return vImp;
	}

	@Override
	public void create(Imprimante var) {
		
		String ref = var.getRefImprimante();
		String des = var.getDesImprimante();
		char type = var.getTypeImprimante().getCodeType();

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("INSERT INTO IMPRIMANTE VALUES (?,?,?)");
			stmt.setString(1, ref);
			stmt.setString(2, des);
			stmt.setString(3, Character.toString(type));
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void update(Imprimante var) {
		
		String newDes = "desc imprimante";

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("update imprimante set desimprimante = ? where refimprimante = ?");
			stmt.setString(1, newDes);
			stmt.setString(2, var.getRefImprimante());
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void delete(Imprimante var) {
		
		String ref = var.getRefImprimante();

		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("delete from imprimante where refimprimante = ?");
			stmt.setString(1, ref);
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
