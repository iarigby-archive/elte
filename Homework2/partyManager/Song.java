package partyManager;

public class Song {

	private String title;
	private String artist;

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public Song(String title) {
		this(title, "Unknown");
	}

	@Override
	public String toString() {
		return title + " by " + artist;
	}

}