import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Search implements ActionListener {
    JFrame frame=new JFrame();
    JTextField textField=new JTextField();
    JTextField textField1=new JTextField();
    JTextField textField2=new JTextField();
    JTextField textField4=new JTextField();
    JButton button=new JButton("Search");
    JLabel label =new JLabel();
    JLabel label1=new JLabel();
    JLabel label2 =new JLabel();
    JLabel label3 =new JLabel();

    Search(){
        frame.setSize(700,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField.setBackground(Color.lightGray);
        textField.setBounds(150,150,400,50);
        frame.add(textField);
        label.setText("URI:");
        label.setBounds(120,150,30,30);
        frame.add(label);
        label.setForeground(Color.BLACK);


        textField1.setBackground(Color.lightGray);
        textField1.setBounds(150,250,400,50);
        frame.add(textField1);

        label1.setText("API key:");
        label1.setForeground(Color.BLACK);
        label1.setBounds(100,250,60,30);
          frame.add(label1);

        textField2.setBackground(Color.lightGray);
        textField2.setBounds(150,350,400,50);
        frame.add(textField2);
        label2.setText("Host:");
        label2.setForeground(Color.BLACK);
        label2.setBounds(120,350,30,30);
        frame.add(label2);


        textField4.setBackground(Color.lightGray);
        textField4.setBounds(150,450,400,50);
        frame.add(textField4);

        label3.setText("Method:");
        label3.setForeground(Color.BLACK);
        label3.setBounds(100,450,60,20);
        frame.add(label3);

        button.setBackground(Color.RED);
        button.setBounds(150,550,100,50);
        button.addActionListener(this);
        button.setFocusable(false);
        frame.add(button);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String d=textField.getText();
        String a=textField1.getText();
        String w=textField2.getText();
        String o=textField4.getText();
        if (e.getSource()==button){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(d))
                    .header("X-RapidAPI-Key", a)
                    .header("X-RapidAPI-Host", w)
                    .method(o, HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = null;
            try {
                response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException t) {
                throw new RuntimeException(t);
            }
            String v=response.body();
          JTextField field =new JTextField(v);
          field.setBounds(150,600,400,50);
          field.setBackground(Color.gray);
          frame.add(field);

        }


    }
}
