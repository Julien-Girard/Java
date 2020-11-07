package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Modele.Medecin;
import Modele.Specialite;

public class DAOMedecin {

	
	public static Vector<Medecin> retieveAll() {
		
		Vector<Medecin> res = new Vector<Medecin>();
		
		String requete = "SELECT * FROM Medecin";
		try {
			Connection con = MysqlConnectionSingleton2.getInstance();
			Statement stLienBd = con.createStatement();
			ResultSet resultat = stLienBd.executeQuery(requete);

			String requeteSpe = "Select * from Specialite where id=" + resultat.getInt(6);
			Specialite resultatSpe = (Specialite) stLienBd.executeQuery(requeteSpe);
			
			while ( resultat.next() )
			{
				Medecin med = new Medecin(resultat.getInt(0),resultat.getString(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5),resultatSpe);
				res.add(med);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return res;
		
	}
	
	
	
	public void create(Medecin med) {
		
		String requeteSpe = "select id from Specialite where libelle='" + med.getSpecialite().toString() + "';";
		
		System.out.println(requeteSpe);
		
		Connection con = MysqlConnectionSingleton2.getInstance();
		
		int resSpe = 1;
		
		try {
			Statement stLienBd = con.createStatement();
			ResultSet resultat = stLienBd.executeQuery(requeteSpe);
			while(resultat.next()) {
				resSpe=resultat.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String requete = "INSERT INTO Medecin VALUES ('";
		requete += med.getId()+"','";
		requete += med.getNom()+"','";
		requete += med.getPrenom()+"','";
		requete += med.getAdresse()+"','";
		requete += med.getTelephone()+"','";
		requete += med.getEmail()+"','";
		requete += resSpe +"','";
		requete += med.getInfos()+"');"
		;
		System.out.println(requete);
		
		
		try {
			Statement stLienBd = con.createStatement();
			int resultat = stLienBd.executeUpdate(requete);
			System.out.println("Nouveau medecin enregistré !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
}
