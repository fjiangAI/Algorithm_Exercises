package ex07_02;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
class bian{
	public int u;
	public int w;
}
class Compnet{
	public int C1;
	public int C2;
}
public class ART2 {
	public static int MAXN=1000;
	public static int DFN[]=new int[MAXN];
	public static int L[]=new int[MAXN];
	public static int num=1;
	public static int Eage[][];
	//结点个数
	public static int n=10;
	public static int Count=0;
	public static List<Nodelist> componentlist=new LinkedList<Nodelist>();
	public static Stack<bian> S=new Stack<bian>();
	public static List<Compnet> couple=new LinkedList<Compnet>();
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
		ChangeToBG();
	}
	public static void ChangeToBG(){
		System.out.println("需要连接的边为：");
		for(int i=0;i<componentlist.size();i++){
			Nodelist nl1=componentlist.get(i);
			for(int j=0;j<componentlist.size();j++){
				//如果不是自己
				if(i!=j){
					//如果在couple列表里两个连通分图还没有链接过
					Nodelist nl2=componentlist.get(j);
					int flag=0;
					for (Compnet C : couple ) {
						if((C.C1==nl1.No&&C.C2==nl2.No)||(C.C1==nl2.No&&C.C2==nl1.No)){
							flag=1;
							break;
						}
					}
					if(flag==1){
						continue;
					}
					for(int k=0;k<nl1.list.size();k++){
						int node1=nl1.list.get(k);
						//如果找到有公共结点
						int index=nl2.list.indexOf(node1);
						if(index!=-1){
							//把这两个分图的序号加入到couple中
							Compnet ctCompnet=new Compnet();
							ctCompnet.C1=nl1.No;
							ctCompnet.C2=nl2.No;
							couple.add(ctCompnet);
							//把这两个中不是关节点的两个连上;
							
							if(index==0&&k==0){
								System.out.println("("+nl1.list.get(1)+","+nl2.list.get(1)+")");
							}
							else if(index!=0&&k==0) {
								System.out.println("("+nl1.list.get(1)+","+nl2.list.get(index-1)+")");
							}
							else if(index==0&&k!=0) {
								System.out.println("("+nl1.list.get(k-1)+","+nl2.list.get(1)+")");
							}
							else {
								System.out.println("("+nl1.list.get(k-1)+","+nl2.list.get(index-1)+")");
							}
							break;
						}
					}
				}
			}
		}
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
						//System.out.println("new biconnected component");
						Nodelist nl=new Nodelist(Count++);
						bian b=new bian();
						do{
							b=S.pop();
							//System.out.println("("+b.u+","+b.w+")");
							nl.add(b.u);
							nl.add(b.w);
						}while(!((b.u==u&&b.w==w)||(b.u==w&&b.w==u)));
						componentlist.add(nl);
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
