package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Modele.Specialite;

public class DAOSpecialite {

	
	@SuppressWarnings("unchecked")
	public static Vector<Specialite> retieveAll(Connection con) {
		
		Vector<Specialite> res = new Vector<Specialite>();
		
		String requete = "SELECT * FROM Specialite";
		try {
			Statement stLienBd = con.createStatement() ;
			ResultSet resultat = stLienBd.executeQuery(requete);
			while ( resultat.next() )
			{
				Specialite spe = new Specialite(resultat.getLong(0),resultat.getString(1));
				res.add(spe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return res;
		
		
	}
	
	
}
