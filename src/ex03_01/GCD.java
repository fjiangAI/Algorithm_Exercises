package ex03_01;

import org.junit.experimental.theories.Theories;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getGCD(10,20));
	}
	/**
	 * 这是一个求最大公因数的方法
	 * @param a
	 * 这是第一个参数，默认是两个参数中最大的那个
	 * @param b
	 * 这是第二个参数
	 * @return
	 * 返回的是两个数的最大公因数，如果返回值为负数，则表示输入为负数了。
	 */
	public  int getGCD(int a,int b){
		//如果a<0或者b小于0
		if(a<0||b<0){
			return -1;
		}
		//如果a<b的话，要交换两个位置
		if(a<b){
			int c=b;
			b=a;
			a=c;
		}
		//如果b等于0就返回a
		if(b==0){
			return a;
		}
		//否则就递归实现
		else{
			return getGCD(b,a%b);
		}
	}

}
