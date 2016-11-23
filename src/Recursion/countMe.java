package Recursion;

public class countMe {

	public int count_me(String str) {

		if (str.startsWith("me")) {
			return count_me(str.substring(2)) + 1;
		} else if (!str.startsWith("me") && str.length() > 0) {
			return count_me(str.substring(1));
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countMe m = new countMe();

		System.out.println(m.count_me("me123me"));
		System.out.println(m.count_me("mememe lsda me"));
		System.out.println(m.count_me("”abcmeymeyme"));
		System.out.println(m.count_me("”abcmeymeyme"));

	}

}
