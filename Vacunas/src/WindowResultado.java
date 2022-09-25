import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;




public class WindowResultado extends JFrame{

    private static JFrame frmPrincipal; 
    private static JPanel panelPrincipal;
    private static JPanel panelMapa;
    private static JLabel lblTitulo, lblSolicitarA, lblMapa;
    private static JTextArea txtDonadores, txtDonadoresHeading;
    private static ImageIcon mapa;
    private static JButton btnClose, btnSolicitar;



     WindowResultado(ArrayList<Hospital> donadores, Hospital solicitante){
        this.setBounds(0,0,650,700);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Donadores");
        this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);

        // frmPrincipal = new JFrame();
		// frmPrincipal.setSize(600, 500);
		// frmPrincipal.setResizable(false);
		// frmPrincipal.setTitle("Resultado");
		// frmPrincipal.setForeground(Color.blue);
		// frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 650, 700);
		panelPrincipal.setBackground(Color.white);
        panelPrincipal.setLayout(null);
        panelPrincipal.setVisible(true);
		this.add(panelPrincipal);

        lblTitulo = new JLabel("Donadores:");
        lblTitulo.setBounds(100, 40, 200, 50);
        //lblTitulo.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblTitulo.setFont(new Font("Sans-serif", Font.BOLD, 30));
        lblTitulo.setForeground(new Color(0x333333));
        panelPrincipal.add(lblTitulo);


        lblSolicitarA = new JLabel("Solicitar a: ");
        panelPrincipal.add(lblTitulo);
        lblSolicitarA.setBounds(100, 100, 80, 50);

        txtDonadoresHeading = new JTextArea("Hospital\t\tVacunas \t Distancia");
        txtDonadoresHeading.setBounds(100, 110, 450, 25);
        txtDonadoresHeading.setFont(new Font("Arial", Font.BOLD, 15));
        txtDonadoresHeading.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        txtDonadoresHeading.setEditable(false);
        //txtDonadoresHeading.setBackground(new Color(0xBABABA));
        panelPrincipal.add(txtDonadoresHeading);

        txtDonadores = new JTextArea("");
        txtDonadores.setBounds(100, 135, 450, 90);
        txtDonadores.setFont(new Font("Arial", Font.PLAIN, 15));
        txtDonadores.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        txtDonadores.setEditable(false);
        
        btnClose = new JButton("Atras");
        btnClose.setBounds(515, 630, 120, 25);
		btnClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowResultado.this.dispose();
            }
		});
		btnClose.setActionCommand("newProduct");
		panelPrincipal.add(btnClose);

       

        btnSolicitar = new JButton("Solicitar");
        btnSolicitar.setBounds(515, 600, 120, 25);
		btnSolicitar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(WindowResultado.this, "Productos solicitados correctamente.");
                WindowResultado.this.dispose();
            }
		});
		btnSolicitar.setActionCommand("newProduct");
		panelPrincipal.add(btnSolicitar);
       

        String txt = "";
        for(int i = 0; i < donadores.size(); i++){
            txt += donadores.get(i).getNombre() + "  \t\t  ";
            //System.out.println("donadores " + donadores.get(i).getNombre() + " "+donadores.get(i).getX());
            //System.out.println(solicitante.getNombre() + " s " + solicitante.getX());

            double distancia = Hospital.getDistancia(solicitante, donadores.get(i));

            distancia = Math.round(distancia*100.0)/100.0;
            //System.out.println(Double.toString(distancia));
            txt += "   " + (Integer.toString(donadores.get(i).getDonacion())+ "\t  ");
            txt += "     " + (Double.toString(distancia) + "\n");


        }
        txtDonadores.setText(txt);
        panelPrincipal.add(txtDonadores);
    
        panelMapa = new JPanel();
        panelMapa.setBounds(100, 240, 300, 400);
		panelMapa.setBackground(Color.red);
        panelMapa.setLayout(null);
		panelPrincipal.add(panelMapa);

         //mapa = new ImageIcon(getClass.class.getResource("Vacunas/src/mapa.png"));
        // BufferedImage myPicture = ImageIO.read(new File("mapa.png"));
         //JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        // add(picLabel);

		lblMapa = new JLabel("cooo");
		lblMapa.setBounds(0, 0, 300,400);
        Image mapa = new ImageIcon(this.getClass().getResource("/mapa.png")).getImage();
		//lblMapa.setIcon(mapa);

        lblMapa.setIcon(new ImageIcon(mapa.getScaledInstance(300, 400,  java.awt.Image.SCALE_SMOOTH)));
        lblMapa.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblMapa.setBackground(Color.CYAN);
		panelMapa.add(lblMapa, 0);

        for (int i = 0; i < WindowPrincipal.listaHospitales.size(); i++){
        JPanel punto = new JPanel();
        punto.setBackground(Color.red);
        punto.setLayout(null);
        punto.setBounds(100 + (int)WindowPrincipal.listaHospitales.get(i).getX(),250 + (int)WindowPrincipal.listaHospitales.get(i).getY(),6,6);
        panelPrincipal.add(punto, 1);

        }
        

        for (int i= 0; i < donadores.size(); i++){
        JPanel punto = new JPanel();
        punto.setBackground(Color.blue);
        punto.setLayout(null);
        punto.setBounds(100 + (int)donadores.get(i).getX(),250+(int)donadores.get(i).getY(),6,6);
        
        panelPrincipal.add(punto, 2);

        JLabel nombre = new JLabel(donadores.get(i).getNombre());
        nombre.setForeground(Color.blue);
        nombre.setLayout(null);
        nombre.setBounds(110 + (int)donadores.get(i).getX(),250+(int)donadores.get(i).getY(),100,40);
        
        panelPrincipal.add(nombre, 2);

        }

        JPanel punto = new JPanel();
        punto.setBackground(Color.green);
        punto.setLayout(null);
        punto.setBounds(100 + (int)solicitante.getX(), 250 + (int)solicitante.getY(),6,6);
        
        panelPrincipal.add(punto, 3);

        JLabel nombre = new JLabel(solicitante.getNombre());
        nombre.setForeground(Color.green);
        nombre.setLayout(null);
        nombre.setBounds(120 + (int)solicitante.getX(),250+(int)solicitante.getY(),100,40);
        
        panelPrincipal.add(nombre, 3);

     }

     
    
}
