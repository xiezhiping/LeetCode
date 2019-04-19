package dp;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
		long start = System.currentTimeMillis();
		System.out.println(longestPalindrome(s));
		System.out.println(System.currentTimeMillis() - start);
	}
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ri = 0;
        int rj = 0;
        int max = -1;
        for (int i = 0; i < len; i ++) {
        	dp[i][i] = true;
        }
        for (int i = len - 1; i >= 0; i--) {
        	for (int j = i; j < len; j++) {
        		dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 
        				|| dp[i + 1][j -1] == true);
        		if (dp[i][j] &&j - i + 1 >= max) {
        			max = j - i + 1;
        			ri = i;
        			rj = j;
        		}
        	}
        }
        System.out.println(ri + " " + rj);
         if (max != -1) {
                return ri < rj ? s.substring(ri, rj + 1) : s.substring(rj, ri + 1);
            } else {
                return "";
            }
    }
}