package match;

public abstract class AndMatcher implements StringMatcher{

	public StringMatcher and(StringMatcher other) {
		return other;
	}
}
