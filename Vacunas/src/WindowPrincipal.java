import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;


public class WindowPrincipal{
    
    private JFrame frmPrincipal; 
    private JPanel panelPrincipal;
	private JLabel lblNombreHospital;
	private JComboBox cbNombreHospital;

	public static ArrayList<Hospital> listaHospitales;
	
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPrincipal window = new WindowPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowPrincipal() {
        frmPrincipal = new JFrame();
		frmPrincipal.setSize(1000, 700);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Vacunas");
		frmPrincipal.setForeground(Color.black);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		primerPanel();
	}

    public void primerPanel(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(403, 380, 80, 30);
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

        lblNombreHospital = new JLabel("Hospital");
        panelPrincipal.add(lblNombreHospital);
        lblNombreHospital.setForeground(Color.white);
        lblNombreHospital.setBounds(100, 200, 100, 50);
        lblNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 20));

		cbNombreHospital = new JComboBox<String>();
        if(listaHospitales.size() < 1){
            JOptionPane.showMessageDialog(frmPrincipal, "No hay hospitales disponibles.");
        } else{
			for(int i =0 ; i < listaHospitales.size(); i++){
				cbNombreHospital.add(listaHospitales.get(i).getNombre());
			}
		}
    }

	static void crearHospitales(){
		Hospital h1 = new Hospital("Cruz roja", 500, 50, "Monterrey", 0, 20);
		listaHospitales.add(h1);
	}

	
}

