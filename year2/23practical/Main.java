/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author southgate
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
    	System.out.println("OPEN HASH");
    	tryhash open = new tryhash();
    	open.main(args);
    	
    	System.out.println("Chained HASH ARRAY");
    	
    	tryhasha open1 = new tryhasha();
    	open.main(args);
    	
    	System.out.println("LINKED LIST HASH ");
    	tryhashll link = new tryhashll();
    	link.main(args);
    	
    	System.out.println("JAVA HASH TABLE");
    	tryhashj jhash = new tryhashj();
    	jhash.main(args);
    }

}
