


import java.io.File;
import java.util.Scanner;
import java.util.Vector;


public class sudolu_check {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<Long>>v = new Vector<Vector<Long>>();
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("values.txt"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		
		int i = 0;
		long size = 0;
		boolean flag = true;
		
		while(flag){
			
			if (i == 0){
				
				size = x.nextLong();
				System.out.printf("Sudoku is of size is %d * %d\n",size,size);
				i++;
				
			}else{
				
				
				i++;
				if(i > size + 1){
					break;
				}
				Vector<Long> temp = new Vector<Long>();
				
				for(int j  = 0; j < size; j++){
					
					if(x.hasNextLong()){
						
						temp.add(x.nextLong());
						
					}else{
						
						System.out.printf("\nInvalid entry\n");
						flag = false;
						break;
						
					}
					
					
				}
				
				
				
				v.add(temp);	
				
			}

	}
		x.close();
		
		if(flag){
				
			
			
			show(v);
		
		/*gets all the column values of the sudoku puzzle*/
		Vector<Vector<Long>>col_values = new Vector<Vector<Long>>();
		col_values = get_column(v);
		
		/*gets all the 3*3 inner matrix as a row vector*/
		Vector<Vector<Long>>inner_matrix = new Vector<Vector<Long>>();
		inner_matrix = get_inner_matrix(v);
		
		
		/*condition for a valid sudoku is checked here, row elements,column elements, inner matrix elements are not duplicate*/
		if(equal_row(v) && equal_row(col_values) && equal_row(inner_matrix)){
			
			System.out.println("\nThis is a valid sudoku\n");
			
		}else{
			
			System.out.println("\nThis is not a valid sudoku answer\n");
			
		}
		}
		
		
}
	
	/*
	 * 
	 * checks the equality of elements in a vector  
	 * 
	 * @param: vector of  elements  
	 * @return: boolean variable  
	 * 
	 * 
	 * 
	 * */
	
	private static boolean equal_elements(Vector<Long>v){
		
		boolean flag = true;
		
		for(int i = 0; i < v.size();i++){
			
			for(int j = i +1 ;j < v.size();j++){
				
				if(v.get(i) == v.get(j)){
					
					flag = false;
					break;
					
				}
				
			}
		}
	
		return flag;
	}
	
	/*
	 * 
	 * checks the equality of elements in a vector  
	 * 
	 * @param: vector of  elements  
	 * @return: boolean variable  
	 * 
	 * 
	 * 
	 * */
	
	private static boolean equal_row(Vector<Vector<Long>>v){
		
		boolean flag = true;
		
		for(int i = 0; i < v.size(); i++){
			
			
			Vector<Long> temp = new Vector<Long>();
			
			temp = v.get(i);
			flag = equal_elements(temp);
			
			if(!flag){
				break;
			}
			
			
		}
		
		return flag;
		
	}
	
	/*
	 * 
	 * Prints out all the elements in a vector
	 * 
	 * @param: Input vector of elements
	 * @return: void
	 * 
	 * 
	 * 
	 * */
	private static void show_vector(Vector<Long> v){
		
		
		for(int j = 0; j < v.size();j++){
			
			System.out.printf("%d ",v.get(j));




	}
		
		
	}
	

	/*
	 * 
	 * prints out all the elements in the box
	 * 
	 * @param: vector of vector's containing the box elements
	 * @return: void
	 * 
	 * 
	 * 
	 * */
	
	
		private static void show(Vector<Vector<Long>>v){
		
				for(int i = 0; i < v.size();i++){
			
						Vector<Long>  Temp = new Vector<Long>();
						Temp = v.get(i);
			
							for(int j = 0; j < Temp.size();j++){
				
									System.out.printf("%d ",Temp.get(j));
				
									if(j == Temp.size() - 1){
					
										System.out.printf("\n");
					
									}
				
							}
			
				}
		
		}
		
		/*
		 * 
		 * Takes the vector of vectors and returns all the column elements  
		 * 
		 * @param: Input vector of vectors 
		 * @return: vector containing Column elements   
		 * 
		 * 
		 * 
		 * */
		private static Vector<Vector<Long>> get_column(Vector<Vector<Long>> v){
			
			Vector<Vector<Long>> temp = new Vector<Vector<Long>>();
			
			
			for(int j = 0; j < v.size(); j++){
				Vector<Long> Add_vector = new Vector<Long>();
			for(int i = 0; i < v.size(); i++){
				Vector<Long> inter = new Vector<Long>();
				inter = v.get(i);
				Add_vector.add(inter.get(j));
				
			}
			temp.add(Add_vector);
			}
			
			
			
			return temp;
			
			
		}
	/*
	 * returns the inner 3*3 matrix as row vector of vectors
	 * 
	 * @param: vector of vectors containing all the elements of sudoku
	 * @return: the vector of vectors containing the inner matrix as row  vector
	 * 
	 * 
	 * 
	 * */	
     private static Vector<Vector<Long>> get_inner_matrix(Vector<Vector<Long>>v){
    	 
    	 Vector<Vector<Long>>final_matrix= new Vector<Vector<Long>>();
    	 
    	 for(int i = 0; i < v.size(); i = i +3){
    		 
    		 Vector<Long> temp = new Vector<Long>();
    		 
    		 Vector<Long> temp_1 = new Vector<Long>();
    		 Vector<Long> temp_2 = new Vector<Long>();
    		 Vector<Long> temp_3 = new Vector<Long>();
    		 
    		 for(int k = 0; k < 3; k++){
    		 
    			 temp = v.get(i + k);
    			 
    			 for(int j = 0; j < v.size(); j++){
    			 
    				 if(j < v.size() - 6){
    					 		temp_1.add(temp.get(j));
    				 
    				 	}else if(j >= v.size() - 6 && j < v.size() - 3){
    				 			temp_2.add(temp.get(j));
    			 
    				 	}else if(j >= v.size() - 3){
    				 			temp_3.add(temp.get(j));
    				 
    			 }
    			 
    			 
    		 }
    	
    		 }
    		 
    		 final_matrix.add(temp_1);
    		 final_matrix.add(temp_2);
    		 final_matrix.add(temp_3);
    		
    		 
    		 
    	 }
    	 
    	 
    	 
    	 return final_matrix;
  
     }
	

}
