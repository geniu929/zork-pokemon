	import java.util.ArrayList;


public class Pokemon{
	private String nom;
	private String type;
	private int puiss;
	private int PV;
	
		
	public Pokemon(String c1,String c2, int x, int a){
		nom = c1;
		type=c2;
		puiss = x;
		PV = a;		
	}
	
	
	public String getNom(){
		return nom;
		}


	public String getType(){	
		return type;
		}


	public int getPV(){
		return PV;
		}
		
	
	public void setPV(int a){
		PV=a;
	}
		
		
	public int getPuiss(){
		return puiss;
		}
		
		}
