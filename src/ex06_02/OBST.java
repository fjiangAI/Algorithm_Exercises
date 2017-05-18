package ex06_02;
import ex06_02.Tree;
public class OBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		double P[]={0.0,3/16.0,3/16.0,1/16.0,1/16.0};
		double Q[]={2/16.0,3/16.0,1/16.0,1/16.0,1/16.0};
		int R[][]=new int[n+2][n+2];
		int RR[][]=new int[n+2][n+2]; 
		OBST(P,Q,n,R,RR);
		Tree tree=BuildTree(0, 4, R);
		System.out.println("最优二分检索树的中序遍历：");
		midtravel(tree);
		System.out.println("");
		System.out.println("最优二分检索树的先序遍历：");
		roottravel(tree);
	}
	public static void OBST(double P[],double Q[],int n,int R[][],int RR[][]){
		double C[][]=new double[n+2][n+2];
		double W[][]=new double[n+2][n+2];
		for(int i=0;i<n;i++){
			//置初值
			W[i][i]=Q[i];
			R[i][i]=0;
			C[i][i]=0;
			//含一个结点的最优树
			W[i][i+1]=Q[i]+Q[i+1]+P[i+1];
			R[i][i+1]=i+1;
			C[i][i+1]=Q[i]+Q[i+1]+P[i+1];
		}
		W[n][n]=Q[n];
		R[n][n]=0;
		C[n][n]=0;
		for(int m=2;m<=n;m++){
			for(int i=0;i<=n-m;i++){
				int j=i+m;
				W[i][j]=W[i][j-1]+P[j]+Q[j];
				//k是区间(R[i][j-1],R[i+1][j])中使得{C[i][l-1]+C[l][j]}取得最小值的l值
				int k=0;
				double min=Integer.MAX_VALUE;
				for(int nn=R[i][j-1];nn<=R[i+1][j];nn++){
					if(min>(C[i][nn-1]+C[nn][j])){
						k=nn;
						min=(C[i][nn-1]+C[nn][j]);
					}
				}
				C[i][j]=W[i][j]+C[i][k-1]+C[k][j];
				R[i][j]=k;
			}
		}
		//输出整个矩阵
		for(int i=0;i<n+1;i++){
			for(int j=0;j<n+1;j++){
				if(j+i<(n+1)){
					RR[i][j]=R[j][j+i];
					System.out.print(R[j][j+i]+" ");
				}
			}
			System.out.println("");
		}
	}
	/***
	 * 根据解，构建最优二叉树
	 * @param i
	 * 这是树开始的位置
	 * @param j
	 * 这时树结束的位置
	 * @param R
	 * 这是解矩阵
	 * @return
	 */
	public static Tree BuildTree(int i,int j,int R[][]){
			System.out.println("i="+i+",j="+j);
			int r=R[i][j];
			System.out.println("R的值："+r);
			Tree tree=new Tree(r);
			if(i==r-1){
				tree.lchild=null;
			}
			else{
				tree.lchild=BuildTree(i, r-1,R);
			}
			if(r==j){
				tree.rchild=null;
			}
			else{
				tree.rchild=BuildTree(r, j, R);
			}
			return tree;
	}
	/***
	 * 中序遍历
	 * @param t
	 */
	public static void midtravel(Tree t){
		if(t==null){
			return;
		}
		else{
			midtravel(t.lchild);
			System.out.print(t.data+" ");
			midtravel(t.rchild);
		}
	}
	/***
	 * 先序遍历
	 * @param t
	 */
	public static void roottravel(Tree t){
		if(t==null){
			return;
		}
		else{
			System.out.print(t.data+" ");
			roottravel(t.lchild);
			roottravel(t.rchild);
		}
	} 

}
