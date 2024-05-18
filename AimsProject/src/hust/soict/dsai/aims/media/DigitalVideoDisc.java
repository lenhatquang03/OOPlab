package hust.soict.dsai.aims.media;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
public class DigitalVideoDisc extends Disc implements Playable {
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

    // Methods
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        String name = String.format("%d.", this.getId()) + "DVD - ";
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
                                name += (fieldName + ":" +(String.format("%s$ - ", attribute.toString())));
                            }
                            else {
                                name += (fieldName + ":" +(String.format("%s - ", attribute.toString())));
                            }
                        }
                        else {
                            name += (fieldName + ":null - ");
                        }
                    }
                    else {
                        if (!Objects.isNull(attribute)) {
                            if (lowerField.equals("cost")) {
                                if (i == clsFields.length - 1) {
                                    name += (fieldName + ":" +(String.format("%s$.", attribute.toString())));
                                }
                                else {
                                    name += (fieldName + ":" +(String.format("%s$ - ", attribute.toString())));
                                }
                            }
                            else {
                                if (i == clsFields.length - 1) {
                                    name += (fieldName + ":" +(String.format("%s.", attribute.toString())));
                                }
                                else {
                                    name += (fieldName + ":" +(String.format("%s - ", attribute.toString())));
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
