package assignment8;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClientThread extends Thread{

  private Socket socket;
  private ChatClient client;
  private DataInputStream streamIn;
  private ChatProtocol chatProtocol = new ChatProtocol();

  public ChatClientThread(ChatClient _client, Socket _socket) throws IOException {
    client = _client;
    socket = _socket;
    streamIn = new DataInputStream(socket.getInputStream());
  }

  public void run() {
    Integer id;
    while (true) {
      try {
        if ((id = streamIn.readInt()) == -1) break;
        streamIn.readChar();
        chatProtocol.processInput(streamIn, null, id);
      } catch(IOException ioe) {
        System.out.println("Listening error: " + ioe.getMessage());
        break;
      }
    }
  }
}
