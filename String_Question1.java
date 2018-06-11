public boolean isUniqueChars(String str){
	// if the string is an ASCII then it has 128 unique characters.
	int len = 128;
	if (str.length > 128) return false;
	
	boolean[] set = new boolean[128];
	for (int i = 0; i < str.length; i++){
		int val = str.charAt(i);
		// if it is already found
		if(set[val]) return false;
		// if it is not found
		set[val] = true;
	}
	return true;
}
