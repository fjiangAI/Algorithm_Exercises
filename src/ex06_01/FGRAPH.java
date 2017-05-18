package ex06_01;

import java.util.LinkedList;
import java.util.List;

import ex05_03.Edge;

public class FGRAPH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用书P125的多段图
		List<Edge> E=new LinkedList<Edge>();
		E.add(new Edge(0,1,9));
		E.add(new Edge(0,2,7));
		E.add(new Edge(0,3,3));
		E.add(new Edge(0,4,2));
		E.add(new Edge(1,5,4));
		E.add(new Edge(1,6,2));
		E.add(new Edge(1,7,1));
		E.add(new Edge(2,5,2));
		E.add(new Edge(2,6,7));
		E.add(new Edge(3,7,11));
		E.add(new Edge(4,6,11));
		E.add(new Edge(4,7,8));
		E.add(new Edge(5,8,6));
		E.add(new Edge(5,9,5));
		E.add(new Edge(6,8,4));
		E.add(new Edge(6,9,3));
		E.add(new Edge(7,9,5));
		E.add(new Edge(7,10,6));
		E.add(new Edge(8,11,4));
		E.add(new Edge(9,11,2));
		E.add(new Edge(10,11,5));
		int p[]=FGRAPH(E,12,5);
		//输出解集
		for(int i=0;i<p.length;i++){
			System.out.print(p[i]);
			if(i!=p.length-1){
				System.out.print("->");
			}
		}
	}
	/***
	 * 这是多段图最短路径求法
	 * @param E 这是边集，附带边成本
	 * @param n 这是有多少个节点
	 * @param k 这是有多段
	 */
	public static int[] FGRAPH(List<Edge> E,int n,int k){
		//这是到达成本
		int cost[]=new int[n];
		//D[j]表示第j的后一个节点值
		int D[]=new int[n];
		//p表示最小路径。
		int p[]=new int[k];
		cost[n-1]=0;
		for (int j=n-2;j>=0;j--){
			int min=Integer.MAX_VALUE;
			int r=0;
			//找到<j,r>属于E，且使c[j][r]+cost[r]取得最小值
			for (Edge e : E) {
				//<j,r>属于E
				if(e.i==j){
					if(e.w+cost[e.j]<min){
						min=e.w+cost[e.j];
						r=e.j;
					}
				}
			}
			//System.out.println("第"+j+"个最小成本是："+min+",后一个路径是:"+r);
			cost[j]=min;
			D[j]=r;
		}
		//for (int i : D) {
		//	System.out.print(i+",");
		//}
		//System.out.println("");
		p[0]=0;
		p[k-1]=n-1;
		for(int j=1;j<=k-2;j++){
			p[j]=D[p[j-1]];
		}
		System.out.println(cost[0]);
		return p;
	}

}
