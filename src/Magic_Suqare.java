import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Magic_Suqare {

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
		show(v);
	}
	
	
	
	
	
	
	
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
