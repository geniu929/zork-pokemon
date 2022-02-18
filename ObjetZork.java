	/**
	* Cette classe définit un ObjetZork.
	* Un objetZork est caractérisé par des attributs.
	* @author     	Mrabet Abderrahmen & Iacobciuc Eugen
	*/
public class ObjetZork {
		private String nom;
		private String description;
		private int poids;
		private boolean EstTransportable;
		private int prix;
	


		public boolean equals(Object o){
		     if(!(o instanceof ObjetZork))
				return false;
				ObjetZork oz= (ObjetZork) o;
		     if(nom.equals(oz.nom) && description.equals(oz.description) && poids==oz.poids && EstTransportable==oz.EstTransportable)
				return true;
		     else
				return false;
		}


	/** 
	* Ce constructeur exécute exactement la méme chose en 
	* attribuant en plus un poids à l'objet.
	* @param n représente le nom de l'objet.
	* @param d est la description de l'objet.
	* @param p est le poids de l'objet.
	*/
		public ObjetZork(String n,String d, int p, boolean s,int g) throws PoidsNegatifException{
			nom=n;
			description=d;
			EstTransportable=s;
			poids=p;
			if (p<0)
				throw new PoidsNegatifException(p);
			else
				poids=p;
			prix=g;
		}



	/**
	* Ces fonctions nous retournent des attributs
	* qui représentent le nom, la description, le poids et  
	* l'etat de l'objet en dehors de la classe.
	*/
		public String getNom(){
			return nom;
		}
		
		
		public String getDescription(){
			return description;
		}
		
		
		public int getPoids(){
			return poids;
		}
		
		
		public boolean getEtat(){
			return EstTransportable;
		}
		
		public int getPrix(){
			return prix;
		}



	/**
	* Cette fonction renvoie l'état compléte de l'objet en 	
	* une chaine de caractére.
	*/
	public String getInformation(){
		String S;
		S=nom+": "+description+" ";
		if (EstTransportable)
			S=S+"transportable"+", poids: "+poids;
		else
			S=S+"pas transportable";
		return S;
	}
	
	}
