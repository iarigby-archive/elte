package match;

public class CompositeMatcher implements StringMatcher{
	public CompositeMatcher(StringMatcher base) {
		
	}
	
	public boolean match(String input) {
		return true;
	}
	
	public StringMatcher and(StringMatcher other) {
		return other;
	}
}
