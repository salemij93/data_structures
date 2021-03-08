package algs11;
import stdlib.*;
import java.util.*;
public class Hello {
  public static void main (String[] args) {
	  //Trace.showBuiltInObjects (true);
	  //Trace.drawSteps ();
	  //Trace.run();
	  Integer x = 3000;
	  Integer y = 3000; 
	  StdOut.println("x=" + x + ", y=" + y);
	  StdOut.println(" x==y : " + (x == y));
	  StdOut.println(" x.equals(y) : " + (x.equals(y)));
	  StdOut.println(" Objects.equals(x,y) : " + (Objects.equals(x,y)));
	  int z = 10;
	  int a = 3;
	  int solution = numerToPower(a,z);
	  StdOut.println(solution);
	  
  }
  public static int numerToPower(int x, int y) {
	  int power=x;
	  for(int i = 0; i < y-1; i++) {
		  x*=power;
		  }
	  return x ;
  }
  }