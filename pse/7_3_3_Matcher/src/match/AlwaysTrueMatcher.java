package match;

public class AlwaysTrueMatcher extends AndMatcher{

	public boolean match(String input) {
		return true;
	}
	
}
