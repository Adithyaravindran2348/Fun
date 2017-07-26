package programmin_abstraction_collections;

import java.util.Scanner;
import java.util.Vector;

public class sieve_of_eratosthenes {

	public static void main(String[] args) {
		
		
		System.out.println("BEHOLD THE SIEVE OF ERATOSTHENES,\n \nWHERE JUST BY ENTERING A NUMBER YOU GET BACK ALL THE PRIME NUMBERS WITHIN THAT NUMBER AND 2"
				+ "\n \nPLEASE BE KIND ENOUGH TO ENTER A NUMBER GREATER THAN 2 BUT LESS THAN 1000,"
				+ "\n \nENTER 0 TO QUIT THE PROGRAM,\n \nALL HAIL CHARLES BABBAGE ");
		// TODO Auto-generated method stub
		
		Scanner x = new Scanner(System.in);
		Vector<Integer> value = new Vector<Integer>();
		
		
		value.add(2);
		boolean flag = true;
		while(flag){
			
			int n = x.nextInt();
			if(n == 0){
				
				flag = false;
				
			}else{
				
				
				enter_value(value,n);
				prime_value(value);
				
				System.out.printf("All the prime nubers beetween %d and %d are\n",2,n);
				show(value);
				
			}
			
			
			
			
			
		}

	}
	
	/*
	 * 
	 * this method returns all the prime numbers in a vector
	 * 
	 * @param vector with non prime and prime numbers
	 * @return vector with prime numbers
	 * 
	 * 
	 * 
	 * */
	private static Vector<Integer> prime_value(Vector<Integer> v){
		
		for(int i = 0;i< v.size();i++){
			
			for(int j = i + 1; j < v.size();j++){
				
				int a = v.get(i);
				int b = v.get(j);
				
				
				if(b % a == 0){
					
					v.remove(j);
					
				}
				
			}
			
		}
		
		
		return v;
	}
	
	/*
	 * 
	 * this method returns all values between 2 and a value in a vector
	 * 
	 * @param empty vector variable
	 * @param range
	 * @return vector with values of a given range
	 * 
	 * 
	 * 
	 * */
	private static Vector<Integer> enter_value(Vector<Integer> v,int n){
		
		for(int i = 1;i <= n - 2;i++){
			
			v.addElement(2 + i);
			
		}
		
		return v;
	}
	/*
	 * 
	 * outputs all the element in vector
	 * 
	 * @param  vector variable 
	 * 
	 * @return void
	 * 
	 * 
	 * 
	 * */
   private static void show(Vector<Integer> v){
		
		for(int i = 0;i < v.size();i++){
			
			System.out.printf("%d \n",v.get(i));
			
		}
		
		
	}

}
