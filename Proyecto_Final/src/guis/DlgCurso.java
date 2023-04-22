package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import entidades.Alumno;
import entidades.Curso;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class DlgCurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtCantHoras;
	DefaultTableModel model = new DefaultTableModel();
	private Curso modCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCurso dialog = new DlgCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCurso() {
		setTitle("Cursos");
		setBounds(100, 100, 886, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 299, 850, 293);
		contentPanel.add(scrollPane);
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(202, 211, 217));
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 50, 850, 193);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 211, 217));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 19, 830, 163);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Codigo:");
		lblNewJgoodiesLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel.setBounds(472, 19, 53, 14);
		panel_1.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Asignatura:");
		lblNewJgoodiesLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_1.setBounds(6, 19, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Ciclo:");
		lblNewJgoodiesLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_2.setBounds(6, 78, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Creditos:");
		lblNewJgoodiesLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_3.setBounds(6, 123, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Cantidad Horas:");
		lblNewJgoodiesLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_4.setBounds(472, 78, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_4);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(576, 16, 86, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(108, 16, 220, 20);
		panel_1.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		txtCiclo = new JTextField();
		txtCiclo.setBounds(108, 75, 220, 20);
		panel_1.add(txtCiclo);
		txtCiclo.setColumns(10);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(108, 120, 86, 20);
		panel_1.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtCantHoras = new JTextField();
		txtCantHoras.setBounds(576, 75, 86, 20);
		panel_1.add(txtCantHoras);
		txtCantHoras.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(570, 254, 100, 34);
		contentPanel.add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int opt = confirmDlg("Seguro que desea eliminar el curso?");
				if(row == -1) {
					mensaje("Necesita esoger un curso");
				}else {
					if(opt == 0) {
						ArregloCurso.deleteCursoByCode(Integer.parseInt(table.getValueAt(row, 0).toString()));
						ArregloCurso.grabarCurso();
						listarCursos();										
					}					
				}
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(20, 254, 100, 34);
		contentPanel.add(btnAdicionar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(385, 254, 100, 34);
		contentPanel.add(btnModificar);
		model.addColumn("Codigo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("N° Creditos");
		model.addColumn("Horas");
		listarCursos();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(748, 254, 100, 34);
		contentPanel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(199, 254, 100, 34);
		contentPanel.add(btnAceptar);
		
		
		
		JLabel lblAlumno = new JLabel("Curso");
		lblAlumno.setVerticalAlignment(SwingConstants.TOP);
		lblAlumno.setOpaque(true);
		lblAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno.setForeground(new Color(128, 0, 0));
		lblAlumno.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblAlumno.setBackground(new Color(202, 211, 217));
		lblAlumno.setBounds(0, 0, 870, 611);
		contentPanel.add(lblAlumno);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !txtCiclo.getText().isEmpty() && !txtCreditos.getText().isEmpty() && !txtCantHoras.getText().isEmpty() ) {
					Curso curso = new Curso(
							Integer.parseInt(txtCiclo.getText()),
							Integer.parseInt(txtCreditos.getText()),
							Integer.parseInt(txtCantHoras.getText()),
							txtAsignatura.getText()
							);
					ArregloCurso.addCurso(curso);
					ArregloCurso.grabarCurso();
					listarCursos();
					limpiarFormulario();
				}else {
					mensaje("Faltan datos");
				}
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					mensaje("Necesita escojer un alumno");
				}else {
					btnAdicionar.setEnabled(false);
					btnEliminar.setEnabled(false);
					btnAceptar.setEnabled(true);
					btnCancelar.setEnabled(true);
					txtCodigo.setEditable(false);
					modCurso = ArregloCurso.getCursoByCode(Integer.parseInt(table.getValueAt(row,0).toString()));
					txtCodigo.setText(String.valueOf(modCurso.getCodCurso()));
					txtCiclo.setText(String.valueOf(modCurso.getCiclo()));
					txtCreditos.setText(String.valueOf(modCurso.getCreditos()));
					txtCantHoras.setText(String.valueOf(modCurso.getHoras()));
					txtAsignatura.setText(modCurso.getAsignatura());
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigo.setEditable(true);
				modCurso.setCiclo(Integer.parseInt(txtCiclo.getText()));
				modCurso.setAsignatura(txtAsignatura.getText());
				modCurso.setCreditos(Integer.parseInt(txtCreditos.getText()));
				modCurso.setHoras(Integer.parseInt(txtCantHoras.getText()));
				ArregloCurso.grabarCurso();
				listarCursos();
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnAdicionar.setEnabled(true);
				btnEliminar.setEnabled(true);
				limpiarFormulario();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				txtCodigo.setEditable(true);
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnAdicionar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
	}
	
	void listarCursos() {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		for (int i = 0; i < ArregloCurso.getCantidadCursos(); i++) {
			model.addRow(new Object[] { 
					ArregloCurso.getCurso(i).getCodCurso(),
					ArregloCurso.getCurso(i).getAsignatura(),
					ArregloCurso.getCurso(i).getCiclo(),
					ArregloCurso.getCurso(i).getCreditos(),
					ArregloCurso.getCurso(i).getHoras()
					});
		}
	}
	public void limpiarFormulario() {
		txtCreditos.setText("");
		txtCantHoras.setText("");
		txtCiclo.setText("");
		txtAsignatura.setText("");
		txtCodigo.setText("");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	int confirmDlg(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}
	
}
