package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import arreglos.ListaAlumnos;

import javax.swing.JList;
import javax.swing.JOptionPane;
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
import javax.swing.border.LineBorder;//ss
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgMatricula extends JDialog {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\the_m\\Desktop\\icons\\operando.png"));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("REGISTRO\r\n");
		setType(Type.POPUP);
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 888, 678);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 873, 639);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 50, 819, 203);
		panel_1.add(panel_2);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(new Color(202, 211, 217));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JLabel lblCorreoElectrnico = new JLabel("Hora:");
		lblCorreoElectrnico.setFont(new Font("Arial", Font.BOLD, 12));
		lblCorreoElectrnico.setBounds(407, 75, 142, 14);
		panel.add(lblCorreoElectrnico);
		
		JLabel lblNombre_4 = new JLabel("Fecha:");
		lblNombre_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre_4.setBounds(10, 115, 129, 14);
		panel.add(lblNombre_4);
		
		JLabel lblNombre_5 = new JLabel("Código de Curso:");
		lblNombre_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre_5.setBounds(407, 38, 142, 14);
		panel.add(lblNombre_5);
		
		JLabel lblNombre_4_1 = new JLabel("Estado:");
		lblNombre_4_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre_4_1.setBounds(407, 115, 129, 14);
		panel.add(lblNombre_4_1);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setEditable(false);
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
		btnNuevo.setBorder(UIManager.getBorder("Button.border"));
		btnNuevo.setBounds(28, 596, 89, 32);
		panel_1.add(btnNuevo);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBorder(UIManager.getBorder("Button.border"));
		btnAceptar.setBounds(28, 264, 89, 32);
		panel_1.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBorder(UIManager.getBorder("Button.border"));
		btnCancelar.setBounds(172, 263, 89, 32);
		panel_1.add(btnCancelar);
		btnAdicionar.setBounds(172, 596, 89, 32);
		panel_1.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(325, 596, 89, 32);
		panel_1.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(471, 596, 89, 32);
		panel_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(620, 596, 89, 32);
		panel_1.add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(754, 596, 89, 32);
		panel_1.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 307, 815, 261);
		panel_1.add(scrollPane);
		
		tbRegistro = new JTable();
		scrollPane.setViewportView(tbRegistro);
		tbRegistro.setFillsViewportHeight(true);
		
		JLabel lblNewLabel = new JLabel("Registro de Alumno");
		lblNewLabel.setBounds(0, 0, 873, 639);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(202, 211, 217));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(tbRegistro);
		
		model = new DefaultTableModel();
		model.addColumn("CODIGO");
		model.addColumn("CODIGO");
		model.addColumn("CODIGO");
		model.addColumn("CODIGO");
		
		
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	int confirmDlg(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}
	
	
}

