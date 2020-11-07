package Vue;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controler.ClicAnnuler;
import Controler.ClicCheckInfos;
import Controler.ClicMenu;
import Controler.ClicValider;
import DAO.MysqlConnectionSingleton2;
import Modele.FocusNom;
import Modele.Medecin;
import Modele.Specialite;


public class FVisiteurMedical extends JFrame {

	/**
	 * <b>VisiteurMediacal est la classe représentant une fenétre graphique permmetant de saisir les informations sur le médecin</b>
	 * <p>
	 * Une fenétre FVisiteurMedical est caractérisée par les informations suivantes
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpMedecin;
	private JPanel jpListe;
	private JTextField jtNom;
	private JTextField jtPrenom;
	private JComboBox<Specialite> jcbSpec;
	private JTextField jtTel;
	private JTextField jtEmail;
	private JTextArea jtaAdresse;
	private JCheckBox jcbInfos;
	private ButtonGroup bgInfos;
	private JTextArea jtaInfos;
	private ArrayList<Medecin> lesMedecins=new ArrayList<Medecin>();
	private JComboBox jlist;

	public FVisiteurMedical(){
		this.setSize(800, 400); // largeur , hauteur
		this.setTitle("Visiteur médicale : Gestion des médecins");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
		buildMedecinPanel();
		
		this.setContentPane(jpMedecin);
		this.setJMenuBar(buildMenuBar());
	}

	private JMenuBar buildMenuBar(){

		JMenuBar menu = new JMenuBar();

		JMenu menuMedecin = new JMenu("Medecins");
		menu.add(menuMedecin);

		JMenuItem miAjouter = new JMenuItem("Ajouter");
		menuMedecin.add(miAjouter);
		miAjouter.addActionListener(new ClicMenu(this));

		JMenuItem miLister = new JMenuItem("Lister");
		menuMedecin.add(miLister);
		miLister.addActionListener(new ClicMenu(this));

		return menu;
	}

	private void buildMedecinPanel(){
		// Panel principal
		// ---------------
		jpMedecin = new JPanel();
		BoxLayout blMedecin= new BoxLayout(jpMedecin,BoxLayout.Y_AXIS);
		jpMedecin.setLayout(blMedecin);

		// ligne 1 : nom du médecin 
		JPanel pl1 = new JPanel();
		pl1.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel jlNom = new JLabel("Nom : ");
		pl1.add(jlNom);
		jtNom = new JTextField();
		jtNom.setColumns(30);
		jtNom.addFocusListener(new FocusNom(this));
		pl1.add(jtNom); 
		jpMedecin.add(pl1);

		// ligne2 : prénom du médecin
		JPanel pl2 = new JPanel();
		pl2.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel jlPrenom= new JLabel("Prénom : ");
		pl2.add(jlPrenom);
		jtPrenom = new JTextField();
		jtPrenom.setColumns(30);
		pl2.add(jtPrenom); // ajout du textField au panel
		jpMedecin.add(pl2);

		//ligne 3 : spécialité
		JPanel pl3 = new JPanel();
		pl3.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel jlSpec = new JLabel("Spécialité : ");
		pl3.add(jlSpec);
		jcbSpec = new JComboBox<Specialite>(); // création d'une combo
		jcbSpec.setPreferredSize(new Dimension(250,20)); // taillage de la combo
		jcbSpec.addItem(new Specialite(1,"Généraliste")); // remplissage de la combo, bof...:-)
		jcbSpec.addItem(new Specialite(2,"Ophtalmologiste"));
		jcbSpec.addItem(new Specialite(3,"Pédiatre"));
		jcbSpec.addItem(new Specialite(4,"Dentiste"));
		pl3.add(jcbSpec);
		jpMedecin.add(pl3);

		// ligne 4 : téléphone
		JPanel pl4 = new JPanel();
		pl4.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel jlTel = new JLabel("Téléphone : ");
		pl4.add(jlTel);
		jtTel = new JTextField();
		jtTel.setColumns(20);
		pl4.add(jtTel); // ajout du textField au panel
		jpMedecin.add(pl4);

		//ligne 5 : email
		JPanel pl5 = new JPanel();
		pl5.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel lEmail = new JLabel("Email : ");
		pl5.add(lEmail);
		jtEmail = new JTextField();
		jtEmail.setColumns(35);
		pl5.add(jtEmail); 
		jpMedecin.add(pl5);

		// ligne 6 : adresse avec textArea
		JPanel pl6 = new JPanel();		
		pl6.setLayout(new FlowLayout(FlowLayout.LEFT)); // création du layout et rattachement au panel
		JLabel lAdresse = new JLabel("Adresse : ");
		pl6.add(lAdresse);
		jtaAdresse = new JTextArea(8,20);
		jtaAdresse.setSize(100,50);
		jtaAdresse.setVisible(true);
		Border blackline = BorderFactory.createLineBorder(Color.GRAY);
		jtaAdresse.setBorder(blackline);
		jtaAdresse.setToolTipText("Saisissez l'adresse complétes (avec ville et code postal) du médecin");
		pl6.add(jtaAdresse);
		pl6.add(Box.createHorizontalStrut(50));

		bgInfos = new ButtonGroup();
		jcbInfos = new JCheckBox("Informations complémentaires",false);
		jcbInfos.setHorizontalTextPosition(SwingConstants.LEFT);
		jcbInfos.addActionListener(new ClicCheckInfos(this, jcbInfos));
		bgInfos.add(jcbInfos);
		pl6.add(jcbInfos);

		jtaInfos = new JTextArea(5,10);
		jtaInfos.setSize(100,50);
		jtaInfos.setBackground(jpMedecin.getBackground());
		jtaInfos.setVisible(true);
		pl6.add(jtaInfos);

		jpMedecin.add(pl6);

		// ligne 7 : boutons annuler et valider
		JPanel pl7 = new JPanel();		
		pl7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//bouton annuler + image
		Toolkit tk = Toolkit.getDefaultToolkit();
		ImageIcon icone = new ImageIcon();
		Image img = tk.getImage("images\\annulation2.gif"); 
		icone.setImage(img);
		JButton jbAnnuler= new JButton ("Annuler");
		jbAnnuler.setPreferredSize(new Dimension(105,30)); // largeur , hauteur
		jbAnnuler.setIcon(icone);
		jbAnnuler.addActionListener(new ClicAnnuler(this));

		pl7.add(jbAnnuler);	

		//bouton valider + image
		tk = Toolkit.getDefaultToolkit();
		icone = new ImageIcon();
		img = tk.getImage("images\\valider2.gif"); 
		icone.setImage(img);
		JButton jbValider = new JButton ("Valider");
		jbValider.setPreferredSize(new Dimension(105,30)); // largeur , hauteur
		jbValider.setIcon(icone);
		jbValider.addActionListener(new ClicValider(this));
		pl7.add(jbValider);	 
		jpMedecin.add(pl7);


	}

	private void buildListeMedecinPanel(){
		jpListe= new JPanel();				
		jpListe.setLayout(new BoxLayout(jpListe,BoxLayout.Y_AXIS));
		// Création du panel "ligne 1"
		JPanel jpL1 =new JPanel();
		jpL1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpListe.add(Box.createVerticalStrut(10));
		JLabel jl1 = new JLabel ("Liste des médecins");
		jpL1.add(jl1);
		jpListe.add(jpL1);		

	}

	public void afficheMedecinPannel() {
		if (jpMedecin==null) {
			this.buildMedecinPanel();
		}
		this.setContentPane(jpMedecin);
		this.validate();
	}

	public void afficheListePannel() {
		if (jpListe==null) {
			this.buildListeMedecinPanel();
		}
		this.setContentPane(jpListe);
		this.validate();
	}

	// é compléter si besoin
	public Medecin validerMedecin() {
		// ajout du médecin dans la liste des médecins
		// -------------------------------------------
		String requete = "SELECT id FROM Medecin order by id asc;";
		Connection con = MysqlConnectionSingleton2.getInstance();
		int lastId = 0;
		try {
			Statement stLienBd = con.createStatement();
			ResultSet resultat = stLienBd.executeQuery(requete);
			while(resultat.next()) {
				lastId = resultat.getInt(1);
				System.out.println(lastId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Medecin med = new Medecin(lastId+1, jtNom.getText(),jtPrenom.getText(), jtaAdresse.getText(), jtTel.getText(), jtEmail.getText(),(Specialite) jcbSpec.getSelectedItem());
		lesMedecins.add(med);


		// ajout du médecin  sur le panneau qui liste toutes les médecin
		// --------------------------------------------------------------
		if (jpListe==null) {
			this.buildListeMedecinPanel();
		}
		JPanel jpLx =new JPanel();
		jpLx.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpListe.add(jpLx);		
		JLabel jl1 = new JLabel ();
		jpLx.add(jl1);
		jpLx =new JPanel();
		//jpLx.setBackground(Color.RED);
		jpLx.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpListe.add(jpLx);		
		jl1 = new JLabel (med.getNom()+" "+ med.getPrenom()+ " - " + med.getSpecialite());
		jpLx.add(jl1);

		this.effacer();
		JOptionPane.showMessageDialog(null, "Médecin enregistré", "Information", JOptionPane.INFORMATION_MESSAGE);
		this.validate();
		return med;
	}

	public void majInfos(String text) {
		this.jtaInfos.setText(text);
		// on enlève la coche de la check box
		bgInfos.clearSelection();
		this.validate();
	}

	public void supprimeInfos() {
		this.jtaInfos.setText("");
		this.validate();
	}

	public void upperCaseNom() {
		String nom;
		nom=this.jtNom.getText();
		this.jtNom.setText(nom.toUpperCase());
		this.validate();
	}

	public void annuler() {
		this.effacer();
	}

	public void effacer() {
		this.jtaInfos.setText("");
		this.jtaAdresse.setText("");
		this.jtaInfos.setText("");
		this.jtEmail.setText("");
		this.jtNom.setText("");
		this.jtPrenom.setText("");
		this.jtTel.setText("");
		// on enlève la coche de la check box
		bgInfos.clearSelection();
	}

	public String getInfos() {
		return jtaInfos.getText();
	}
}
