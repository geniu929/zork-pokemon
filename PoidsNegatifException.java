	import java.util.*;
	public class PoidsNegatifException extends Exception{
		int p;
		public PoidsNegatifException(){
			System.out.println("Le poids est négatif! ");
		}
		
		public PoidsNegatifException(int i){
			p=i;
		}
		
		public void message(){
			System.out.println("Le poids  "+p+"  est négatif! ");
		}
	}
