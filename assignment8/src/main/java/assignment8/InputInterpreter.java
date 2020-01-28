package assignment8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

enum EnumCommand {
  CONNECT("logon"),
  DISCONNECT("logoff"),
  QUERY_CONNECTED_USERS("who"),
  DIRECT_MESSAGE("@user"),
  BROADCAST_MESSAGE("@all"),
  SEND_INSULT("!user"),
  HELP("?");

  String command;

  EnumCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

  public static Boolean contains(String command) {
    for (EnumCommand enumCommand: EnumCommand.values()) {
      if (enumCommand.getCommand().equals(command)) {
        return true;
      }
    }
    return false;
  }

  public static EnumCommand getEnum(String input) {
    for (EnumCommand command: EnumCommand.values()) {
      if (command.getCommand().equals(input)) {
        return command;
      }
    }
    throw new IllegalArgumentException();
  }
}

public class InputInterpreter {

  private static DataOutputStream outputStream;
  private static BufferedReader bufferedReader;
  private static ChatClient chatClient;
  private static String username;
  private static String recipient;
  private static String message;
  private static String[] tokens;

  public InputInterpreter(DataOutputStream outputStream, BufferedReader bufferedReader, ChatClient chatClient) {
    this.outputStream = outputStream;
    this.bufferedReader = bufferedReader;
    this.chatClient = chatClient;
  }

  public boolean canInterpret(String input) {
    if (EnumCommand.contains(firstWordOf(input))) {
      return true;
    }
    System.out.println("Cannot interpret given command.");
    return false;
  }

  private String firstWordOf(String input) {
    return input.contains(" ") ? input.substring(0, input.indexOf(" ")) : input;
  }

  private Boolean isConnected() {
    return !isDisconnected();
  }

  private Boolean isDisconnected() {
    return chatClient.getUsername() == null;
  }

  public void interpret(String input) throws IOException {
    String command = firstWordOf(input);
    if (canInterpret(input)) {
      switch (EnumCommand.getEnum(command)) {
        case CONNECT:
          if (isConnected()) {
            System.out.println("You are already connected with the username: " + chatClient.getUsername());
            break;
          }
          tokens = input.split(" ", 2);
          username = tokens[1];
          chatClient.setUsername(username);
          outputStream.writeInt(19);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case DISCONNECT:
          if (isDisconnected()) {
            System.out.println("You are already disconnected.");
            break;
          }
          username = chatClient.getUsername();
          chatClient.setUsername(null);
          outputStream.writeInt(21);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case QUERY_CONNECTED_USERS:
          if (isDisconnected()) {
            System.out.println("You are disconnected.");
            break;
          }
          username = chatClient.getUsername();
          outputStream.writeInt(22);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case DIRECT_MESSAGE:
          if (isDisconnected()) {
            System.out.println("You must first connect with a valid username.");
            break;
          }
          username = chatClient.getUsername();
          tokens = input.split(" ", 3);
          recipient = tokens[1];
          message = tokens[2];
          outputStream.writeInt(25);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.writeInt(recipient.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(recipient);
          outputStream.writeChar(' ');
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case BROADCAST_MESSAGE:
          if (isDisconnected()) {
            System.out.println("You must first connect with a valid username.");
            break;
          }
          username = chatClient.getUsername();
          tokens = input.split(" ", 2);
          message = tokens[1];
          recipient = "everyone";
          outputStream.writeInt(24);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.writeInt(recipient.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(recipient);
          outputStream.writeChar(' ');
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case SEND_INSULT:
          if (isDisconnected()) {
            System.out.println("You must first connect with a valid username.");
            break;
          }
          username = chatClient.getUsername();
          tokens = input.split(" ", 2);
          recipient = tokens[1];
          outputStream.writeInt(27);
          outputStream.writeChar(' ');
          outputStream.writeInt(username.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(username);
          outputStream.writeChar(' ');
          outputStream.writeInt(recipient.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(recipient);
          outputStream.writeChar(' ');
          outputStream.flush();
          break;
        case HELP:
          chatClient.printOptions();
          break;
        default:
          throw new IllegalStateException("Unexpected value: " + tokens[0]);
      }
    }
  }

}
