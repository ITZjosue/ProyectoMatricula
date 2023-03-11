package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class dlgRetiro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgRetiro dialog = new dlgRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgRetiro() {
		setBounds(100, 100, 679, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alumno:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 201, 643, 241);
		contentPanel.add(table);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(564, 7, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(564, 41, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(564, 75, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pepe", "Juan", "Marco", "Liliana", "Margaret", "Lupe"}));
		comboBox.setBounds(66, 7, 89, 22);
		contentPanel.add(comboBox);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Curso");
		lblNewJgoodiesLabel.setBounds(10, 45, 46, 14);
		contentPanel.add(lblNewJgoodiesLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Anatomia", "Redes", "Quimica", "Matematica", "Fisica", "Historia"}));
		comboBox_1.setBounds(66, 41, 89, 22);
		contentPanel.add(comboBox_1);
	}
}
