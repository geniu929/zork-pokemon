	import java.util.*;

	/**
	 *  Classe principale du jeu "Zork". <p>
	 *
	 *  Zork est un jeu d'aventure très rudimentaire avec une interface en mode
	 *  texte: les joueurs peuvent juste se déplacer parmi les différentes pieces.
	 *  Ce jeu nécessite vraiment d'etre enrichi pour devenir intéressant!</p> <p>
	 *
	 *  Pour jouer a ce jeu, créer une instance de cette classe et appeler sa
	 *  méthode "jouer". </p> <p>
	 *
	 *  Cette classe crée et initialise des instances de toutes les autres classes:
	 *  elle crée toutes les pieces, crée l'analyseur syntaxique et démarre le jeu.
	 *  Elle se charge aussi d'exécuter les commandes que lui renvoie l'analyseur
	 *  syntaxique.</p>
	 *
	 * @author     	Mrabet Abderrahmen & Iacobciuc Eugen (pour la modification et l'ajout des commandes)
	 */

public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	private Piece pieceCourante;
	private Piece piecePrecedente;
	private ArrayList<Piece> ListePiece;
	private Joueur J; 	//Initialisation du joueur et choix du poids maximal.
	private int n=5;
	private ObjetZork k ;
	private Piece[] ListeTEleport;
	private Piece pieceTele;
	
	/**
	 *  Crée le jeu et initialise la carte du jeu (i.e. les pièces).
	 */
	public Jeu()throws PoidsNegatifException{
		creerPieces();
		analyseurSyntaxique = new AnalyseurSyntaxique();
		ListePiece= new ArrayList<Piece>();
		J = new Joueur("Joueur1",40,100);
		J.ajouterPokemon(new Pokemon("Pikachu","éléctrique",15,100));
		k= new ObjetZork("Coupe ","Or ",10,true,0);
	}

	

	
	/**
	 *  Crée toutes les pieces et relie leurs sorties les unes aux autres.
	 */
	public void creerPieces() throws PoidsNegatifException{
		Piece BourgPalette;
		Piece Parmanie;
		Piece Argenta;
		Piece Azuria;
		Piece Safrania;
		Piece CarminSurMer;
		Piece Teleport;
		
		
		// création des pieces
		
		BourgPalette = new Piece("Bourg Palette");
		Parmanie = new Piece("Parmanie");
		Argenta = new Piece("Argenta");
		Azuria = new Piece("Azuria");
		Safrania = new Piece("Safrania");
		CarminSurMer = new Piece("Carmin-Sur-Mer");
		Teleport = new Piece("Piece magique");
		// initialise les sorties des pieces
		BourgPalette.setSorties(Teleport, Parmanie, Azuria, Argenta);
		Parmanie.setSorties(null, null, null, BourgPalette);
		Argenta.setSorties(null, BourgPalette, null, null);
		Azuria.setSorties(BourgPalette, Safrania, null, null);
		Safrania.setSorties(null, null, null, Azuria);
		CarminSurMer.setSorties(Azuria, null, null, Safrania);
		Teleport.setSorties(null,null,null,null);

		// le jeu commence BourgPalette
		pieceCourante = BourgPalette;
	
		
		// Création des objets et ajout dans les salles
		try{
		//salle de TD
		Parmanie.getPokemonPiece().add(new Pokemon("Bulbizarre","Plante",12,100));
		Parmanie.getPokemonPiece().add(new Pokemon("Roucoups","Aérien",13,100));
		Parmanie.getPokemonPiece().add(new Pokemon("Salameche","Feu",17,100));
		
		Parmanie.getListeBatiments().add("Hopital");
		Parmanie.getListeBatiments().add("Marché");
		Parmanie.getListeBatiments().add("Ring");
		Joueur j1=new Joueur("Arikkama",40,100);
		j1.ajouterPokemon(new Pokemon("Glasiasrus","Aquatique",15,100));
		j1.ajouter(new ObjetZork("Coupe ","Or ",10,true,0));
		Parmanie.setBoss(j1);
		//salle de TP
		CarminSurMer.getPokemonPiece().add(new Pokemon("Carapuce","Aquatique",10,100));
		CarminSurMer.getPokemonPiece().add(new Pokemon("Stario","Aquatique",12,100));
		CarminSurMer.getPokemonPiece().add(new Pokemon("Dracaufeu","Feu",15,100));
		
		CarminSurMer.getListeBatiments().add("Hopital");
		CarminSurMer.getListeBatiments().add("Ring");
		Joueur j2=new Joueur("Soshiguma",40,200);
		j2.ajouterPokemon(new Pokemon("Pamounu","Terrestre",16,100));
		j2.ajouter(new ObjetZork("Coupe ","Or ",10,true,0));
		CarminSurMer.setBoss(j2);
		//BourgPalette
		BourgPalette.getPokemonPiece().add(new Pokemon("Carabaffe","Aquatique",11,100));
		BourgPalette.getPokemonPiece().add(new Pokemon("Rattata","Terrestre",10,100));
		BourgPalette.getPokemonPiece().add(new Pokemon("Rafflesia","Plante",14,100));
		
		
		BourgPalette.getListeBatiments().add("Marché");
		BourgPalette.getListeBatiments().add("Ring");
		Joueur j3=new Joueur("Anannasous",40,300);
		j3.ajouterPokemon(new Pokemon("Rex","Plante",17,100));
		j3.ajouter(new ObjetZork("Coupe ","Or ",10,true,0));
		BourgPalette.setBoss(j3);
		
		
		//Argenta
		Argenta.getPokemonPiece().add(new Pokemon("Persian","Domestique",5,100));
		Argenta.getPokemonPiece().add(new Pokemon("Tartard","Aquatique",13,100));
		Argenta.getPokemonPiece().add(new Pokemon("Magnéti","Electrique",14,100));
		Argenta.ajouter(new ObjetZork("table","table",50,true,10));
		Argenta.getListeBatiments().add("Ring");
		Joueur j4=new Joueur("Chaka",40,400);
		j4.ajouterPokemon(new Pokemon("Foulgere","Electrique",18,100));
		j4.ajouter(new ObjetZork("Coupe ","Or ",10,true,0));
		Argenta.setBoss(j4);
		//Safrania
		Safrania.getPokemonPiece().add(new Pokemon("Spectrum","Fantome",11,100));
		Safrania.getPokemonPiece().add(new Pokemon("Soporifik","Hypnose",14,100));
		Safrania.getPokemonPiece().add(new Pokemon("Smogogo","Poison",20,100));
		Safrania.getListeBatiments().add("Ring");
		Joueur j5=new Joueur("Drakula",40,500);
		j5.ajouterPokemon(new Pokemon("Vulkanis","Feu",18,100));
		j5.ajouter(new ObjetZork("Coupe ","Or ",10,true,0));
		Safrania.setBoss(j5);
		//Azuria
		Azuria.getPokemonPiece().add(new Pokemon("Stari","Aquatique",11,100));
		Azuria.getPokemonPiece().add(new Pokemon("Electrode","Electrique",16,100));
		Azuria.getPokemonPiece().add(new Pokemon("Racaillou","Roche",10,100));
		
		Azuria.getListeBatiments().add("Marché");
		
	
		Piece PieceA[]= {Azuria,Safrania,Argenta,BourgPalette,CarminSurMer,Parmanie};
		ListeTEleport = PieceA;
		pieceTele = Teleport;
		
		
	
	} catch(PoidsNegatifException e){
		e.message();
	}
	}

	
	public Piece Piecerandom(){
	
			Random r= new Random();
			

			int i = r.nextInt(ListeTEleport.length);
			Piece pieceAlea =ListeTEleport[i]; 
			
				
				System.out.println("vous etes entre dans le ville sacre et interdi il vous a teleporté");
				
			
			return pieceAlea;
			
			
		}

	
	
	
	/**
	 *  Pour lancer le jeu. Boucle jusqu'a la fin du jeu.
	 */
	public void jouer() throws PoidsNegatifException{

		afficherMsgBienvennue();

		// Entrée dans la boucle principale du jeu. Cette boucle lit
		// et exécute les commandes entrées par l'utilisateur, jusqu'a
		// ce que la commande choisie soit la commande "quitter"
		
		boolean termine = false;
		while (!termine) {
			
			
		
			if(mission()==1)
			{
				termine =true;
				System.out.println("!!!!VOUS AVEZ GAGNE!!!!");
			}
			else if(mission()==0){
			termine =false;
			}
			else if(mission()==-1){
			termine =true;
			System.out.println("!!!!VOUS AVEZ PERDU!!!!");
			}
			if(termine == false){
			Commande commande = analyseurSyntaxique.getCommande();
			termine = traiterCommande(commande);
			}
		
		}
		System.out.println("Merci d'avoir joué.  Au revoir.");
	}


	/**
	 *  Affiche le message d'accueil pour le joueur.
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println("Bienvenue dans le monde de POKEMON !");
		System.out.println("Je suis le professeur IACOBCIUC, je serai votre guide personnel ");
		System.out.println("Votre carriére en tant que dresseur Pokemon commence dés maintenant ");
		System.out.println("Alors, vous pensez que vous avez ce qu'il faut pour vous en sortir ?");
		System.out.println("Bon jeu et Bonne chance à vous (vous en aurez besoin)");
		System.out.println("Tapez 'aide' si vous avez besoin d'aide.");

		System.out.println();
		System.out.println(pieceCourante.descriptionLongue());
	}


	/**
	 *  Exécute la commande spécifiée. Si cette commande termine le jeu, la valeur
	 *  true est renvoyée, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande) throws PoidsNegatifException{
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}
		
		String motCommande = commande.getMotCommande();
		if (motCommande.equals("retour")) {
			if(commande.aSecondMot()){
				System.out.println("retour ou ?taper juste retour");
			}
			else{
				retour();
			}
		}
		else if (motCommande.equals("inventaire")){
			AfficherObjetJoueur();
			AfficherSortJoueur();
		}
		
		else if (motCommande.equals("capture")){
			capture();
		}
		
		
		else if (motCommande.equals("pokemons")){
			AfficherPokemonJoueur();
		}
		else if(motCommande.equals("regarde")){
			AfficherLesBatimentsDeLaPieceCourante();
			System.out.println("\n");
			AfficherLesPokemonsDeLaPieceCourante();
		}	
		else if(motCommande.equals("ramasse")){
			 RamasserUnObjet();
		}
		else if(motCommande.equals("depose")){
			 DeposerUnObjet();
		}
		else if(motCommande.equals("guerir")){
			 Guerir();
		}
		else if (motCommande.equals("aide")) {
		 	afficherAide();	
		} 
		else if (motCommande.equals("acheter")) {
		 	Acheter();	
		}  
		else if (motCommande.equals("mission")) {
		 	gagner();	 	
		} 
		else if (motCommande.equals("budget")) {
		 	Budget();	 	
		} 
		else if (motCommande.equals("aller")) {
			deplacerVersAutrePiece(commande);
		} 
		else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
		}	


	// implementations des commandes utilisateur:

	/**
	 *  Affichage de l'aide. Affiche notament la liste des commandes utilisables.
	 */
	public void afficherAide() {
		System.out.println("Vous etes perdu. Vous etes seul. Vous errez");
		System.out.println("dans le UNIVERS de POKEMONS.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		analyseurSyntaxique.afficherToutesLesCommandes();
	}


	/**
	 *  Tente d'aller dans la direction spécifiée par la commande. Si la piece
	 *  courante possède une sortie dans cette direction, la piece correspondant a
	 *  cette sortie devient la piece courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie la direction a suivre
	 */
	public void deplacerVersAutrePiece(Commande commande) {
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller où ?");
			return;
		}

		String direction = commande.getSecondMot();

		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(direction);

		if (pieceSuivante == null) {
			System.out.println("Euuhh, c'est dangereux pour vous d'aller dans cette direction.. ");
			}
		if(pieceSuivante.descriptionCourte().equals("Piece magique")){
		 pieceCourante=Piecerandom();
		 
		 System.out.println("vous êtes dans " + pieceCourante.descriptionCourte());
		}
		else {
			ListePiece.add(pieceCourante);
			piecePrecedente = pieceCourante;
			pieceCourante = pieceSuivante;
			System.out.println(pieceCourante.descriptionLongue());
		}
	}
	
	
	
	
	/**
	 * Cette méthode exécute un retour à la piéce précédente.
	 * @requires	piecePrecedente!=null;	(on ne peut pas exécuter cette commande dans la premiére piéce.)
	 * @ensures	pieceCourante!=null;
	 */
	
	public void retour(){
		if (ListePiece.size()==0)
			System.out.println("retour impossible");
		else{
			pieceCourante=ListePiece.get(ListePiece.size()-1);
			ListePiece.remove(ListePiece.size()-1);
			System.out.println(pieceCourante.descriptionLongue());
		}
		}
		
		
	/**
	 * Cette méthode affiche les objets présents dans piece courante.
	 * Elle fait simplement appel à AfficherLesObjets qui est
	 * définie dans Piece.java.
	 */
	public void AfficherLesBatimentsDeLaPieceCourante(){
		pieceCourante.AfficherLesBatiments();
	}
	
	
	public void AfficherLesPokemonsDeLaPieceCourante(){
		pieceCourante.AfficherLesPokemons();
	}
	
	
	public void AfficherPokemonJoueur(){
		J.AfficherPokemon();
	}
	
	
	public void Acheter()throws PoidsNegatifException{
		Scanner scan = null;
		String input = null;
    		scan = new Scanner(System.in);
		if(pieceCourante.getListeBatiments().contains("Marché")){
			System.out.println("Bienvenue Mr.");
			System.out.println("Quel objet voulez-vous acheter ?");
			System.out.println("On a des : 'Guérison' à 100€ et 'Booster de puissance' à 100€  ");
			Budget();
			input = scan.nextLine();
			if (input.equals("Guérison") && (J.getArgent()>=100)){
				if (J.getPoidsTotal()+5<=J.getPoidsMax()){
				 	J.getSortJoueur().add(new Sort("Guérison","Rajoute 20 PV à votre Pokemon",5,true,100,20)); 
				 	J.setArgent(J.getArgent()-100);
				 	System.out.println("Voilà! à bientot");
				 }
				else
					System.out.println("Vous n'avez plus d'espace dans votre sac !");
			}
			else if (input.equals("Booster de puissance") && (J.getArgent()>=100)){
				if (J.getPoidsTotal()+5<=J.getPoidsMax()){
				 	J.getSortJoueur().add(new Sort("Booster de puissnce","Rajoute 20 unité de puissance à votre Pokemon",5,true,100,20)); 
				 	J.setArgent(J.getArgent()-100);
				 	System.out.println("Voilà! à bientot");
				}
				else
					System.out.println("Vous n'avez plus d'espace dans votre sac !");
			}
		}
		else
			System.out.println("Il n'y a pas de marché à "+pieceCourante.descriptionCourte()+ " \n Bizarre ouais");
	}
	
	
	
	public void Guerir(){
		if(pieceCourante.getListeBatiments().contains("Hopital")){
			for(int i=0;i<J.getPokemonJoueur().size();i++){
				J.getPokemonJoueur().get(i).setPV(100);
				J.setArgent(J.getArgent()-50);
				int n=0;
				n+=50;
				System.out.println("Vous aviez depance "+n+"€ ");
				System.out.println("Vos Pokemons sont desormais en pleine forme. à Bientot!");
			}
		}
		else
			System.out.println("Pas d'hopital à "+pieceCourante.descriptionCourte());
	}
	
	
	/**
	 * Comme son nom l'indique, la méthode affiche les objets
	 * qui se trouvent dans l'inventaire du joueur.
	 * Elle fait appel à AfficherObjetJoueur qui est définie dans Joueur.java.
	 */
	public void AfficherObjetJoueur(){
		J.Afficher();
	}
	
	public void AfficherSortJoueur(){
		J.AfficherSort();
	}

	/**
	 * Cette méthode ramasse un objet (dont le nom sera demandé) dans l'inventaire
 	 * du joueur.
 	 * @requires	objets.size()!=null;
 	 * @requires	Poidstotal+Objet.Poids<=PoidsMax;
 	 * @ensures	poidsTotal<=poidsMax;
 	 * @ensures	objets_joueur.size()!=0;
 	 */
	public void RamasserUnObjet(){
		
		boolean test=false;
		Scanner scan = null;
		String input = null;
    		scan = new Scanner(System.in);
   		System.out.println("Quel objet voulez-vous ramasser ?: ");
    		input = scan.nextLine();	//Scanner le nom de l'objet.
		for(int i=0; i<pieceCourante.getObjets().size();i++){
			if (input.equals(pieceCourante.getObjets().get(i).getNom()) && (pieceCourante.getObjets().get(i).getEtat())){
			// Si l'objet est trouvé, et que il est transportable alors:...
				if (J.getPoidsTotal()+pieceCourante.getObjets().get(i).getPoids()<=J.getPoidsMax())  
				{
					J.setPoidsTotal(J.getPoidsTotal() + pieceCourante.getObjets().get(i).getPoids()) ;
					J.ajouter(pieceCourante.getObjets().get(i));	
					pieceCourante.retirer(pieceCourante.getObjets().get(i));	 	
					test=true;
					
				}
				else 
		                       	System.out.println("Vous avez dépassé le poids maximal! Déposez des objets si vous voulez ramasser celui-ci! ");
								
			}
			
		}
		if (test==true )
			System.out.println("Objet ramassé!");
		else
			System.out.println("Ramassage impossible! ");	//si l'objet n'est pas ramassé, un message d'erreur s'affiche.
	}
	
	
	/**
	 * Cette méthode permet de déposer un objet dans la piéce courante.
	 * @requires	objets_joueur.size()!=null;
	 * @requires	PoidsTotal!=0;
	 * @ensures	objets.siz()!=0;
	 */
	
	public void DeposerUnObjet(){
	boolean test=false;
		Scanner scan = null;
		String input = null;
    		scan = new Scanner(System.in);
   		System.out.println("Quel objet voulez-vous deposer ?: ");
    		input = scan.nextLine();
		for(int i=0;i<J.getObjets().size();i++){
			if(input.equals(J.getObjets().get(i).getNom())){
				pieceCourante.ajouterPiece(J.getObjets().get(i));
				J.retirer(J.getObjets().get(i));	
				test=true;			
			}
			
		}
		if (test==true )
			System.out.println("Objet deposé!");
		else
			System.out.println("Impossible de deposer! ");
	
	}
	
	
	public void Budget(){
		System.out.println("Vous avez actuellement: "+ J.getArgent()+"€ :D\n");
	}
	
	
	/**
	 * Cette méthode montre les objectifs pour gagner.	
	*/
	public int gagner(){
	
	if(pieceCourante.getListeBatiments().contains("Ring")){
	System.out.println("Vous  commance le tournois");
	Scanner scan = null;
		
		int j = 0;
    		scan = new Scanner(System.in);
    		pieceCourante.getBoss().aficherJoueur();
		    				
		J.AfficherPokemon();
		System.out.println("tape le nombre de pokemon lequlle vous voulez utiliser");
		j = scan.nextInt();
		
		while(j <0||j >J.getPokemonJoueur().size()-1){
		System.out.println("le nombre que vous avez taper n'appartien a aucune pokemon"+j);
		System.out.println("tape le nombre de pokemon lequlle vous voulez capture");		
		j = scan.nextInt();
		}
		
		while(pieceCourante.getBoss().getPokemonJoueur().get(0).getPV()>=10&&J.getPokemonJoueur().get(j).getPV()>=10){
			
			attaque(J.getPokemonJoueur().get(j),pieceCourante.getBoss().getPokemonJoueur().get(0));
			if(pieceCourante.getBoss().getPokemonJoueur().get(0).getPV()>=10){
			defense(pieceCourante.getBoss().getPokemonJoueur().get(0),J.getPokemonJoueur().get(j));	
			}
			
		}
		if(pieceCourante.getBoss().getPokemonJoueur().get(0).getPV()<=10&&J.getPokemonJoueur().get(j).getPV()>=10){
			System.out.println("vous avez gagner la coupe pokemon");
			J.ajouter(pieceCourante.getBoss().getobjets_joueur().get(0));
			J.setArgent(J.getArgent()+pieceCourante.getBoss().getArgent());
			chNom("Ring", "Ring (vous aviez jouer sur cette Ring)");
			n=n-1;
			return 1; 			
			}
		else{	
			System.out.println("vous avez perdu le match");
			chNom("Ring", "Ring (vous aviez jouer sur cette Ring)");
			n=n-1;
			return -1;						
		}
		
		

		
	 
	}
		
		
	else
	System.out.println("vous aviez participer dejaz a ce tournois");
	
	
	
	return 0;
	
	}
	
	/**
	 * Cette méthode représente la mission a effectuer!
	 */
	
	public int mission(){
	
		if(J.ContientCombienDe(k)==3){
		return 1;
		}
		if(J.ContientCombienDe(k)==0&&n<=2){
		return -1;
		}
		if(J.ContientCombienDe(k)==2&&n==0){
		return -1;	
		}
		if(J.ContientCombienDe(k)==1&&n==1){
		return -1;
		}
		return 0;
	}
		
	

	
	public void capture (){


		Scanner scan = null;
		int i = 0;
		int j = 0;
    		scan = new Scanner(System.in);
    		pieceCourante.AfficherLesPokemons();
		System.out.println("tape le nombre de pokemon lequlle vous voulez capture");
    		i = scan.nextInt();
		
		while(i <0||i>=pieceCourante.getPokemonPiece().size()){
		System.out.println("le nombre que vous avez taper n'appartien a aucune pokemon");
		System.out.println("tape le nombre de pokemon lequlle vous voulez capture "+i);		
		i = scan.nextInt();
		}
		J.AfficherPokemon();
		System.out.println("tape le nombre de pokemon lequlle vous voulez utiliser");
		j = scan.nextInt();
	
		while(j <0||j >J.getPokemonJoueur().size()-1){
		System.out.println("le nombre que vous avez taper n'appartien a aucune pokemon"+j);
		System.out.println("tape le nombre de pokemon lequlle vous voulez capture");		
		j = scan.nextInt();
		}	
		
		
		System.out.println("pour capture le pokemon il faux que le pokemon perd 60 point de vie");
		System.out.println("les attaque sont suivi de defense");
		System.out.println("");
			while(pieceCourante.getPokemonPiece().get(i).getPV()>=40&&J.getPokemonJoueur().get(j).getPV()>=10){
			
				attaque(J.getPokemonJoueur().get(j),pieceCourante.getPokemonPiece().get(i));
				if(pieceCourante.getPokemonPiece().get(i).getPV()>=40){
				defense(pieceCourante.getPokemonPiece().get(i),J.getPokemonJoueur().get(j));	
				}
			}
			
				if(pieceCourante.getPokemonPiece().get(i).getPV()<=40&&J.getPokemonJoueur().get(j).getPV()>=10){
				System.out.println("vous avez capture le pokemon");
				J.ajouterPokemon(pieceCourante.getPokemonPiece().get(i));
				pieceCourante.getPokemonPiece().remove(i);
				}
				else
				System.out.println("vous avez rate la capture");
										
			
	}
	
	
	
	public void attaque(Pokemon a,Pokemon b){
	Scanner scan = null;
	int input = 0;
    	scan = new Scanner(System.in);
   	System.out.println("c'est vous qui attaquez ");
   	System.out.println("POUR BUSTER VOTRE PUISSANCE TAPER 3 ");
	System.out.println("tapez 1 pour attaque tete ");
	System.out.println("tapez 2 pour attaque corp ");
	input = scan.nextInt();
	while(input <1||input >3){
		System.out.println("le nombre que vous avez taper n'appartien a aucune ataque ");
		System.out.println("c'est vous qui attaquez ");
		System.out.println("Si vous BOOSTE sans avoir un sort vous apliquer 11 degas");
		System.out.println("POUR BUSTER VOTRE PUISSANCE TAPER 3 ");
		System.out.println("tapez 1 pour attaque tete ");
		System.out.println("tapez 2 pour attaque corp ");
	
		input = scan.nextInt();
		}
		if(a.getType().equals(b.getType())){
		Random rand = new Random();
		int nombre = rand.nextInt(2);
		nombre+=1;
		System.out.println("votre enemie choisi la defense "+nombre);
			if(input==nombre){
			System.out.println("votre enemie a deviner votre ataque");
			b.setPV(b.getPV()-(a.getPuiss()+5));
			desinAttaq();
			}
			
			else if((input==2&&nombre==1)||(input==1&&nombre==2)){
			System.out.println("votre enemie n'a pas deviner votre ataque");
			b.setPV(b.getPV()-(a.getPuiss()+10));
			desinAttaq();
			}
			else {
			System.out.println("vous avez lancer une attaque fort ");
			b.setPV(b.getPV()-(bouster()+10));			
			desinAttaq();
			}
			System.out.println("l'enemie "+b.getPV() );
		}
		else{
		System.out.println("votre enemie est une Pokemon " +b.getType());
		System.out.println("et votre Pokemon est de type " +a.getType());
		System.out.println("les degats de vos attaque sont plus considerables");
		Random rand = new Random();
		int nombre = rand.nextInt(2);
		nombre+=1;
		System.out.println("votre enemie choisi l'attaque "+nombre);
			if(input==nombre){
			System.out.println("votre enemie a deviner votre ataque");
			b.setPV(b.getPV()-(a.getPuiss()+10));
			desinAttaq();
			}
			else if((input==2&&nombre==1)||(input==1&&nombre==2)){
			System.out.println("votre enemie n'a pas deviner votre ataque");
			b.setPV(b.getPV()-(a.getPuiss()+15));
			desinAttaq();
			}
			else{
			b.setPV(b.getPV()-(bouster()+15));			
			desinAttaq();
			}
		System.out.println("l'enemie "+b.getPV() );
		}
	
	}
	
	public void defense(Pokemon a,Pokemon b){
	Scanner scan = null;
	int input = 0;
    	scan = new Scanner(System.in);
   	System.out.println("c'est vous de se defender ");
	System.out.println("tapez 1 pour defense tete ");
	System.out.println("tapez 2 pour defense corp ");
	
	input = scan.nextInt();
	while(input <1||input >3){
	System.out.println("le nombre que vous avez taper n'appartien a aucune defense ");
	System.out.println("c'est vous de se defender ");
	System.out.println("tapez 1 pour defense tete ");
	System.out.println("tapez 2 pour defense corp ");
	
	input = scan.nextInt();
	}
		if(a.getType().equals(b.getType())){
		Random rand = new Random();
		int nombre = rand.nextInt(2);
		nombre+=1;
		System.out.println("votre enemie choisi l'attaque "+nombre);
			if(input==nombre){
			System.out.println("vous aviez deviner l'attaque");
			b.setPV(b.getPV()-(a.getPuiss()+5));
			desinDefence();
			}
			else {
			System.out.println("vous n'aviez pas deviner l'attaque");
			b.setPV(b.getPV()-(a.getPuiss()+10));
			desinDefence();
			}
			
		System.out.println("votre pokemon "+b.getPV());	
		}
		else{
		System.out.println("votre enemie est une Pokemon " +a.getType());
		System.out.println("et votre Pokemon est de type " +b.getType());
		System.out.println("les degats de ses attaque sont plus considerables");
		Random rand = new Random();
		int nombre = rand.nextInt(2);
		nombre+=1;
		System.out.println("votre enemie choisi l'attaque "+nombre);
			if(input==nombre){
			System.out.println("vous aviez deviner son attaque");
			b.setPV(b.getPV()-(a.getPuiss()+10));
			desinDefence();
			}
			else {
			System.out.println("vous n'aviez pas deviner l'attaque");
			b.setPV(b.getPV()-(a.getPuiss()+15));
			desinDefence();
			}
			
		System.out.println("votre pokemon "+b.getPV());
		}
	
	}	
	
	public int bouster(){
	
		if(J.getSortJoueur().size()==0){
	
		System.out.println("vous n'aviez de Sort pour bouste la puissance");
		return 1;		
		}
		else{
		int i=J.getSortJoueur().get(0).getEffet();
		J.getSortJoueur().remove(0);
		System.out.println("vous aviez lance une attaque fort");
		return i;
		}
	
	}
	
	
	public void desinAttaq(){
	
	System.out.println("     ^  ");
	System.out.println("    (.) " );
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println("    |.|");
	System.out.println(" ___|.|___");
	System.out.println("|___   ___|");
	System.out.println("    | |  ");
	System.out.println("    | |  ");
	System.out.println("    |_|");
	}
	
	public void desinDefence(){
	System.out.println("                      ");
	System.out.println("         @@@@         ");	
	System.out.println("    @()()()()()()@    ");
	System.out.println("  @()()()()()()()()@");
	System.out.println("  @()()()()()()()()@");	
	System.out.println("   @()()()()()()()@");
	System.out.println("    @()()()()()()@");
	System.out.println("     @()()()()()@");
	System.out.println("      @()()()()@");
	System.out.println("       @@@@@@@@");
	
	}
	
	public void chNom(String descr,String newdescr){
	
	int i;
	i=pieceCourante.getListeBatiments().indexOf(descr);
	
	if (i!=-1){
		pieceCourante.getListeBatiments().set(i,newdescr);	
	} 
	else
		System.out.println("le batiment n'existe pas danS la ville");
		
	}	
	
 
	
}


