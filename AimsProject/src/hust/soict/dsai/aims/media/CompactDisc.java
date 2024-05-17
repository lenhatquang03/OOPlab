package AimsProject.src.hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc {
    // Attributes
    private String artist;
    private ArrayList<Track> tracks;

    // Accessor methods
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Constructors
    public CompactDisc() {}
    public CompactDisc(int id, String title, String artist, String director) {
        super(title, director);
        this.setId(id);
        this.artist = artist;
    }

    // Methods
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists!!");
        }
        else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
        else {
            System.out.println("Track does not exist!!");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
}
