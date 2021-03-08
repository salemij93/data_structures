package textstats;
import stdlib.*;
import algs23.*;



public class TextStats {

	public static double averageWordLength(String[] words) {
		double avg = 0.0;
		for(int i = 0; i < words.length; i++) {
			avg += words[i].length();
		}
		return avg/words.length;
	} 
	
	public static int numUnique (String[] list) {
		int sum = 0;
		
		if(list.length == 0) {
			return sum;
		}
		
		if(list.length == 1) {
			return sum + 1;
		}
		
		for (int i = 0; i < list.length-1; i++ ) {
			if (list[i].equals(list[i+1])) {
				sum++;
			}
			
		}
	
		return list.length - sum; 
	}
	
	public static String[] deDupAndReverse (String[] list) {
		int countUnique = numUnique (list);
		if (countUnique == 0 ) {
			return new String[] {};
		}
		if (countUnique == 1 ) {
			return new String[] {list[0]};
		}
		String[] uniqueList = new String[countUnique];
		uniqueList[0] = list[list.length-1];
		countUnique--;
		for (int i = 0; i < list.length -1; i++) {
			if (!list[i].equals(list[i+1])) {
				uniqueList[countUnique] = list[i];
				countUnique--;
			} 
		}
		
		return uniqueList; 
	}
	
	
	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String[] a = StdIn.readAllStrings();
		StdOut.println("Total Words : " + a.length);
		Quick.sort(a);
		StdOut.println("First word: " + a[0]);
		StdOut.println("Last word: " + a[a.length-1]);
		StdOut.println("Middle word: " + a[a.length/2]);
		int b = numUnique(a);
		StdOut.println("unique words: " + b);
		String[] d = deDupAndReverse(a);
		StdOut.println("First word in reversed array: " + d[0]);
		StdOut.println("Last word in reversed array: " + d[d.length-1]);
		StdOut.println("Middle word in reversed array: " + d[d.length/2]);
		double xyz = averageWordLength(a);
		StdOut.println("Avg word length: " + xyz);
		
	}

}
