package Recursion;

public class addBetweenAdjChar {
	
	public String pair(String str, char c){
		while(str.length()>=2){
			if (str.charAt(0)==str.charAt(1) && str.length()>=2){
			return String.valueOf(str.charAt(0)) + String.valueOf(c) + pair(str.substring(1), c);
		}else{
			return String.valueOf(str.charAt(0))+ pair(str.substring(1), c);
		}
	}
		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addBetweenAdjChar p = new addBetweenAdjChar();
		System.out.println(p.pair("aaa", '!'));
		System.out.println(p.pair("hello", '!'));
		System.out.println(p.pair("xxyy", '!'));
	}

}
