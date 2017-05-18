package extend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.accessibility.AccessibleRelation;

public class Firstmission {

	public static void main(String[] args) {
		// 初始化活动列表
		List<Action> actions=new ArrayList<Action>();
		actions.add(new Action(1,2, 8));
		actions.add(new Action(2,3, 10));
		actions.add(new Action(3,5, 15));
		actions.add(new Action(4,7, 8));
		actions.add(new Action(5,4, 18));
		actions.add(new Action(6,8, 13));
		actions.add(new Action(7,15, 20));
		actions.add(new Action(8,20, 22));
		actions.add(new Action(9,30, 35));
		actions.add(new Action(10,22, 29));
		actions.add(new Action(11,18, 28));
		actions.add(new Action(12,14, 24));
		actions.add(new Action(13,19, 23));
		actions.add(new Action(14,27, 33));
		//2路归并排序，非减排序结束时间
		Sort.sort(actions, 0, actions.size()-1);
        //输出序列
		for (Action a : actions) {
            System.out.print(a.getinfo());
        }
		//初始化贪心算法
        Greedy greedy=new Greedy(actions);
        //获得贪心算法的结果
        greedy.getGeedyResult();
	}

}