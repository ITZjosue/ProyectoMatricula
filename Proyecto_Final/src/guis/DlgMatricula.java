package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import libreria.*;

import entidades.*;

import arreglos.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import arreglos.ArregloAlumno;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgMatricula extends JDialog implements ActionListener, MouseListener {
	private JScrollPane scrollPane;
	private JTextField txtNumMatricula;
	private JTextField txtCodCurso;
	private JTextField txtHora;
	private JTable tbRegistro;
	private JComboBox <String> cboAlumnoNoMatriculado;
	private JComboBox <String> cboCursoDispo;
	
	
	DefaultTableModel model = new DefaultTableModel();
	ArregloMatricula am = new ArregloMatricula();

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
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 50, 819, 201);
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
		lblCodAlumno.setBounds(406, 38, 129, 14);
		panel.add(lblCodAlumno);
		
		JLabel lblAlumnosSinMatricula = new JLabel("Alumnos no Matriculados:");
		lblAlumnosSinMatricula.setFont(new Font("Arial", Font.BOLD, 12));
		lblAlumnosSinMatricula.setBounds(10, 115, 147, 14);
		panel.add(lblAlumnosSinMatricula);
		
		JLabel lblCursosMatriculados = new JLabel("Cursos Matriculados:");
		lblCursosMatriculados.setFont(new Font("Arial", Font.BOLD, 12));
		lblCursosMatriculados.setBounds(10, 75, 129, 14);
		panel.add(lblCursosMatriculados);
		
		JLabel lblCurso = new JLabel("Código de Curso:");
		lblCurso.setFont(new Font("Arial", Font.BOLD, 12));
		lblCurso.setBounds(406, 75, 142, 14);
		panel.add(lblCurso);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setEditable(false);
		txtNumMatricula.setBounds(162, 35, 211, 20);
		panel.add(txtNumMatricula);
		txtNumMatricula.setColumns(10);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(541, 35, 227, 20);
		panel.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(541, 72, 227, 20);
		panel.add(txtHora);
		txtHora.setColumns(10);
		
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarMatricula();
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
		btnCancelar.setBounds(176, 264, 89, 32);
		panel_1.add(btnCancelar);
		btnMatricular.setBounds(331, 262, 89, 32);
		panel_1.add(btnMatricular);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(476, 262, 89, 32);
		panel_1.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(622, 262, 89, 32);
		panel_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(758, 262, 89, 32);
		panel_1.add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(754, 596, 89, 32);
		panel_1.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 307, 815, 261);
		panel_1.add(scrollPane);
		
		tbRegistro = new JTable();
		tbRegistro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(tbRegistro);
		tbRegistro.setFillsViewportHeight(true);
		
		JLabel lblNewLabel = new JLabel("Registro de Matrícula");
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
		model.addColumn("NUM_MATRICULA");
		model.addColumn("COD_ALUMNO");
		model.addColumn("COD_CURSO");
		model.addColumn("FECHA MATRICULA");
		model.addColumn("HORA MATRICULA");
		
		tbRegistro.setModel(model);
		txtHora.setEditable(false);

		if (am.tamanio() == 0)
			visibleInvisible(false);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		
		JLabel lblCursosDisponibles = new JLabel("Cursos Disponibles:");
		lblCursosDisponibles.setFont(new Font("Arial", Font.BOLD, 12));
		lblCursosDisponibles.setBounds(406, 115, 129, 14);
		panel.add(lblCursosDisponibles);
		
		cboCursoDispo = new JComboBox <String> ();
		cboCursoDispo.setBounds(541, 111, 227, 22);
		panel.add(cboCursoDispo);
		
		
		JComboBox cboCursosMatri = new JComboBox();
		cboCursosMatri.setBounds(162, 71, 211, 22);
		panel.add(cboCursosMatri);
		
		cboAlumnoNoMatriculado = new JComboBox <String> ();
		cboAlumnoNoMatriculado.addActionListener(this);
		cboAlumnoNoMatriculado.addMouseListener(this);
		cboAlumnoNoMatriculado.setBounds(162, 111, 211, 22);
		panel.add(cboAlumnoNoMatriculado);
		insertarData();

	}
	
	//
	public void insertarData(){
		for (int i = 0; i <ArregloAlumno.getListaAlumnosLen(); i++) {
			if(ArregloAlumno.getAlumno(i).getEstado()==0);
			cboAlumnoNoMatriculado.addItem("" + ArregloAlumno.getAlumno(i).getCodAlumno());
		}
		for (int i = 0; i <ArregloCurso.getCantidadCursos(); i++) {
			cboCursoDispo.addItem("" + ArregloCurso.getCurso(i).getCodCurso());
		}
		
	}
	public void generarMatricula() {
		int codAlumno = Integer.parseInt(cboAlumnoNoMatriculado.getSelectedItem().toString());

		int codCurso = Integer.parseInt(cboCursoDispo.getSelectedItem().toString());
		Matricula newMatricula = new Matricula();
	}

//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	int confirmar(String s1, String s2) {
		return JOptionPane.showConfirmDialog(this, s1, s2, 0, 1, null);
	}
	String confirmarIngreso(String s) {
		return JOptionPane.showInputDialog(this, "", s, 3);
	}
	String ajustar(int numero) {
		return String.format("%02d", numero);
	}

	private int leerNumeroMatricula() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void editarFila() {
		// TODO Auto-generated method stub
		
	}

	private void listar() {
		// TODO Auto-generated method stub
		
	}

	private void ajustarAnchoColumnas() {
		// TODO Auto-generated method stub
		
	}

	private void visibleInvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	int confirmDlg(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

