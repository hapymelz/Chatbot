package chat.view;

import javax.swing.JFrame;
import chat.controller.Controller;


public class ChatFrame extends JFrame
{
	private ChatPanel chatPanel;
	private Controller app;
	
	public ChatFrame(Controller app)
	{
		super();
		
		this.app = app;
		this.chatPanel = new ChatPanel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(chatPanel);
		this.setSize(800,600);
		this.setTitle("ChatBot");
		this.setResizable(false);
		this.setVisible(true);
	}
}
