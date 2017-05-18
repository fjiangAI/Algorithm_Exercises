package ex08_02;

public class NQueen {
	
	static int n=8;
	static int x[]=new int[n+1];
	static char show[][]=new char[n+1][n+1];
	static int count=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen(1);
	}
	public static void restartshow(){
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				show[i][j]='■';
			}
		}
	}
	public static void show(int count){
		System.out.println("第"+count+"种解法");
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				System.out.print(show[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean Place(int k){
		int i=1;
		while(i<k){
			if(x[i]==x[k]||(Math.abs(x[i]-x[k])==Math.abs(i-k))){
				return false;
			}
			i++;
		}
		return true;
	}
	public static void NQueen(int k){
		x[k]=1;
		while(x[k]<=n){
			if(Place(k)){
				if(k==n){
					restartshow();
					for(int i=1;i<=k;i++){
						//System.out.print(x[i]+"\t");
						show[i][x[i]]='*';
					}
					show(count++);
					
					//System.out.println("");
				}
				else{
					NQueen(k+1);
				}
			}
			x[k]++;
		}
	}
}
