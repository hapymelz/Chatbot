package chat.model;

import java.time.LocalDateTime;



public class Chatbot
{
	private String name;
	private ArrayList<Chatbot> greetings;
	
	
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
		
		response += getDate() + "\n";
		
		response += getTime();
		
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
		
		day = "the " + currentDate.getDayOfMonth() + " ";
		
		date += day + "of ";
		
		String month = currentDate.getMonth().toString();
		
		date += month + ", " + currentDate.getYear();
		
		return date;
	}
	
	public String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time += currentTime.getHour() + ":";	
		time += currentTime.getMinute();
		
		
		
		return time;
	}
	
	
	public String sayGreeting()
	{
		
		
		
		
	}
	
}
	
