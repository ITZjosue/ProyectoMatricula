package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class DlgMatricula extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMatricula dialog = new DlgMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMatricula() {
		setBounds(100, 100, 627, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Alumno:");
		lblNewJgoodiesLabel.setBounds(10, 11, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Josue", "Pepe", "Alonso", "Maria", "Lupe"}));
		comboBox.setBounds(72, 7, 131, 22);
		contentPanel.add(comboBox);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Curso: ");
		lblNewJgoodiesLabel_1.setBounds(10, 40, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Fisica II", "Geometria del espacio", "Quimica Organica", "Fisica III", "Materiales"}));
		comboBox_1.setBounds(72, 36, 131, 22);
		contentPanel.add(comboBox_1);
		
		table = new JTable();
		table.setBounds(10, 153, 591, 262);
		contentPanel.add(table);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(512, 7, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(512, 36, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(512, 70, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		String alumnos[] = {"Jose","Pepe","Lucho","Maria"};
	}
}
