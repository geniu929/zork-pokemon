	import java.util.ArrayList;
	/**
	 * L'unique personnage du jeu.
	 * Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
	 * texte.</p> <p>
	 *
	 * Un joueur se déplace dans les pieces et essaye de retrouver des objets pour
	 * les rélaner au bureau.
	 * @author     	Mrabet Abderrahmen & Iacobciuc Eugen
	 */

public class Joueur extends ArrayListConteneur{
		private String nom;
		private Piece Pos ;
		private ArrayList<Pokemon> PokemonJoueur;	//la liste qui comporte les objets presents dans l'inventaire.
		private int PoidsTotal;
		private int PoidsMax;
		private int Argent;
		private ArrayList<Sort> SortJoueur;


	/**
	 * Initialise un joueur décrit par son nom et le poids total qu'il
	 * peut transporter.
	 *
	 * @param   	nom		représente le nom du joueur.
	 * @param   	x		désigne le poids total que le joueur pout porter.
	 * @requires	nom!=null;
	 * @ensures	objets_joueur.size()!=0;
	 */

	public Joueur(String nom, int x, int y){
		super();
		this.nom=nom;
		PoidsMax=x;
		PokemonJoueur = new ArrayList<Pokemon>();
		Argent=y;
		SortJoueur = new ArrayList<Sort>();
	}

	/**
	 * Un deuxiéme constructeur qui initialise un joueur décrit par
	 * son nom, sa position, son inventaire, son poids totale,
	 * son poids maximale et le nombre d'objets.
	 *
	 * @requires	nom!=null;
	 * @requires	PoidsMax!=0;
	 * @requires	NbObjetsMax!=0;
	 * @ensures	objets_joueur.size()!=0;
	 */

	public Joueur(String nom, Piece pos,ArrayList<ObjetZork> objets_joueur,int PoidsTotal,int PoidsMax,int NbObjetsMax ){
		super(objets_joueur);
		this.nom=nom;
		this.Pos=Pos;
		this.PoidsTotal=PoidsTotal;
		this.PoidsMax=PoidsMax;
		PokemonJoueur = new ArrayList<Pokemon>();
		SortJoueur = new ArrayList<Sort>();
		}


	public String getNom(){
		return nom;
		}


	public Piece getpos(){	
		return Pos;
		}


	public ArrayList<ObjetZork> getobjets_joueur(){
		return getObjets();
		
		}


	public int getPoidsTotal(){
		return PoidsTotal;
		}
		
		
	public void setPoidsTotal(int i){
		PoidsTotal=i;
		}
		
	public void setArgent(int f){
		Argent=f;
		}
		
	public int getPoidsMax(){
		return PoidsMax;
		}

	public ArrayList<Pokemon> getPokemonJoueur(){
		return PokemonJoueur;
	}
	
	public ArrayList<Sort> getSortJoueur(){
		return SortJoueur;
	}
	
	
	public int getArgent(){
		return Argent;
	}
	
	
	public void AfficherPokemon(){
		if (getPokemonJoueur().size()!=0){  // verifier si le joueur posséde des objets.
			System.out.println("Voici les pokemons et leurs états: ");
			for(int i=0; i<getPokemonJoueur().size();i++)
				System.out.println("* "+ i+" *"+getPokemonJoueur().get(i).getNom()+ " : Il est de type " + getPokemonJoueur().get(i).getType() + " sa puissance est de " +getPokemonJoueur().get(i).getPuiss() + "  et il a actuellement " + getPokemonJoueur().get(i).getPV() + " Points de Vie" );
			System.out.println("\n");
		}
		else
			System.out.println("Vous n'avez aucun Pokemon pour l'instant!"); // si l'inventaire est vide un message sera affiché.
		}
		
		
	public void AfficherSort(){
		if (getSortJoueur().size()!=0){  // verifier si le joueur posséde des objets.
			System.out.println("Voici les sorts que vous avez:");
			for(int i=0; i<getSortJoueur().size();i++)
				System.out.println("**  "+getSortJoueur().get(i).getNom()+ " : Il  " + getSortJoueur().get(i).getDescription() + " son poids " +getSortJoueur().get(i).getPoids() );
			System.out.println("\n");
		}
		else
			System.out.println("Vous n'avez aucun Sort pour l'instant!"); // si l'inventaire est vide un message sera affiché.
		}


	@Override
	public boolean AjoutPossible(ObjetZork oz){
		int poids = oz.getPoids();
		for (int i=0;i<getObjets().size();i++)
			poids+=getObjets().get(i).getPoids();
		if (poids>PoidsMax)
			return false;
		return true;
	}
	
	public void aficherJoueur(){
	System.out.println(""+nom);
	AfficherPokemon();
	
	}
	
	
	public void ajouterPokemon(Pokemon p){
			PokemonJoueur.add(p);
		}
	}	
	
	
	
	
