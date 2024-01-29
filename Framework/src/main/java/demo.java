
public class demo {

		public static void main(String[] args){

		String a = "aaabbcc";
		int counta= 0;
		int countb= 0;
		int countc= 0;
		char[] s1=a.toCharArray();

		for(char b : s1){

		if(b == 'a'){
		counta++;
		}else if(b == 'b'){
		countb++;
		}else if(b == 'c'){
		countc++;
		}
		}
		System.out.println(counta+" "+countb+" "+countc);
		}
		}
