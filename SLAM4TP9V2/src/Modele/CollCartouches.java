package Modele;

import java.util.ArrayList;

public class CollCartouches {
	
	private ArrayList<Cartouche> listeCart;

	public CollCartouches() 
	{
		this.listeCart = new ArrayList<Cartouche>();
	}
	
	   public void addCartouche(Cartouche uneCartouche)
	   {
		   this.listeCart.add(uneCartouche);
	   }
	   
	   public int getNbCartouches()
	   {
		   return this.listeCart.size();
	   }
	   
	   public Cartouche getCartouche(int i)
	   {
		   return this.listeCart.get(i);
	   }

	public ArrayList<Cartouche> getListeCart() {
		return listeCart;
	}

	public void setListeCart(ArrayList<Cartouche> listeCart) {
		this.listeCart = listeCart;
	}
	   
	   
}
