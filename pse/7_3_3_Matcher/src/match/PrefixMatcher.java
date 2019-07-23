package match;

public class PrefixMatcher extends AndMatcher{
	
	private String prefix;
	
	public PrefixMatcher(String prefix) {
		this.prefix = prefix;
	}
	
	public boolean match(String input) {
		return false;
	}
	
}
