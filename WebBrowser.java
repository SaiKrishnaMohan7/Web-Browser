package javaIntermediatePractice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//Constructor
	public WebBrowser(){
		
		super("Sai Browser");
		
		addressBar = new JTextField("Enter a URL, mate!");
		addressBar.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							//Will go and read a HTML file and display it in the main window
							//Will take a string
							loadPage(e.getActionCommand());
							
						}
					}
				);
		add(addressBar, BorderLayout.NORTH);
		
		//the lead functionality for the display 
		display = new JEditorPane();
		display.setEditable(false);//only view no modification allowed to the user
		display.addHyperlinkListener(
					//the listener sits on top of every link created and waits for the event to occur
					new HyperlinkListener(){
						//called when and hyperlink event happens
						//when clicked(activated), when rolling over the link(entered), leaving the event(exited)
						//getType() deals the different types of hyperlink events
						public void hyperlinkUpdate(HyperlinkEvent e){
							if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
								loadPage(e.getURL().toString());
							}
						}
					}
				);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	
	//loadPage() loads the info to the display screen
	private void loadPage(String userText){
		try{
			//take any URL as a String and displays it!!
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			System.out.println("Wrong address!!");
		}
	}

}
