import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            System.out.println("Server starting..");
            //создаем объект сервера с указанием порта
            ServerSocket serverSocket = new ServerSocket(18443);
            System.out.println("Waiting connection..");

            //создаем объект подключения, которое берем из "слушания" сервера
            Socket socket = serverSocket.accept();
            System.out.println("Client connected " + socket);

            //создаем объекты входного и вызодного потоков
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            //создаем отдельный поток для независимого получения сообщений от клиента
            new Thread(() -> {
                while (true) {
                    try {
                        //считываем сообщения из входящего потока, если оно есть
                        String message = in.readUTF();
                        //данный процесс является блокирующим, поэтому он в отдельном потоке
                        System.out.println("Client: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //отдельный поток для отправки сообщения от сервера, но можно и не делать было
            new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                    try {
                        //считываем из консоли сообщение от сервера
                        String messageServer = reader.readLine();
                        //и передаем его в выходящий поток
                        out.writeUTF(messageServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    private DataInputStream in;
//    private DataOutputStream out;
//
//    public static void main(String[] args) {
//        new Server();
//    }
//
//    public Server() {
//        try {
//            System.out.println("Server is starting up...");
//            ServerSocket serverSocket = new ServerSocket(18443);
//
//            System.out.println("Server waiting for connection...");
//            Socket socket = serverSocket.accept();
//            System.out.println("Client connected: " + socket);
//
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//
//            while (true) {
//                String message = in.readUTF();
//                out.writeUTF("Echo: " + message);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                in.close();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}