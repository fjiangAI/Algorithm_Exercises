package ex04_01;

import static org.junit.Assert.assertEquals;

public class BinSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arrary1={1,2,3,4,5,6,7};
		System.out.println(BinSearch.getBinSearch(arrary1, 0, arrary1.length-1,7));
	}
	/**
	 * 这是一个在有序数组中查找目标值的二分查找
	 * @param array
	 * 这是给出的有序数组
	 * @param start
	 * 这是查找的下限
	 * @param end
	 * 这是查找的上限
	 * @param x
	 * 这是要查找的值
	 * @return
	 * 如果找到目标值，返回目标元素下标，否则返回-1；
	 */
	public static int getBinSearch(double[] array,int start,int end,double x){
		if(start==end){
			if (array[start]==x){
				return start;
			}
			else{
				return -1;
			}
		}
		else{
			int mid=(start+end)/2;
			if(array[mid]==x){
				return mid;
			}
			else if(array[mid]>x){
				return getBinSearch(array, start, mid, x);
			}
			else{
				return getBinSearch(array, mid+1, end, x);
			}
			
		}
	}

}
