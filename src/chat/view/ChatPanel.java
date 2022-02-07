package chat.view;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;

import javax.swing.JPanel;
import chat.controller.Controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;




public class ChatPanel extends JPanel
{
	private Controller app;
	
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private SpringLayout layout;
	
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JTextField chatField;
	
	private JButton chatButton;
	private JButton dateButton;
	private JButton timeButton;
	private JButton questionButton;
	private JButton politeButton;
	private JButton politicsButton;
	private JButton randomChatButton;
	
	private JButton saveButton;
	private JButton loadButton;
	
	public ChatPanel(Controller app)
	{
		super();
		
		this.app = app;
		
		this.layout = new SpringLayout();
		
		this.chatButtonPanel = new JPanel(new GridLayout(1,0));
		
		this.ioPanel = new JPanel(new GridLayout(1,0));
		
		this.chatArea = new JTextArea(20, 24);
		this.chatPane = new JScrollPane();
		this.chatField = new JTextField(50);
		
		this.chatButton = new JButton("Chat");
		
		this.dateButton = new JButton("Date");
		this.timeButton = new JButton("Time");
		this.questionButton = new JButton("Question");
		this.politeButton = new JButton("Polite?");
		this.politicsButton = new JButton("Politics?");
		this.randomChatButton = new JButton("Random");
		
		this.saveButton = new JButton("Save");
		this.loadButton = new JButton("Load");
		
		setupChatPane();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupChatPane()
	{
		chatArea.setEnabled(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		
		chatPane.setViewportView(chatArea);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		
		this.setPreferredSize(new Dimension(700, 500));
		
		this.add(chatButtonPanel);
		this.add(ioPanel);
		this.add(chatPane);
		this.add(chatField);
		this.add(chatButton);
		
		ioPanel.add(saveButton);
		ioPanel.add(loadButton);
		
		chatButtonPanel.add(dateButton);
		chatButtonPanel.add(timeButton);
		chatButtonPanel.add(questionButton);
		chatButtonPanel.add(politeButton);
		chatButtonPanel.add(politicsButton);
		chatButtonPanel.add(randomChatButton);
		
		Color background = new Color(45,67,212);
		this.setBackground(background);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText())));
		dateButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 1)));
		timeButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 2)));
		questionButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 0)));
		politeButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 4)));
		politicsButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 3)));
		randomChatButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 5)));
		saveButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 6)));
		saveButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 7)));
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, chatButtonPanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, chatButtonPanel, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, chatButtonPanel, 10, SpringLayout.SOUTH, ioPanel);
		layout.putConstraint(SpringLayout.WEST, ioPanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, ioPanel, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, chatPane, -150, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, chatPane, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, chatField, 10, SpringLayout.SOUTH, chatPane);
		layout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		layout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		layout.putConstraint(SpringLayout.NORTH, ioPanel, 10, SpringLayout.SOUTH, chatButton);
		layout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, chatField);
		layout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, this);
	}
	
	
	
}
