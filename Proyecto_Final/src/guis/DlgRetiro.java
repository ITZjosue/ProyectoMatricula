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
import java.awt.event.MouseEvent;

public class DlgRetiro extends JDialog implements ActionListener, KeyListener, MouseListener {
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox cboMatricula;
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
		
		JLabel lblNewLabel_1 = new JLabel("Numero De Matricula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 61, 199, 25);
		panel.add(lblNewLabel_1);
		
		cboMatricula = new JComboBox();
		cboMatricula.setBounds(284, 63, 247, 22);
		panel.add(cboMatricula);
		
		JButton btnRetiro = new JButton("Generar Retiro");
		btnRetiro.setBorder(UIManager.getBorder("Button.border"));
		btnRetiro.setBounds(28, 264, 169, 32);
		panel_1.add(btnRetiro);
		
		JButton btnCancelarRetiro = new JButton("Cancelar Retiro");
		btnCancelarRetiro.setBorder(UIManager.getBorder("Button.border"));
		btnCancelarRetiro.setBounds(222, 264, 163, 32);
		panel_1.add(btnCancelarRetiro);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(754, 596, 89, 32);
		panel_1.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 307, 815, 261);
		panel_1.add(scrollPane);
		
		table = new JTable(model){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		model.addColumn("NUM_RETIRO");
		model.addColumn("NUM_MATRICULA");
		model.addColumn("FECHA");
		model.addColumn("HORA");
		
		JLabel lblNewLabel = new JLabel("Retiro");
		lblNewLabel.setBounds(0, 0, 873, 639);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(202, 211, 217));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(table);
	
		insertarDataToComboBox();
		listar();
		
		btnRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codMatricula = Integer.parseInt(cboMatricula.getSelectedItem().toString());
				Retiro newRetiro = new Retiro(codMatricula);
				ArregloRetiro.adicionar(newRetiro);
				Matricula matricula = ArregloMatricula.getMatriculaById(codMatricula);
				matricula.setEstado(1);
				ArregloAlumno.getAlumnoByCode(matricula.getCodAlumno()).setEstado(2);
				insertarDataToComboBox();
				listar();
			}
		});
		
		btnCancelarRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					mensaje("Necesita escoger un registro de retiro");
				}else {
					int opt = confirmar("Seguro que desea cancelar el retiro ?");
					Matricula m = ArregloMatricula.getMatriculaById(Integer.parseInt(table.getValueAt(row,1).toString()));
					Alumno a = ArregloAlumno.getAlumnoByCode(m.getCodAlumno());
					if(a.getEstado() == 2 &&  opt == 0) {
						ArregloRetiro.deleteRetiroByCode(Integer.parseInt(table.getValueAt(row,0).toString()));
						listar();						
					}else if(opt == 0 && a.getEstado() != 2){
						mensaje("No se puede cancelar este retiro");
					}
				}
			}
		});

	}
	
	public void insertarDataToComboBox(){
		cboMatricula.removeAllItems();
		for (int i = 0; i <ArregloMatricula.tamanio(); i++) {
			if(ArregloMatricula.getMatricula(i).getEstado() == 0) {
				cboMatricula.addItem(""+ArregloMatricula.getMatricula(i).getNumMatricula());				
			}
		}
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


	private void listar() {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		for (int i = 0; i < ArregloRetiro.getRetiroLen(); i++) {
			model.addRow(new Object[] { 
					ArregloRetiro.getRetiro(i).getNumRetiro(),
					ArregloRetiro.getRetiro(i).getNumMatricula(),
					ArregloRetiro.getRetiro(i).getFecha(),
					ArregloRetiro.getRetiro(i).getHora(),
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

