package com.alure.hotel.jdbc.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.alura.hotel.jdbc.controller.HuespedesController;
import com.alura.hotel.jdbc.controller.ReservasController;
import com.alura.hotel.jdbc.controller.ResultadoBusquedaController;
import com.alura.hotel.jdbc.modelo.Huesped;
import com.alura.hotel.jdbc.modelo.HuespedReserva;
import com.mchange.lang.StringUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservasController reservasController;
	private HuespedesController huespedesController;
	private ResultadoBusquedaController resultadoBusquedaController;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {

		this.resultadoBusquedaController = new ResultadoBusquedaController();
		this.reservasController = new ReservasController();
		this.huespedesController = new HuespedesController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscar.setBounds(376, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		cargarReservas();
		
		/*
		modelo.addRow(new Object[] { "ID", "CHECK-IN", "CHECK-OUT", "VALOR", "FORMA DE PAGO"});
		modelo.addRow(new Object[] {});
		*/
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), tbHuespedes, null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		modeloH.addColumn("Numero de Reserva");
		cargarHuespedes();
		/*
		modeloH.addRow(new Object[] { "Id huesped", "Nombre", "Apellido", "F. Nacimiento", "Nacionalidad", "Telefono", "N° reserva"});
		modeloH.addRow(new Object[] {});
		*/

		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(376, 157, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//ahora acepta numerico como string, la verificacion se hace en la peticion y puede buscar con ambos
							
				if(!txtBuscar.getText().isBlank()) {
					limpiarTabla();
					resultadoBusqueda(txtBuscar.getText());
				}
				/*
				//con este metodo verificamos si es un numero o un string, lo usamos como un if
				String textoIngresado = txtBuscar.getText();
				try {
				  int numero = Integer.parseInt(textoIngresado);
				  resultadoBusquedaR(numero);
				} catch (NumberFormatException ex) {
				  resultadoBusquedaH(textoIngresado);
				}
				*/
			}
		});

		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(585, 121, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));		
		
		JPanel btnVerRegistros = new JPanel();
		btnVerRegistros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					txtBuscar.setText("");
					limpiarTabla();
					cargarReservas();
					cargarHuespedes();
			}
		});
		btnVerRegistros.setLayout(null);
		btnVerRegistros.setBackground(new Color(12, 138, 199));
		btnVerRegistros.setBounds(711, 121, 170, 35);
		btnVerRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnVerRegistros);
		
		JLabel lblVerRegistros = new JLabel("VER REGISTROS");
		lblVerRegistros.setBounds(0, 0, 170, 35);
		btnVerRegistros.add(lblVerRegistros);
		lblVerRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerRegistros.setForeground(Color.WHITE);
		lblVerRegistros.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editarRegistros(panel.getSelectedIndex());
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar(panel.getSelectedIndex());
				limpiarTabla();
				cargarHuespedes();
				cargarReservas();
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
	    
    private void resultadoBusqueda(Object parametroBusqueda) {
    	agregarTitulosHuespedes();
    	agregarTitulosReservas();
    	
    	var huespedes = this.resultadoBusquedaController.resultadoBusqueda(parametroBusqueda);
    	huespedes.forEach(huesped ->{
    		modeloH.addRow(new Object[] {
    				huesped.getHuesped().getId(),
    				huesped.getHuesped().getNombre(),
    				huesped.getHuesped().getApellido(),
    				huesped.getHuesped().getFecha_nacimiento(),
    				huesped.getHuesped().getNacionalidad(),
    				huesped.getHuesped().getTelefono(),
    				huesped.getHuesped().getId_reserva(),
    		});
    		
    		modelo.addRow(new Object[] {
    				huesped.getReserva().getId(),
    				huesped.getReserva().getFecha_entrada(),
    				huesped.getReserva().getFecha_salida(),
    				huesped.getReserva().getValor(),
    				huesped.getReserva().getForma_pago(),
    		});				
    	});
    }
    

    //dependiendo de la pestaña abierta hacemos una accion panel.getSelectedIndex() para saber cual esta abierta
	public void eliminar(int pestañaAbierta) {
		if (pestañaAbierta == 0) {
			eliminarDesdeReserva();
		}
		else if (pestañaAbierta == 1){
			eliminarDesdeHuespedes();
		}
	}
	
	public void editarRegistros(int pestañaAbierta) {
		if (pestañaAbierta == 0) {
			editarReserva();
			System.out.println("reserva");
		}
		else if (pestañaAbierta == 1){
			editarHuesped();
			System.out.println("huesped");
		}
	}
	
	private boolean escogioFilaReservas() {
		return tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
	}
	
	private boolean escogioFilaHuespedes() {
		return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
	}
	
   private void limpiarTabla() {
	   /*//este metodo daba fallos
        modelo.getDataVector().clear();
        modeloH.getDataVector().clear();
       */
	   modelo.setRowCount(0);
	   modeloH.setRowCount(0);
   }
   
   private void agregarTitulosReservas() {
	   modelo.addRow(new Object[] { "ID", "CHECK-IN", "CHECK-OUT", "VALOR", "FORMA DE PAGO"});
	   modelo.addRow(new Object[] {});
   }
   
   private void agregarTitulosHuespedes() {
	   modeloH.addRow(new Object[] { "Id huesped", "Nombre", "Apellido", "F. Nacimiento", "Nacionalidad", "Telefono", "N° reserva"});
	   modeloH.addRow(new Object[] {});
   }
   
	//////////////////////////////////////////////////////////////
   
   private void cargarReservas(){
	   var reservas = this.reservasController.listarReservas();
	   agregarTitulosReservas();
	   reservas.forEach(reserva -> modelo.addRow(
			   new Object[] {
					   reserva.getId(),
					   reserva.getFecha_entrada(),
					   reserva.getFecha_salida(),
					   reserva.getValor(),
					   reserva.getForma_pago()
			   }));
   }
    
   
   private void cargarHuespedes() {
	   var huespedes = this.huespedesController.listarHespedes();
	   agregarTitulosHuespedes();
	   huespedes.forEach(huesped -> modeloH.addRow(
			   new Object[] {
					   huesped.getId(),
					   huesped.getNombre(),
					   huesped.getApellido(),
					   huesped.getFecha_nacimiento(),
					   huesped.getNacionalidad(),
					   huesped.getTelefono(),
					   huesped.getId_reserva()
			   }));
   }
   
   
   private void eliminarDesdeHuespedes(){
	   if(escogioFilaHuespedes()) {
           JOptionPane.showMessageDialog(this, "Por favor, elije un item");
           return;
	   }
	   
    	Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer idReserva = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
			this.resultadoBusquedaController.eliminarReservaYHuesped(idReserva);
			modeloH.removeRow(tbHuespedes.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Datos de reserva y huesped eliminados con exito!");

		}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));  
    }
    
    private void eliminarDesdeReserva(){
 	   if(escogioFilaReservas()) {
           JOptionPane.showMessageDialog(this, "Por favor, elije un item");
           return;
	   }
 	   
    	Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer idReserva = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
			this.resultadoBusquedaController.eliminarReservaYHuesped(idReserva);
			modelo.removeRow(tbReservas.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Datos de reserva y huesped eliminados con exito!");
		}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void editarReserva() {
        if (escogioFilaReservas()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }
    	
    	Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
    			.ifPresentOrElse(fila -> {
    				
    				Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
    				Date fecha_entrada = (Date) modelo.getValueAt(tbReservas.getSelectedRow(), 1);
    				Date fecha_salida = (Date) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
    				Double valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
    				String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
    				
    				var filasModificadas = this.reservasController.modificarReserva(id, fecha_entrada, fecha_salida, valor, formaPago);
    				
                    JOptionPane.showMessageDialog(this, String.format("%d item en reserva modificado con éxito!", filasModificadas));   			
    			}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije una reserva"));
    }
    
    private void editarHuesped() {
        if (escogioFilaHuespedes()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }
        
    	Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
    			.ifPresentOrElse(fila -> {
    				
    				Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
    				String nombre = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
    				String apellido = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
    				Date fecha_nacimiento = (Date) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 3);
    				String nacionalidad = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
    				String telefono = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5);
    				
    				var filasModificadas = this.huespedesController.modificarHuesped(id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono);
    				
    				JOptionPane.showMessageDialog(this, String.format("%d item en huespedes modificado con éxito!", filasModificadas));
    			}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije una reserva"));
    }
}