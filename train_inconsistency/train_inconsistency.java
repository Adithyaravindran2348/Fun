package starter;
import java.io.*;
import java.util.*;




public class first_question {
	

	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = null;
		
		try{
			
			sc = new Scanner(new File("sample.in"));
			
		}catch(Exception e){
			
			System.out.println(" Could not find file ");
		}
		
		/*
		 * iterator for each row
		 * 
		 * */
		int i = 0;
		
		/*
		 * variable for capacity
		 * 
		 * */
		long c = 0;
		
		/*
		 * variable for number of stations
		 * 
		 * */
		long n = 0;
		
		/*
		 * variable for number of people present in the train at an instant
		 * 
		 * */
		long people = 0;
		
		/*
		 * variable for number of seats free at an instant
		 * 
		 * */
		long free = 0;
		
		/*
		 * boolean variable
		 * 
		 * */
		
		boolean flag = true;
		
		
		while(sc.hasNextLong()){
			
			if(i == 0){
			
			 c = sc.nextLong();
			 n = sc.nextLong();
			 i++;
			
			
			
			}else if(i == 1){
				
				
				/*
				 * has the value for the first station 
				 * 
				 * 							    left: people who left the station
				 * 								entered: people who entered the train
				 *  							stayed: people who stayed in the train
				 * 
				 * */
				long left = sc.nextLong();
				long entered = sc.nextLong();
				long stayed = sc.nextLong();
				
				
				i++;
				
				
				/*
				 * Train should start empty and the number of people inside the train should not exceed 
				 * the capacity
				 * 
				 * */
				
				
				if (left != 0 || conflict_basic(left,entered,c) ){
					flag = false;
					break;
				}
				
				
				
				/*
				 * how many space is available in the train
				 * 
				 * */
				free = general_difference(entered,c);
				
				
				/*
				 * how many people are there in the train
				 * 
				 * */
				
				people = general_difference(free,c);
				
				
				
				/* 
				 * 
				 * customers waiting in vain.
				 * 
				 * */
				if(stayed != 0 & free != 0){
					flag = false;
					break;
					
				}
				
				
				
				
				}else{
					
					/*
					 * has the value for the second station onwards 
					 * 
					 * 							nextleft: people who left the station
					 * 							nextentered: people who entered the train
					 *  						nextstayed: people who stayed in the train
					 * 
					 * */
					long nextleft = sc.nextLong();
					long nextentered = sc.nextLong();
					long nextstayed = sc.nextLong();
					i++;
					
					/*
					 * 
					 * 
					 * last station : all the people should go out, 
					 * 
					 * 				  there should be no one entering the train, 
					 * 
					 * 				  no one waiting for the train.
					 * 
					 * 
					 * 
					 * */
					
					
					
					
					if(i == n+1){
						
						if (nextstayed != 0 || nextentered != 0 || nextleft != people){
							
							flag = false;
							break;
						}
						
					}
					
					/*
					 * 
					 * conflict on capacity: the number of people inside the train should not exceed 
					 * the capacity or the number of people going out should not exceed the capacity
					 * 
					 * conflict on exit: Number of people exiting the train should be less than or equal to the people present 
					 * in the previous station
					 * 
					 * 
					 * 
					 * */
					
					if(conflict_basic(nextleft,nextentered,c) || conflict_present(nextleft, people)){
						
						flag = false;
						break;
						
						
					}
					
					
					/* 
					 * 
					 * variable to get the number of free seats available after exit
					 * but before people start entering the train. 
					 * 
					 * */
					
					
					long free_present = nextleft + free;
					
					
					
					/* 
					 * 
					 * Conflict on people entering the train: number of people entering the train should not exceed 
					 * the present free space
					 *  
					 * 
					 * */
					
					
					if(conflict_present(nextentered,free_present)){
						
						flag = false;
						break;
						
						
					}
					
					
					/*
					 * how many space is available in the train
					 * 
					 * */
					free = general_difference(free_present,nextentered);
					
					/*
					 * how many people are there in the train
					 * 
					 * */
					
					people = general_difference(free,c);
					
					/* 
					 * 
					 * customers waiting in vain.
					 * 
					 * */
					
					
					if(nextstayed != 0 & free != 0){
						flag = false;
						break;
						
					}
					
					
				}
					
					
				}
				
				
				
		sc.close();
		
		if(flag){
			
			
			System.out.println("possible");
			
		}else{
			
			
			System.out.println("impossible");
		}
		
		
		
        
    
		 
				
			}
			
		
	/*
	 * returns long variable after computing difference between two variables
	 * 
	 * @param free: variable of datatype long
	 * @param capacity : variable of datatype long
	 * @returns: long variable after taking the difference of the two parameters 
	 * 
	 * 
	 * 
	 * */	
	
	
	
	private static long general_difference(long free,long capacity){
		
		if(capacity >= free){
		
		return capacity - free;
		} else {
			
			return free - capacity;
		}
	}
	
	/*
	 * returns true if there is a conflict between the two parameters and a constant.used to check whether 
	 * number of people left or entered the train  exceed the capacity
	 * 
	 * @param left: the value  to compare 
	 * @param present : value beign compared
	 * @param capacity: constant value
	 * @returns: boolean value after comparing 
	 * 
	 * 
	 * 
	 * */	

private static boolean conflict_basic(long left,long entered,long capacity){
		
		if (left > capacity || entered > capacity){
			
			return true;
			
		}else{
			
			return false;
		}
		
		
		
	}



/*
 * returns true if there is a conflict beetween the two parameters
 * 
 * @param left: the value  to compare some ting
 * @param present : value beign compared
 * @returns: boolean value after comparing 
 * 
 * 
 * 
 * */

private static boolean conflict_present(long left, long present){
	
	
	if(left > present ){
		
		return true;
		
	}else{
		
		return false;
	}
	
}
	
	
	
	
	
	
	
}

