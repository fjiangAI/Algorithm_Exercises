package ex05_02;

import java.awt.print.Printable;
import java.util.List;

public class prim {
	public static void main(String[] args) {
		int cost[][]={{Integer.MAX_VALUE,3,Integer.MAX_VALUE,10,2,15},
					  {3,Integer.MAX_VALUE,5,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
					  {Integer.MAX_VALUE,5,Integer.MAX_VALUE,7,1,13},
					  {10,Integer.MAX_VALUE,7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
					  {2,Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
					  {15,Integer.MAX_VALUE,13,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		prim(cost,6);
	}
	public static void prim(int cost[][],int n){
		//T是解决办法生成树
		int T[][]=new int[n-1][2];
		for(int i=0;i<n-1;i++){
			T[i]=new int[2];
			T[i][0]=0;
			T[i][1]=0;
		}
		//这是第N个节点最小成本的节点
		int NEAR[]=new int[n];
		//生成树的最小成本
		int mincost=0;
		int k=0,l=0;
		//k,l是具有最小成本的边
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(cost[k][l]>cost[i][j]){
					k=i;
					l=j;
				}
			}
		}
		//最小成本
		mincost=cost[k][l];
		//对NEAR赋初值
		for(int i=0;i<n;i++){
			if(cost[i][l]<cost[i][k]){
				NEAR[i]=l;
			}
			else{
				NEAR[i]=k;
			}
		}
		NEAR[k]=-1;
		NEAR[l]=-1;
		T[0][0]=k;
		T[0][1]=l;
		//找剩下的解决方案
		for(int i=1;i<n-1;i++){
			int max=Integer.MAX_VALUE;
			int j=0;
			//j是NEAR[j]!=-1且cost[j][NEAR[j]]最小的下标
			for(int index=0;index<n;index++){
				if(NEAR[index]!=-1){
					if(cost[index][NEAR[index]]<max){
						j=index;
						max=cost[index][NEAR[index]];
					}
				}
			}
			T[i][0]=j;
			T[i][1]=NEAR[j];
			mincost+=cost[j][NEAR[j]];
			NEAR[j]=-1;
			for(int sq=0;sq<n;sq++){
				if(NEAR[sq]!=-1&&cost[sq][NEAR[sq]]>cost[sq][j]){
					NEAR[sq]=j;
				}
			}
		}
		//输出最小成本
		System.out.println("最小成本为："+mincost);
		//输出解
		for(int i=0;i<n-1;i++){
			System.out.println("第"+(i+1)+"边为"+T[i][0]+"-"+T[i][1]);
		}
	}
} 
