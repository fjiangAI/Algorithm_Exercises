package ex05_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 图的最小树生成算法
 * 
 *
 */
public class Kruskal {
	/**
	 * 求最小树的Kruskal算法
	 * 算法思想：克鲁斯卡尔算法从另一个途径求网中的最小生成树。假设联通网N=(V,{E})，则令
	 * 最小生成树的厨师状态为只有n个顶点而无边的非连通图T=(V,{})，途中每个顶点自称一个连通分量。
	 * 在E中选择代价最小的边，若该边衣服的顶点落在T中不同的连通分量上，则将此边加入到T中，否则舍去此边
	 * 而选择下一条最小的边。以此类推，直至T中所有的顶点都在同一连通分量上为止。
	 * @param V 图中的节点集合
	 * @param E 图中边的集合
	 */
	public static void KRUSKAL(int [] V,Edge [] E){
		Arrays.sort(E);//将边按照权重w升序排序
		ArrayList<HashSet> sets=new ArrayList<HashSet>();
		for(int i=0;i<V.length;i++){
			HashSet set=new HashSet();
			set.add(V[i]);
			sets.add(set);			
		}
		
		System.out.println("size="+sets.size());
		int mincost=0;
		for(int i=0;i<E.length;i++){
			int start=E[i].i,end=E[i].j;
			int counti=-1,countj=-2;
			for(int j=0;j<sets.size();j++){
				HashSet set=sets.get(j);
				if(set.contains(start)){
					counti=j;
				}
					
				if(set.contains(end)){
					countj=j;
				}
			}
			if(counti<0||countj<0) System.err.println("没有在子树中找到节点，错误");
			if(counti!=countj){
				System.out.println("添加边"+start+"-"+end);
				mincost+=E[i].w;
				HashSet setj=sets.get(countj);
				sets.remove(countj);
				HashSet seti=sets.get(counti);
				sets.remove(counti);
				seti.addAll(setj);
		        sets.add(seti);
			}
		}
		System.out.println("最小成本为:"+mincost);
	}
	
	public static void main(String [] args){
		int [] V={1,2,3,4,5,6};
		Edge [] E=new Edge[10];
		E[0]=new Edge(1,2,6);
		E[1]=new Edge(1,3,1);
		E[2]=new Edge(1,4,5);
		E[3]=new Edge(2,3,5);
		E[4]=new Edge(2,5,3);
		E[5]=new Edge(3,4,5);
		E[6]=new Edge(3,5,6);
		E[7]=new Edge(3,6,4);
		E[8]=new Edge(4,6,2);
		E[9]=new Edge(5,6,6);
		Kruskal.KRUSKAL(V, E);
	}

}
