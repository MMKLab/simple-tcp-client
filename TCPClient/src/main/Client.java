package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		int portNumber = 12000;
		
		BufferedReader serverInputStream;
		PrintStream serverOutputStream;		
		BufferedReader consoleInputStream = new BufferedReader(new InputStreamReader(System.in));
		
		Socket communicationSocket = new Socket("localhost", portNumber);		
		/* 
		 * Alternatively replace x.x.x.x with IP address of another device to connect to it instead of localhost
		 * Socket communicationSocket = new Socket("x.x.x.x", portNumber);
		 */	
		serverInputStream = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
		serverOutputStream = new PrintStream(communicationSocket.getOutputStream());
		
		System.out.println("Enter a word or a sentence:");
		String userInput = consoleInputStream.readLine();
		
		serverOutputStream.println(userInput);
		
		String result = serverInputStream.readLine();		
		System.out.println("You entered: " + userInput + "\nServer replied: " + result);
		
		communicationSocket.close();
		
	}	
}