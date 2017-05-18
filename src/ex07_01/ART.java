package ex07_01;

import java.util.Stack;
class bian{
	public int u;
	public int w;
}
public class ART {
	public static int MAXN=1000;
	public static int DFN[]=new int[MAXN];
	public static int L[]=new int[MAXN];
	public static int num=1;
	public static int Eage[][];
	//结点个数
	public static int n=10;
	public static Stack<bian> S=new Stack<bian>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eage=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				Eage[i][j]=0;
			}
		}
		Eage[1][2]=1;Eage[1][4]=1;
		Eage[2][1]=1;Eage[2][3]=1;Eage[2][5]=1;
		Eage[2][7]=1;Eage[2][5]=1;
		Eage[3][2]=1;Eage[3][4]=1;Eage[3][9]=1;Eage[3][10]=1;
		Eage[4][1]=1;Eage[4][3]=1;
		Eage[5][2]=1;Eage[5][6]=1;Eage[5][7]=1;Eage[5][8]=1;
		Eage[6][5]=1;
		Eage[7][2]=1;Eage[7][5]=1;Eage[7][8]=1;
		Eage[8][2]=1;Eage[8][5]=1;Eage[8][7]=1;
		Eage[9][3]=1;
		Eage[10][3]=1;
		for(int i=1;i<=n;i++){
			DFN[i]=0;
		}
		ART(1, 0);
	}
	public static void ART(int u,int v){
		DFN[u]=num;L[u]=num;num+=1;
		for(int w=1;w<=n;w++){
			
			if(Eage[u][w]==1){
				if((v!=w)&&(DFN[w]<DFN[u])){
				bian bian=new bian();
				bian.u=u;
				bian.w=w;
				S.push(bian);
				}
				if(DFN[w]==0){
					ART(w, u);
					if(L[w]>=DFN[u]){
						System.out.println("一个新的连通分量：");
						bian b=new bian();
						do{
							b=S.pop();
							System.out.println("("+b.u+","+b.w+")");
						}while(!((b.u==u&&b.w==w)||(b.u==w&&b.w==u)));
					}
					L[u]=Math.min(L[u], L[w]);
				}
				else{
					if(w!=v){
						L[u]=Math.min(L[u], DFN[w]);
					}
				}
			}
		}
	}
}
