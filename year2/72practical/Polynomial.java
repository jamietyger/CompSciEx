


import java.util.ArrayList;
import java.util.LinkedList;




public class Polynomial {


        ArrayList<Integer> poly1 = new ArrayList<Integer>();
        ArrayList<Integer> poly2 = new ArrayList<Integer>();
        int size =0;
        String operation;
        static String[] testD = {"1","1","^","2"};



    public void setup(String[] test){


        for(int i=0;i<test.length;i++){
            if(test[i].equals("+") || test[i].equals("-") || test[i].equals("*") || test[i].equals("^")){
               size = i;
               operation = test[i];
               break;


            }
            else{
                poly1.add(Integer.parseInt(test[i]));


                }
        }
      for(int i = size+1; i<test.length;i++){
          poly2.add(Integer.parseInt(test[i]));




            }

    if(operation.equals("+")){


        System.out.println("polynomial "+ poly1.toString().replace(","," ").replace("[", "").replace("]", "")+ " "+operation);
        System.out.print("polynomial ");
        makeSpaces(poly1.size()-poly2.size());
        System.out.print(poly2.toString().replace(","," ").replace("[", "").replace("]", ""));
        System.out.println();
        System.out.println("------------------------------------------");
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer = this.add();
        System.out.println("polynomial "+answer.toString().replace(","," ").replace("[", "").replace("]", ""));
       calculate(answer);
    }
    else if(operation.equals("-")){
    	  System.out.println("polynomial "+ poly1.toString().replace(","," ").replace("[", "").replace("]", "")+ " "+operation);
          System.out.print("polynomial ");
          makeSpaces(poly1.size()-poly2.size());
          System.out.print(poly2.toString().replace(","," ").replace("[", "").replace("]", ""));
          System.out.println();
          System.out.println("------------------------------------------");
          ArrayList<Integer> answer = new ArrayList<Integer>();
          answer = this.minus();
          System.out.println("polynomial "+answer.toString().replace(","," ").replace("[", "").replace("]", ""));
         calculate(answer);
    }
    else if(operation.equals("*")){
    	  System.out.println("polynomial "+ poly1.toString().replace(","," ").replace("[", "").replace("]", "")+ " "+operation);
          System.out.print("polynomial ");
          makeSpaces(poly1.size()-poly2.size());
          System.out.print(poly2.toString().replace(","," ").replace("[", "").replace("]", ""));
          System.out.println();
          System.out.println("------------------------------------------");
          ArrayList<Integer> answer = new ArrayList<Integer>();
          answer = this.multiply();
          System.out.println("polynomial "+answer.toString().replace(","," ").replace("[", "").replace("]", ""));
         calculate(answer);
    }
    else if(operation.equals("^")){
    	  System.out.println("polynomial "+ poly1.toString().replace(","," ").replace("[", "").replace("]", "")+ " "+operation);
          System.out.print("polynomial ");
          makeSpaces(poly1.size()-poly2.size());
          System.out.print(poly2.toString().replace(","," ").replace("[", "").replace("]", ""));
          System.out.println();
          System.out.println("------------------------------------------");
          ArrayList<Integer> answer = new ArrayList<Integer>();
          answer = this.power();
          System.out.println("polynomial "+answer.toString().replace(","," ").replace("[", "").replace("]", ""));
         calculate(answer);
    }

        }

    public ArrayList<Integer>  add(){
        ArrayList<Integer> c = new ArrayList<Integer>();
        int max = Math.max(poly1.size(), poly2.size());


      
        for(int i = 0; i< max;i++){  //fill answer
            c.add(0);
        }

        if(poly1.size()>poly2.size()){


        int len = poly1.size() - poly2.size();
        for(int k = 0; k<len;k++){
            c.set(k, poly1.get(k));
        }
       

        for(int j =len ;j<max;j++){
            c.set(j, poly1.get(j)+poly2.get(j-len));
        }

        }
        else{
              int len = poly2.size() - poly1.size();
        for(int k = 0; k<len;k++){
            c.set(k, poly2.get(k));
        }


        for(int j =len ;j<max;j++){
            c.set(j, poly1.get(j-len)+poly2.get(j));
        }

        }

        return c;

    }

 public ArrayList<Integer>  minus(){
        ArrayList<Integer> c = new ArrayList<Integer>();
        int max = Math.max(poly1.size(), poly2.size());



        for(int i = 0; i< max;i++){  //fill answer
            c.add(0);
        }

        if(poly1.size()>poly2.size()){


        int len = poly1.size() - poly2.size();
        for(int k = 0; k<len;k++){
            c.set(k, poly1.get(k));
        }

 System.out.println("polynomial "+this.minus().toString().replace(","," ").replace("[", "").replace("]", ""));
        for(int j =len ;j<max;j++){
            c.set(j, poly1.get(j)-poly2.get(j-len));
        }

        }
        else{
              int len = poly2.size() - poly1.size();
        for(int k = 0; k<len;k++){
            c.set(k, -(poly2.get(k)));
        }


        for(int j =len ;j<max;j++){
            c.set(j, poly1.get(j-len)-poly2.get(j));
        }

        }

        return c;

    }


     public ArrayList<Integer>  multiply(){
        ArrayList<Integer> c = new ArrayList<Integer>();
        int max = poly1.size()+poly2.size();
        for(int i = 0; i< max-1;i++){  //fill answer
            c.add(0);
        }

        for(int i =0; i<poly1.size();i++){

            for(int j =0; j<poly2.size();j++){

                c.set(i+j, c.get(i+j)+poly1.get(i)*poly2.get(j));
            }


        }

        return c;

    }

public ArrayList<Integer> power(){
     ArrayList<Integer> c = new ArrayList<Integer>();

     int power = poly2.get(0);
     poly2 = poly1;
     for(int i = 0;i<power-1;i++){

         c = multiply();
         poly2 = c;
     }
     return c;

}

public void calculate(ArrayList<Integer> input){
	System.out.println();
	int[] xval = {0,2,4,10,16,64,-10,-16};
	
	
	for(int i =0;i<xval.length;i++){
		double sum=0;
		int len = input.size();
		for(int j=0;j<input.size();j++ ){
			sum = sum+Math.pow(xval[i],len-1)*input.get(j);
			len--;
		}
		System.out.println("f("+xval[i]+") = "+sum);
	}
}

  
public static void makeSpaces(int num){
	for(int i =0;i<num;i++){
		System.out.print("   ");
	}
	
}
    public static void main(String [] args){

      Polynomial test = new Polynomial();
       test.setup(args);








}
}


