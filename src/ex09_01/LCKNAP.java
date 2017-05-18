package ex09_01;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCKNAP {
	/* @param LBB
	 * 目前的下限
	 * @param UBB
	 * 目前的上限
	 * */
	public static double LBB,UBB;
	public static int MAXN=100;
	public static int N=10;
	public static double M=10;
	public static double e=0.1;
	public static double P[]=new double[MAXN+1];
	public static double W[]=new double[MAXN+1];
	public static int PARENT[]=new int[MAXN+1];
	public static int LEVEL[]=new int[MAXN+1];
	public static int TAG[]=new int[MAXN+1];
	public static double CU[]=new double[MAXN+1];
	public static double PE[]=new double[MAXN+1];
	public static double UB[]=new double[MAXN+1];
	//活结点表
	public static List<Integer> LiveNode=new LinkedList<Integer>();
	//新节点
	public static int I=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=4;M=15;
		P[1]=10;W[1]=2;
		P[2]=10;W[2]=4;
		P[3]=12;W[3]=6;
		P[4]=18;W[4]=9;
		LCKNAP(M, N, e);
		N=5;M=12;
		P[1]=10;W[1]=4;
		P[2]=15;W[2]=6;
		P[3]=16;W[3]=3;
		P[4]=8;W[4]=4;
		P[5]=4;W[5]=2;
		LCKNAP(M, N, e);
		N=5;M=15;
		P[1]=4;W[1]=4;
		P[2]=4;W[2]=4;
		P[3]=5;W[3]=5;
		P[4]=8;W[4]=8;
		P[5]=9;W[5]=9;
		LCKNAP(M, N, e);
		
		
	}
	public static int LARGEST(){
		Integer E=0;
		double MAXUB=0;
		for (Integer I : LiveNode) {
			if(UB[I]>MAXUB){
				MAXUB=UB[I];
				E=I;
			}
		}
		LiveNode.remove(E);
		return E;
	}
	public static void INIT(){
		for(int i=0;i<MAXN+1;i++){
			PARENT[i]=0;
			LEVEL[i]=0;
			TAG[i]=0;
			CU[i]=0;
			PE[i]=0;
			UB[i]=0;
		}
		LBB=0;
		UBB=0;
		LiveNode=new LinkedList<Integer>();
		I=1;
	}
	public static void show(int E){
		System.out.println("------------Now,Trees are folling:");
		System.out.println("E:"+E);
		System.out.println("PARENT:"+PARENT[E]);
		System.out.println("LEVEL:"+LEVEL[E]);
		System.out.println("TAG:"+TAG[E]);
		System.out.println("CU:"+CU[E]);
		System.out.println("PE:"+PE[E]);
		System.out.println("UB:"+UB[E]);
	}
	public static void showlist(){
		System.out.println("Now,livenode are :------------");
		for (Integer d : LiveNode) {
			System.out.print(d+",");
		}
		System.out.println("");
	}
	public static void LCKNAP(double M,int N,double e){
		double L,cap,prof;
		int ANS=0,X;
		//初始化结点
		INIT();
		//获取根节点
		int E=1;
		PARENT[E]=0;LEVEL[E]=1;CU[E]=M;PE[E]=0;
		LUBOUND(M,0,1);
		L=LBB-e;
		UB[E]=UBB;
		do{
			//show(E);
			int i=LEVEL[E];
			cap=CU[E];
			prof=PE[E];
			if(i==N+1){
				if(prof>L){
					L=prof;
					ANS=E;
				}
			}
			else{
					if(cap>=W[i]){
						NEWNODE(E, i+1, 1, cap-W[i], prof+P[i], UB[E]);
					}
					LUBOUND(cap, prof, i+1);
					if(UBB>L){
						NEWNODE(E, i+1, 0, cap, prof, UBB);
						L=Math.max(L, LBB-e);
					}
				}
			if(LiveNode.isEmpty()){
				break;
			}
			//showlist();
			//查找下一个E结点,是树中结点UB最大的结点。
			E=LARGEST();
			//showlist();
			
		}while(UB[E]>L);
		FINISH(L, ANS);
	} 
	/***
	 * 创建一个新节点
	 * @param par
	 * 父节点
	 * @param lev
	 * 层级
	 * @param t
	 * @param d
	 * @param f
	 * @param uB
	 */
	public static void NEWNODE(int par,int lev,int t,double cap,double prof,double ub){
		I++;
		PARENT[I]=par;
		LEVEL[I]=lev;
		TAG[I]=t;
		CU[I]=cap;
		PE[I]=prof;
		UB[I]=ub;
		LiveNode.add(I);
	}
	/***
	 * 打印出结果
	 * @param L
	 * 这是最终结果
	 * @param ANS
	 * 这是回溯起点
	 * @param N
	 * 这是所有节点数
	 */
	public static void FINISH(double L,int ANS){
		System.out.println("VALUE OF OPTIMAL FILLING IS "+L);
		System.out.println("OBJECTS IN KNAPSACK ARE");
		for(int j=N;j>=1;j--){
			if(TAG[ANS]==1){
				System.out.print(j+",");
			}
			ANS=PARENT[ANS];
		}
		System.out.println("");
	}
	/***
	 * 计算上界和下界的算法
	 * @param P
	 * 是一个价值数组
	 * @param W
	 * 是一个重量数组
	 * @param rw
	 * 是背包的剩余容量
	 * @param prof
	 * 是已获得的效益
	 * @param N
	 * 总个数
	 * @param k
	 * 这是要考虑的第一个
	 */
	public static void LUBOUND(double rw,double prof,int k){
		LBB=prof;
		double c=rw;
		for(int i=k;i<=N;i++){
			if(c<W[i]){
				UBB=LBB+(c*P[i])/(1.0*W[i]);
				for(int j=i+1;j<=N;j++){
					if(c>=W[j]){
						c=c-W[j];
						LBB=LBB+P[j];
					}
				}
				return;
			}
			c=c-W[i];
			LBB=LBB+P[i];
		}
		UBB=LBB;
	}
}
