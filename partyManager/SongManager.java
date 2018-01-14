package partyManager;

import java.util.ArrayList;
import java.util.Random;

public class SongManager extends Entrance implements DJ {

	private Random random = new Random();
	private ArrayList<Song> playedSongs = new ArrayList<Song>();
	
	public Song playSong() {
		if (getPlayList().size() == 0) {
			System.out.println("there are no songs currently in playlist, we'll play silence");
			return new Song("Sound of Silence", "Disturbed");
		} else {
			int index = random.nextInt(getPlayList().size());
			Song song = getPlayList().get(index);
			getPlayList().remove(index);
			playedSongs.add(song);
			return song;
		}
	}

	public String listPlayedSongs() {
		if (playedSongs.size() == 0) {
			return "there are no played songs";
		} else {
			String result = "played Songs are: \n";
			for (Song song: playedSongs)
				result += song;
			return result;
		}
	}

}