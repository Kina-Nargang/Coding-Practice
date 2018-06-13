public String lcs(String str1,str2){
	int len1 = str1.length();
	int len2 = str2.length();
	
	int[][] arr = new arr[len1 + 1][len2 + 1];
	
	for (int i = 0;i < len1;i++){
		for (int j = 0;j < len2; j++){
			if (i == 0 || j == 0){
				arr[i][j] = 0;
			}else if(str1.charAt(i - 1) == str2.charAt(j)){
				arr[i][j] = arr[i - 1][j - 1] + 1;
			}else{
				arr[i][j] = Math.max(arr[i - 1][j],arr[i][j - 1];
				}
			}
		}
	}
	
	int index1 = 0, index2 = 0, index = arr[len1][len2];
	char[] lcs = new char[index];
	lcs[index] = '';
	
	int i = len1, j = len2;
	while (i > 0 && j > 0){
		if (str1.charAt(i - 1) == str2.charAt(j - 1)){
			lcs[index - 1] = str1.charAt(i - 1);
			i--;
			j--;
			index--;
		}else if (arr[i][j - 1] > arr[i - 1][j]){
			j--;
		}else{
			i--;
		}
	}
	return lcs;
}