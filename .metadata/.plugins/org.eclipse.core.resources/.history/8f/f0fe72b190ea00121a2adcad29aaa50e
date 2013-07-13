package server;


public class MathProtocol {
	private static final int WAITING = 0;
	private static final int RECIEVEDQUERY = 1;
	private static final int ADDITION = 2;
	private static final int SUBTRACTION = 3;
	
	private int state = WAITING;
	
	public String processInput(String in)
	{
		String out = null;
		
		if(state == WAITING)
		{
			out = "Would you like to add or subtract?";
			state = RECIEVEDQUERY;
		}
		else if (state == RECIEVEDQUERY)
		{
			if(in.equalsIgnoreCase("add"))
			{
				out = "Enter the two integers, seperated by a comma. (ex: 12,13)";
				state = ADDITION;
			}
			else if (in.equalsIgnoreCase("subtract"))
			{
				out = "Enter the two integers, seperated by a comma. (ex: 12,13)";
				state = SUBTRACTION;
			}
		}
		else if (state == ADDITION)
		{
			String[] parts = in.split(",");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			out = "" + MathLogic.add(a, b);
			state = WAITING;
		}
		else if (state == SUBTRACTION)
		{
			String[] parts = in.split(",");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			out = "" + MathLogic.subtract(a, b);
			state = WAITING;
		}
		return out;
	}
}
