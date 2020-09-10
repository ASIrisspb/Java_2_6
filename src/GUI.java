//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//
//public class GUI extends JFrame {
//    private Client client;
//
//    public GUI() {
//        JTextArea chatArea = new JTextArea();
//        client = new Client(chatArea);
//
//        setTitle("Dummy Chat");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(new Rectangle(0, 0, 300, 500));
//        setLayout(new BorderLayout());
//
//
//        chatArea.setEditable(false);
//        add(chatArea, BorderLayout.CENTER);
//
//        JPanel bottom = new JPanel();
//        bottom.setLayout(new BorderLayout());
//
//        JTextField inputField = new JTextField();
//        JButton submitButton = new JButton();
//        submitButton.setText("Submit");
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String message = inputField.getText();
//                if (!message.trim().isBlank()) {
//                    try {
//                        client.getOut().writeUTF(message);
//                        inputField.setText("");
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        bottom.add(inputField, BorderLayout.CENTER);
//        bottom.add(submitButton, BorderLayout.EAST);
//
//        add(bottom, BorderLayout.SOUTH);
//
//        setVisible(true);
//    }
//
//
//    public static void main(String[] args) {
//        new GUI();
//
//    }
//}
