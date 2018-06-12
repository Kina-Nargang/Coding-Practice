// solution 1: sort two strings then compare the sorted two strings are the same or not
public String sort(String str){
	char[] input = str.toCharArray();
	Arrays.sort(input);
	return new String(input);
}
public boolean isPermutation(String str1,String str2){
	// edge case:if two strings'lengths are not the same then return false
	if (str1.length() != str2.length()) return false;
	// edge case:either string is null then return false
	if (str1.length() == null || str2.length() == null) return false;
	
	return sort(str1).equels(sort(str2));
}

// solution 2: use hashmap
public boolean isPermutation(String str1,String str2){
	// edge case:if two strings'lengths are not the same then return false
	if (str1.length() != str2.length()) return false;
	// edge case:either string is null then return false
	if (str1.length() == null || str2.length() == null) return false;
	
	char[] char1 = str1.toCharArray();
	char[] char2 = str2.toCharArray();
	Hashmap<Characters,Integer> map = new Hashmap<>();
	int count = 1;
	
	for (Character c : char1){
		if(!map.containsKey(c)){
			map.put(c,count);
		}else{
			map.put(c,count + 1);
		}
	}
	for (Character c : char2){
		if (!map.containsKey(c)){
			return false;
		}else{
			map.put(c,count - 1);
		}
	}
	
	for (Character c : map.keySet()){
		if (map.get(c) != 0) return false;
	}
	
	return true;
}