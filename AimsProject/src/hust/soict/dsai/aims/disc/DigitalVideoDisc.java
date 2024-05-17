package hust.soict.dsai.aims.disc;
import java.lang.reflect.*;
import java.util.Objects;
public class DigitalVideoDisc {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;


    // Getters and Setters

    public static int getNb() {
        return nbDigitalVideoDiscs;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void setNb(Object nb) {
    	DigitalVideoDisc.nbDigitalVideoDiscs = (int) nb;
    }

    public void setDirector(Object director) {
        this.director = (String) director;
    }

    public void setLength(Object length) {
        this.length = (int) length;
    }

    // Constructors

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.director = director;
        this.title = title;
        this.category = category;
        this.length = length;
        this.cost = cost;
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;

    }

    public DigitalVideoDisc(String title, String director, String category, float cost) {
        this.director = director;
        this.title = title;
        this.category = category;
        this.cost = cost;
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc() {
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
    }

    @Override
    public String toString() {
        Class<?> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        String name = String.format("%d.", this.id) + "DVD - ";
        for (int i = 0; i < fields.length - 2; i++) {
            String lowerField = fields[i].toString().split(String.format("%s.", cls.toString().split(" ")[1]))[1];
            String fieldName = String.valueOf(lowerField.charAt(0)).toUpperCase() + lowerField.substring(1);
                try {
                Method getter = cls.getDeclaredMethod("get" + fieldName);
                Object attribute = getter.invoke(this);

                if ((i < fields.length - 4) & (Objects.isNull(attribute) == false)) {
                    name += (String.format("%s - ", attribute.toString()));
                }
                else if ((i < fields.length - 4) & (Objects.isNull(attribute) == true)) {
                    name += "null - ";
                }
                else if ((i == fields.length - 4) & (Objects.isNull(attribute) == false)) {
                    name += (String.format("%s: ", attribute.toString()));
                }
                else if ((i == fields.length - 4) & (Objects.isNull(attribute) == true)) {
                    name += "null: ";
                }
                else {
                    name += (String.format("%s$", attribute.toString()));
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
