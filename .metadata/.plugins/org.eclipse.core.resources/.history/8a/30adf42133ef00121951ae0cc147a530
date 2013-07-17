package server.utility;

public class StringParser {
	public static Object parseFromString(String input)
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
		return output;
	}
}
