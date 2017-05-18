package ex04_02;

import java.util.Arrays;
import java.util.Random;

public class quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//生成从1-1亿的1000万个随机数
		int array[]=getNArray(10000000, 1, 1000000000);
		int array1[]=new int[10000001];
		int array2[]=new int[10000001];
		for(int i=0;i<=10000000;i++){
			array1[i]=array[i];
			array2[i]=array[i];
		}
		System.out.println("开始排序");
		long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		sort(array1,0,9999999);
		long endMili=System.currentTimeMillis();
		System.out.println("已排好，用时："+(endMili-startMili)+"毫秒");
		System.out.println("其中前10个数为");
		for(int i=0;i<=10;i++){
			System.out.print(array1[i]);
			if(i<10)
				System.out.print(",");
		}
		System.out.println("");
		System.out.println("下面是java自带的排序：");
		System.out.println("开始排序");
		long startMili2=System.currentTimeMillis();// 当前时间对应的毫秒数
		Arrays.sort(array2);
		long endMili2=System.currentTimeMillis();
		System.out.println("已排好，用时："+(endMili2-startMili2)+"毫秒");
		System.out.println("其中前10个数为");
		for(int i=0;i<=10;i++){
			System.out.print(array2[i]);
			if(i<10)
				System.out.print(",");
		}
	}
	/***
	 * 这是快速排序的实现,从小到大排序
	 * @param array
	 * 这是待排数组，共有n+1个，其中第n+1个为大于等于前n个的数
	 * @param start
	 * 这是快速排序的开始
	 * @param end
	 * 这是快速排序的结束，但end+1还有数。
	 */
	public static void sort(int array[],int start,int end){
		//如果还没有排完
		if(start<end){
			//找到最大的
			int biggest=end+1;
			//找到中间值
			int mid=partition(array, start, biggest);
			//对左边进行快排
			sort(array, start, mid-1);
			//对右边进行快排
			sort(array, mid+1, end);
		}
	}
	/***
	 * 排序
	 * @param array
	 * 这是要排的数组，从start到end-1，end不参与排序
	 * @param start
	 * 这是要开始排的
	 * @param end
	 * 这是不参与排序的，这个数比start到end-1数都大于等于
	 * @return
	 */
	public static int partition(int array[],int start,int end){
		//这是监视哨，以它为分界线划分左右两个递归
		int monitor=array[start];
		//这是从前向后指针
		int front=start;
		//这是循环，直到front>=end为止，也就是前指针大于等于后指针了。
		while(true){
			//从前面一直走，如果小于监视哨，就继续往后走，直到遇到大于等于监视哨的数为止。
			while(array[++front]<monitor);
			//从后面往前面走，如果大于监视哨，就继续往前走，直到遇到和监视哨一般大的
			while(array[--end]>monitor);
			//如果前面还没走到后面
			if(front<end)
			{
				//交换前后两个数位置，保证前面的数比监视哨小于等于，后面的数比监视哨大于等于
				int temp=array[front];
				array[front]=array[end];
				array[end]=temp;
			}
			//否则的话，
			else
				break;
		}
		//都结束了，把end的数和开始的数进行交换，
		array[start]=array[end];
		array[end]=monitor;
		//返回中间的值
		return end;
	}
	/**
	 * 这是获取N+1个数的数组，其中N+1个数大于等于前N个数，为标志位，
	 * @param num
	 * 这是要生成的数量，最终会有num+1个数
	 * @param start
	 * 这是随机的数的最小值
	 * @param end
	 * 这是随机数的最大值
	 * @return
	 * 返回的是一个N+1的数组
	 */
	public static int[] getNArray(int num,int start,int end){
		int result[]=new int[num+1];
		Random ra =new Random();
		for (int i=0;i<num;i++)
		{
			result[i]=ra.nextInt(end)+start;
		}
		result[num]=Integer.MAX_VALUE;
		return result;
	}
}
