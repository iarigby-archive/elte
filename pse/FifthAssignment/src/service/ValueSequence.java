/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Third Assignment
>
> %% 2017.10.09
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Third assignment of the Practical Software Engineering course.
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
import java.util.*;

public class ValueSequence<E> {

	private List<E> list = new LinkedList<>();
	
	
	public void add(E... elems) { 
		for (E elem : elems) {
			list.add(elem);
		}	
	}
	
	public E calculate(Operator<E> e) {
		return defaultCalculate(e, list.subList(1, list.size()), list.get(0));
	}
	
	public E calculateMaybeEmpty(Operator<E> e) {
		return defaultCalculate(e, list, null);
	}
	
	public String toString() {
		String result = "";
		for (E element : list) {
			result = result + element + ", ";
		}
		return result;
	}
	
	private E defaultCalculate(Operator<E> e, List<E> list, E firstElement) {
		E result = firstElement;
		for (E element : list) {
			result = e.calculate(element, result);
		}
		return result;
	}
}
