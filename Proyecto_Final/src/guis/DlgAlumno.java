package guis;

import arreglos.ArregloAlumno;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import entidades.Alumno;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class DlgAlumno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codAlumno;
	private JTextField nomAlumno;
	private JTextField apeAlumno;
	private JTextField dniAlumno;
	private JTextField edadAlumno;
	private JTextField celAlumno;
	private JTable table;
	private JComboBox comboBox;

	DefaultTableModel model = new DefaultTableModel();
	private Alumno modAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlumno dialog = new DlgAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumno() {
		setTitle("Mantenimiento Alumno");
		setBounds(100, 100, 698, 642);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Código:");
		lblNewJgoodiesLabel.setBounds(10, 11, 53, 14);
		contentPanel.add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nombres:");
		lblNewJgoodiesLabel_1.setBounds(10, 36, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_1);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Apellidos:");
		lblNewJgoodiesLabel_2.setBounds(10, 61, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_2);

		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setBounds(10, 86, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_3);

		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Edad:");
		lblNewJgoodiesLabel_4.setBounds(169, 86, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_4);

		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Celular:");
		lblNewJgoodiesLabel_5.setBounds(10, 120, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_5);

		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Estado");
		lblNewJgoodiesLabel_6.setBounds(10, 145, 92, 14);
		contentPanel.add(lblNewJgoodiesLabel_6);

		codAlumno = new JTextField();
		codAlumno.setEditable(false);
		codAlumno.setBounds(73, 8, 86, 20);
		contentPanel.add(codAlumno);
		codAlumno.setColumns(10);

		nomAlumno = new JTextField();
		nomAlumno.setColumns(10);
		nomAlumno.setBounds(73, 33, 220, 20);
		contentPanel.add(nomAlumno);

		apeAlumno = new JTextField();
		apeAlumno.setColumns(10);
		apeAlumno.setBounds(73, 58, 220, 20);
		contentPanel.add(apeAlumno);

		dniAlumno = new JTextField();
		dniAlumno.setColumns(10);
		dniAlumno.setBounds(73, 86, 86, 20);
		contentPanel.add(dniAlumno);
		
		celAlumno = new JTextField();
		celAlumno.setBounds(73, 117, 86, 20);
		contentPanel.add(celAlumno);
		celAlumno.setColumns(10);
		
		edadAlumno = new JTextField();
		edadAlumno.setColumns(10);
		edadAlumno.setBounds(207, 86, 86, 20);
		contentPanel.add(edadAlumno);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(388, 21, 89, 23);
		contentPanel.add(btnAdicionar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(388, 91, 89, 23);
		contentPanel.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(388, 57, 89, 23);
		contentPanel.add(btnModificar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(10, 173, 89, 23);
		contentPanel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(109, 173, 89, 23);
		contentPanel.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 207, 662, 385);
		contentPanel.add(scrollPane);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		comboBox.setBounds(73, 141, 114, 22);
		contentPanel.add(comboBox);
		comboBox.setEnabled(false);
		
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		
		// creating columns
		model.addColumn("Codigo");
		model.addColumn("DNI");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("Estado");
		
		listarAlumnos();
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!nomAlumno.getText().isEmpty() && !apeAlumno.getText().isEmpty() && !dniAlumno.getText().isEmpty() && !edadAlumno.getText().isEmpty() && !celAlumno.getText().isEmpty()) {
					// VERIFICANDO QUE NO SE REPITA DNI
					for(int i = 0;i<ArregloAlumno.getListaAlumnosLen();i++) {
						if(ArregloAlumno.getAlumno(i).getDni().equals(dniAlumno.getText())) {
							mensaje("Este dni ya está registrado");
							return;
						}
					}
					// VALIDACIONES
					
					Alumno nuevoAlumno = new Alumno(
							nomAlumno.getText(), 
							apeAlumno.getText(), 
							dniAlumno.getText(), 
							Integer.parseInt(edadAlumno.getText()),
							Integer.parseInt(celAlumno.getText())
							);
					ArregloAlumno.setListaAlumnos(nuevoAlumno);
					listarAlumnos();
					limpiarFormulario();
				}else {
					mensaje("Faltan datos");
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					mensaje("Necesita escoger un alumno");
				}else {
					int opt = confirmDlg("Seguro que desea eliminar al alumno?");
					if( table.getValueAt(row,4).toString() == "REGISTRADO" && opt == 0) {
						ArregloAlumno.deleteAlumnoByCode(Integer.parseInt(table.getValueAt(row,0).toString()));
						listarAlumnos();
					}else if(table.getValueAt(row,4) == "MATRICULADO"){
						mensaje("El alumno no puede ser eliminado porque está matriculado");
					}
					else if(table.getValueAt(row, 4) == "RETIRADO") {
						mensaje("El alumno no puede ser eliminado porque está retirado");
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
					dniAlumno.setEditable(false);
					modAlumno = ArregloAlumno.getAlumnoByCode(Integer.parseInt(table.getValueAt(row, 0).toString()));
					nomAlumno.setText(modAlumno.getNombres());
					apeAlumno.setText(modAlumno.getApellidos());
					dniAlumno.setText(modAlumno.getDni());
					edadAlumno.setText(String.valueOf(modAlumno.getEdad()));
					codAlumno.setText(String.valueOf(modAlumno.getCodAlumno()));
					celAlumno.setText(String.valueOf(modAlumno.getCelular()));
					comboBox.setSelectedIndex(modAlumno.getEstado());
				}
			}
		});
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dniAlumno.setEditable(true);
				modAlumno.setNombres(nomAlumno.getText()); 
				modAlumno.setApellidos(apeAlumno.getText());
				modAlumno.setDni(dniAlumno.getText());
				modAlumno.setCelular(Integer.parseInt(celAlumno.getText()));
				modAlumno.setEdad(Integer.parseInt(edadAlumno.getText()));
				listarAlumnos();
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
				dniAlumno.setEditable(true);
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnAdicionar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});

		
	}
	
	public void listarAlumnos() {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		for (int i = 0; i < ArregloAlumno.getListaAlumnosLen(); i++) {
			Alumno aa = ArregloAlumno.getAlumno(i);
			model.addRow(new Object[] { 
					aa.getCodAlumno(),
					aa.getDni(), 
					aa.getNombres(),
					aa.getApellidos(), 
					aa.getEstadoName() });
		}
	}
	
	public void limpiarFormulario() {
		nomAlumno.setText("");
		comboBox.setSelectedIndex(0);
		apeAlumno.setText("");
		dniAlumno.setText("");
		edadAlumno.setText("");
		celAlumno.setText("");
		codAlumno.setText("");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	int confirmDlg(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}
}
