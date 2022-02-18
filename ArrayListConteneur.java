	import java.util.ArrayList;


	public abstract class ArrayListConteneur implements Conteneur{
		private ArrayList<ObjetZork> objets;
	
	
		public ArrayListConteneur() {
			objets = new ArrayList<ObjetZork>();
		}
	
		public ArrayListConteneur(ArrayList<ObjetZork> arr) {
			objets = new ArrayList<ObjetZork>(arr.size());
			for (int i=0;i<arr.size();i++){
				objets.add(arr.get(i));
			}
		}
		
		
		public ArrayList<ObjetZork> getObjets(){
			return objets;
		}
	
		@Override	
		public void ajouter(ObjetZork oz){
			if (!(AjoutPossible(oz)))
				return;
			else
				objets.add(oz);
		}
		
		@Override	
		public void ajouterPiece(ObjetZork oz){
			objets.add(oz);
		}

		
		@Override		
		public abstract boolean AjoutPossible(ObjetZork oz);


			
		public boolean contient(ObjetZork oz){
			return objets.contains(oz);
		}
	

		@Override	
		public int ContientCombienDe(ObjetZork oz){
			int n=0;
			for(int i=0;i<objets.size();i++){
				if(objets.get(i).equals(oz))
					n++;
			}
			return n;
		}
	
	
	
		@Override	
		public boolean retirer(ObjetZork oz){
			return objets.remove(oz);
		}
		
		/**
	 * Cette méthode afficher la liste d'inventaire du joueur et le poids des objets.
	 * càd les objets qu'il posséde. 
			
	*/
	public void Afficher(){
		if (getObjets().size()!=0){  // verifier si le joueur posséde des objets.
			for(int i=0; i<getObjets().size();i++)
			  	System.out.println(getObjets().get(i).getNom()+ ", son poids est " + getObjets().get(i).getPoids());
			
		}
		else
			System.out.println("Le joueur n'a actuellement aucun objet!!"); // si l'inventaire est vide un message sera affiché.
		}
	
	}

	


	
	
