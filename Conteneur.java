

	public interface Conteneur {
		public abstract void ajouter(ObjetZork oz);
		public abstract void ajouterPiece(ObjetZork oz);
		public boolean retirer(ObjetZork oz);
		public int ContientCombienDe(ObjetZork oz);
		public abstract boolean AjoutPossible(ObjetZork oz);
		public void Afficher();
	} 

