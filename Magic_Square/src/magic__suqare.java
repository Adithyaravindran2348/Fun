
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class magic__suqare {

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
		
		while(x.hasNext()){
			
			if (i == 0){
				
				size = x.nextLong();
				System.out.printf("size is %d\n",size);
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
		Vector<Long>  sum_vector = new Vector<Long>();
		sum_vector = rowwise(v);
		
		
		show(v);
		/*System.out.printf("\nsum is \n");
		show_vector(sum_vector);
		
		Vector<Vector<Long>> temp = new Vector<Vector<Long>>();
		temp = get_column(v);
		System.out.printf("\ncolumns are \n");
		
		show(temp);*/
		Vector<Vector<Long>> diag = new Vector<Vector<Long>>();
		diag = get_diagonal(v);
		System.out.printf("\ndiagonals are are \n");
		show(diag);
		
		
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

