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
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class DlgRetiro extends JDialog {
	private JTextField txtNumMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtFecha;
	private JTextField txtCodCurso;
	private JTextField txtHora;
	private JTable tbRegistro;
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRetiro dialog = new DlgRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRetiro() {
		setBounds(100, 100, 888, 601);
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(new Color(202, 211, 217));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(26, 39, 819, 203);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 25, 778, 159);
		panel_2.add(panel);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(202, 211, 217));
		panel.setLayout(null);
		
		JLabel lblNumMatricula = new JLabel("Número de Matrícula:");
		lblNumMatricula.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumMatricula.setBounds(10, 38, 142, 14);
		panel.add(lblNumMatricula);
		
		JLabel lblCodAlumno = new JLabel("Código de Alumno:");
		lblCodAlumno.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodAlumno.setBounds(10, 75, 129, 14);
		panel.add(lblCodAlumno);
		
		JLabel lblhora = new JLabel("Hora:");
		lblhora.setFont(new Font("Arial", Font.BOLD, 12));
		lblhora.setBounds(407, 75, 142, 14);
		panel.add(lblhora);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 12));
		lblFecha.setBounds(10, 115, 129, 14);
		panel.add(lblFecha);
		
		JLabel lblCodCurso = new JLabel("Código de Curso:");
		lblCodCurso.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodCurso.setBounds(407, 38, 142, 14);
		panel.add(lblCodCurso);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.BOLD, 12));
		lblEstado.setBounds(407, 115, 129, 14);
		panel.add(lblEstado);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setBounds(162, 35, 211, 20);
		panel.add(txtNumMatricula);
		txtNumMatricula.setColumns(10);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setBounds(162, 72, 211, 20);
		panel.add(txtCodAlumno);
		txtCodAlumno.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(162, 112, 211, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(541, 35, 227, 20);
		panel.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(541, 72, 227, 20);
		panel.add(txtHora);
		txtHora.setColumns(10);
		
		JComboBox cboEstado = new JComboBox();
		cboEstado.setToolTipText("");
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setSelectedIndex(1);
		cboEstado.setBounds(541, 111, 129, 22);
		panel.add(cboEstado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 873, 562);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBorder(UIManager.getBorder("Button.border"));
		btnNuevo.setBounds(28, 505, 89, 32);
		panel_1.add(btnNuevo);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(176, 505, 89, 32);
		panel_1.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(327, 505, 89, 32);
		panel_1.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(474, 505, 89, 32);
		panel_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(624, 505, 89, 32);
		panel_1.add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(754, 505, 89, 32);
		panel_1.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 256, 815, 224);
		panel_1.add(scrollPane);
		
		tbRegistro = new JTable();
		scrollPane.setViewportView(tbRegistro);
		tbRegistro.setFillsViewportHeight(true);
		
		JLabel lblNewLabel = new JLabel("Retiro de Alumno");
		lblNewLabel.setBounds(0, 0, 873, 562);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(202, 211, 217));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		String alumnos[] = {"Jose","Pepe","Lucho","Maria"};
		
		//Definir columnas
		
		model.addColumn("NumMat");
		model.addColumn("CodCur");
		model.addColumn("CodAlu");
		model.addColumn("Hora");
		model.addColumn("Fecha");
		model.addColumn("Estado");
		tbRegistro.setModel(model);
	}
}
