package ex04_03;

import java.util.Random;
import ex04_02.quicksort;
public class quickselect {

	public static void main(String[] args) {
		for(int i=1;i<6;i++){
			System.out.print("第"+i+"次测试");
			int array[]=getNArray(100000, 1, 1000000);
			int array1[]=new int[100001];
			int array2[]=new int[100001];
			for(int k=0;k<=100000;k++){
				array1[k]=array[k];
				array2[k]=array[k];
			}
			Random ra =new Random();
			int index=ra.nextInt(100000)+1;
			System.out.println(" 查找中");
			long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
			int aim=select(array1, 0, 100000,index);
			long endMili=System.currentTimeMillis();
			System.out.print("查找完毕，第"+index+"小的数为："+array1[aim]);
			System.out.println(" 耗时："+(endMili-startMili)+"毫秒");
			
			System.out.println("使用快速排序后的查找开始");
			long startMili2=System.currentTimeMillis();// 当前时间对应的毫秒数
			quicksort.sort(array2,0,99999);
			long endMili2=System.currentTimeMillis();
			System.out.print("查找完毕，第"+index+"小的数为："+array2[index-1]);
			System.out.println(" 耗时："+(endMili2-startMili2)+"毫秒");
		}
	}
	/**
	 * 这是查找第K个小的值的程序
	 * @param array
	 * 这是待查找的数组
	 * @param start
	 * 这是要查找的数组的开始
	 * @param end
	 * 这是要查找的数组的结束
	 * @param index
	 * 这是要查找的K值
	 * @return
	 * 返回的是其索引值
	 */
	public static int select(int array[],int start,int end,int index){
		//最小为9时，就使用插入排序
		int r=80;
		if(end-start+1<=r){
			Insertsort(array, start, end);
			return (start+index-1);
		}
		while(true){
			//元素数
			int num=end-start+1;
			for(int i=1;i<=num/r;i++){
				Insertsort(array, start+(i-1)*r,start+i*r-1);
				int temp=array[start+i-1];
				array[start+i-1]=array[start+(i-1)*r+r/2-1];
				array[start+(i-1)*r+r/2-1]=temp;
			}
			int j=select(array, start, start+num/2-1,(num/2)/2+1);
			int temp=array[start];
			array[start]=array[j];
			array[j]=temp;
			j=end+1;
			j=partition(array, start, j);
			if(j-start+1==index)
				return j;
			else if(j-start+1>index)
				end=j-1;
			else {
				index=index-(j-start+1);
				start=j+1;
			}
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
	 * 这是插入排序
	 * @param array
	 * 这是待排的数组
	 * @param start
	 * 这是数组的开始索引
	 * @param end
	 * 这是数组的结束索引
	 */
	public static void Insertsort(int array[],int start,int end){
		//从第二个开始一直
		for(int i=start+1;i<=end;i++){
			//如果前一个比后一个大
			if(array[i-1]>array[i]){
				//定位已排好序的结尾
				int tempend=i-1;
				//把要插入的值记下来,作为监视哨
				int monitor=array[i];
				//一直找到小于监视哨的数停止
				while(tempend>=start&&monitor<array[tempend]){
					//往后移一个
					array[tempend+1]=array[tempend];
					tempend--;
				}
				//把监视哨放入到位置中
				array[tempend+1]=monitor;
			}
		}
	}
	/**
	 * 这是获取一个N个随机的数组
	 * @param num
	 * 这是数组的长度
	 * @param start
	 * 这是数组中数的最小值
	 * @param end
	 * 这是数组中数的最大值
	 * @return
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
