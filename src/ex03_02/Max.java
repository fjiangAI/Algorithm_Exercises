package ex03_02;

public class Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double[] array2={0,1,7,7,7,5,6};
		//System.out.println(getMax(0,array2));
	}
	/**
	 * 这是一个求一个数组array里最大值下标的函数
	 * @param i
	 * 这是当前起始下标
	 * @param array
	 * 这是给出的数组
	 * @return
	 * 返回的是该数组中最大值的下标。
	 */
	public static int getMax(int i,double[] array){
		int j,k;
		//如果不正常，返回值为-1
		if(i<0||array.length<1){
			return -1;
		}
		//如果正常的话
		if(i<array.length-1){
			j=getMax(i+1, array);
			if(array[i]>array[j]){
				k=i;
			}
			else{
				k=j;
			}
		}
		else{
			k=array.length-1;
		}
		return k;
	}

}
