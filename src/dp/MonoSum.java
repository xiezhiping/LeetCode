package dp;

public class MonoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,2,4,6};
		System.out.println(new MonoSum().calcMonoSum(A,6));
	}
    public int calcMonoSum(int[] A, int n) {
        // write code here
        int sum = 0; // 相加的结果
        int[] dp = new int[n]; // 存储f(i)
        dp[0] = 0; // 第一个初始化为0
        for (int i = 1; i < n; i++) {
//            dp[i] = 0; // 初始化
//            // 分两种情况
//            if (A[i] >= A[i-1]) {
//                dp[i] = dp[i-1] + A[i-1];
//                sum += dp[i];
//            } else {
//                for (int j = 0; j < i; j++) {
//                    if (A[i] >= A[j]) {
//                        dp[i] += A[j];
//                    }
//                }
//                sum += dp[i];
//            }
        	 for (int j = 0; j < i; j++) {
                 if (A[i] >= A[j]) {
                     sum += A[j];
                 }
             }
            
        }
        return sum;
    }
}
