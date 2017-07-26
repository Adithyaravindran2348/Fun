package programmin_abstraction_collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;


public class calculator {

	public static void main(String[] args) {
		
		System.out.printf("Reverse Polish Calculator Simulator(Type H for Help) \n \nEnter the values \n" );
		
		Stack<Float> memory = new Stack<Float>();
		
		/*  */
		float num = 0;
		
		
		char ch = 'a' ;
		
		int i = 0;
		Scanner x = new Scanner(System.in);
		
		
		
		boolean flag = true;
		
		while( flag){
			  
			
			  if(x.hasNextFloat()){
				  
				  /*if(i == 0){
					  
					  num = x.nextFloat();
					  i++;
					
					  
				  }else{
					  
					  memory.push(num);
					  num = x.nextFloat();
					
				  }*/
				 
				  num = x.nextFloat();
				  memory.push(num);
				  
				  
				  
			  }else{
				  
				  ch = x.next().charAt(0);
			      flag = Scenario(ch,memory);
			      
				  
			  }
			  
		      
		}
		
		System.out.println(memory.size());
		show(memory);

	}
	
	
	private static void show(Stack<Float> m){
		Iterator itr = m.iterator();
		while(itr.hasNext()){
			Object n = itr.next();
			System.out.printf("%f \n",n);
			
		}
		
		
	}
	
	private static boolean Scenario(char c,Stack<Float> m){
		boolean flag = true;
		
		
		if(isexpression(c)){
			
			execute(c,m);
		}else{
			switch(c){
			
			case 'Q':
				flag = false;
				System.out.println("Closing Calculator\n");
				break;
				
			
			case 'H':
				printhelp();
				break;
				
			case 'C':
				m.clear();
				System.out.println("Clear Stack\n");
				break;
				
			 default:
				System.out.println("Entered an invalid command\n");
				break;
			
			
			
			
			
			}
			
			
		}
		
		
		
		return flag;
		
	}
	
	private static boolean isexpression(char c) {
		// TODO Auto-generated method stub
		
		if( (c == '+') || (c == '-')|| (c == '/')|| (c == '*')){
			return true;
			
		}
		
		return false;
	}


	private static void execute(char num, Stack<Float> m){
		
		float rhs = m.pop();
		float lhs = m.pop();
		float ans = 0;
		
		
		switch(num){
			
		case ('+'):
			ans = lhs + rhs;
			break;
		
		case ('-'):
			ans = lhs - rhs;
			break;
		
		case ('*'):
			ans = lhs * rhs;
			break;
			
		case ('/'):
			ans = lhs / rhs;
			break;
			
			
			
		}
		m.push(ans);
		
		
		
		
		
	}
	
	
	
	
	
	private static void printhelp(){
		
		System.out.println("Enter expressions in Reverse Polish Notation, In which the operators follows the operands"
				+ "\n to which they apply,Each line consists of a number,an operator and one of the following commands");
		
		System.out.println("Q--- quits the program");
		System.out.println("H--- Displays this help message");
		System.out.println("C--- Clears the calculator stack\n");
		
		
		
	}

}
