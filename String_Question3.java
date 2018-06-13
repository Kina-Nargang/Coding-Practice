public String replaceSpace(String str){
	String[] s = str.split(" ");
	StringBuilder sb = new StringBuilder();
	
	for (int i = 0;i < s.length();i++){
		if (s[i] == " "){
			sb.append("%20");
		}else{
			sb.append(s[i]);
		}
	}
	return sb.toString();
}