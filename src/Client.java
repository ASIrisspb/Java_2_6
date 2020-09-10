import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
//    private JTextArea textForView;

    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        try {
            Socket socket = new Socket("127.0.0.1", 18443);
            System.out.println("Client info " + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //отдельный поток для получения сообщений от сервера
            new Thread(()->{
                while (true) {
                    try {
                        String messageServer = in.readUTF();
                        System.out.println("Server: " + messageServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //отдельный поток для печати в консоль. Можно было не делать
            new Thread(()->{
                while (true) {
                    try {
                        String message = reader.readLine();
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //конструктор для работы с ГУИ
//    public Client(JTextArea textForView) {
//        this.textForView = textForView;
//        try {
//            Socket socket = new Socket("127.0.0.1", 18443);
//            System.out.println("Client info " + socket);
//
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            //отдельный поток для получения сообщений от сервера
////            new Thread(()->{
////                while (true) {
////                    try {
////                        String messageServer = in.readUTF();
////                        System.out.println("Server: " + messageServer);
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }).start();
//            //отдельный поток для печати в консоль. Можно было не делать
////            new Thread(()->{
////                while (true) {
////                    try {
////                        String message = reader.readLine();
////                        out.writeUTF(message);
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }).start();
//            //отдельный поток для связи с ГУИ
//            new Thread(()->{
//                while (true) {
//                    try {
//                        String messageGUI = in.readUTF();
//                        textForView.append(messageGUI);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
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
//
//    public DataInputStream getIn() {
//        return in;
//    }
//
//    public DataOutputStream getOut() {
//        return out;
//    }

}



//import javax.swing.*;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//
//public class Client {
//    private DataInputStream in;
//    private DataOutputStream out;
//    private JTextArea charArea;
//
//    public Client() {}
//
//    public Client(JTextArea charArea) {
//        this.charArea = charArea;
//
//        try {
//            Socket socket = new Socket("127.0.0.1", 18443);
//            System.out.println("Client info: " + socket);
//
//            in = new DataInputStream(socket.getInputStream());
//            out = new DataOutputStream(socket.getOutputStream());
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        while (true) {
//                            String message = in.readUTF();
//                            charArea.append(message);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
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
//
//    public DataInputStream getIn() {
//        return in;
//    }
//
//    public DataOutputStream getOut() {
//        return out;
//    }
//
//    public static void main(String[] args) {
//        new Client();
//    }
//}
