package second_question;



import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;



public class second_question {
	
	

	public static void main(String[] args) {
		
		
		
		// TODO Auto-generated method stub
		
		
		Scanner sc = null;
		
		try{
			
			sc = new Scanner(new File("sample.in"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		
		
		/*
		 * 
		 * variable to get the size of the line of string
		 * 
		 * */
		int b = 0;
		
		
		/*
		 * 
		 * Arraylist variable to get each string segment
		 * 
		 * */
		ArrayList<String> String_value = new ArrayList<String>();
		
		/*
		 * 
		 * Arraylist variable to get the size of each string segment
		 * 
		 * */
		ArrayList<Integer> String_Indice = new ArrayList<Integer>();
		
		
		
		/*
		 * 
		 * Arraylist variable to store the hash value
		 * 
		 * */
		ArrayList<Long> hash_check = new ArrayList<Long>();
		
		
		/*
		 * 
		 * getting the input value
		 * 
		 * */
		
		while(sc.hasNext()){
			
			
			if (sc.hasNextInt()){
				
				/*
				 * 
				 * get the length of the string segment
				 * 
				 * */
				b = sc.nextInt();
				
				/*
				 * 
				 * if the input is zero, then it indicates the end of file
				 * 
				 * */
				if(b == 0){
					 
					 break;
					 
				 }
				
				/*
				 * 
				 *storing the indice in an Arraylist
				 * 
				 * */
				String_Indice.add(b) ;
				
				 
				 
				
				
			}else if (sc.hasNextLine()){
				
				/*
				 * 
				 * extracting the string value
				 * 
				 * */
				String a = sc.nextLine();
				
				
				/*
				 * 
				 * removing the space beetweeen string segments and the the integer value
				 * 
				 * */
				if(!a.isEmpty()){
					
					String_value.add(a) ;
					
				}
				
			   }
			
			
			
			
			
		}
		
		sc.close();
		
		/*
		 * 
		 * computing the hash value and storing it in an arraylist
		 * 
		 * */
		
		for(int i = 0;i < String_value.size();i++ ){
			
			String s = String_value.get(i);
			
			long Ascii_value = s.charAt(0);
			
			for(int j = 1; j < s.length();j++){
				
				Ascii_value = Ascii_value ^ s.charAt(j);
			}
			
			hash_check.add(Ascii_value);
			
			
			
		}
		
		
		
		
		
		/*
		 * 
		 * 
		 * comparing the hash value of each string segment
		 * 
		 * 
		 * */
		
	    int value = 0;
	    
	    
		for(int i = 0;i < String_Indice.size();i++){
			/*
			 * variables to get each string segment and its corresponding hash value
			 * 
			 * */
			ArrayList<Long> temporary = new ArrayList<Long>(hash_check.subList(value , value + String_Indice.get(i)));
			ArrayList<String> sub_check = new ArrayList<String>(String_value.subList(value , value + String_Indice.get(i)));
			value = value + String_Indice.get(i);
			
			
			/*
			 * finding unique string value
			 * 
			 * */
			
			
			int unique = 0;
			int collision = 0;
			
			/*
			 * set variables to get each unique hash value
			 * 
			 * */
			
			 Set<Long> set = new HashSet<Long>(temporary);
			 
			 Iterator<Long> iter = set.iterator();
			 
			 while (iter.hasNext()) {
				 	
				 long np = iter.next();
				 
				 	/*
					 * variables to get each string segment having a common hash value
					 * 
					 * */
				 
				 ArrayList<String> t_string = new ArrayList<String>();
				 
				    
				    for (int it = 0;it < temporary.size();it++){
				    	
				    	if(temporary.get(it) == np){
				    		
				    		t_string.add(sub_check.get(it));
				    		
				    	}
				    	
				    }
				    
				    /*
					 * 
					 * collisions of each string segment
					 * 
					 * */
				    
				    collision = collision + collision(t_string);
				    unique = unique + unique(t_string);
				    
				    
				    
			 }
			 
			show(unique,collision);			
			
		}
		
		
	}
	
	private static int unique(List<String> a){
		
		int unique = 0;
		
		if(a.size()>1){
			
			List<String> a_unique = a.stream().distinct().collect(Collectors.toList());
			unique = unique + a_unique.size();
			
		}else{
			
			unique = 1;
			
		}
		
		
		return unique;
		
		
		
	}
	
	private static int collision(List<String> a){
		
		int collision = 0;
		
		for(int i = 0;i < a.size();i++){
			
			if(i != a.size() - 1){
				
				for(int j = i + 1; j < a.size();j++){
					
					
					if(!a.get(i).equals(a.get(j))){
						
						collision++;
					}
					
				}
				
			}
			
			
		}
		
		
		return collision;
		
		
	}
	
	private static void show(int unique, int collision){
		
		
		System.out.printf("%d %d\n",unique,collision);
		
	}
	
	

	
	
	
	
}
