package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * The model for our Chatbot project. Used to explore String methods and Text processing
 * Not very smart, but thats ok!
 * @author knum5420
 *
 */



public class Chatbot
{
	private String name;
	//private int greetingCount;
	//private int farewellCount; 
	public ArrayList<String> userInputs;
	public ArrayList<String> chatbotResponses;
	
	public Chatbot(String name)
	{
		this.name = name;
		//this.greetingCount = 0;
		//this.farewellCount = 4;
		this.userInputs = new ArrayList<String>();
		this.chatbotResponses = new ArrayList<String>();
	}
	
	public String getName()
	{
		String Name = this.name;
		
		return "My name is " + Name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String processText(String text, int choice)
	{
		String response = "";
		
		if (choice == 0)
		{
			if (containsQuestion(text))
			{
				response += answerQuestion(text);
			}
			else
			{
				response += "not a question, silly mammal";
			}
		}
		else if (choice == 1)
		{
			response += getDate();
		}
		else if (choice == 2)
		{
			response += getTime();
		}
		else if (choice == 3) 
		{
			response += "Whatever you say about politics, you're wrong. \n";
		}
		else if (choice == 4)
		{
			response += "Oh, you are SO polite!";
		}
		else if (choice == 5)
		{
			response += " " + getRandomTopic();
		}
		
		
		return response + "\n";
	}
	
	
	
	/**
	 * Processes the supplied text and provides a response for external method called
	 * @param text The text sent from the user via the Controller
	 * @return The Chatbot's answer to continue the discussion.
	 */
	
	public String processText(String text)
	{
		String response =  "\nYou said: ";
		
		response += text + "\n";
		
		if (containsQuestion(text))
		{
			response += answerQuestion(text);
		}
		
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
			response += "Whatever you say about politics, you're wrong. \n";
		}
		
		if (isPolite(text))
		{
			response += "Oh, you are SO polite!";
		}
		
		
		
		
		//response += " " + getRandomTopic();
		
		
		return response;
	}
	
	public String sayGreeting()
	{
		String greeting = " ";
		
		
		String [] greetings = new String [5];
		
		
		greetings[0] = ("Hallo!");
		greetings[1] = ("Howdy!");
		greetings[2] = ("Good day to you, sir.");
		greetings[3] = ("Hi friend!");
		greetings[4] = ("Hey, you!");
		
		int random = (int) Math.random() * greetings.length;
		
		greeting = greetings[random];
		
		return greeting;
	}
	
	public String sayFarewell()
	{
		String farewell = " ";
		
		String [] farewells = new String [5];
		
		farewells[0] = ("Bye Bye!");
		farewells[1] = ("See ya!");
		farewells[2] = ("Au Revoir!");
		farewells[3] = ("Good Bye!");
		farewells[4] = ("Don't have a good day. Have a great day!");
		
		int random = (int) Math.random() * farewells.length;
		
		farewell = farewells[random];
		
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
	
	private String getDate()
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
	
	private String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time += currentTime.getHour() + ":";	
		time += currentTime.getMinute();
		
		
		
		return time;
	}
	
	private Boolean isPolitical(String parameter)
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
	
	private Boolean isPolite(String parameter)
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
	
	private String getRandomTopic()
	{
		String topic = "";
		
		ArrayList<String> randomTopics = new ArrayList<String>();
		
		randomTopics.add("Favorite Animal? ");
		randomTopics.add("What's your favorite sport/team? ");
		randomTopics.add("Do you go to school? ");
		randomTopics.add("Can an elephant jump sideways? ");
		randomTopics.add("Can anything jump sideways? ");
		randomTopics.add("What animals can jump sideways? ");
		randomTopics.add("Can you jump sideways? ");
		randomTopics.add("What's your name? ");
		randomTopics.add("I want to talk about cheese. ");
		randomTopics.add("What's the capital of Uruguay? ");
		randomTopics.add("Can I go to the bathroom please? ");
		
		int randomIndex = (int) (Math.random() * randomTopics.size());
		
		topic = randomTopics.get(randomIndex);
		
		return topic;
	}
	


	private Boolean containsQuestion(String question)
	{
		boolean isQuestion = false;
	
		
		ArrayList<String> keywords = new ArrayList<String>();
		
		keywords.add("can you");
		keywords.add("will you");
		keywords.add("?");
		keywords.add("can i");
		keywords.add("will i");
		
		
		for (int index = 0; index < keywords.size(); index ++)
		{
			if (question.toLowerCase().contains(keywords.get(index)))
			{
				isQuestion = true;
			}
			
		}
				

		
		return isQuestion;
	}
	
	private String answerQuestion(String question)
	{
		String answer = question;
		String topic = "";
		
		ArrayList<String> keywords = new ArrayList<String>();
		ArrayList<String> identifiers = new ArrayList<String>();
		ArrayList<String> wonderings = new ArrayList<String>();
		
		keywords.add("can you");
		keywords.add("will you");
		
		identifiers.add(" me");
		identifiers.add(" i ");
		//identifiers.add("you");
		
		wonderings.add("you are pretty smart. ");
		wonderings.add("I should not do that ");
		wonderings.add("you can eat a banana. ");
		wonderings.add("is very interesting. ");
		wonderings.add("shrimp is tasty ");
		wonderings.add("Ryan Reynolds is hilarious. ");
		wonderings.add("you are kinda dumb. ");
		wonderings.add("the Utes are a pretty good football team. ");
		wonderings.add("I should instead eat ice cream. ");
		wonderings.add("we should go together. ");
		wonderings.add("I have an appointment today. ");
		wonderings.add("we should break up. ");
		
		
		for (int index = 0; index < identifiers.size(); index ++)
		{
			answer = answer.replace(identifiers.get(index), " you ");
		}

		
		for (int index = 0; index < keywords.size(); index ++)
		{
			if (answer.toLowerCase().contains(keywords.get(index)))
			{
				answer = answer.replace(keywords.get(index), "You asked me to");
			}
			
		}
		
		if (answer.contains("?"))
		{
			answer = answer.replace("?", ". ");
		}
					
		int randomIndex = (int) (Math.random() * wonderings.size());
		topic = wonderings.get(randomIndex);
		
		answer += ". I think that " + topic;
		
		//answer += ". I'm wondering " + getRandomTopic();
		
		return answer;
	}

	
	public String getMostCommonWord(ArrayList<String> source)
	{
		String common = "";
		
		ArrayList<String> actualWords = new ArrayList<String>();
		
		for (String sentence : source)
		{
			String [] words = sentence.split(" ");
			for(String word : words)
			{
				actualWords.add(word);
			}
		}
		
		int most = 0;
		
		for (int index = 0; index < actualWords.size(); index++)
		{
			String current = actualWords.get(index);
			int count = 1;
			for (int inner = index + 1; inner < actualWords.size(); inner++)
			{
				if (actualWords.get(inner).equalsIgnoreCase(current))
				{
					count++;
				}
				
			}
			if (count > most)
			{
				most = count;
				common = current;
			}
		}
		common = "The most common word was: "+ common + " and it occurs " + most + " times.";
		
		return common;
	}
	
	public ArrayList<String> getUserInputs()
	{
		return this.userInputs;
	}
	
	public ArrayList<String> getChatbotResponses()
	{
		return this.chatbotResponses;
	}

	public void setUserInput(ArrayList<String> input)
	{
		this.userInputs = input;
	}
	
	public void setChatbotResponses(ArrayList<String> responses)
	{
		this.chatbotResponses = responses;
	}


}
	
