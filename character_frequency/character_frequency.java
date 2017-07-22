package programmin_abstraction_collections;
import java.util.*;
import java.io.File;



public class character_frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("sample.in"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		int i = 0;
		
		
		
		int[] frequency =  new int[27];
		
		while(x.hasNext()){
			
			if(x.hasNextInt()){
				
				i = x.nextInt();
				
				/*System.out.printf("\n%d",i);*/
				
				
			}else{
				
				String s = x.nextLine();
				
				for(char j = 'a';j <= 'z'; j++){
				String im = Character.toString(j);
				String l = s.replaceAll(im,"");
				int f = s.length() - l.length();
				frequency[j - 97] = frequency[j - 97] + f;
				
				}
				
			}
			
			
		}
		System.out.println("\n");
		
		
		for(char j = 'a';j <= 'z'; j++){
			
			System.out.printf("%d %c\n",frequency[j - 97],j);
			
			}
		

	}
	
}