package chat.view;

import javax.swing.JFrame;
import chat.controller.Controller;


public class Frame extends JFrame
{
	private Panel panel;
	private Controller app;
	
	public Frame(Controller app)
	{
		super();
		
		this.app = app;
		this.panel = new Panel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(800,600);
		this.setTitle("GUI Demo");
		this.setResizable(false);
		this.setVisible(true);
	}
}
