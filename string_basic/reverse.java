package programmin_abstraction_collections;
import java.util.*;
import java.io.File;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("sample.in"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		Vector<String> v = new Vector<String>();
		
		int i = 0;
		
		while(x.hasNext()){
			
			if(x.hasNextInt()){
				
				i = x.nextInt();
				System.out.printf("\n%d",i);
				
			}else{
				
				String s = x.nextLine();
				v = reverse(s);
				
				show(v);
				System.out.println("\n");
				
				
			}
			
			
		}

	}
	
	private static Vector<String> reverse(String s){
		Vector<String> v = new Vector<String>();
		String ch = "";
		int size = s.length();
		for(int i = size - 1 ; i >= 0; i--){
			ch = Character.toString(s.charAt(i));
			v.add(ch);
			
		}
		
		return v;
		
		
	}
	
	private static void show(Vector<String> s){
		
		for(int i = 0;i < s.size();i++){
			
			System.out.printf(s.get(i));
			
		}
		
		
		
	}

	
	

}
