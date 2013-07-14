package edu.neumont.csc380;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Driver {
	public static void main(String[] args)
	{
		/* 1) Get an instance of a Class object using the String name for ReflectionActivity.java. */
		Class c = null;
		try {
			c = Class.forName("edu.neumont.csc380.ReflectionActivity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* 2) Print out all of the constructors available for a class, including their respective parameter types. */
		Constructor[] ctors = c.getConstructors();
		for(Constructor ctor : ctors)
		{
			System.out.print(ctor.getName() + ", Params: ");
			Class[] params = ctor.getParameterTypes();
			for(Class param : params)
			{
				System.out.print(param.getName() + ", ");
			}
			System.out.println();
		}
		
		/* 3) Create an instance of a ReflectionActivity from its Class object by calling the ReflectionActivity(String, double) constructor. */
		ReflectionActivity fromReflect = null;
		try {
			fromReflect = (ReflectionActivity) c.getConstructor(String.class, double.class).newInstance("test", 1.1);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* 4) Print out all of the fields (type and name) in a class (including private fields) */
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields)
		{
			System.out.print("Field type: " + f.getType().getName());
			System.out.println(", Field name: " + f.getName());
		}
		
		/* 5) Using reflection, call the addToNumber(double) method on your ReflectionActivity instance. */
		Method m = null;
		try {
			m = c.getMethod("addToNumber", double.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			m.invoke(fromReflect, 7.7);
			
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Math.abs('q'));
	}
}
