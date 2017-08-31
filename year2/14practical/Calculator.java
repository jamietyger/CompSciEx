/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;



/**
 *
 * @author southgate
 */
public class Calculator {

static String[] testD = {"2","^","5"};



    public Calculator(){
   
    }

    public void run(String[] input){
       
       String in = Arrays.toString(input);
        String st = in.replace(",","").replace("[", "").replace("]", "").replace(" ", "");
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='+'){
            int result=Integer.parseInt(st.substring(0, i))+Integer.parseInt(st.substring(i+1, st.length()));
             System.out.println(result);


            }
            else if(st.charAt(i)=='-'){

                int result=Integer.parseInt(st.substring(0, i))-Integer.parseInt(st.substring(i+1, st.length()));
             System.out.println(result);


            }


            else if(st.charAt(i)=='*'){

                int result=Integer.parseInt(st.substring(0, i))*Integer.parseInt(st.substring(i+1, st.length()));
             System.out.println(result);


            }
            else if(st.charAt(i)=='/'){

                int result=Integer.parseInt(st.substring(0, i))/Integer.parseInt(st.substring(i+1, st.length()));
             System.out.println(result);


            }

            else if(st.charAt(i)=='%'){

                int result=Integer.parseInt(st.substring(0, i))-Integer.parseInt(st.substring(i+1, st.length()));
             System.out.println(result);


            }

            else if(st.charAt(i)=='^'){
                int result = power(Integer.parseInt(st.substring(0, i)),Integer.parseInt(st.substring(i+1, st.length())));

             System.out.println(result);


            }









        }


    }






private int power(int base, int exp)
{
    int result = 1;
    while (exp != 0)
    {
        if ((exp & 1) == 1)
            result *= base;
        exp >>= 1;
        base *= base;
    }

    return result;
}
        











public static void main(String []args){
              Calculator test = new Calculator();
              test.run(args);

        }
    }

        

