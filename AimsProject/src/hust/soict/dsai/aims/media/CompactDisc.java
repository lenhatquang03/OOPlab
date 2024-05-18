package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    // Attributes
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Accessors
    public String getArtist() {
        return artist;
    }

    // Constructor
    public CompactDisc(String title, String category, String director, String artist) {
        super(title, category, director);
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
        int CDlength = 0;
        for (Track track : tracks) {
            CDlength += track.getLength();
        }
        return CDlength;
    }

    public void play() {
        System.out.println("Playing CD" + this.getTitle());
        System.out.println("Diretcor: " + this.getDirector());
        System.out.println("Artist: " + this.getArtist());
        System.out.println();
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
}
