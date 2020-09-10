//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//import java.util.Date;
//
//public class ClientChat extends JFrame {
//    JPanel writePanel = new JPanel();
//    JLabel label = new JLabel("Ниже будут отображаться сообщения");
//    JTextArea textForView = new JTextArea();
//    JTextField textForSend = new JTextField();
//    JButton buttonSend = new JButton("Отправить");
//    StringBuilder s = new StringBuilder();
//
//    private Client client;
//
//    public ClientChat() {
//
//        client = new Client(textForView);
//
//        setTitle("Chat by ASIris");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(new Rectangle(0,0,500,700));
//        setLocationRelativeTo(null);
//
//        JPanel panelLabel = new JPanel();
//        add(panelLabel, BorderLayout.NORTH);
//        panelLabel.setLayout(new GridBagLayout());
//        panelLabel.add(label);
//
//
//        add(textForView, BorderLayout.CENTER);
//        textForView.setEditable(false);
//        textForView.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
//        textForView.setBackground(new Color(215,215,215));
//        textForView.setLineWrap(true);
//        textForView.setWrapStyleWord(true);
//
//
//        add(new JScrollPane(textForView));
//
//
//        add(writePanel, BorderLayout.SOUTH);
//        writePanel.setLayout(new BoxLayout(writePanel,BoxLayout.X_AXIS));
//        writePanel.add(textForSend);
//        textForSend.addActionListener(e -> sendMessage());
//        writePanel.add(buttonSend);
//        buttonSend.addActionListener(e -> sendMessage());
//
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new ClientChat();
//    }
//
//    private void sendMessage() {
//        Date date = new Date();
//                s.append("client: ").append(date).append("\n").append(textForSend.getText()).append("\n");
//                textForView.setText(s.toString());
//
//        String messageChat = textForSend.getText();
//        if (!messageChat.trim().isBlank()) {
//            try {
//                client.getOut().writeUTF(messageChat);
//                textForSend.setText("");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
