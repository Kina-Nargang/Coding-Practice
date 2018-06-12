public string compressString(String str){
	// edge case:if str is null then return null
	if (str == null || str.length() == 0) return null;
	
	int count = 0;
	StringBulider sb = new StringBulider();
	
	for (int i = 0;i < str.length();i++){
		// If the compressed string is bigger than the original string then return the original string.
		if (sb.length() > str.length()){
			return str;
		}
		
		count++;
		if(str.toChatAt(i) != str.toCharAt(i + 1) || i + 1 >= str.length()){
			sb.append(str.toCharAt(i));
			sb.appeng(count);
			count = 0;
		}
	}
	
	return sb.toString();
}