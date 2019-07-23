package palindrome;

public class PalindromePercentageChecker {

	public String check( String string ) {
		
		for(int i=0; i < string.length(); i++) {
			while(i < string.length() && !Character.isLetter(string.charAt(i))) {
				string = string.replace(Character.toString(string.charAt(i)), "");
			} 
			if (i < string.length())
				string = string.replace(string.charAt(i), Character.toLowerCase(string.charAt(i)));
		}
		
		float count = 0;
		int j = string.length()-1;
		int i = 0;
		while( i <= string.length()/2) {
			if (string.charAt(i) == string.charAt(j)) 
				count++;
			else
				break;
			j--;
			i++;
		} 
		return " " + (count*2/(string.length()));
		
	}
}
