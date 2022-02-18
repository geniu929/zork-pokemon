import java.util.ArrayList;

import java.util.*;


public class Sort extends ObjetZork{
	private int effet;
		
	public Sort(String c1,String c2, int x, boolean h,int s,int a)throws PoidsNegatifException{
		
		super(c1,c2,x,h,s);
		
		effet=a;
	}
	
	
	public int getEffet(){
		return effet;
	}
	
	
	}
