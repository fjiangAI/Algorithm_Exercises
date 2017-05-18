package ex04_04;

public class Sort {
	public static void main(String[] args) {
		System.out.println("第一次实验");
		int arr[]={7,5,3,1,3,4,6};
		InsertSort(arr);
		System.out.println("第二次实验");
		int arr2[]={3,5,7,8,1,2};
		InsertSort(arr2);
		System.out.println("第三次实验");
		int arr3[]={2,3,4,5,6,1,89,9,64,43,32,5,3,1,3,4,6};
		InsertSort(arr3);
	}
	public static void show(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println("");
	}
	
	public static void InsertSort(int[] arr)
	{
		
	    int i, j;
	    int n = arr.length;
	    int target;
	    System.out.println("排序前");
	    show(arr);
	    //假定第一个元素被放到了正确的位置上
	    //这样，仅需遍历1 - n-1
	    for (i = 1; i < n; i++)
	    {
	        j = i;
	        target = arr[i];
	 
	        while (j > 0 && target < arr[j - 1])
	        {
	            arr[j] = arr[j - 1];
	            j--;
	        }
	 
	        arr[j] = target;
	    }
	    System.out.println("排序后");
	    show(arr);
	}
}
