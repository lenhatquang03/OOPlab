package AimsProject.src.hust.soict.dsai.aims.test.disc;
import java.lang.reflect.*;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {

		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		System.out.println(jungleDVD.getTitle());
		System.out.println(cinderellaDVD.getTitle());
		System.out.println();

		DigitalVideoDisc[] dvds = {jungleDVD, cinderellaDVD};

		realSwap(dvds);

		System.out.println(jungleDVD.getTitle());
		System.out.println(cinderellaDVD.getTitle());
	}

	public static <T> String realSwap(T... objs) {
		if (objs.length != 2) {
			return "Only 2 objects can be swapped!!";
		}
		else {
			Class<?> cls = objs[0].getClass();
			Field[] fields = cls.getDeclaredFields();
			// fields[i] will have the form: private java.lang.String DigitalVideoDisc.director

			for (int i = 0; i < fields.length; i++) {
				String lowerField = fields[i].toString().split(String.format("%s.", cls.toString().split(" ")[1]))[1];
				// Example of lowerField: director.
				String fieldName = String.valueOf(lowerField.charAt(0)).toUpperCase() + lowerField.substring(1);
				// Example of fieldName: Director

				try{
					Method getter = cls.getDeclaredMethod("get" + fieldName);
					Method setter = cls.getDeclaredMethod("set" + fieldName, Object.class);
					// cls.getDeclaredMethod(name, parameterTypes = Getting the specific method in the class.
					Object tmp0 = getter.invoke(objs[0]);
					Object tmp1 = getter.invoke(objs[1]);
					setter.invoke(objs[1], tmp0);
					setter.invoke(objs[0], tmp1);
					// Method.invoke(object, arguments) = calling the method on the object with the arguments stated.
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				}
			}
			return "Objects swapped!";
		}

}

