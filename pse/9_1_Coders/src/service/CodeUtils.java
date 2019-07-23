/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , First test
>
> %% 2017.11.14
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> First test of the Practical Software Engineering course.
>
> %% I declare that this solution is my own work.
>
> %% I have not copied or used third party solutions.
>
> %% I have not passed my solution to my classmates, neither  made it public.
>
> %% Students’ regulation of Eötvös Loránd University (ELTE Regulations
> Vol. II. 74/C. § ) states that as long as a student presents another
> student’s work - or at least the significant part of it - as his/her own
> performance, it will count as a disciplinary fault. The most serious

> consequence of a disciplinary fault can be dismissal of the student from
> the University."

*/

package service;

import java.util.Arrays;
import java.util.List;

public class CodeUtils {

	public static List<String> list = Arrays.asList("HU", "HA", "HE", "HI", "YU", "YA", "YE", "YI", "KU", "KA", "KE", "KI", "DU", "DA", "DE", "NG");
	
	public static String decimalToString(int n) {
		String result = "";
		String s = Integer.toHexString(n);
		for (char c : s.toCharArray()) {
			result += list.get(Integer.parseInt(Character.toString(c), 16));
		}
		return result;
		
	}
	
	
	
	public static int stringToDecimal(String s) {
		String result = "";
		int n;
		String hex;
		
		for (int i = 0; i < s.length(); i+=2) {
			n = list.indexOf(s.substring(i, i+2));
			hex = Integer.toHexString(n);
			result += hex;
		}
		
		return Integer.parseInt(result, 16);
	}
	

}
