package com.sistema.venta.jdbc.views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import com.sistema.venta.jdbc.controller.ClienteController;
import com.sistema.venta.jdbc.controller.ProductConroller;
import com.sistema.venta.jdbc.controller.Proveedorcontroller;
import com.sistema.venta.jdbc.modelo.Producto;
import com.sistema.venta.jdbc.modelo.Proveedor;

import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sPRINCIPAL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private DefaultTableModel tbModelNuevaV;
	private JTable tbNVENTA;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDNICliente;
	private JTextField txtNombreCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtDireccionCliente;
	private JTextField txtRazonCliente;
	private JTable tbCliente;
	private DefaultTableModel modeloTbCliente;
	private JTable tbVentas;
	private DefaultTableModel modeloTbVentas;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField txtCodProduc;
	private JTextField txtDescripProduct;
	private JTextField txtCantidadProduct;
	private JTextField txtPrecioProduct;
	private DefaultTableModel tbModelProducto;
	private JTable tbproducto;
	private JTextField txtIdVentas;
	private JTextField txtIdProducto;
	protected JTabbedPane tabbedPaneA;
	private Proveedorcontroller proveedorcontroller;
	private ClienteController clienteController;
//	private static JComboBox<Forma> comboFormaPago;
	private JComboBox<Proveedor> cmbProveedor;
	private JTable tbProveedor;
	private DefaultTableModel tbModelProveedor;
	private JTextField txtRuc;
	private JTextField txtNombreProvee;
	private JTextField txtTelefonoProvee;
	private JTextField txtDireccionProvee;
	private JTextField txtRazonProvee;
	private ProductConroller productController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sPRINCIPAL frame = new sPRINCIPAL();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sPRINCIPAL() {
		
		this.productController = new ProductConroller();
		this.proveedorcontroller = new Proveedorcontroller();
		this.clienteController = new ClienteController();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel background = new JPanel();
		background.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.setBackground(UIManager.getColor("Button.highlight"));
		background.setBounds(0, 0, 784, 461);
		contentPane.add(background);
		background.setLayout(null);
		
		ImageIcon imgVenta = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\\\Nventa.png");
		ImageIcon imgVenta2 = new ImageIcon(imgVenta.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		
		
		ImageIcon imgConfig = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\config.png");
		ImageIcon imgConfig2 = new ImageIcon(imgConfig.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH));
		
		
		ImageIcon imgLogo = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\MI LOGO.png");
		ImageIcon imgLogo2 = new ImageIcon(imgLogo.getImage().getScaledInstance(88, 88, Image.SCALE_SMOOTH));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(140, 0, 644, 75);
		background.add(panel_2);
		panel_2.setLayout(null);
		
		/*
		 * AQUI COMIENZA EL DISENO DE LA TABLA
		 * */
		
		tbModelNuevaV = new DefaultTableModel();
		
		String TitulosNV [] = {"CODIGO","DESCRIPCION","CANTIDAD","PRECIO","TOTAL"};
		tbModelNuevaV.setColumnIdentifiers(TitulosNV);
		
//		table = new JTable();
//		table.setBounds(220, 11, 409, 336);
//		tab4.add(table);
		
//		TABLA PRODUCTO
		
		tbModelProducto = new DefaultTableModel();
		
		String TitulosP [] = {"ID","CODIGO","NOMBRE", "PROVEEDOR","CANTIDAD","PRECIO"};
		tbModelProducto.setColumnIdentifiers(TitulosP);
		cargarTablaProductos();
		
		/*
		 * AQUI COMIENZA EL DISENO DE LA TABLA Cliente
		 * */
		
		modeloTbCliente = new DefaultTableModel();
		
		String TitulosC [] = {"DNI/RUC","NOMBRE","TELEFONO","DIRECCION","RAZON SOCIAL"};
		modeloTbCliente.setColumnIdentifiers(TitulosC);
		
//		TABLA VENTAS
		
		modeloTbVentas = new DefaultTableModel();
		
		String TitulosVentas [] = {"ID","CLIENTE","VENDEDOR","TOTAL"};
		modeloTbVentas.setColumnIdentifiers(TitulosVentas);
		
		JPanel menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(Color.GREEN);
		menu.setBounds(0, 0, 140, 461);
		background.add(menu);
		
		JPanel Panel_producto = new JPanel();
		Panel_producto.setLayout(null);
		Panel_producto.setBounds(10, 240, 120, 24);
		menu.add(Panel_producto);
		
		JLabel lblProducto = new JLabel("   Producto");
		lblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tabbedPaneA.setSelectedIndex(1);
			}
		});
		lblProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProducto.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\producto.png"));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setFont(new Font("Roboto", Font.BOLD, 13));
		lblProducto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblProducto.setBackground(Color.WHITE);
		lblProducto.setBounds(0, 0, 120, 24);
		Panel_producto.add(lblProducto);
		
		JPanel panel_Cliente = new JPanel();
		panel_Cliente.setLayout(null);
		panel_Cliente.setBounds(10, 275, 120, 24);
		menu.add(panel_Cliente);
		
		JLabel lblCliente = new JLabel("     Cliente");
		lblCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneA.setSelectedIndex(2);
			}
		});
		lblCliente.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\Clientes.png"));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Roboto", Font.BOLD, 13));
		lblCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setBounds(0, 0, 120, 24);
		panel_Cliente.add(lblCliente);
		
		JPanel panel_Proveedor = new JPanel();
		panel_Proveedor.setLayout(null);
		panel_Proveedor.setBounds(10, 310, 120, 24);
		menu.add(panel_Proveedor);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneA.setSelectedIndex(3);
			}
		});
		
		
		lblProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProveedor.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\proveedor.png"));
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Roboto", Font.BOLD, 13));
		lblProveedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblProveedor.setBackground(Color.WHITE);
		lblProveedor.setBounds(0, 0, 120, 24);
		panel_Proveedor.add(lblProveedor);
		
		JPanel panel_Ventas = new JPanel();
		panel_Ventas.setLayout(null);
		panel_Ventas.setBounds(10, 345, 120, 24);
		menu.add(panel_Ventas);
		
		JLabel lblVentas = new JLabel("      Ventas");
		lblVentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tabbedPaneA.setSelectedIndex(4);
			}
		});
		lblVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVentas.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\compras.png"));
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setFont(new Font("Roboto", Font.BOLD, 13));
		lblVentas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVentas.setBackground(Color.WHITE);
		lblVentas.setBounds(0, 0, 120, 24);
		panel_Ventas.add(lblVentas);
		
		JPanel panel_Config = new JPanel();
		panel_Config.setLayout(null);
		panel_Config.setBounds(10, 380, 120, 24);
		menu.add(panel_Config);
		
		ImageIcon imgCFG = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\config.png");
		ImageIcon imgCFG2 = new ImageIcon(imgCFG.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH));
		
		JLabel lblConfig = new JLabel("Config");
		lblConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tabbedPaneA.setSelectedIndex(5);
			}
		});
		lblConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConfig.setIcon(imgCFG2);
		lblConfig.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfig.setFont(new Font("Roboto", Font.BOLD, 13));
		lblConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblConfig.setBackground(Color.WHITE);
		lblConfig.setBounds(0, 0, 120, 24);
		panel_Config.add(lblConfig);
		
		ImageIcon imgLogoA = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\MI LOGO.png");
		ImageIcon imglogo2 = new ImageIcon(imgLogoA.getImage().getScaledInstance(88, 88, Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(imglogo2);
		lblNewLabel_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1.setBounds(31, 53, 88, 88);
		menu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("SISTEMA DE VENTA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Roboto Black", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 11, 137, 31);
		menu.add(lblNewLabel_3);
		
		JPanel panel_Nueva_v = new JPanel();
		panel_Nueva_v.setLayout(null);
		panel_Nueva_v.setBounds(10, 205, 120, 24);
		menu.add(panel_Nueva_v);
		
		ImageIcon imgNV = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\Nventa.png");
		ImageIcon imgNV2 = new ImageIcon(imgNV.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH));
		
		JLabel lblNueva_venta = new JLabel("Nueva venta");
		lblNueva_venta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNueva_venta.setIcon(imgNV2);
		lblNueva_venta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneA.setSelectedIndex(0);
			}
		});
		lblNueva_venta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNueva_venta.setFont(new Font("Roboto", Font.BOLD, 13));
		lblNueva_venta.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNueva_venta.setBackground(Color.BLACK);
		lblNueva_venta.setBounds(0, 0, 120, 24);
		panel_Nueva_v.add(lblNueva_venta);
		
		tabbedPaneA = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneA.setBounds(140, 75, 644, 386);
		background.add(tabbedPaneA);
		
		JPanel tab1 = new JPanel();
		tabbedPaneA.addTab("New tab", null, tab1, null);
		tab1.setLayout(null);
//		tabbedPaneA.setSelectedIndex(1);
				
				textField_5 = new JTextField();
				textField_5.setBorder(new LineBorder(Color.BLACK));
				textField_5.setColumns(10);
				textField_5.setBounds(421, 40, 86, 20);
				tab1.add(textField_5);
				
				textField_6 = new JTextField();
				textField_6.setBorder(new LineBorder(Color.BLACK));
				textField_6.setEditable(false);
				textField_6.setColumns(10);
				textField_6.setBounds(335, 40, 76, 20);
				tab1.add(textField_6);
				
				textField_7 = new JTextField();
				textField_7.setBorder(new LineBorder(Color.BLACK));
				textField_7.setColumns(10);
				textField_7.setBounds(239, 40, 86, 20);
				tab1.add(textField_7);
				
				JLabel lblNewLabel_5_1 = new JLabel("Cantidad");
				lblNewLabel_5_1.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_5_1.setBounds(239, 15, 61, 14);
				tab1.add(lblNewLabel_5_1);
				
				JLabel lblNewLabel_4_1 = new JLabel("Descripcion");
				lblNewLabel_4_1.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_4_1.setBounds(106, 15, 88, 14);
				tab1.add(lblNewLabel_4_1);
				
				textField_8 = new JTextField();
				textField_8.setBorder(new LineBorder(Color.BLACK));
				textField_8.setColumns(10);
				textField_8.setBounds(106, 40, 123, 20);
				tab1.add(textField_8);
				
				textField_9 = new JTextField();
				textField_9.setBorder(new LineBorder(Color.BLACK));
				textField_9.setColumns(10);
				textField_9.setBounds(10, 40, 86, 20);
				tab1.add(textField_9);
				
				JLabel lblNewLabel_2_1 = new JLabel("Codigo");
				lblNewLabel_2_1.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_2_1.setBounds(10, 15, 63, 14);
				tab1.add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_6_1 = new JLabel("Precio");
				lblNewLabel_6_1.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_6_1.setBounds(335, 15, 58, 14);
				tab1.add(lblNewLabel_6_1);
				
				JLabel lblNewLabel_7_1 = new JLabel("Stock Disponible");
				lblNewLabel_7_1.setForeground(Color.BLUE);
				lblNewLabel_7_1.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_7_1.setBounds(421, 15, 86, 14);
				tab1.add(lblNewLabel_7_1);
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\eliminar.png"));
				btnNewButton_1.setBounds(579, 37, 27, 23);
				tab1.add(btnNewButton_1);
				
				JScrollPane SCRNVENTA = new JScrollPane();
				SCRNVENTA.setBorder(new LineBorder(Color.BLACK));
				SCRNVENTA.setBounds(10, 71, 619, 218);
				tab1.add(SCRNVENTA);
				
				tbNVENTA = new JTable(tbModelNuevaV);
				tbNVENTA.setBounds(10, 71, 619, 235);
				
				tbModelNuevaV = (DefaultTableModel) tbNVENTA.getModel();
				SCRNVENTA.setViewportView(tbNVENTA);
				
//		AQUI TERMINA EL DISENO
				
				JLabel lblNewLabel_2 = new JLabel("DNI/RUC");
				lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_2.setBounds(20, 300, 46, 14);
				tab1.add(lblNewLabel_2);
				
				JLabel lblNewLabel_4 = new JLabel("NOMBRE");
				lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_4.setBounds(121, 300, 61, 14);
				tab1.add(lblNewLabel_4);
				
				textField = new JTextField();
				textField.setBorder(new LineBorder(Color.BLACK));
				textField.setBounds(20, 321, 86, 20);
				tab1.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBorder(new LineBorder(Color.BLACK));
				textField_1.setBounds(118, 321, 86, 20);
				tab1.add(textField_1);
				textField_1.setColumns(10);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\print.png"));
				btnNewButton.setBounds(235, 301, 46, 40);
				tab1.add(btnNewButton);
				
				JLabel lblNewLabel_5 = new JLabel("TOTAL A PAGAR");
				lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 11));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setBounds(325, 301, 86, 14);
				tab1.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("-----------");
				lblNewLabel_6.setBounds(421, 301, 46, 14);
				tab1.add(lblNewLabel_6);
				
				txtIdProducto = new JTextField();
				txtIdProducto.setBorder(new LineBorder(Color.BLACK));
				txtIdProducto.setBounds(520, 40, 38, 20);
				tab1.add(txtIdProducto);
				txtIdProducto.setColumns(10);
				
				JPanel tab4 = new JPanel();
				tab4.setBackground(Color.WHITE);
				tabbedPaneA.addTab("New tab", null, tab4, null);
				tab4.setLayout(null);
				
				JLabel lblNewLabel_17 = new JLabel("Codigo:");
				lblNewLabel_17.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_17.setBounds(10, 28, 46, 14);
				tab4.add(lblNewLabel_17);
				
				JLabel lblNewLabel_18 = new JLabel("Descripcion:");
				lblNewLabel_18.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_18.setBounds(10, 68, 77, 14);
				tab4.add(lblNewLabel_18);
				
				JLabel lblNewLabel_19 = new JLabel("Cantidad:");
				lblNewLabel_19.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_19.setBounds(10, 111, 55, 14);
				tab4.add(lblNewLabel_19);
				
				JLabel lblNewLabel_20 = new JLabel("Precio:");
				lblNewLabel_20.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_20.setBounds(10, 147, 46, 14);
				tab4.add(lblNewLabel_20);
				
				JLabel lblNewLabel_21 = new JLabel("Proveedor:");
				lblNewLabel_21.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_21.setBounds(10, 183, 77, 14);
				tab4.add(lblNewLabel_21);
				
				txtCodProduc = new JTextField();
				txtCodProduc.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtCodProduc.setBounds(97, 26, 113, 20);
				tab4.add(txtCodProduc);
				txtCodProduc.setColumns(10);
				
				txtDescripProduct = new JTextField();
				txtDescripProduct.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtDescripProduct.setBounds(97, 66, 113, 20);
				tab4.add(txtDescripProduct);
				txtDescripProduct.setColumns(10);
				
				txtCantidadProduct = new JTextField();
				txtCantidadProduct.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtCantidadProduct.setBounds(97, 109, 113, 20);
				tab4.add(txtCantidadProduct);
				txtCantidadProduct.setColumns(10);
				
				txtPrecioProduct = new JTextField();
				txtPrecioProduct.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtPrecioProduct.setBounds(97, 145, 113, 20);
				tab4.add(txtPrecioProduct);
				txtPrecioProduct.setColumns(10);
				
				cmbProveedor = new JComboBox();
				cmbProveedor.setBorder(new LineBorder(new Color(0, 0, 0)));
				cmbProveedor.setEditable(true);
				cmbProveedor.setBounds(97, 180, 113, 22);
				tab4.add(cmbProveedor);
				cmbProveedor.addItem(new Proveedor(0, "Elige una opcion"));
				
				var ProveCombo = this.proveedorcontroller.mostrarCombo();
				ProveCombo.forEach(proveedor -> cmbProveedor.addItem(proveedor));
				
				JScrollPane SCRProd = new JScrollPane();
				SCRProd.setBorder(new LineBorder(Color.BLACK));
				SCRProd.setBounds(220, 11, 409, 336);
				tab4.add(SCRProd);
				
				tbproducto = new JTable(tbModelProducto);
				tbproducto.setBounds(220, 11, 409, 336);
				
				tbModelNuevaV = (DefaultTableModel) tbproducto.getModel();
				SCRProd.setViewportView(tbproducto);
				cargarTablaProductos();
				
				JButton btnGuardarP = new JButton("");
				btnGuardarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnGuardarP.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						guardarProducto();
						limpiarTablas();
						cargarTablaProductos();
						limpiarFormulario();
						
					}
				});
				btnGuardarP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnGuardarP.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnGuardarP.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\GuardarTodo.png"));
				btnGuardarP.setBounds(34, 232, 30, 30);
				tab4.add(btnGuardarP);
				
				JButton btnmodificarP = new JButton("");
				btnmodificarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificarProduct();
					}
				});
				btnmodificarP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnmodificarP.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnmodificarP.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\Actualizar (2).png"));
				btnmodificarP.setBounds(98, 232, 30, 30);
				tab4.add(btnmodificarP);
				
				JButton btnEliminarP = new JButton("");
				btnEliminarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EliminarProducto();
						limpiarTablas();
						cargarTablaProductos();
					}
				});
				btnEliminarP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminarP.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnEliminarP.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\eliminar.png"));
				btnEliminarP.setBounds(34, 292, 30, 30);
				tab4.add(btnEliminarP);
				
				JButton btnNuevo = new JButton("");
				btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNuevo.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnNuevo.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\nuevo.png"));
				btnNuevo.setBounds(98, 292, 30, 30);
				tab4.add(btnNuevo);
				
				JButton btnExcelP = new JButton("");
				btnExcelP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnExcelP.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnExcelP.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\excel.png"));
				btnExcelP.setBounds(154, 262, 30, 30);
				tab4.add(btnExcelP);
				
				JPanel tab2 = new JPanel();
				tab2.setBackground(Color.WHITE);
				tabbedPaneA.addTab("New tab", null, tab2, null);
				tab2.setLayout(null);
				
				JLabel lblNewLabel_7 = new JLabel("DNI/RUC:");
				lblNewLabel_7.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_7.setBounds(10, 45, 92, 14);
				tab2.add(lblNewLabel_7);
				
				JLabel lblNewLabel_8 = new JLabel("NOMBRE:");
				lblNewLabel_8.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_8.setBounds(10, 74, 92, 14);
				tab2.add(lblNewLabel_8);
				
				JLabel lblNewLabel_9 = new JLabel("TELEFONO:");
				lblNewLabel_9.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_9.setBounds(10, 106, 92, 14);
				tab2.add(lblNewLabel_9);
				
				JLabel lblNewLabel_10 = new JLabel("DIRECCION:");
				lblNewLabel_10.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_10.setBounds(10, 137, 92, 14);
				tab2.add(lblNewLabel_10);
				
				JLabel lblNewLabel_11 = new JLabel("RAZON SOCIAL:");
				lblNewLabel_11.setFont(new Font("Roboto", Font.BOLD, 12));
				lblNewLabel_11.setBounds(10, 170, 92, 14);
				tab2.add(lblNewLabel_11);
				
				txtDNICliente = new JTextField();
				txtDNICliente.setBorder(new LineBorder(Color.BLACK));
				txtDNICliente.setBounds(102, 43, 86, 20);
				tab2.add(txtDNICliente);
				txtDNICliente.setColumns(10);
				
				txtNombreCliente = new JTextField();
				txtNombreCliente.setBorder(new LineBorder(Color.BLACK));
				txtNombreCliente.setBounds(102, 74, 86, 20);
				tab2.add(txtNombreCliente);
				txtNombreCliente.setColumns(10);
				
				txtTelefonoCliente = new JTextField();
				txtTelefonoCliente.setBorder(new LineBorder(Color.BLACK));
				txtTelefonoCliente.setBounds(102, 104, 86, 20);
				tab2.add(txtTelefonoCliente);
				txtTelefonoCliente.setColumns(10);
				
				txtDireccionCliente = new JTextField();
				txtDireccionCliente.setBorder(new LineBorder(Color.BLACK));
				txtDireccionCliente.setBounds(102, 135, 86, 20);
				tab2.add(txtDireccionCliente);
				txtDireccionCliente.setColumns(10);
				
				txtRazonCliente = new JTextField();
				txtRazonCliente.setBorder(new LineBorder(Color.BLACK));
				txtRazonCliente.setBounds(102, 168, 86, 20);
				tab2.add(txtRazonCliente);
				txtRazonCliente.setColumns(10);
				
				JScrollPane SCCLIENTE = new JScrollPane();
				SCCLIENTE.setBorder(new LineBorder(Color.BLACK));
				SCCLIENTE.setBounds(198, 45, 431, 302);
				tab2.add(SCCLIENTE);
				
				tbCliente = new JTable(modeloTbCliente);
				tbCliente.setBounds(198, 45, 441, 139);
				
				modeloTbCliente = (DefaultTableModel) tbCliente.getModel();
				SCCLIENTE.setViewportView(tbCliente);
				
				JButton btnGuardarCliente = new JButton("");
				btnGuardarCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						guardarCliente();
						
					}
				});
				btnGuardarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnGuardarCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnGuardarCliente.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\GuardarTodo.png"));
				btnGuardarCliente.setBounds(35, 219, 50, 25);
				tab2.add(btnGuardarCliente);
				
				JButton btnModificarCliente = new JButton("");
				btnModificarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnModificarCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnModificarCliente.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\Actualizar (2).png"));
				btnModificarCliente.setBounds(119, 219, 50, 25);
				tab2.add(btnModificarCliente);
				
				JButton btnEliminarCliente = new JButton("");
				btnEliminarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminarCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnEliminarCliente.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\eliminar.png"));
				btnEliminarCliente.setBounds(35, 275, 50, 25);
				tab2.add(btnEliminarCliente);
				
				JButton btnNuevoC = new JButton("");
				btnNuevoC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNuevoC.setBackground(Color.GREEN);
				btnNuevoC.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnNuevoC.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\nuevo.png"));
				btnNuevoC.setBounds(119, 275, 50, 25);
				tab2.add(btnNuevoC);
				
				JPanel tab3 = new JPanel();
				tabbedPaneA.addTab("New tab", null, tab3, null);
				tab3.setLayout(null);
				
				JScrollPane scrollProveedor = new JScrollPane();
				scrollProveedor.setBorder(new LineBorder(Color.BLACK));
				scrollProveedor.setBounds(10, 75, 619, 272);
				tab3.add(scrollProveedor);
				
				tbModelProveedor = new DefaultTableModel();
				
				String TitulosProveedor [] = {"ID","RUC","NOMBRE","TELEFONO","DIRECCION","RAZON","FECHA"};
				tbModelProveedor.setColumnIdentifiers(TitulosProveedor);
				
				tbProveedor = new JTable(tbModelProveedor);
				tbProveedor.setBounds(10, 75, 619, 272);
				scrollProveedor.add(tbProveedor);
				
				tbModelProveedor = (DefaultTableModel) tbProveedor.getModel();
				scrollProveedor.setViewportView(tbProveedor);
				
				JLabel lblNewLabel_22 = new JLabel("RUC");
				lblNewLabel_22.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_22.setHorizontalTextPosition(SwingConstants.CENTER);
				lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_22.setBounds(10, 11, 46, 14);
				tab3.add(lblNewLabel_22);
				
				JLabel lblNewLabel_23 = new JLabel("NOMBRE");
				lblNewLabel_23.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_23.setBounds(86, 11, 75, 14);
				tab3.add(lblNewLabel_23);
				
				JLabel lblNewLabel_24 = new JLabel("TELEFONO");
				lblNewLabel_24.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_24.setBounds(177, 11, 66, 14);
				tab3.add(lblNewLabel_24);
				
				JLabel lblNewLabel_25 = new JLabel("DIRECCION");
				lblNewLabel_25.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_25.setBounds(271, 11, 93, 14);
				tab3.add(lblNewLabel_25);
				
				JLabel lblNewLabel_26 = new JLabel("RAZON");
				lblNewLabel_26.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_26.setBounds(374, 11, 46, 14);
				tab3.add(lblNewLabel_26);
				
				JLabel lblNewLabel_27 = new JLabel("FECHA");
				lblNewLabel_27.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_27.setBounds(471, 11, 46, 14);
				tab3.add(lblNewLabel_27);
				
				txtRuc = new JTextField();
				txtRuc.setBounds(10, 36, 56, 20);
				tab3.add(txtRuc);
				txtRuc.setColumns(10);
				
				txtNombreProvee = new JTextField();
				txtNombreProvee.setBounds(75, 36, 86, 20);
				tab3.add(txtNombreProvee);
				txtNombreProvee.setColumns(10);
				
				txtTelefonoProvee = new JTextField();
				txtTelefonoProvee.setBounds(171, 36, 86, 20);
				tab3.add(txtTelefonoProvee);
				txtTelefonoProvee.setColumns(10);
				
				txtDireccionProvee = new JTextField();
				txtDireccionProvee.setBounds(264, 36, 86, 20);
				tab3.add(txtDireccionProvee);
				txtDireccionProvee.setColumns(10);
				
				txtRazonProvee = new JTextField();
				txtRazonProvee.setBounds(360, 36, 75, 20);
				tab3.add(txtRazonProvee);
				txtRazonProvee.setColumns(10);
				
				JDateChooser dtProveed = new JDateChooser();
				dtProveed.setBounds(445, 36, 97, 20);
				tab3.add(dtProveed);
				
				JButton btnNewButton_2 = new JButton("GUARDAR");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardarProveedor();
						limpiarTablas();
						cargarTablaProveedor();
					}
				});
				btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 9));
				btnNewButton_2.setBounds(552, 36, 76, 22);
				tab3.add(btnNewButton_2);
				cargarTablaProveedor();
				
				tbModelNuevaV = (DefaultTableModel) tbproducto.getModel();
				SCRProd.setViewportView(tbproducto);
						
				JPanel tab5 = new JPanel();
				tabbedPaneA.addTab("New tab", null, tab5, null);
				tab5.setLayout(null);
				
				JScrollPane SCVentas = new JScrollPane();
				SCVentas.setBorder(new LineBorder(Color.BLACK));
				SCVentas.setBounds(10, 63, 619, 188);
				tab5.add(SCVentas);
				
				tbVentas = new JTable(modeloTbVentas);
				tbVentas.setBounds(10, 63, 619, 188);
				
				modeloTbVentas = (DefaultTableModel) tbVentas.getModel();
				SCVentas.setViewportView(tbVentas);
				
				JButton btnPDFVentas = new JButton("");
				btnPDFVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnPDFVentas.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnPDFVentas.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\pdf.png"));
				btnPDFVentas.setBounds(10, 25, 30, 30);
				tab5.add(btnPDFVentas);
				
				txtIdVentas = new JTextField();
				txtIdVentas.setBorder(new LineBorder(Color.BLACK));
				txtIdVentas.setBounds(56, 32, 86, 20);
				tab5.add(txtIdVentas);
				txtIdVentas.setColumns(10);
				
				
				JPanel tab6 = new JPanel();
				tabbedPaneA.addTab("New tab", null, tab6, null);
				tab6.setLayout(null);
				
				JLabel lblNewLabel_12 = new JLabel("RUC");
				lblNewLabel_12.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_12.setBounds(10, 104, 132, 14);
				tab6.add(lblNewLabel_12);
				
				JLabel lblNewLabel_13 = new JLabel("NOMBRE DE LA EMPRESA");
				lblNewLabel_13.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_13.setBounds(175, 104, 183, 14);
				tab6.add(lblNewLabel_13);
				
				JLabel TXT = new JLabel("TELEFONO");
				TXT.setFont(new Font("Roboto", Font.BOLD, 13));
				TXT.setHorizontalAlignment(SwingConstants.CENTER);
				TXT.setBounds(384, 104, 121, 14);
				tab6.add(TXT);
				
				JLabel lblNewLabel_15 = new JLabel("DIRECCION");
				lblNewLabel_15.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_15.setBounds(106, 193, 86, 14);
				tab6.add(lblNewLabel_15);
				
				JLabel lblNewLabel_16 = new JLabel("R ZOCIAL");
				lblNewLabel_16.setFont(new Font("Roboto", Font.BOLD, 13));
				lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_16.setBounds(332, 193, 86, 14);
				tab6.add(lblNewLabel_16);
				
				textField_12 = new JTextField();
				textField_12.setBorder(new LineBorder(new Color(0, 0, 0)));
				textField_12.setBounds(10, 122, 132, 20);
				tab6.add(textField_12);
				textField_12.setColumns(10);
				
				textField_13 = new JTextField();
				textField_13.setBorder(new LineBorder(new Color(0, 0, 0)));
				textField_13.setBounds(175, 122, 183, 20);
				tab6.add(textField_13);
				textField_13.setColumns(10);
				
				textField_14 = new JTextField();
				textField_14.setBorder(new LineBorder(new Color(0, 0, 0)));
				textField_14.setBounds(384, 122, 121, 20);
				tab6.add(textField_14);
				textField_14.setColumns(10);
				
				textField_15 = new JTextField();
				textField_15.setBorder(new LineBorder(new Color(0, 0, 0)));
				textField_15.setBounds(106, 214, 86, 20);
				tab6.add(textField_15);
				textField_15.setColumns(10);
				
				textField_16 = new JTextField();
				textField_16.setBorder(new LineBorder(new Color(0, 0, 0)));
				textField_16.setBounds(332, 214, 86, 20);
				tab6.add(textField_16);
				textField_16.setColumns(10);
				
				JButton btnNewButton_3 = new JButton("ACTUALIZAR");
				btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnNewButton_3.setFont(new Font("Roboto", Font.BOLD, 14));
				btnNewButton_3.setBounds(203, 267, 140, 23);
				tab6.add(btnNewButton_3);
				
				JLabel lblNewLabel_14 = new JLabel("DATOS DE LA EMPRESA");
				lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_14.setFont(new Font("Roboto Black", Font.BOLD, 18));
				lblNewLabel_14.setBounds(131, 37, 257, 14);
				tab6.add(lblNewLabel_14);
				
				ImageIcon imgEncabezado = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\MI ENCABEZADO-BUENO.png");
				ImageIcon imgEncabezado2 = new ImageIcon(imgEncabezado.getImage().getScaledInstance(644, 75, Image.SCALE_SMOOTH));
				
				JLabel lblNewLabel_28 = new JLabel("X");
				lblNewLabel_28.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				lblNewLabel_28.setVerticalTextPosition(SwingConstants.TOP);
				lblNewLabel_28.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_28.setBackground(Color.WHITE);
				lblNewLabel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblNewLabel_28.setHorizontalTextPosition(SwingConstants.CENTER);
				lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_28.setFont(new Font("Roboto", Font.BOLD, 18));
				lblNewLabel_28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel_28.setBounds(615, 0, 29, 30);
				panel_2.add(lblNewLabel_28);
				
				JLabel lblNewLabel_29 = new JLabel("CERRAR");
				lblNewLabel_29.setVerticalTextPosition(SwingConstants.TOP);
				lblNewLabel_29.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_29.setFont(new Font("Roboto", Font.PLAIN, 6));
				lblNewLabel_29.setBounds(617, 21, 27, 9);
				panel_2.add(lblNewLabel_29);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBackground(Color.GREEN);
				lblNewLabel.setIcon(imgEncabezado2);
				lblNewLabel.setBounds(0, 0, 644, 75);
				panel_2.add(lblNewLabel);
				
	}

	protected void guardarProveedor() {
		
		if (txtNombreProvee.getText().isBlank() || txtTelefonoProvee.getText().isBlank() || txtRazonProvee.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Los campos Nombre y Descripción son requeridos.");
            return;
        }
		
		var proveedor = new Proveedor(txtRuc.getText(), txtNombreProvee.getText(), txtTelefonoProvee.getText(), txtDireccionProvee.getText(), txtRazonProvee.getText());
	
	
	}

//	protected void guardarCliente() {
//			
//	        if (txtUsuario.getText().isBlank() || txtContrasena.getText().isBlank()) {
//	            JOptionPane.showMessageDialog(this, "Los campos Nombre y Descripción son requeridos.");
//	            return;
//	        }
//
//	        var usuario = new Usuario(txtUsuario.getText(),String.valueOf(txtContrasena.getText()));
//	        
//
//	        this.usuarioController.guardar(usuario);
//			
//	        JOptionPane.showMessageDialog(this, "Registrado con éxito!");
//
//	        this.limpiarFormulario();
//	    }
//			
//		private void limpiarFormulario() {
//			this.txtUsuario.setText("");
//			this.txtContrasena.setText("");
//		
//	}
	
	protected void modificarProduct() {
	        if (tieneFilaElegida()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }

	        Optional.ofNullable(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), tbproducto.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer id = Integer.valueOf(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 0).toString());
	                    String codigo = (String) tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 1);
	                    String descripcion = (String) tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 2);
	                    Integer proveedor = Integer.valueOf(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 3).toString());
	                    Integer cantidad = Integer.valueOf(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 4).toString());
	                    Double precio = Double.valueOf(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 5).toString());
	                    var filasModificadasPModif = this.productController.modificar(codigo, descripcion, proveedor, cantidad, precio, id);
	                    
	                    JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filasModificadasPModif));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	    }
		
//	}

	private boolean tieneFilaElegida() {
        return tbproducto.getSelectedRowCount() == 0 || tbproducto.getSelectedColumnCount() == 0;
    }

	protected void EliminarProducto() {
		        if (tieneFilaElegida()) {
		            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
		            return;
		        }

		        Optional.ofNullable(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), tbproducto.getSelectedColumn()))
		                .ifPresentOrElse(fila -> {
		                    Integer id = (Integer.valueOf(tbModelProducto.getValueAt(tbproducto.getSelectedRow(), 0).toString()));
		                    
		                  var filasModificadasProduct = this.productController.eliminar(id);

		                    tbModelProducto.removeRow(tbproducto.getSelectedRow());

		                    JOptionPane.showMessageDialog(this, 
		                    		String.format("Item %d eliminado con éxito!", filasModificadasProduct));
		                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	protected void limpiarFormulario() {
		txtCodProduc.setText("");
		txtDescripProduct.setText("");
		txtCantidadProduct.setText("");
		txtPrecioProduct.setText("");
		
	}

	protected void limpiarTablas() {
//		tbModelNuevaV.getDataVector().clear();
		tbModelProducto.getDataVector().clear();
		
	}

	private void cargarTablaProductos() {
		limpiarTablas();
		
		var cargarProduct = this.productController.cargarProduct();	
	      
        cargarProduct.forEach(producto -> tbModelProducto.addRow(new Object[] {
        		producto.getId(), 
        		producto.getCodigo(),
        		producto.getNombre(),
        		producto.getProveedor(),
        		producto.getCantidad(),
        		producto.getPrecio(),
        		producto.getFecha()
        		
            		 }));
    }
		

	protected void guardarProducto() {
		if (txtCodProduc.getText().isBlank() || txtDescripProduct.getText().isBlank() || txtCantidadProduct.getText().isBlank() || 
				txtPrecioProduct.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Los campos codigo, cantidad, descripcion y proveedor son requeridos.");
			return;
		}
		
		Integer cantidadProduct = Integer.parseInt(txtCantidadProduct.getText());
		
		var producto = new Producto(txtCodProduc.getText(), txtDescripProduct.getText(), cantidadProduct, txtPrecioProduct.getText());
		
		var proveedor = (Proveedor) cmbProveedor.getSelectedItem();
		
		this.productController.guardar(producto, proveedor.getId());
		
		JOptionPane.showMessageDialog(this, "Registrado con éxito!");

//        this.limpiarFormulario();
	}
	
	
	private void cargarTablaProveedor() {
		

		tbModelProveedor.getDataVector().clear();
		
	     var verVerPROVEEDOR = this.proveedorcontroller.mostrarCmb();	
	      
	        verVerPROVEEDOR.forEach(mirarReserv -> tbModelProveedor.addRow(new Object[] {
	        		mirarReserv.getId(), 
	        		mirarReserv.getRuc(),
	        		mirarReserv.getNombre(),
	        		mirarReserv.getTelefono(),
	        		mirarReserv.getDireccion(),
	        		mirarReserv.getRazon(),
	        		mirarReserv.getFecha()
	            		 }));
	    }
	
	
}
