package assignment8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

  private static final Integer portNumber = 1235;
  private static Map<String, DataOutputStream> users = new ConcurrentHashMap<>();
  private static ChatProtocol chatProtocol = new ChatProtocol(users);

  public static void main(String[] args) throws Exception {
    System.out.println("The chat server is listening to port " + portNumber + "...");
    try (ServerSocket listener = new ServerSocket(portNumber)) {
      ExecutorService pool = Executors.newFixedThreadPool(10);
      while (true) {
        pool.execute(new ChatRoomServer(listener.accept()));
      }
    }
  }

  /** The client handler task. */
  private static class ChatRoomServer implements Runnable {
    private Socket socket;

    ChatRoomServer(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      System.out.println("Connected: " + socket.toString());
      try {
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        Integer id;
        while ((id = inputStream.readInt()) != -1) {
          inputStream.readChar();
          chatProtocol.processInput(inputStream, outputStream, id);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Closed: " + socket);
    }
  }
}
