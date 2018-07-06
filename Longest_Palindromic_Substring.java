/*
Find the Longest Palindromic Substring in a given string

Ex:
  input:"abbac"
  output:"abba"
  
Solution1: use dp(Dynamic Programming)

Solution2: use Manacher's algorithm
*/

// use dp: Time:O(n^2),Space:O(n^2)
public static String LPS(String s){
	// edge cases check
	if (s == null || s.length() == 0) return s;
	
	int max = 0;
	boolean[] dp = new boolean[s.length()][s.length()];
	String res = "";
	
	for (int j = 0;j < s.length();j++){
		for (int i = 0;i <= j;i++){
			if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
				dp[i][j] = true;
			}else{
				dp[i][j] = false;
			}
			if(dp[i][j]){
				if(j - i + 1 > max){
					max = j - i + 1;
					res = s.substring(i,j + 1);
				}
			}
		}
	}
	return res;
}

//use Manacher's algorithm. Space:O(1),Time:O(n^2)
public String res = "";
public static String LPS(Sring s){
	if (s == null || s.length() == 0) return s;
	
	for (int i = 0;i < s.length();i++){
		findLPS(s,i,i);
		findLPS(s,i,i+1);
	}
	
	return res;
}
public String findLPS(String s,int left,int right){
	while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
		left--;
		right++;
	}
	String cur = s.substring(left+1,right);
	if(cur.length() > res.length()){
		res = cur;
	}
	return res;
}
