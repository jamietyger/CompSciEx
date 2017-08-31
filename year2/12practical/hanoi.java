import java.lang.Math.*;   
public class hanoi{
static long moves= 0;
   public static void main(String args[]){
	long start, finish, runTime;
	double totalTime = 0.0;
   int n = 12, from = 1, to = 2, other =3;
	int runs = 1, run;
	int repetition, repetitions = 1000;

	for (run=1; run<=runs; run++) {	
		runTime = 0;
		for(repetition=0; repetition<repetitions; repetition++) {
			start = System.currentTimeMillis();
        	moves =0;
			hanoi(n, from, to, other);
			
			finish = System.currentTimeMillis();
			runTime += finish - start;
			
      	System.out.println("Number of moves " + moves);
			}
		totalTime += (double)runTime;
		}
   System.out.println("Average time    = " + totalTime/runs/repetitions);
   System.out.println("Ave/Theoretical = " + totalTime/runs/repetitions/Math.pow(2.0,(double)n));
   System.out.println("n               = " + n);
   System.out.println("Repetitions     = " + repetitions);
   System.out.println("Runs            = " + runs);
   System.out.println("=========================");
	}

static void hanoi(int n, int from, int other, int to) {
//  pre:  n is number of disks on from tower
//  post: have moved n disks from from-tower to to-tower 
//  using other-tower as the holding area
//
// 
	moves+=1;
   if (n == 1) 
		moveDisk (from, to);
	else {
		hanoi (n-1, from, to, other);
//		hanoi (1, from, other, to);
//
      moveDisk (from, to);
		hanoi (n-1, other, from, to);
		}
	}

static void moveDisk(int from, int to) {
//  post: moved 1 disks from from-tower to to-tower directly
// 
//
   // System.out.println("Move from " + from + " to " + to);
	}
}
