package hust.soict.dsai.aims.media;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book extends Media {
    // Attributes
    private List<String> authors = new ArrayList<String>();

    // Constructor
    public Book() {}
    public Book(String title, String category, int id) {
        super(title, category);
        this.setId(id);
    }

    // Accessor methods

    // Methods
    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("The author already exists!!");
        }
        else {
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.remove(authorName);
        }
        else {
            System.out.println("The author does not exist!!");
        }
    }

    @Override
    public String toString() {
        String name = String.format("%d.", this.getId()) + "Book - ";
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
