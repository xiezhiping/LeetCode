package dp;

public class MonoSum {

	public static void main(String[] args) {
		int[] A = {1,3,5,2,4,6};
		System.out.println(new MonoSum().calcMonoSum(A,6));
	}
    public int calcMonoSum(int[] A, int n) {
        // write code here
        int sum = 0; // ��ӵĽ��
        int[] dp = new int[n]; // �洢f(i)
        dp[0] = 0; // ��һ����ʼ��Ϊ0
        short s = 1;
        long num = 99999999999999L;  // error
        System.out.println(s);
        for (int i = 1; i < n; i++) {
        	 for (int j = 0; j < i; j++) {
                 if (A[i] >= A[j]) {
                     sum += A[j];
                 }
             }
            
        }
        return sum;
    }
}
