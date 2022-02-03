package chat.view;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import javax.swing.JPanel;
import chat.controller.Controller;

import java.awt.Color;
import java.awt.GridLayout;




public class Panel extends JPanel
{
	private Controller app;
	
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private SpringLayout layout;
	
	private JTextArea chatArea;
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
	
	public Panel(Controller app)
	{
		super();
		
		this.app = app;
		
		this.layout = new SpringLayout();
		
		this.chatButtonPanel = new JPanel(new GridLayout(1,0));
		this.ioPanel = new JPanel(new GridLayout(1,0));
		
		this.chatArea = new JTextArea(20, 24);
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
		
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	
	
}
