package guis;

import arreglos.*;
import entidades.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import entidades.Alumno;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DlgReporteMartriculadosPorCurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cboCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteMartriculadosPorCurso dialog = new DlgReporteMartriculadosPorCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteMartriculadosPorCurso() {
		setTitle("Matriculados por curso");
		setBounds(100, 100, 790, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Curso");
			lblNewLabel.setBounds(32, 24, 55, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			cboCurso = new JComboBox();
			cboCurso.setBounds(96, 20, 178, 22);
			contentPanel.add(cboCurso);
			cboCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int codCurso = Integer.parseInt(cboCurso.getSelectedItem().toString());
					listarAlumnosMatriculados(codCurso);
				}
			});
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Alumnos matriculados");
			lblNewLabel_1.setBounds(32, 53, 138, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 89, 728, 282);
		contentPanel.add(scrollPane);
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		model.addColumn("Codigo");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("DNI");
		model.addColumn("Estado");
		scrollPane.setViewportView(table);
		
		insertData();
	}
	
	void insertData() {
		cboCurso.removeAllItems();
		for (int i = 0; i <ArregloCurso.getCantidadCursos(); i++) {
				cboCurso.addItem(""+ArregloCurso.getCurso(i).getCodCurso());
			};
		
	}
	
	public void listarAlumnosMatriculados(int codCurso) {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		ArrayList<Matricula> matriculas;
		for(int i = 0;i<ArregloMatricula.tamanio();i++) {
			if(ArregloMatricula.getMatricula(i).getCodCurso() == codCurso) {
				int codAlumno = ArregloMatricula.getMatricula(i).getCodAlumno();
				Alumno alumno = ArregloAlumno.getAlumnoByCode(codAlumno);
				model.addRow(new Object[] {
						alumno.getCodAlumno(),
						alumno.getNombres(),
						alumno.getApellidos(),
						alumno.getDni(),
						alumno.getEstadoName()
				});
			}
		}
	}
}
