import java.util.*;
	public class PieceRetourException extends Exception{
		public PieceRetourException(){
			
		}
		
		public void message(){
			System.out.println("Vous ne pouvez plus retourner");
		}
	}
