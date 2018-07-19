package match;

public interface StringMatcher {

	public boolean match(String input);
	
	public StringMatcher and(StringMatcher other);
	
}
