package ex07_02;

import java.util.LinkedList;
import java.util.List;

public class Nodelist {
	public Nodelist(int i) {
		// TODO Auto-generated constructor stub
		No=i;
		list=new LinkedList<Integer>();
	}
	public boolean find(int x){
		if(list.indexOf(x)==-1){
			return false;
		}
		else{
			return true;
		}
	}
	public void add(int a){
		if(list.indexOf(a)==-1){
			list.add(a);
		}
	}
	//分图序号
	public int No;
	//分图节点集合
	public List<Integer> list; 
}
