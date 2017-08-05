


import java.io.File;
import java.util.Scanner;
import java.util.Vector;


public class sudolu_check {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<Long>>v = new Vector<Vector<Long>>();
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("sample.txt"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		
		int i = 0;
		long size = 0;
		
		while(x.hasNext()){
			
			if (i == 0){
				
				size = x.nextLong();
				System.out.printf("Sudoku is of size is %d * %d\n\n",size,size);
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
		
		
		Vector<Vector<Long>>col_values = new Vector<Vector<Long>>();
		col_values = get_column(v);
		
		if(equal_row(v) && equal_row(col_values)){
			
			System.out.println("\nThis is a valid sudoku\n");
			
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
	

}
