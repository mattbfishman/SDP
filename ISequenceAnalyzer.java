public interface ISequenceAnalyzer {

	/**
	 * A char constant that represents the fact that a solution was obtained from the cell above
	 * in a dynamic programming table.
	 */
	public static final char UP = 'u';
	/**
	 * A char constant that represents the fact that a solution was obtained from the cell to the
	 * left in a dynamic programming table.
	 */
	public static final char LEFT = 'l';
	/**
	 * A char constant that represents the fact that a solution was obtained from the cell diagonally
	 * left and up in a dynamic programming table.
	 */
	public static final char DIAG = 'd';

	/**
	 * Finds the longest common subsequence of <code>x</code> and <code>y</code>.
	 * 
	 * After this method returns, the lengths of the longest common subsequences of any two
	 * prefixes of <code>x</code> and <code>y</code> are stored in the given
	 * <code>lengths</code> table. The length of the longest common subsequence of 
	 * x and y is stored in lengths[x.length()][y.length()].
	 * 
	 * After this method returns, each cell (i,j) of the <code>pointers</code> table contains
	 * a pointer that describes how the corresponding value of the (i,j) cell in the 
	 * <code>lengths</code> table was derived.
	 * A cell in the <code>pointers</code> table can have 3 possible values:
	 * - DIAG: means that the value in lengths[i][j] was based on the value of lengths[i-1][j-1]
	 * - UP: means that the value in lengths[i][j] was based on the value of lengths[i-1][j]
	 * - LEFT: means that the value in lengths[i][j] was based on the value of lengths[i][j-1]
	 * 
	 * PREREQUISITES:
	 * - lengths and pointers have dimensions x.length() + 1 by y.length() + 1
	 * 
	 * @param x
	 * @param y
	 * @param lengths
	 * @param pointers
	 * @return
	 */
	public int lengthLCS(String x, String y, int[][] lengths, char[][] pointers);

	/**
	 * Print the longest common subsequence based on pointers stored in the
	 * <code>pointers</code> table. <code>i</code> and <code>j</code> are are the indices of the
	 * cell that corresponds to the final solution. 
	 * 
	 * @param pointers
	 * @param x
	 * @param i
	 * @param j
	 */
	public void printLCS(char[][] pointers, String x, int i, int j);
	
	
	
	/**
	 * Computes the edit distance between the given sequences <code>x</code> and <code>y</code>
	 * using the dynamic programming approach.
	 * 
	 * After this method returns, <code>dist</code> contains the edit distances between all prefixes of
	 * <code>x</code> and <code>y</code>. The  edit distance between <code>x</code> and <code>y</code> 
	 * is stored in dist[x.length][y.length] (indexing of <code>dist</code> starts from 0, thus
	 * dist is a (x.length + 1) by (y.length + 1) table.).
	 * 
	 * @param x The first sequence
	 * @param y The second sequence
	 * @param dist The table that contains the edit distances between all prefixes of
	 * <code>x</code> and <code>y</code>.
	 * @return The edit distance between <code>x</code> and <code>y</code>. 
	 */
	public int computeEditDistance(String x, String y, int[][] dist);
	
	
	
	/**
	 * Print the alignment that corresponds to the minimum edit distance of
	 * <code>x</code> and <code>y</code> based on the given table <code>dist</code>.
	 * 
	 * <code>dist</code> contains the edit distances between all prefixes of
	 * <code>x</code> and <code>y</code>. The  edit distance between <code>x</code> and <code>y</code> 
	 * is stored in <code>dist[x.length][y.length]</code> (indexing of <code>dist</code> starts from 0, thus
	 * <code>dist</code> is a (x.length + 1) by (y.length + 1) table.). 
	 * 
	 * @param x The first sequence
	 * @param y The second sequence
	 * @param dist The table that contains the edit distances between all prefixes of
	 * <code>x</code> and <code>y</code>.
	 */
	public void printAlignment(String x, String y, int[][] dist);

}