public String IntegertoWords(int num){
	if (num == 0) return "Zero";
	String res = "";
	int i = 0;
	String[] str = {"", "Thousand", "Million", "Billion"};
	
	while (num > 0){
		if (num%1000 > 0){
			res = toHundreds(num%1000) + str[i] + " " + res;
		}
		num /= 1000;
		i++;
	}
	return res.trim();
}

public String toHundreds(int num){
	String[] str1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] str2 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	if (num == 0) return "";
	if (num < 20){
		return str1[num%20] + " ";
	}else if (num < 100){
		return str2[num/10] + " " + toHundreds(num%10);
	}else{
		return str1[num/100] + " " + "Hundred" + " " + toHundreds(num%100);
	}
}