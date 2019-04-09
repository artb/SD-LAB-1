package socket.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ClientInterface extends JFrame{

    public ClientInterface() {
        Container panel = getContentPane();
        JLabel q0_label = new JLabel("Valor do Investimento: ");
        final JTextField Q0 = new JTextField(5);
        JLabel qf_label = new JLabel("Patrimonio desejado: ");
        final JTextField QF = new JTextField(5);
        JLabel t_label = new JLabel("Tempo: ");
        final JTextField t = new JTextField(5);

        JButton ok = new JButton("Calcular");
        final JTextArea area = new JTextArea(30, 30);

        panel.setLayout(new FlowLayout());
        panel.add(q0_label);
        panel.add(Q0);
        panel.add(qf_label);
        panel.add(QF);
        panel.add(t);
        panel.add(t_label);
        panel.add(ok);
        panel.add(area);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = Q0.getText();
                    String s2 = QF.getText();
                    String s3 = t.getText();

                    double taxas = new ClientSocket().taxas(Double.parseDouble(s1), Double.parseDouble(s2), Integer.parseInt(s3));
                    System.out.println(taxas);
                    String texto = "Taxas Calculadas: " + taxas;
                    area.setText(texto);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {

        ClientInterface frame  = new ClientInterface();
        Container content = frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        // Display the window.
        frame.setLocation(500,500);
        frame.pack();
        frame.setVisible(true);
        frame.toFront();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
