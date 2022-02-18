	import java.util.Set;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.ArrayList;

	/**
	 *  Une piece dans un jeu d'aventure. <p>
	 *
	 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
	 *  texte.</p> <p>
	 *
	 *  Une "Piece" represente un des lieux dans lesquels se déroule l'action du
	 *  jeu. Elle est reliée a au plus quatre autres "Piece" par des sorties. Les
	 *  sorties sont étiquettées "nord", "est", "sud", "ouest". Pour chaque
	 *  direction, la "Piece" possède une référence sur la piece voisine ou null
	 *  s'il n'y a pas de sortie dans cette direction.</p>
	 *
	 * @author     	Mrabet Abderrahmen & Iacobciuc Eugen
	 */

public class Piece extends ArrayListConteneur{
	private String Description;
	private ArrayList<Pokemon> PokemonPiece;	//une liste qui représente les objets de la piece.
	private int NbObjets; 				// mémorise les sorties de cette piece.
	private ArrayList<String> ListeBatiments;
	private Map sorties;
	private Joueur boss;


	/**
	 *  Initialise une piece décrite par la chaine de caractères spécifiée.
	 *  Initialement, cette piece ne possède aucune sortie. La description fournie
	 *  est une courte phrase comme "la bibliothèque" ou "la salle de TP".
	 *
	 * @param  	description  Description de la piece.
	 * @requires 	description != null;
	 * @ensures	getObjets().size()=0;
	 */
	public Piece(String description){
		super();
		this.Description=description;
		//objets=new ArrayList<ObjetZork>();
		sorties = new HashMap();
		PokemonPiece = new ArrayList<Pokemon>();
		ListeBatiments = new ArrayList<String>();
		boss=null;
	}


	/**
	* @param  d  		Description de la piece.
	* @param  tabObjets	La liste des objets contenus dans la piece.
	* @param  NbObjets	Le nombre d'objet contenus dans la piece.
	* @requires 	description != null;
	* @ensures	getObjets().size()=tabObjets.size();	
	*/
	public Piece(String d, ArrayList<ObjetZork> tabObjets, int NbObjets){
		super(tabObjets);
		Description=d;
		//objets=tabObjets;
		this.NbObjets=NbObjets;
		PokemonPiece = new ArrayList<Pokemon>();
		ListeBatiments = new ArrayList<String>();
	}


	public ArrayList<Pokemon> getPokemonPiece(){
		return PokemonPiece;
	}

	public Joueur getBoss(){
	return boss;
	}
	
	public void setBoss(Joueur j){
	boss=j;
	}
	
	
	
	public ArrayList<String> getListeBatiments(){
		return ListeBatiments;
	}
	
	
	/**
	 *  Renvoie la description de cette piece (i.e. la description spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Description de cette piece
	 */

	public String descriptionCourte() {
		return Description;
	}
	/**
	 *  Renvoie une description de cette piece mentionant ses sorties et
	 *  directement formatée pour affichage, de la forme: <pre>
	 *  Vous etes dans la bibliothèque.
	 *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractères
	 *  renvoyée par la méthode descriptionSorties pour décrire les sorties de
	 *  cette piece.
	 *
	 * @return    Description affichable de cette piece
	 */
	public String descriptionLongue() {
		return "Vous etes à " + Description + ".\n" + descriptionSorties();
	}


	@Override 
	public boolean AjoutPossible(ObjetZork oz){
		return true;
	}
	
	
	public void AfficherLesBatiments(){
		if (getListeBatiments().size()!=0){
			System.out.println("Voici les batiments qui se trouvent à "+this.descriptionCourte());
			for(int i=0; i<getListeBatiments().size();i++){
				System.out.println(getListeBatiments().get(i));
			} 
		} else
		System.out.println("Il n'y a aucun Batiment à " + this.descriptionCourte());
	
	}
	
	public void AfficherLesPokemons(){
		if (getPokemonPiece().size()!=0){
			System.out.println("Et voici les Pokemons sauvages qui se trouvent à "+this.descriptionCourte());
			for(int i=0; i<getPokemonPiece().size();i++){
				System.out.println("* "+ i+" *"+getPokemonPiece().get(i).getNom()+ " : Il est de type " + getPokemonPiece().get(i).getType() + " sa puissance est de " +getPokemonPiece().get(i).getPuiss() + "  et il a actuellement " + getPokemonPiece().get(i).getPV() + " Points de Vie" );
			} 
		} else
		System.out.println("et Il n'y a aucun Pokemon sauvage " );
	
	}


	/**	
	* @param oz	représente l'objetzork qu'on cherche à determiner son nombre d'occurence dans la liste.
	* @requires 	!objets.isEmpty();
	* @ensures	n >= 0;
	* @return	le nombre d'occurence de l'objet.
	*/
	public int CombienDe(ObjetZork oz){

		
		int n=0;
		for (int i=0;i<getObjets().size();i++){
			if(getObjets().get(i).equals(oz))
				n++;
		}
		return n;

	}
	
	
	
	/**
	 *  Définie les sorties de cette piece. A chaque direction correspond ou bien
	 *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
	 *  cette direction.
	 *
	 * @param  nord   La sortie nord
	 * @param  est    La sortie est
	 * @param  sud    La sortie sud
	 * @param  ouest  La sortie ouest
	 */
	public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
		if (nord != null) {
			sorties.put("nord", nord);
		}
		if (est != null) {
			sorties.put("est", est);
		}
		if (sud != null) {
			sorties.put("sud", sud);
		}
		if (ouest != null) {
			sorties.put("ouest", ouest);
		}
	}


	
	/**
	 *  Renvoie une description des sorties de cette piece, de la forme: <pre>
	 *  Sorties: nord ouest</pre> Cette description est utilisée dans la
	 *  description longue d'une piece.
	 *
	 * @return    Une description des sorties de cette pièce.
	 */
	public String descriptionSorties() {
		String resulString = "Sorties:";
		Set keys = sorties.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			resulString += " " + iter.next();
		}
		return resulString;
	}




	/**
	 *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
	 *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se déplacer
	 * @return            Piece atteinte lorsque l'on se déplace dans la direction
	 *      spécifiée ou null.
	 */
	public Piece pieceSuivante(String direction) {
		return (Piece) sorties.get(direction);
	}
	
	
	
}


