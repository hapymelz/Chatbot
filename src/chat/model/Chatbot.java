package chat.model;

import java.time.LocalDateTime;



public class Chatbot
{
	private String name;
	
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public String processText(String text)
	{
		String response = "You said: ";
		
		response += text + "\n";
		
		response += getDate();
		
		return response;
	}
	
	
	@Override
	public String toString()
	{
		String description = "Hello, I am "  + name + " and I am here to chat with you";
		description += ".\n";
		description += "My favorite topic is: coming soon";
		
		return description;
	}
	
	public String getDate()
	{
		String date = "The date is ";
		
		LocalDateTime currentDate = LocalDateTime.now();
		
		String day = currentDate.getDayOfWeek().toString();
		
		date += day + ", ";
		
		return date;
	}
	
	public String getTime()
	{
		String time = "";
		
		return time;
	}
	
}
	
