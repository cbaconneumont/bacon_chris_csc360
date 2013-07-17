package server.utility;

import java.lang.reflect.InvocationTargetException;

public class StringParser {
	public static Object parseFromString(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		//check int -> double -> char -> boolean -> string
		Object output = input;
		try
		{
			int i = Integer.parseInt(input);
			output = i;
			return output;
		}
		catch(NumberFormatException nfe)
		{}
		try
		{
			double d = Double.parseDouble(input);
			output = d;
			return output;
		}
		catch(NumberFormatException nfe)
		{}
		if(input.length() == 1)
		{
			char c = input.charAt(0);
			output = c;
			return output;
		}
		else if(input.equalsIgnoreCase("false"))
		{
			output = false;
		}
		else if(input.equalsIgnoreCase("true"))
		{
			output = true;
		}
		else if(input.startsWith("new "))
		{
			String allParams = input.substring(input.indexOf('(')+1, input.indexOf(')'));
			String[] paramsAsStrings = allParams.split(";");
			Object[] parameters = new Object[paramsAsStrings.length];
			for(int i = 0; i <paramsAsStrings.length; i++)
			{
				parameters[i] = parseFromString(paramsAsStrings[i]);
			}
			String className = input.substring(4, input.indexOf('('));
			Class creating = Class.forName(className);
			output = creating.getConstructors()[0].newInstance(parameters);
		}
		return output;
	}
}
