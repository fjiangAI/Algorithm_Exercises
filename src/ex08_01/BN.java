package ex08_01;
/***
 * 0/1背包问题回溯解法
 * @author jf320
 *
 */
public class BN {
	int N;//物品个数
	float bestp;//最好价值
	int C=10;//最大背包容量
	int p[];//每个物品价值
	int w[];//每个物品重量
	int x[];//搜索路径
	int slution[];
	public BN(int n,int c,int p[],int w[]){
		this.N=n;
		this.C=c;
		this.p=p;
		this.w=w;
		this.x=new int[n];
		this.slution=new int[n];
		//初始化搜索路径
		for(int i=0;i<N;i++){
			x[i]=0;
		}
		getbest(0,0,0,x);
		//打印出结果
		for(int i=0;i<N;i++){
			System.out.print(slution[i]);
		}
		//打印出最好数
		System.out.println(":"+bestp);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}
	/***
	 * 限界函数
	 * @param P
	 * 当前价值
	 * @param W
	 * 当前重量
	 * @param k
	 * 序列次数
	 * @return
	 * 返回限界函数的可能解的上界
	 */
	public float Bound(float P,float W,int k){
		float b,c;//b是当前可能最大值
		b=P;c=W;
		for(int i=k+1;i<N;i++){
			c+=w[i];
			if (c<C){
				b+=p[i];
			}
			else{
				return (b+(1-(c-C)/w[i])*p[i]);//返回最大可能解上限
			}
		}
		return b;
	}
	/***
	 * 获得最优解的过程
	 * @param k
	 * 次序
	 * @param P
	 * 是价值
	 * @param W
	 * 重量
	 */
	public void getbest(int k,float P,float W,int y[]){
		int x[]=new int[y.length];
		for(int i=0;i<y.length;i++){
			x[i]=y[i];
		}
		if(k>N-1){//如果有可行解了。
			if(P>bestp){
				bestp=P;
				//打印出结果
				for(int i=0;i<N;i++){
					slution[i]=x[i];
				}
				return ;
			}
		}
		//如果还能放的话
		if(W+w[k]<=C){
			x[k]=1;
			getbest(k+1, P+p[k], W+w[k],x);
		}
		//如果右子树还有可能解
		if(Bound(P, W, k)>bestp){
			x[k]=0;
			getbest(k+1, P, W,x);
		}
	}
}
