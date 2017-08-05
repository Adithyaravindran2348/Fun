
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class magic__suqare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector<Vector<Long>>v = new Vector<Vector<Long>>();
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("sample_1.txt"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		
		int i = 0;
		long size = 0;
		
		while(x.hasNext()){
			
			if (i == 0){
				
				size = x.nextLong();
				System.out.printf("The square size is %d * %d\n\n",size,size);
				i++;
				
			}else{
				
				Vector<Long> temp = new Vector<Long>();
				for(int j  = 0; j < size; j++){
					
					temp.add(x.nextLong());
					
				}
				
				
				v.add(temp);	
				
			}

	}
		
		x.close();
		
		
		
		/*get the column elements as row vectors*/
		Vector<Vector<Long>> col_values = new Vector<Vector<Long>>();
		col_values = get_column(v);
		
		/*get the diagonal elements as row vectors*/
		Vector<Vector<Long>> diag_values = new Vector<Vector<Long>>();
		diag_values = get_diagonal(v);
		
		
		/*variables to get the sum of the row , column and diagonal elements*/
		Vector<Long>  sum_row = new Vector<Long>();
		Vector<Long>  sum_col = new Vector<Long>();
		Vector<Long>  sum_diag = new Vector<Long>();
		
		/*sum of each row, column and diagonal elelements*/
		sum_row = rowwise(v);
		sum_col = rowwise(col_values);
		sum_diag = rowwise(diag_values);
		
		/*prints out all the elements in the box*/
		show(v);
		
		/*checks if the sum of row, column and diagonal elements are equal*/
		if(equal_sum(sum_row) && equal_sum(sum_col) && equal_sum(sum_diag)  ){
			
			System.out.printf("\nThis is a Magic Square \n");
			
		}else{
			
			System.out.printf("\nThis is not a Magic Square \n");
		}
		
		
		
	}
	
	
	/*
	 * 
	 * checks the equality of elements in a vector 
	 * 
	 * @param: vector of sum of the row, column or diagonal elements in the box
	 * @return: boolean variable  
	 * 
	 * 
	 * 
	 * */
	
	private static boolean equal_sum(Vector<Long>v){
		
		boolean flag = true;
		
		for(int i = 0; i < v.size();i++){
			
			
			
			
			for(int j = i +1 ;j < v.size();j++){
				
				if(v.get(i) != v.get(j)){
					
					flag = false;
					break;
					
				}
				
			}
		}
		
		
		
		
		return flag;
	}
	
	/*
	 * 
	 * Takes the sum of the whole vector 
	 * 
	 * @param: vector of number's of the row, column or diagonal elements in the box
	 * @return: Long integer sum of the elements in the vectors 
	 * 
	 * 
	 * 
	 * */
	
	
	private static long sum(Vector<Long> v){
		
		long sum = 0;
		
		for(int i = 0; i < v.size(); i++){
			
			sum = sum + v.get(i);
			
			
			
		}
		
		return sum;
		
	}
	
	/*
	 * 
	 * performs row-wise addition of all the elements in a vector
	 * 
	 * @param: vector of vectors containing column or diagonal elements in the box
	 * @return: Long integer sum of the elements in the vectors 
	 * 
	 * 
	 * 
	 * */
	private static Vector<Long> rowwise(Vector<Vector<Long>>v){
		
		long g = 0;
		Vector<Long>  sum_vector = new Vector<Long>();
		
		for(int i = 0; i < v.size();i++){
			Vector<Long>  temp = new Vector<Long>();
			temp = v.get(i);
			sum_vector.add(sum(temp));	
			
		}
		
		
		
		
		return sum_vector;
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
	 * 
	 * Takes the vector of vectors and returns all the column elements  
	 * 
	 * @param: Input vector of vectors 
	 * @return: vector containing Column elements   
	 * 
	 * 
	 * 
	 * */

	private static Vector<Vector<Long>> get_diagonal(Vector<Vector<Long>> v){
		
		Vector<Vector<Long>> temp = new Vector<Vector<Long>>();
		
		for(int i = 0; i < v.size() ; i = i + v.size() -1 ){
			
			
			Vector<Long> Add_vector = new Vector<Long>();
			
			for(int j = 0; j < v.size(); j++){
				
				Vector<Long> inter = new Vector<Long>();
				inter = v.get(j);
				
				if(i == 0){
					
					Add_vector.add(inter.get(j));
					
					
				}else{
					
					
					if(j == v.size() - 1){
						
						Add_vector.add(inter.get(0));
						
					}else if(j == 0){
						
						Add_vector.add(inter.get(v.size() - 1));
						
						
					}else{
						
						Add_vector.add(inter.get(v.size() - 1 - j));
					}
					
					
				}
				
				
				
			}
			
			temp.add(Add_vector);
			
			
		}
		
		
		
		
		return temp;
		
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

}

