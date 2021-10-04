package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Chatbot
{
	private String name;
	private int greetingCount;
	private int farewellCount; 
	
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
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
		String response = sayGreeting() + "\nYou said: ";
		
		response += text + "\n";
		
		if (text.toLowerCase().indexOf("date") >= 0)
		{
			response += getDate() + "\n";
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			response += getTime() + "\n";
		}
		
		if (isPolitical(text))
		{
			response += "I'm not about politics.\n";
			response += sayFarewell() + "\n";
		}
		
		if (isPolite(text))
		{
			response += "Oh, you are SO polite!";
		}
		
		response += getRandomTopic();
		
		return response;
	}
	
	public String sayGreeting()
	{
		String greeting = " ";
		
		ArrayList<String> greetings = new ArrayList<String>();
		
		greetings.add("Hallo!");
		greetings.add("Howdy!");
		greetings.add("Good day to you, sir.");
		greetings.add("Hi friend!");
		greetings.add("Hey, you!");
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		
		if (greetingCount == greetings.size())
		{
			greetingCount = 0;
		}
		
		return greeting;
	}
	
	public String sayFarewell()
	{
		String farewell = " ";
		
		ArrayList<String> farewells = new ArrayList<String>();
		
		farewells.add("Bye Bye!");
		farewells.add("See ya!");
		farewells.add("Au Revoir!");
		farewells.add("Good Bye!");
		farewells.add("Have a nice day!");
		
		farewell = farewells.get(farewellCount);
		farewellCount--;
		
		if (farewellCount == 0)
		{
			farewellCount = 4;
		}
		
		return farewell;
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
	
	public Boolean isPolitical(String parameter)
	{
		boolean political = false;
		
		ArrayList<String> politicList = new ArrayList<String>();
		
		politicList.add("politics");
		politicList.add("republican");
		politicList.add("democrat");
		politicList.add("election");
		politicList.add("biden");
		
		for (int index = 0; index < 5; index++)
		{
			if (parameter.toLowerCase().indexOf(politicList.get(index)) >= 0)
			{
				political = true;
			}
		}
		
		return political;
	}
	
	public Boolean isPolite(String parameter)
	{
		boolean polite = false;
		
		ArrayList<String> politeness = new ArrayList<String>();
		
		politeness.add("please");
		politeness.add("thank you");
		
		for (String current : politeness)
		{
			if (parameter.toLowerCase().indexOf(current) >= 0)
			{
				polite = true;
			}
		}
		
		return polite;
	}
	
	public String getRandomTopic()
	{
		String topic = "";
		
		ArrayList<String> randomTopics = new ArrayList<String>();
		
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		randomTopics.add("");
		
		int randomIndex = (int) (Math.random() * randomTopics.size());
		
		topic = randomTopics.get(randomIndex);
		
		return topic;
	}
	
}
	
