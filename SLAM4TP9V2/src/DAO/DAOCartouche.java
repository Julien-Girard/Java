package DAO;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modele.Cartouche;
import Modele.TypeImprimante;

public class DAOCartouche extends DAO<Cartouche,String> {
	
	public Vector<Cartouche> findAll() {
		
		String req = "SELECT * FROM CARTOUCHE";
		
		Vector<Cartouche> vCartouche = new Vector<Cartouche>();
		
		try {
			
			ResultSet resultat = PostGreConnection.getInstance().createStatement().executeQuery(req);
			
			while (resultat.next() )
			{
				String refCar = resultat.getString("refcartouche");
				String descCar = resultat.getString("descartouche");
				String prixCarInt = resultat.getString("prixcartouche");
				double prixCar = Double.parseDouble(prixCarInt);
				Cartouche cartouche = new Cartouche(refCar, descCar, prixCar);
				vCartouche.add(cartouche);
			}
			
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return vCartouche;
	}

	@Override
	public Cartouche find(String id) {
		
		String req = "SELECT * FROM CARTOUCHE where refcartouche ='"+id+"'";
		
		Cartouche vCartouche = new Cartouche();
		
		try {
			
			ResultSet resultat = PostGreConnection.getInstance().createStatement().executeQuery(req);
			
			while (resultat.next() )
			{
				String refCar = resultat.getString("refcartouche");
				String descCar = resultat.getString("descartouche");
				String prixCarInt = resultat.getString("prixcartouche");
				double prixCar = Double.parseDouble(prixCarInt);
				vCartouche = new Cartouche(refCar, descCar, prixCar);
			}
			
		}catch(SQLException e){
			System.out.println("problème lors de la connexion à la bd "+e);
		}

		return vCartouche;
	}

	@Override
	public void create(Cartouche var) {
		
		String req = "INSERT INTO CARTOUCHE VALUES ('"+ var.getRefCartouche() +"', '"+ var.getDesCartouche() +"', "+ var.getPrixNeuve() +")";
		
		try {
			PostGreConnection.getInstance().createStatement().executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Insertion Réussi");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Insertion échoué");
			System.out.println("problème lors de la connexion à la bd "+e);
		}
		
	}

	@Override
	public void update(Cartouche var) {
		
		String newDes = "desc cartouche";
		double newPrix = 58;
		
		try {
			PreparedStatement stmt = super.getConnection().prepareStatement("update cartouche set descartouche = ?, prixcartouche = ? where refcartouche = ?");
			stmt.setString(1, newDes);
			stmt.setDouble(2, newPrix);
			stmt.setString(3, var.getRefCartouche());
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void delete(Cartouche var) {
		
		String req = "delete from cartouche where refcartouche = '"+var.getRefCartouche()+"'";
		
		try {
			PostGreConnection.getInstance().createStatement().executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Cartouche modifié");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Modification échoué");
			System.out.println("problème lors de la connexion à la bd "+e);
		}
		
	}
	
	
}
