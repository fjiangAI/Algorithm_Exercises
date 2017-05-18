package ex05_01;

public class Jobsort {

	public static void main(String[] args) {
		int deadline[]={0,7,2,5,8,5,6,6,1,3,4,3,8,11,13,15};
		int n=15;
		int job[]=new int[n+1];
		Test(deadline,job,n);
		int deadline2[]={0,1,3,4,3,8,11,13,15};
		int n2=8;
		int job2[]=new int[n2+1];
		Test(deadline2,job2,n2);
		int deadline3[]={0,7,2,5,8,5,6,6};
		int n3=7;
		int job3[]=new int[n3+1];
		Test(deadline3,job3,n3);
	}
	public static void Test(int deadline[],int job[],int n){
		int k=Jobsort(deadline, job, n);
		for(int i=1;i<=k;i++){
			if(i<k)
				System.out.print(deadline[job[i]]+",");
			else
				System.out.println(deadline[job[i]]);
		}
	}
	/**
	 * 这是带有有限期作业的作业调度
	 * @param deadline
	 * 这是作业的限期数组，0为监视位，真正数组是从1到n
	 * @param job
	 * 这是最有解的作业数组，0同样为监视位，真正数组从1到k
	 * @param n
	 * 这是作业的数量
	 * @return
	 * 返回的是选取的作业的个数，从1到k为止
	 */
	public static int Jobsort(int deadline[],int job[],int n){
		
		int r;
		deadline[0]=0;
		job[0]=0;
		//计入作业1
		int k=1;job[1]=1;
		//按p的费赠辞去考虑作业。找i的位置并检查插入的可行性
		for(int i=2;i<=n;i++){
			r=k;
			while(deadline[job[r]]>deadline[i]&&deadline[job[r]]!=r){
				r=r-1;
			}
			if(deadline[job[r]]<=deadline[i]&&deadline[i]>r){
				//把i插入到j中
				for(int ii=k;ii>=r+1;ii--){
					job[ii+1]=job[ii];
				}
				job[r+1]=i;
				k=k+1;
			}
		}
		return k;
	}

}
