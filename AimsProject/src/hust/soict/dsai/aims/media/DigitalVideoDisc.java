package hust.soict.dsai.aims.media;

import java.lang.reflect.*;
import java.util.Objects;
public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    // Getters and Setters
    public void setId(Object id) { this.setId((int) id); }
    
    public void setNb(Object nb) {
    	DigitalVideoDisc.nbDigitalVideoDiscs = (int) nb;
    }

    public void setTitle(Object title) {
        this.setTitle((String) title);
    } 

    public void setDirector(Object director) {
        this.setDirector((String) director);
    }

    public void setCategory(Object category) {
        this.setCategory((String) category);
    }

    public void setLength(Object length) {
        this.setLength((int) length);
    }

    public void setCost(Object cost) {
        this.setCost((float) cost);
    }

    // Constructors

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.setDirector(director);
        this.setTitle(title);
        this.setCategory(category);
        this.setLength(length);
        this.setCost(cost);
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String director, String category, float cost) {
        this.setDirector(director);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc() {
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    @Override
    public String toString() {
        Class<?> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        String name = String.format("%d.", this.getId()) + "DVD - ";
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
