package extend;

import java.lang.reflect.Array;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5,6};
		System.out.println("没发生改变前。");
		for(int i=0;i<6;i++){
			System.out.print(a[i]+",");
		}
		System.out.println("");
		test(a);
		for(int i=0;i<6;i++){
			System.out.print(a[i]+",");
		}
		System.out.println("");
		System.out.println("发生改变后。");
	}
	public static void test(int a[]){
		
		a[3]=9;
		System.out.println("函数内改变后");
		for(int i=0;i<6;i++){
			System.out.print(a[i]+",");
		}
		System.out.println("");
	}

}
