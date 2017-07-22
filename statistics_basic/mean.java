package programmin_abstraction_collections;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class mean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner x = null;
		
		try{
			
			x = new Scanner(new File("1.in"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		Vector<Integer> v = new Vector<Integer>();
		
		while(x.hasNextInt()){
			
			/*if(x.hasNextInt()){*/
				
				v.add(x.nextInt());
			/*}*/
			
		}
		
		Set<Integer> values = new HashSet<Integer>();
		values.addAll(v);
		
		Integer[] arr = values.toArray(new Integer[values.size()]);
		
		
		int[] frequnecy_values = frequency(arr,v);
		
		
		
		for(int i = 0; i < frequnecy_values.length;i++){
			
			System.out.printf("%ds:",arr[i]);
			printstar(frequnecy_values[i]);
			System.out.printf("\n");
			
			
		}
		double ans = meanof(v);
		double stadanrddeviation = stddeviation(ans,v);
		System.out.printf("The average is %f",ans);
		System.out.printf("\nThe standard deviation is %f",stadanrddeviation);
		

	}
	
	private static void printstar(int n){
		
		for(int i = 0; i < n;i++){
			
			System.out.printf("*");
		}
		
	}
	
	private static int[] frequency(Integer[] arr, Vector<Integer> v){
		
		int[] frequency =  new int[arr.length];
		for(int i = 0;i < arr.length;i++){
			for(int j = 0; j < v.size();j++){
				
				if (v.get(j) == arr[i]){
					
					frequency[i] += 1;
				}
				
			}
		}
		
		
		
		
		return frequency;
		
	}
	
	private static float meanof(Vector<Integer> v){
		
		float ans = 0;
		int sum = 0;
		
		for(int i = 0;i < v.size();i++){
			
			sum = sum + v.get(i);
			
		}
		
		ans = sum / v.size();
		
		
		return ans;
	}
	
	
	
	private static double stddeviation(double mean, Vector<Integer> v){
		
		double ans = 0;
		
		double sum = 0;
		
		
		for(int i = 0; i < v.size();  i++){
			
			double interim = 0;
			interim = Math.pow(mean - v.get(i),2);
			sum = sum + interim;
		}
		
		sum = sum / v.size();
		ans = Math.sqrt(sum);
		
		return ans;
	}

}
