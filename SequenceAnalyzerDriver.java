import java.util.Scanner;


public class SequenceAnalyzerDriver {

	public static void main (String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first sequence (no white space between sequences is allowed).");
		String s1 = scanner.nextLine();
		s1 = s1.toLowerCase();
		System.out.println("Enter second sequence (no white space between sequences is allowed).");
		String s2 = scanner.nextLine();
		s2 = s2.toLowerCase();
		
		ISequenceAnalyzer seqAnalyzer = new SequenceAnalyzer();
		
		// Find the LCS of x and y and print it.
		int[][] lengths = new int[s1.length()+1][s2.length()+1];
		char[][] pointers = new char[s1.length()+1][s2.length()+1];
		System.out.println("The LCS has length: " + seqAnalyzer.lengthLCS(s1, s2, lengths, pointers));
		System.out.print("The LCS is: ");
		seqAnalyzer.printLCS(pointers, s1, s1.length(), s2.length());
		//System.out.println();
		
		// Find the edit distance between x and y and print the corresponding alignment.
		int[][] dist = new int[s1.length() + 1][s2.length() + 1];
		System.out.println("The edit distance is: " + seqAnalyzer.computeEditDistance(s1, s2, dist));
		seqAnalyzer.printAlignment(s1, s2, dist);
		
		scanner.close();
	}

}
