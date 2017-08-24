
import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;






public class Mine_Sweeper {

	public static void main(String[] args) {
		
		
		int n = 0;
		int side = 0;
		int mine = 0;
		Scanner x = new Scanner(System.in);
		/*
		 * 
		 *  Its three difficulty levels were Beginner (8x8, 10 mines),
		 *  Intermediate (16x16, 40 mines) and Expert (24x24, 99 mines).
		 * 
		 * 
		 * 
		 * */
		
		System.out.printf("Enter the Difficulty Level\n");
		String ch = x.nextLine();
		
		if(ch.equals("B")){
			side = 8;
			mine = 10;
		}else if(ch.equals("I")){
				
				side = 16;
				mine = 40;
				
			}else if(ch.equals("E")){
				
				side = 24;
				mine = 99;
			}else{
				
				System.out.printf("Invalid Input");
				
			}
			
		
			
		
		System.out.printf("%d,%d\n",side,mine);
		
		Vector<Vector<Integer>>v = new Vector<Vector<Integer>>();
		
		v = initialize(v,side);
		Vector<Integer> random_num = new Vector<Integer>();
		Vector<Integer> random_num_div = new Vector<Integer>();
		random_num = generate(side,mine);
		int sum = adding(random_num);
		random_num_div = divide_uneven(random_num,mine,sum);
		v.add(random_num);
		v.add(random_num_div);
		
		show(v);
		System.out.printf("%d\n",sum);
		
		
		
		
		

	}
	
	private static Vector<Integer> divide_uneven(Vector<Integer> v, int mine,int sum){
		
		Vector<Integer> partition = new Vector<Integer>();
		
		for(int i = 0; i < v.size();i++){
			
			int temp = Math.floorDiv(v.get(i)*mine, sum);
			partition.add(temp);
		}
		
		
		
		int residual = mine - adding(partition);
		
		System.out.printf("%d\n",residual);
		
		
		if(residual == 0){
			
			return partition;
			
		}else{
			
			return fillup(partition,residual);
			
		}
		
		
		
		
	}
	
	private static Vector<Integer> fillup(Vector<Integer> v,int residual){
		
		Random rand = new Random();
		
		
		for(int i = 0; i< residual;i++){
			
			int pos = rand.nextInt(v.size());
			int temp = v.get(pos);
			temp = temp + 1;
			v.add(pos, temp);
			
			/*v.add(pos,temp + 1);*/
			
		}
		
		return v;
		
	}
	
	
	
	private static Vector<Integer> generate(int side,int mine){
		
		Random rand = new Random();

		int  n = rand.nextInt(200) + mine*2;
		
		Vector<Integer> v = new Vector<Integer>();
		
		
		for(int i = 0; i < side;i++){
			
			v.add(rand.nextInt(n));
			
		}
		
		return v; 
	}
	
	private static int adding(Vector<Integer> v){
		
		int sum = 0;
		
		for(int i = 0; i < v.size();i++){
			
			sum = sum + v.get(i);
			
		}
		
		return sum;
		
		
	}
	
	
	private static Vector<Vector<Integer>> initialize(Vector<Vector<Integer>>v, int rows){
		
		int var = 0;
		for(int i = 0; i < rows;i++){
			
			Vector<Integer>  Temp = new Vector<Integer>();
			
			for(int j = 0; j < rows ; j++){
				
				
				Temp.add(var);
			}
			
			v.addElement(Temp);
			
		}
		
		return v;
		
	}
	
	
private static void show(Vector<Vector<Integer>>v){
		
		for(int i = 0; i < v.size();i++){
			
			Vector<Integer>  Temp = new Vector<Integer>();
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
