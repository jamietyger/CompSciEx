
public class Function {
private double answer;
private String equation;
	
	
	public Function(String funct){
		
		equation = funct;
	
	}
	public String getEq(){
		return equation;
	}
	public double getAns(){
		return answer;
	}
	
	public double solve(int n){
		
		  if(equation.equals("1"))
		  {
		   answer = 1;
		  }         
		  if(equation.equals("logloglogn"))
		  {
			  answer= Math.log(Math.log(Math.log(n)/Math.log(2))/Math.log(2))/Math.log(2);
		  }         
		  
		  if(equation.equals("loglogn"))
		  {
			  answer= Math.log(Math.log(n)/Math.log(2))/Math.log(2);
		  }     
		  
		  if(equation.equals("lnn"))
		  {
			  answer= Math.log(n);
		  }     
		  if(equation.equals("n"))
		  {
			  answer= n;
		  }     
		  if(equation.equals("nlogn"))
		  {
			  answer= n*(Math.log(n)/Math.log(2));
		  }     
		  if(equation.equals("logn^200"))
		  {
			  answer= Math.log((Math.pow(n, 200)))/Math.log(2);
		  }     
		  if(equation.equals("n^2logn"))
		  {
			  answer= Math.pow(n, 2)*(Math.log(n)/Math.log(2));
		  }     
		  if(equation.equals("n^3"))
		  {
			  answer= Math.pow(n, 3);
		  }     
		  if(equation.equals("n^4logn"))
		  {
			  answer= Math.pow(n, 4)*(Math.log(n)/Math.log(2));
		  }     
		  if(equation.equals("n^7sinn"))
		  {
			  answer= Math.pow(n, 7)*Math.sin( Math.toRadians(n));
		  }    
		  if(equation.equals("n^5cosn"))
		  {
			  answer= Math.pow(n, 5)*Math.cos( Math.toRadians(n));
		  }    
		  
		  if(equation.equals("4n^3+2n^2+3n+1"))
		  {
			  answer= (4*Math.pow(n, 3))+(2*Math.pow(n, 2))+(3*n)+1;
		  }    
		  
		  if(equation.equals("n!"))
		  {
			  answer = factorial(n);
		  }    
	
		  
		  if(equation.equals("n!^2"))
		  {
			  answer = Math.pow(factorial(n),2);
		  }  
		  if(equation.equals("10^n"))
		  {
			  answer = Math.pow(10, n);
		  }  
		  if(equation.equals("2^n"))
		  {
			  answer = Math.pow(2, n);
		  }  
		  
		  if(equation.equals("n^n"))
		  {
			  answer = Math.pow(n, n);
		  }  
		  
		  if(equation.equals("n!*n^n"))
		  {
			  answer = factorial(n)*Math.pow(n, n);
		  }  
		  
		  if(equation.equals("n^n^n"))
		  {
			  answer = Math.pow(n,Math.pow(n, n));
		  }  
		  if(equation.equals("n^2!"))
		  {
			  answer = factorial(Math.pow(n, 2));
		  }  
		  if(equation.equals("n^n^2"))
		  {
			  answer = Math.pow(n,Math.pow(n, 2));
		  }  
		  if(equation.equals("(n^n)^2"))
		  {
			  answer = Math.pow(Math.pow(n, n),2);
		  }  

		  
		  if(equation.equals("n^n!"))
		  {
			  answer = Math.pow(n,factorial(n));
		  }  
		
		  if(equation.equals("n!^n"))
		  {
			  answer = Math.pow(factorial(n),n);
		  }  
		return answer;
		
	}
	
	
	public double factorial(double d){
		int result = 1;
	       for (int i = 1; i <= d; i++) {
	           result = result * i;
	       }
		return result;
	}
}
