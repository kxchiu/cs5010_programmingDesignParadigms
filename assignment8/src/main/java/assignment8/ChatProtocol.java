package assignment8;

import java.io.*;
import java.util.Map;

enum MessageIdentifier {
  CONNECT_MESSAGE(19),
  CONNECT_RESPONSE(20),
  DISCONNECT_MESSAGE(21),
  QUERY_CONNECTED_USERS(22),
  QUERY_USER_RESPONSE(23),
  BROADCAST_MESSAGE(24),
  DIRECT_MESSAGE(25),
  FAILED_MESSAGE(26),
  SEND_INSULT(27),
  RECEIVE_MESSAGE(28),
  SENT_MESSAGE(29);

  Integer value;

  MessageIdentifier(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public static MessageIdentifier getEnum(Integer identifierValue) throws IllegalArgumentException {
    for (MessageIdentifier messageIdentifier: MessageIdentifier.values()) {
      if (messageIdentifier.getValue().equals(identifierValue)) {
        return messageIdentifier;
      }
    }
    throw new IllegalArgumentException();
  }
}

public class ChatProtocol {

  Map<String, DataOutputStream> users;
  String message;
  String username;
  String recipient;
  String response;
  Integer length;

  public ChatProtocol(Map<String, DataOutputStream> users) {
    this.users = users;
  }

  public ChatProtocol() {
    this(null);
  }

  private String parseByteToString(DataInputStream inputStream) throws IOException {
    length = inputStream.readInt();
    inputStream.readChar();
    byte[] usernameByte = new byte[length];
    inputStream.readFully(usernameByte);
    inputStream.readChar();
    return new String(usernameByte);
  }

  public void processInput(DataInputStream inputStream, DataOutputStream outputStream, Integer id) throws IOException {
    boolean success;
    switch (MessageIdentifier.getEnum(id)) {
      case CONNECT_MESSAGE:
        username = parseByteToString(inputStream);
        if (users.containsKey(username)) {
          success = false;
          response = "Username " + username + " unsuccessfully connected! Username (" + username + ") is " +
            "already in use.";
        } else {
          users.put(username, outputStream);
          success = true;
          response = "Username " + username + " successfully connected! There are " + (users.size() - 1) +
            " " +
              "other users!";
        }

        outputStream.writeInt(20);
        outputStream.writeChar(' ');
        outputStream.writeBoolean(success);
        outputStream.writeChar(' ');
        outputStream.writeInt(response.getBytes().length);
        outputStream.writeChar(' ');
        outputStream.writeBytes(response);
        outputStream.writeChar(' ');
        outputStream.flush();
        break;
      case CONNECT_RESPONSE:
        success = inputStream.readBoolean();
        inputStream.readChar();
        message = parseByteToString(inputStream);
        System.out.println(message);
        break;
      case DISCONNECT_MESSAGE:
        username = parseByteToString(inputStream);
        if (users.containsKey(username)) {
          users.remove(username);
          success = true;
          response = "Username " + username + " successfully disconnected!";
        } else {
          success = false;
          response = "Username " + username + " not found!";
        }

        outputStream.writeInt(20);
        outputStream.writeChar(' ');
        outputStream.writeBoolean(success);
        outputStream.writeChar(' ');
        outputStream.writeInt(response.getBytes().length);
        outputStream.writeChar(' ');
        outputStream.writeBytes(response);
        outputStream.writeChar(' ');
        outputStream.flush();
        break;
      case QUERY_CONNECTED_USERS:
        username = parseByteToString(inputStream);

        outputStream.writeInt(23);
        outputStream.writeChar(' ');
        if (users.containsKey(username)) {
          outputStream.writeInt(users.size() - 1);
          outputStream.writeChar(' ');
          for (String user: users.keySet()) {
            if (!user.equals(username)) {
              outputStream.writeInt(user.getBytes().length);
              outputStream.writeChar(' ');
              outputStream.writeBytes(user);
              outputStream.writeChar(' ');
            }
          }
        }
        outputStream.flush();
        break;
      case QUERY_USER_RESPONSE:
        Integer userCount = inputStream.readInt();
        inputStream.readChar();
        System.out.println("----------\nCurrent Users:");
        for (int i = 0; i < userCount; i++) {
          System.out.println(parseByteToString(inputStream));
        }
        System.out.println("----------");
        break;
      case BROADCAST_MESSAGE:
        username = parseByteToString(inputStream);
        if (!users.containsKey(username)) {
          outputStream.writeInt(26);
          outputStream.writeChar(' ');
          message = "Sender username is invalid.";
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          break;
        }
        recipient = parseByteToString(inputStream);
        message = parseByteToString(inputStream);
        for (DataOutputStream dataOutputStream: users.values()) {
          sendMessage(dataOutputStream, username, message, recipient);
        }
        break;
      case DIRECT_MESSAGE:
        username = parseByteToString(inputStream);
        if (!users.containsKey(username)) {
          outputStream.writeInt(26);
          outputStream.writeChar(' ');
          message = "Sender username is invalid.";
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          break;
        }
        recipient = parseByteToString(inputStream);
        if (!users.containsKey(recipient)) {
          outputStream.writeInt(26);
          outputStream.writeChar(' ');
          message = "Recipient username is invalid.";
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          break;
        }
        message = parseByteToString(inputStream);

        for (Map.Entry<String, DataOutputStream> entry: users.entrySet()) {
          if (entry.getKey().equals(recipient)) {
            sendMessage(entry.getValue(), username, message, recipient);
          }
        }
        sendMessage(outputStream, username, message, recipient);
        break;
      case FAILED_MESSAGE:
        break;
      case SEND_INSULT:
        username = parseByteToString(inputStream);
        if (!users.containsKey(username)) {
          outputStream.writeInt(26);
          outputStream.writeChar(' ');
          message = "Sender username is invalid.";
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          break;
        }
        recipient = parseByteToString(inputStream);
        if (!users.containsKey(recipient)) {
          outputStream.writeInt(26);
          outputStream.writeChar(' ');
          message = "Recipient username is invalid.";
          outputStream.writeInt(message.getBytes().length);
          outputStream.writeChar(' ');
          outputStream.writeBytes(message);
          outputStream.writeChar(' ');
          break;
        }
        message = GrammarUtil.initiate();
        for (Map.Entry<String, DataOutputStream> entry: users.entrySet()) {
          if (entry.getKey().equals(recipient)) {
            sendMessage(entry.getValue(), username, message, recipient);
          }
        }
        sendMessage(outputStream, username, message, recipient);
        break;
      case RECEIVE_MESSAGE:
        String sender = parseByteToString(inputStream);
        recipient = parseByteToString(inputStream);
        message = parseByteToString(inputStream);
        System.out.println("From " + sender + " to " + recipient + ": " + message);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + id);
    }
  }

  private void sendMessage(DataOutputStream dataOutputStream, String username, String message,
                           String recipient) throws IOException {
    dataOutputStream.writeInt(28);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeInt(username.getBytes().length);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeBytes(username);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeInt(recipient.getBytes().length);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeBytes(recipient);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeInt(message.getBytes().length);
    dataOutputStream.writeChar(' ');
    dataOutputStream.writeBytes(message);
    dataOutputStream.writeChar(' ');
    dataOutputStream.flush();
  }


}
