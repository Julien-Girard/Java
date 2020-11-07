package Vue;

	import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

	import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controler.ClicValiderInfos;

	/**
	 * <b>Infos est la classe repr�sentant une fen�tre graphique permmetant de saisir des informations diverses sur un m�decin</b>
	 * <p>
	 * Une fen�tre FInfos est caract�ris�e par les informations suivantes
	 * <ul>
	 * <li></li>
	 * </ul>
	 * </p>
	 *  
	 * @author hbrouard
	 * @version 1.0
	 */

	public class FInfos extends JFrame  {

		private FVisiteurMedical fvm=null;
		private JTextArea taInfos=null;
		/**
		 * 
		 */
		
		private static final long serialVersionUID = 1L;
		
		public FInfos (FVisiteurMedical fvm) {
			super();
			this.fvm=fvm;
			
			build();
		}
		
		private void build (){
			setTitle("Infos concernant le m�decin"); //On donne un titre � l'application
			setSize(450,300); //On donne une taille � notre fen�tre
			setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
			setResizable(true); //On interdit la redimensionnement de la fen�tre
			setContentPane(buildContentPane());// On construit le Pane

		}

		private JPanel buildContentPane(){
			
			JPanel panel = new JPanel();
			BoxLayout lpanel= new BoxLayout(panel,BoxLayout.Y_AXIS);
			panel.setLayout(lpanel);
			
			JPanel pInfos = new JPanel();
			pInfos.setLayout(new FlowLayout(FlowLayout.LEFT)); // cr�ation du layout et rattachement au panel
			taInfos = new JTextArea(80,40);
			taInfos.setSize(80,40);
			taInfos.setVisible(true);
			taInfos.setText(fvm.getInfos());
			pInfos.add(taInfos);
			panel.add(pInfos);

			JPanel pValider = new JPanel();
			pValider.setLayout(new FlowLayout(FlowLayout.LEFT)); // cr�ation du layout et rattachement au panel
			Toolkit tk = Toolkit.getDefaultToolkit();
			ImageIcon icone = new ImageIcon();
			Image img = tk.getImage("images\\valider2.gif"); 
		    icone.setImage(img);
		    JButton jbValider= new JButton ("Valider");
		    jbValider.setPreferredSize(new Dimension(105,30)); // largeur , hauteur
		    jbValider.setIcon(icone);
			jbValider.addActionListener(new ClicValiderInfos(this));
			pValider.add(jbValider);
			panel.add(pValider);

			return panel;
			
		}
		
			public void majInfos () {
				this.fvm.majInfos(taInfos.getText());
			}
	}


