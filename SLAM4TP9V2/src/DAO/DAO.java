package DAO;

import java.sql.Connection;
import java.util.Vector;

public abstract class DAO<T1,T2>{

	protected Connection connect = PostGreConnection.getInstance();
	
	public abstract Vector<T1> findAll();
	
	public abstract T1 find(T2 id);
	
	public abstract void create(T1 var);
	
	public abstract void update(T1 var);
	
	public abstract void delete(T1 var);
	
	public Connection getConnection() {
		return this.connect;
	}
	
}