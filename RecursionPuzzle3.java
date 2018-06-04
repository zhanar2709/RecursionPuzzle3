package recursionPuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionPuzzle3 {
	
	private static ArrayList<Integer> v = new ArrayList<Integer>();
	
	static public ArrayList<Integer> discardNegative(ArrayList<Integer> numbers){
		//
		// Insert code here to produce a new ArrayList where each element in the
		// new list is non-negative and then return that list. The process removes
		// negative values from the input. Order of result is not important.
		//
		// Eliminate the following return instruction!
		//return null;
		int len=numbers.size();
		if(len==0) 
			return numbers;
		Integer x=numbers.get(0);
		ArrayList<Integer>result=new ArrayList<Integer>();
		ArrayList<Integer> y=numbers;
		y.remove(0);
		result.addAll(discardNegative(y));
		if(x>=0)
			result.add(x);
		System.out.println("AA"+result);
		
		return result;
	}
	
	public static void main (String [] args) {
		System.out.println("Enter positive or negative integer values e.g. 1 2 -5 4 followed by end of line.  An empty line signals the end of the input.");
		Scanner keyboard = new Scanner (System.in);
		String str = keyboard.nextLine().trim();
		while (str.length() > 0){
			Scanner valueReader = new Scanner(str);
			while (valueReader.hasNextInt()) {
				Integer x = (Integer)valueReader.nextInt();
				v.add(x);
			}
			str = keyboard.nextLine().trim();
		}
		
		v = discardNegative(v);
		
		System.out.println("The values after removing the negative values are:");
		for (Integer out: v)
			System.out.print(out + " ");
		System.out.println();	
	}
}
