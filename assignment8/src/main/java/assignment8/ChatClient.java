package assignment8;

import java.io.*;
import java.net.Socket;

public class ChatClient implements Runnable {

  private static final Integer portNumber = 1235;
  private static final String hostName = "localhost";

  private Socket socket;
  private ChatClientThread thread;
  private BufferedReader console;
  private DataOutputStream streamOut;
  private DataInputStream streamIn;
  private ChatClientThread client;
  private InputInterpreter interpreter;
  private String username;



  public ChatClient() {
    System.out.println("Establishing connection. Please wait...");
    try {
      socket = new Socket(hostName, portNumber);
      System.out.println("Connected: " + socket);
      console = new BufferedReader(new InputStreamReader(System.in));
      streamOut = new DataOutputStream(socket.getOutputStream());
      streamIn = new DataInputStream(socket.getInputStream());
      interpreter = new InputInterpreter(streamOut, console, this);
      thread = new ChatClientThread(this, socket);
      thread.start();
      printOptions();
    } catch (IOException ioe) {
      System.out.println("Unexpected exception: " + ioe.getMessage());
    }
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void printOptions() {
    System.out.println();
    System.out.println("Chat Options:");
    System.out.println("Logging On: \"logon [username]\"");
    System.out.println("Logging Off: \"logoff\"");
    System.out.println("Query Users: \"who\"");
    System.out.println("Direct Messaging: \"@user [recipient] [message]\"");
    System.out.println("Broadcast Messaging: \"@all [message]\"");
    System.out.println("Direct Insulting: \"!user [recipient]\"");
    System.out.println();
  }

  public void run() {
    while (true) {
      try {
        interpreter.interpret(console.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Thread client = new Thread(new ChatClient());
    client.start();
  }

//  public static void main(String[] args) throws IOException {
//    try (Socket socket = new Socket(hostName, portNumber)) {
//      DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//      DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//      InputInterpreter inputInterpreter = new InputInterpreter(outputStream, stdIn);
//
//      inputInterpreter.interpret("connect");
//
//      Integer id;
//      while ((id = inputStream.readInt()) != -1) {
//        inputStream.readChar();
//        chatProtocol.processInput(inputStream, outputStream, id);
//        String input = stdIn.readLine();
//        while (inputInterpreter.cannotInterpret(input)) {
//          System.out.println("Invalid command. Please try again or type '?' to view the options.");
//          input = stdIn.readLine();
//        }
//        inputInterpreter.interpret(input);
//      }
//    }
//  }
}
