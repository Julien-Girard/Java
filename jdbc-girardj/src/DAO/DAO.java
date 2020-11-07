package DAO;

import java.sql.Connection;
import java.util.Vector;

/**
 * DAO générique qui permet une uniformisation des dao
 * 
 * @author dejoie
 *
 * @param <T> le type d'objet traité
 * @param <K> le type d'identifiant utilisé
 */


public abstract class DAO<T,K> {
	
	protected Connection con = MysqlConnectionSingleton2.getInstance();

	/**
	 *  initialisation de la connexion a la BD lors de l'instantition du dao
	 */
	
	public abstract boolean create(T t);
	
	public abstract boolean delete(T t);
	
	public abstract boolean update(T t);
	
	public abstract Vector<T> retrieveAll();
	
	public abstract T retrieveById(K k);
	
	public Connection getConnection() {
		return this.con;
	}

}
