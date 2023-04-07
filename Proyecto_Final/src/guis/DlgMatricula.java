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
import java.time.LocalDateTime;
import java.awt.event.MouseEvent;

public class DlgMatricula extends JDialog implements ActionListener, MouseListener {
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox <String> cboAlumnoNoMatriculado;
	private JComboBox <String> cboCursoDispo;
	DefaultTableModel model = new DefaultTableModel();
	private Matricula modMatricula;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\User\\\\git\\\\repository\\\\Proyecto_Final\\\\img\\\\icons\\\\operando.png"));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("REGISTRO\r\n");
		setType(Type.POPUP);
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 991, 678);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 975, 639);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 50, 928, 164);
		panel_1.add(panel_2);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(new Color(202, 211, 217));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 25, 886, 115);
		panel_2.add(panel);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(202, 211, 217));
		panel.setLayout(null);
		
		JLabel lblAlumnosSinMatricula = new JLabel("Alumno");
		lblAlumnosSinMatricula.setFont(new Font("Arial", Font.BOLD, 12));
		lblAlumnosSinMatricula.setBounds(10, 54, 147, 14);
		panel.add(lblAlumnosSinMatricula);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBorder(UIManager.getBorder("Button.border"));
		btnAceptar.setBounds(28, 264, 111, 32);
		panel_1.add(btnAceptar);
		
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.setBounds(732, 264, 111, 32);
		panel_1.add(btnMatricular);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBorder(UIManager.getBorder("Button.border"));
		btnCancelar.setBounds(189, 264, 111, 32);
		panel_1.add(btnCancelar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(362, 264, 111, 32);
		panel_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(540, 264, 111, 32);
		panel_1.add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(863, 596, 89, 32);
		panel_1.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 307, 924, 261);
		panel_1.add(scrollPane);
		
		table = new JTable(model){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		model.addColumn("NUM_MATRICULA");
		model.addColumn("COD_ALUMNO");
		model.addColumn("NOMBRE ALUMNO");
		model.addColumn("COD_CURSO");
		model.addColumn("FECHA MATRICULA");
		model.addColumn("HORA MATRICULA");
		model.addColumn("ESTADO_MATRICULA");

		JLabel lblNewLabel = new JLabel("Registro de Matrícula");
		lblNewLabel.setBounds(0, 0, 974, 639);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(202, 211, 217));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(table);
		

		
		JLabel lblCursosDisponibles = new JLabel("Curso");
		lblCursosDisponibles.setFont(new Font("Arial", Font.BOLD, 12));
		lblCursosDisponibles.setBounds(373, 54, 71, 14);
		panel.add(lblCursosDisponibles);
		
		cboCursoDispo = new JComboBox <String> ();
		cboCursoDispo.setBounds(500, 50, 227, 22);
		panel.add(cboCursoDispo);
		
		cboAlumnoNoMatriculado = new JComboBox <String> ();
		cboAlumnoNoMatriculado.addActionListener(this);
		cboAlumnoNoMatriculado.addMouseListener(this);
		cboAlumnoNoMatriculado.setBounds(104, 50, 211, 22);
		panel.add(cboAlumnoNoMatriculado);
		
		
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarMatricula();
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					mensaje("Necesita escojer una matricula");
				}else {
					btnMatricular.setEnabled(false);
					btnEliminar.setEnabled(false);
					btnAceptar.setEnabled(true);
					btnCancelar.setEnabled(true);
					modMatricula = ArregloMatricula.getMatriculaById(Integer.parseInt(table.getValueAt(row, 0).toString()));
					cboAlumnoNoMatriculado.removeAllItems();
					cboAlumnoNoMatriculado.addItem(table.getValueAt(row, 1).toString());
					cboAlumnoNoMatriculado.setEnabled(false);
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modMatricula.setCodCurso(Integer.parseInt(cboCursoDispo.getSelectedItem().toString()));
				listar();
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnMatricular.setEnabled(true);
				btnEliminar.setEnabled(true);
				cboAlumnoNoMatriculado.setEnabled(true);
				insertarData();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnMatricular.setEnabled(true);
				btnEliminar.setEnabled(true);
				cboAlumnoNoMatriculado.setEnabled(true);
				insertarData();			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					mensaje("Necesita escoger una matricula");
				}else {
					int opt = confirmar("Seguro que desea eliminar la matricula ?");
					Alumno a = ArregloAlumno.getAlumnoByCode(Integer.parseInt(table.getValueAt(row,1).toString()));
					if(a.getEstado() != 2 &&  opt == 0) {
						ArregloMatricula.deleteMatriculaByCode(Integer.parseInt(table.getValueAt(row,0).toString()));
						a.setEstado(0);
						insertarData();
						listar();						
					}else if(opt == 0 && a.getEstado() == 2){
						mensaje("No se puede eliminar esta matrícula porque le pertenece a un alumno retirado");
					}
				}
			}
		});
		
		if(ArregloMatricula.tamanio() > 0) {
			listar();			
		}
		insertarData();

	}
	
	//
	public void insertarData(){
		cboCursoDispo.removeAllItems();
		cboAlumnoNoMatriculado.removeAllItems();
		for (int i = 0; i <ArregloAlumno.getListaAlumnosLen(); i++) {
			if(ArregloAlumno.getAlumno(i).getEstado()==0) {
				cboAlumnoNoMatriculado.addItem(""+ArregloAlumno.getAlumno(i).getCodAlumno());
			};
		}
		for (int i = 0; i <ArregloCurso.getCantidadCursos(); i++) {
			cboCursoDispo.addItem(""+ArregloCurso.getCurso(i).getCodCurso());
		}
		
	}
	public void generarMatricula() {
		int codAlumno = Integer.parseInt(cboAlumnoNoMatriculado.getSelectedItem().toString());
		int codCurso = Integer.parseInt(cboCursoDispo.getSelectedItem().toString());
		Matricula newMatricula = new Matricula(codAlumno,codCurso);
		ArregloMatricula.adicionar(newMatricula);
		ArregloAlumno.getAlumnoByCode(codAlumno).setEstado(1);
		cboAlumnoNoMatriculado.removeAllItems();
		insertarData();
		listar();
	}


	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	private void listar() {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		for (int i = 0; i < ArregloMatricula.tamanio(); i++) {
			model.addRow(new Object[] { 
					ArregloMatricula.getMatricula(i).getNumMatricula(),
					ArregloMatricula.getMatricula(i).getCodAlumno(),
					ArregloAlumno.getAlumnoByCode(ArregloMatricula.getMatricula(i).getCodAlumno()).getNombres()+" "+ArregloAlumno.getAlumnoByCode(ArregloMatricula.getMatricula(i).getCodAlumno()).getApellidos(),
					ArregloMatricula.getMatricula(i).getCodCurso(),
					ArregloMatricula.getMatricula(i).getFechaMatricula(),
					ArregloMatricula.getMatricula(i).getHoraMatricula(),
					ArregloMatricula.getMatricula(i).getEstadoName(),
					});
		}
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

