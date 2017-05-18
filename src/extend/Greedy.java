package extend;

import java.util.List;
/**
 * 这是贪心算法类
 * @author huangfei
 *
 */
public class Greedy {
	boolean[] choice;
	List<Action> actions;
	public Greedy(List<Action> actions){
		choice=new boolean[actions.size()];
		this.actions=actions;
	}
	/**
	 * 这是获得贪心算法的结果
	 */
	public void getGeedyResult(){
		this.greedyChoice();
		System.out.println("最大相容子集为：");
		for(int i=0;i<this.actions.size();i++){
			if(choice[i]){	
				System.out.print(actions.get(i).getinfo());
			}
		}
	}
	/**
	 * 这是贪心算法
	 */
	public void greedyChoice(){
		choice[0]=true;
		int j=0;
		for(int i=1;i<this.actions.size();i++){
			if(this.actions.get(i).starttime>=this.actions.get(j).endtime){
				choice[i]=true;
				j=i;
			}
			else{
				choice[i]=false;
			}
		}
	}
	
}
