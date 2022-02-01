package chat.controller;

//import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Controller
{	//private Scanner input;
	private Chatbot myChatbot;
	private Popup view;
	
	
	public Controller()
	{
		//this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("Chatbot");
		this.view = new Popup(); 
		
	}
	
	public void start()
	{
		ArrayList<String> input = loadTextToList("user input.txt");
		myChatbot.setUserInput(input);
		input = loadTextToList("chat output.txt");
		myChatbot.setChatbotResponses(input);
		
		
		view.displayMessage(myChatbot.sayGreeting());
		
		String userText = view.askQuestion("What do you want to talk about?");
		
		while (!userText.equals("quit"))
		{
			String response = interactWithChatbot(userText);
			view.displayMessage(response);
			
			
			userText = view.askQuestion("Keep talking?");
		}
		view.displayMessage(myChatbot.sayFarewell());
		
		view.displayMessage("Conversation saved");
		saveListAsText(myChatbot.getUserInputs(), "user input.txt");
		saveListAsText(myChatbot.getChatbotResponses(), "chat output.txt");
	}
	
	public String interactWithChatbot(String text, int buttonNumber)
	{
		String response = "";
		
		response += myChatbot.processText(text, buttonNumber);
		
		
		return response;
	}
	
	
	public String interactWithChatbot(String text)
	{
		String response = "";
		
		response += myChatbot.processText(text,1);
		
		return response;
	}

	public void handleError(Exception error)
	{
		String details = "Your error is: " + error.getMessage();
		view.displayMessage(details);
	}

	private void saveListAsText(ArrayList<String> responses, String fileName)
	{
		File saveFile = new File(fileName);
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			for (String content : responses)
			{
				saveText.println(content);
			}
		}
		catch (IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch (Exception genericError)
		{
			handleError(genericError);
		}
	}

	private ArrayList<String> loadTextToList(String filename)
	{
		ArrayList<String> fileContents = new ArrayList<String>();
		
		File source = new File(filename);
		
		try (Scanner fileScanner = new Scanner(source))
		{
			while (fileScanner.hasNextLine())
			{
				fileContents.add(fileScanner.nextLine());
			}
		}
		catch (IOException fileError)
		{
			handleError(fileError);
		}
		catch (Exception error)
		{
			handleError(error);
			
		}
		
		return fileContents;
	}


}





 