package examsolutions;
import algs13.Queue;
import algs13.Stack;
import java.util.*;
import stdlib.*;

public class ReverseQueue {

	public static Queue<Integer> reverseQueue(Queue<Integer> q1) {
		
		Stack<Integer> q2 = new Stack<>();
		int a = q1.size();
		if(a == 0) {return q1;}
		for(int i = 0; i < a; i++) {
			q2.push(q1.dequeue());
		}
		Queue<Integer> q3 = new Queue<>();
		for(int i = 0; i < a; i++) {
			q3.enqueue(q2.pop());
		}
		return q3;
	}
		
	public static void main(String[] args) {
		Queue<Integer> a = new Queue<>();
		Integer[] b = new Integer[20];
		Random r = new Random();
		for (int i = 0; i < b.length; i++) {
			b[i] = r.nextInt(1001);
			a.enqueue(b[i]);
		}
		Queue<Integer> c = new Queue<>();
		StdOut.println(a.toString());
		c = reverseQueue(a);
		StdOut.println("New Queue");
		StdOut.println(c.toString());

		
	}

}
