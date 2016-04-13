
public class SequenceAnalyzer implements ISequenceAnalyzer {

	@Override
	public int lengthLCS(String x, String y, int[][] lengths, char[][] pointers) {
		for(int i = 1; i < x.length(); i++){
			lengths[i][0] = 0;
		}
		for(int j = 1; j < y.length(); j++){
			lengths[0][j] = 0;
		}
		for(int i = 1; i <= x.length(); i++){
			for(int j = 1; j <= y.length(); j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					lengths[i][j] = (lengths[i-1][j-1]+1);
					pointers[i][j] = DIAG;
				}
				else if(lengths[i-1][j] >= lengths[i][j-1]){
					lengths[i][j] = lengths[i-1][j];
					pointers[i][j] = UP;
				}
				else{
					lengths[i][j] = lengths[i][j-1];
					pointers[i][j] = LEFT;
				}
			}
		}
		return lengths[x.length()][y.length()];
	}


	public void printLCS(char[][] pointers, String x, int i, int j) {
		if(i == 0  || j == 0){
			return;
		}
		if(pointers[i][j] == DIAG){
			printLCS(pointers,x,i-1,j-1);
			//System.out.println(x);
		}
		else{
			if(pointers[i][j] == UP){
				printLCS(pointers,x,i-1,j);
			}
			else{
				printLCS(pointers,x,i,j-1);
			}
		}
	
	}

	public int computeEditDistance(String x, String y, int[][] dist) {
		for(int i = 1; i <= x.length(); i++){
			dist[i][0] = i;
		}
		for(int j = 1; j <= y.length(); j++){
			dist[0][j] = j;
		}
		for(int i = 1; i <= x.length(); i++){
			for(int j = 1; j <= y.length(); j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dist[i][j] = min(dist[i-1][j-1], dist[i-1][j]+1, dist[i][j-1]+1);
				}
				else{
					dist[i][j] = min(dist[i-1][j-1]+1, dist[i-1][j]+1,dist[i][j-1]+1);
				}
			}	
		}
		return dist[x.length()][y.length()];		
	}

	public void printAlignment(String x, String y, int[][] dist) {
		int i = x.length();
		int j = y.length();
		StringBuilder sbX = new StringBuilder("");
		StringBuilder sbY = new StringBuilder("");
		while(i > 0 || j > 0){
			if(i > 0 && j > 0){
				if(x.charAt(i-1) == y.charAt(j-1)){
					sbX.insert(0,x.charAt(i-1));
					sbY.insert(0,y.charAt(j-1));
					i--;
					j--;
				}
				else if (dist[i-1][j-1]+1 == dist[i][j]){
					sbX.insert(0,x.charAt(i-1));
					sbY.insert(0,y.charAt(j-1));
					i--;
					j--;
				}
				else if(dist[i-1][j]+1 == dist[i][j]){
					sbX.insert(0,x.charAt(i-1));
					sbY.insert(0,'_');
					i--;
				}
				else if(dist[i][j-1]+1 == dist[i][j]){
						sbX.insert(0,'_');
						sbY.insert(0,y.charAt(j-1));
						j--;
					}
			}
			else if(i>0){
				 if(dist[i-1][j]+1 == dist[i][j]){
					sbX.insert(0,x.charAt(i-1));
					sbY.insert(0,'_');
					i--;
				}
			}
			else if(j>0){
				 if(dist[i][j-1]+1 == dist[i][j]){
					sbX.insert(0,'_');
					sbY.insert(0,y.charAt(j-1));
					j--;
				}
			}
		}
		System.out.println(sbX.toString());
		System.out.println(sbY.toString());
	}
	
	public int min(int x1, int x2, int x3){
		return Math.min(x1, Math.min(x2, x3));
		
	}
}
