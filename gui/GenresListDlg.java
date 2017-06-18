package videoteca.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GenresListDlg extends JDialog {
    private Videoteca videoteca = VideotecaGUI.videoteca;
    private JTextArea text = new JTextArea(20, 20);
    private JPanel panel = new JPanel();
    private JButton okBtn;
    
    public GenresListDlg(Frame f) {
        super(f, "Todos los géneros");
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(f);
        setSize(300, 300);
        
        String result = "";
        for (String s : videoteca.getGenres()) {
            result += s + "\n";
        }
        text.setText(result);

        okBtn = new JButton("Ok");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new VideotecaGUI(VideotecaGUI.getT()).setVisible(true);
            }
        });
        
        add(panel);
        panel.setLayout(new GridLayout(2,1));
        panel.add(text);
        JPanel paux = new JPanel();
        paux.setLayout(new GridLayout(2,1));
        paux.add(okBtn);
        panel.add(paux);

        
    }
    
    
    
}