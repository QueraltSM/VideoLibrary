package videoteca.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase VideotecaGUI que representa la ventana principal de la videoteca
 */
public class VideotecaGUI extends JFrame {
    protected static Videoteca videoteca = new Videoteca("Mi videoteca");
    
    private JPanel p1 = new JPanel();
    private JButton añadir = new JButton("Añadir película");
    private JButton generos = new JButton("Géneros de películas");
    private JPanel p2 = new JPanel();
    
    protected static JTextArea text = new JTextArea(10, 20);
    
    private JPanel aux = new JPanel();
    
    private JRadioButton titulo = new JRadioButton("Por título");
    private JRadioButton year = new JRadioButton("Por año");
    
    private JPanel p3 = new JPanel();
    private ButtonGroup bg = new ButtonGroup();
    private JScrollPane sp = new JScrollPane(text);
    
    protected static String t;
    
    public static String getT() {
        return t;
    }
    

    public VideotecaGUI(String t){
        super(t);
        this.t = t;
        initVideoteca(videoteca);
        
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        bg.add(titulo);
        bg.add(year);
        titulo.setSelected(true);
        text.setText(videoteca.toString());
        
        text.setEditable(false);
        
        aux.setLayout(new GridLayout(1, 2));
        
        p1.setLayout(new GridLayout(2,1));
        JPanel aux2 = new JPanel();
        aux2.setLayout(new GridLayout(2,1));
        JPanel aux3 = new JPanel();
        aux3.setLayout(new GridLayout(2,1));
        aux3.add(añadir);
        aux3.add(generos);
        aux2.add(aux3);
        p1.add(aux2);
        

        titulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                videoteca.setOrder(0);
                text.setText(videoteca.toString());
            }
        });
        
        
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                videoteca.setOrder(1);
                text.setText(videoteca.toString());
            }
        });
        
        
        
                
        generos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new GenresListDlg(new JFrame()).setVisible(true);
            }
        });
        
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new NewFilmDlg(new JFrame()).setVisible(true);
            }
        });
        
        

        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Ordenar:"));
        p3.add(titulo);
        p3.add(year);
    
    
        p2.add(sp, BorderLayout.NORTH);
        p2.add(p3, BorderLayout.SOUTH);
        
    
        
        aux.add(p1);
        aux.add(p2);
        add(aux, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(650,415);
    }






    
// DESCOMENTAR PARA INICIALIZAR LA VIDEOTECA
    /**
     * Inicializa la videoteca con películas de varios géneros
     */ 
    private void initVideoteca(Videoteca videoteca){
        this.videoteca = videoteca;
        videoteca.setOrder(0);
        
        videoteca.add(new Film("Los miserables", "Musical", 2012));
        videoteca.add(new Film("El fantasma de la ópera", "Musical", 2004));
        videoteca.add(new Film("Cantando bajo la lluvia", "Musical", 1952));
        videoteca.add(new Film("Forrest Gump", "Comedia", 1994));
        videoteca.add(new Film("Star Wars: Episodio IV - Una nueva esperanza", "Ciencia ficción", 1977));
        videoteca.add(new Film("Star Wars: Episodio V - El Imperio contraataca", "Ciencia ficción", 1980));
        videoteca.add(new Film("Star Wars: Episodio VI - El regreso del Jedi", "Ciencia ficción", 1983));
        videoteca.add(new Film("Star Wars: Episodio I - La amenaza fantasma", "Ciencia ficción", 1999));
        videoteca.add(new Film("Star Wars: Episodio II - El ataque de los clones", "Ciencia ficción", 2002));
        videoteca.add(new Film("Star Wars: Episodio III - La venganza de los Sith", "Ciencia ficción", 2005));
        videoteca.add(new Film("Star Wars: Episodio VII - El despertar de la Fuerza", "Ciencia ficción", 2015));
        videoteca.add(new Film("Rogue One: Una historia de Star Wars", "Ciencia ficción", 2016));
        videoteca.add(new Film("Lo que el viento se llevó", "Epica", 1939));
        videoteca.add(new Film("Lawrence de Arabia", "Epica", 1962));
        videoteca.add(new Film("La lista de Schindler", "Epica", 1993));
        videoteca.add(new Film("El rey león", "Animación", 1994));
        videoteca.add(new Film("La bella y la bestia", "Animación", 1991));
        videoteca.add(new Film("Buscando a Nemo", "Animación", 2004));
        videoteca.add(new Film("Buscando a Nemo", "Dibujos", 2004));
    }



    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            
        }
        new VideotecaGUI("Mi videoteca");
    }
}
