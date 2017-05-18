package ex06_03;

public class DKNAP {
    public static void main(String[] args) {
    	System.out.println("第一次实验：");
    	int m = 6;int n = 3;
        int w[] = {2,3,4};int p[] = {1,2,5};
        int c[][] = BackPack_Solution(m, n, w, p);
        showresult(c, m, n);
        System.out.println("第二次实验：");
        int m2 = 10;int n2 = 4;
        int w2[] = {2,3,4,6};int p2[] = {1,2,5,8};
        int c2[][] = BackPack_Solution(m2, n2, w2, p2);
        showresult(c2, m2, n2);
        System.out.println("第三次实验：");
        int m3 = 15;int n3 = 5;
        int w3[] = {3,5,7,1,2};int p3[] = {1,5,8,2,3};
        int c3[][] = BackPack_Solution(m3, n3, w3, p3);
        showresult(c3, m3, n3);
        
        
        
    }
    public static void showresult(int c[][],int m,int n) {
		for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                System.out.print(c[i][j]+",");
                if(j==m){
                    System.out.println();
                }
            }
        }
	}

 /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
}
