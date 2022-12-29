package Program9;

public class Recordings {
	private String title;
	private String artist;
	private int playingTime; 

	public Recordings (String title, String artist, int sec) {
		this.title = title;
		this.artist = artist;
		if (sec>0)
			this.playingTime = sec;
	}
	
	public Recordings () {
	}
	
	public Recordings (String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public void setArtist(String a) {
		artist = a;
	}
	
	public void setPlayingTime(int sec) {
		playingTime = sec;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getPlayingTime() {
		return playingTime;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Title:"+ title);
		str.append("\nArtist:" + artist);
		str.append("\nPlaying Time:"+ playingTime);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object x) {
		if (this == x)
			return true;
		if (x==null)
			return false;
		if (this.getClass()!=x.getClass())
			return false;
		Recordings other = (Recordings)x;
		if (!this.title.equals(other.getTitle()))
			return false;
		if (!this.artist.equals(other.getArtist()))
			return false;
		if (this.playingTime != other.getPlayingTime())
			return false;
		
		return true;
	}
}
