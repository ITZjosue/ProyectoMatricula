package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 658, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Codigo:");
		lblNewJgoodiesLabel.setBounds(10, 11, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Asignatura:");
		lblNewJgoodiesLabel_1.setBounds(10, 36, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Ciclo:");
		lblNewJgoodiesLabel_2.setBounds(10, 61, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Creditos:");
		lblNewJgoodiesLabel_3.setBounds(10, 86, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Cantidad Horas:");
		lblNewJgoodiesLabel_4.setBounds(10, 111, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_4);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(543, 7, 89, 23);
		contentPanel.add(btnAdicionar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(543, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(543, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(119, 8, 165, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(119, 33, 165, 20);
		contentPanel.add(txtAsignatura);
		
		txtCiclo = new JTextField();
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(119, 58, 86, 20);
		contentPanel.add(txtCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(119, 83, 86, 20);
		contentPanel.add(txtCreditos);
		
		txtCantHoras = new JTextField();
		txtCantHoras.setColumns(10);
		txtCantHoras.setBounds(119, 108, 86, 20);
		contentPanel.add(txtCantHoras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 622, 281);
		contentPanel.add(scrollPane);
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		model.addColumn("Codigo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("N° Creditos");
		model.addColumn("Horas");
		listarCursos();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(13, 151, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(116, 151, 89, 23);
		contentPanel.add(btnCancelar);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !txtCodigo.getText().isEmpty() && !txtCiclo.getText().isEmpty() && !txtCreditos.getText().isEmpty() && !txtCantHoras.getText().isEmpty() ) {
					Curso curso = new Curso(
							Integer.parseInt(txtCodigo.getText()),
							Integer.parseInt(txtCiclo.getText()),
							Integer.parseInt(txtCreditos.getText()),
							Integer.parseInt(txtCantHoras.getText()),
							txtAsignatura.getText()
							);
					ArregloCurso.addCurso(curso);
					listarCursos();
					limpiarFormulario();
				}else {
					mensaje("Faltan datos");
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int opt = confirmDlg("Seguro que desea eliminar el curso?");
				if(row == -1) {
					mensaje("Necesita esoger un curso");
				}else {
					if(opt == 0) {
						ArregloCurso.deleteCursoByCode(Integer.parseInt(table.getValueAt(row, 0).toString()));
						listarCursos();										
					}					
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
