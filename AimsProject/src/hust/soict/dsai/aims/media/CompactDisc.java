package hust.soict.dsai.aims.media;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class CompactDisc extends Disc implements Playable {
    // Attributes
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Accessors
    public String getArtist() {
        return artist;
    }

    // Constructor
    public CompactDisc(String title, String category, String director, String artist, int id) {
        super(title, category, director);
        this.artist = artist;
        this.setId(id);
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

    @Override
    public String toString() {
        String name = String.format("%d.", this.getId()) + "CD - ";
        Class<?> cls = this.getClass();
        while (cls.getSuperclass() != null) {
            // Accessing the inherited fields of the class.
            cls = cls.getSuperclass();
            Field[] clsFields = cls.getDeclaredFields();
            for (int i = 0; i < clsFields.length; i++) {
                // Accessing the simple fieldName like "attribute".
                String lowerField = clsFields[i].toString().split(String.format("%s.", cls.toString().split(" ")[1]))[1];
                // Transform "attribute" to "Attribute" so we can invoke the method name "getAttribute".
                String fieldName = String.valueOf(lowerField.charAt(0)).toUpperCase() + lowerField.substring(1);
                try {
                    Method getter = this.getClass().getMethod("get" + fieldName);
                    Object attribute = getter.invoke(this);
                    if (!cls.getSuperclass().toString().equals("class java.lang.Object")) {
                        if (!Objects.isNull(attribute)) {
                            if (lowerField.equals("cost")) {
                                name += (fieldName + ":" + (String.format("%s$ - ", attribute.toString())));
                            } else {
                                name += (fieldName + ":" + (String.format("%s - ", attribute.toString())));
                            }
                        } else {
                            name += (fieldName + ":null - ");
                        }
                    } else {
                        if (!Objects.isNull(attribute)) {
                            if (lowerField.equals("cost")) {
                                if (i == clsFields.length - 1) {
                                    name += (fieldName + ":" + (String.format("%s$.", attribute.toString())));
                                } else {
                                    name += (fieldName + ":" + (String.format("%s$ - ", attribute.toString())));
                                }
                            } else {
                                if (i == clsFields.length - 1) {
                                    name += (fieldName + ":" + (String.format("%s.", attribute.toString())));
                                } else {
                                    name += (fieldName + ":" + (String.format("%s - ", attribute.toString())));
                                }
                            }
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return name;
    }
}
