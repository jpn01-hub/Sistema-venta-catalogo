/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Detalle;
import Modelo.Eventos;
import Modelo.LoginDAO;
import Modelo.Productos;
import Modelo.ProductosDao;
import Modelo.Venta;
import Modelo.VentaDao;
import Modelo.login;

public final class Sistema_cliente extends javax.swing.JFrame {
	LocalDate fecha = LocalDate.now();
   // String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    Cliente cl = new Cliente();
    ClienteDao client = new ClienteDao();
    Productos pro = new Productos();
    ProductosDao proDao = new ProductosDao();
    Venta v = new Venta();
    VentaDao Vdao = new VentaDao();
    Detalle Dv = new Detalle();
    Eventos event = new Eventos();
    login lg = new login();
    LoginDAO login = new LoginDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

    int item;
    double Totalpagar = 0.00;
    public Sistema_cliente() {
        initComponents();
    }
    public Sistema_cliente (login priv){
    	lg=priv;
    	cl =client.BuscarclienteLg(priv.getId());
        initComponents();
        this.setLocationRelativeTo(null);
            LabelVendedor.setText(priv.getNombre());
    }

    public void ListarVentas() {
        List<Venta> ListarVenta = Vdao.Listarventas();
        modelo = (DefaultTableModel) TableVentas.getModel();
        Object[] ob = new Object[4];
        int id=cl.getId();
        for (Venta element : ListarVenta) {
        	if(id==element.getCliente()){
        		ob[0] = element.getId();
	            ob[1] = element.getNombre_cli();
	            ob[2] = element.getVendedor();
	            ob[3] = element.getTotal();
	            modelo.addRow(ob);
        	}


        }
        TableVentas.setModel(modelo);
    }


    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        btnNuevaCompra = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        btnUsuario.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/usuario.png")));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/encabezado.png")));
        jLabel2.setText("NOMBRE");
        jLabel2.setBackground(new Color(128, 128, 128));
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNombre.setEditable(false);
    	panelCarrito = new JPanel();
    	scrollPane2 = new JScrollPane(listaProductos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setResizable(false);

        jPanel1.setBackground(new Color(112, 112, 112));
        jLabel1.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/cesta-de-mano.png"))); // NOI18N

        btnNuevaCompra.setBackground(new Color(192, 192, 192));
        btnNuevaCompra.setForeground(new Color(0, 0, 0));
        btnNuevaCompra.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/bolsa.png"))); // NOI18N
        btnNuevaCompra.setText("Nueva Compra");
        btnNuevaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCompra.setFocusable(false);
        btnNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new Color(192, 192, 192));
        btnVentas.setForeground(new Color(0, 0, 0));
        btnVentas.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/cesta.png"))); // NOI18N
        btnVentas.setText("Historial");
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setFocusable(false);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnUsuario.setBackground(new Color(192, 192, 192));
        btnUsuario.setForeground(new Color(0, 0, 0));
        btnUsuario.setText("Usuario");
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.setFocusable(false);
       btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LabelVendedor.setForeground(new java.awt.Color(255, 255, 255));
        LabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVendedor.setText("Nombre del cliente");
        tipo.setForeground(new java.awt.Color(255, 255, 255));

        btnSalir = new JButton("Salir");
        btnSalir.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/cerrar-sesion.png")));
        btnSalir.setBackground(new Color(192, 192, 192));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		Login lg = new Login();
                lg.setVisible(true);
                dispose();
        	}
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(btnNuevaCompra, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        		.addComponent(LabelVendedor, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(74)
        			.addComponent(tipo)
        			.addContainerGap(126, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(39, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(33))
        		.addComponent(btnVentas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        		.addComponent(btnUsuario, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        		.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(34)
        			.addComponent(LabelVendedor)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(tipo)
        			.addGap(8)
        			.addComponent(btnNuevaCompra, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnUsuario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
        			.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 560));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 870, 130));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new Color(192, 192, 192));

       List<Productos> productos=proDao.ListarProductos();
    // Creamos el panel de productos y lo agregamos al scroll pane
       JPanel panelProductos = new JPanel(new GridLayout(0, 3, 1, 1));
       for (Productos producto : productos) {
           panelProductos.add(crearComponenteProducto(producto));
       }

       JScrollPane scrollPane = new JScrollPane(panelProductos);
       scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


       JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, null);
       splitPane.setOneTouchExpandable(true);
       splitPane.setDividerLocation(0.5);


       JScrollPane scrollPaneCarrito = new JScrollPane(panelCarrito);
       scrollPaneCarrito.setBorder(BorderFactory.createTitledBorder("Productos agregados al carrito"));
    // Agregamos el segundo scroll pane al JSplitPane
       splitPane.setRightComponent(scrollPaneCarrito);

       // Agregamos el scroll pane al panel principal
       jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       BorderLayout bl_jPanel2 = new BorderLayout();
       bl_jPanel2.setVgap(2);
       jPanel2.setLayout(bl_jPanel2);
       jPanel2.add(splitPane, BorderLayout.CENTER);


        jTabbedPane1.addTab("4", jPanel2);

        panelComprar = new JPanel();
        jPanel2.add(panelComprar, BorderLayout.SOUTH);
        labelTotal = new JLabel("0.00");

        btncomprar = new JButton("comprar");
        btncomprar.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		if(listaProductos.getModel().getSize() > 0) {

        		 RegistrarVenta();
                 RegistrarDetalle();
        		}

        	}
        });

        JLabel lblNewLabel = new JLabel("Total a Pagar:");
        lblNewLabel.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/money.png")));
        GroupLayout gl_panelComprar = new GroupLayout(panelComprar);
        gl_panelComprar.setHorizontalGroup(
        	gl_panelComprar.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelComprar.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelTotal, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        			.addGap(472)
        			.addComponent(btncomprar)
        			.addGap(78))
        );
        gl_panelComprar.setVerticalGroup(
        	gl_panelComprar.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelComprar.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panelComprar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(labelTotal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btncomprar))
        			.addContainerGap())
        );
        panelComprar.setLayout(gl_panelComprar);

        jPanel3.setBackground(new Color(192, 192, 192));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        TableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableVentasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableVentas);
        if (TableVentas.getColumnModel().getColumnCount() > 0) {
            TableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 766, 310));

        btnPdfVentas.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/descargar-pdf.png"))); // NOI18N
        btnPdfVentas.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfVentasActionPerformed(evt);
            }
        });
        jPanel3.add(btnPdfVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));
        jPanel3.add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 46, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Historial Ventas");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 280, -1));

        jTabbedPane1.addTab("5", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.setBackground(new Color(166, 166, 166));

        jLabel33.setIcon(new ImageIcon(Sistema_cliente.class.getResource("/Img/usuario-e.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new Color(0, 0, 0));
        jLabel34.setText("Correo Electr\u00F3nico");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new Color(0, 0, 0));
        jLabel35.setText("Password");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnIniciar.setBackground(new Color(192, 192, 192));
        btnIniciar.setForeground(new Color(0, 0, 0));
        btnIniciar.setText("Actualizar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new Color(0, 0, 0));
        jLabel36.setText("Nombre:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13Layout.setHorizontalGroup(
        	jPanel13Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel13Layout.createSequentialGroup()
        			.addContainerGap(30, Short.MAX_VALUE)
        			.addGroup(jPanel13Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel13Layout.createSequentialGroup()
        					.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnIniciar)
        						.addComponent(jLabel36)
        						.addComponent(jLabel35)
        						.addComponent(jLabel34)
        						.addComponent(txtCorreo, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        						.addComponent(txtPass, 226, 226, 226)
        						.addComponent(txtNombre, 226, 226, 226))
        					.addGap(24))
        				.addGroup(jPanel13Layout.createSequentialGroup()
        					.addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        					.addGap(71))))
        );
        jPanel13Layout.setVerticalGroup(
        	jPanel13Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel13Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel33)
        			.addGap(18)
        			.addComponent(jLabel34)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel35)
        			.addGap(2)
        			.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel36)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
        			.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel13.setLayout(jPanel13Layout);

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 380));

        jTabbedPane1.addTab("7", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 95, 860, 460));

        botonEliminar.addActionListener(e -> {
            int indiceSeleccionado = listaProductos.getSelectedIndex();
            if (indiceSeleccionado >= 0) {
                carrito.remove(indiceSeleccionado);
                actualizarListaCarrito();
                actualizarTotal();
            }
        });

        listaProductos.addListSelectionListener(e -> {
            if (!listaProductos.isSelectionEmpty()) {
                botonEliminar.setEnabled(true);
            } else {
                botonEliminar.setEnabled(false);
            }
        });

       // panelCarrito.add(labelTotal, BorderLayout.SOUTH);


        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        LimpiarTable();
        ListarVentas();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    	txtCorreo.setText(lg.getCorreo());
    	txtPass.setText(String.valueOf(lg.getPass()));
    	txtNombre.setText(lg.getNombre());
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        if(txtNombre.getText().equals("") || txtCorreo.getText().equals("") || txtPass.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
        }else{
            String correo = txtCorreo.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String nom = txtNombre.getText();
            lg.setNombre(nom);
            lg.setCorreo(correo);
            lg.setPass(pass);
            login.Actualizar(lg);
            JOptionPane.showMessageDialog(null, "Usuario Actualizado");

        }
    }//GEN-LAST:event_btnIniciarActionPerformed
    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnPdfVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfVentasActionPerformed

        if(txtIdVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }else{
            v = Vdao.BuscarVenta(Integer.parseInt(txtIdVenta.getText()));
            Vdao.pdfV(v.getId(), v.getCliente(), v.getTotal(), v.getVendedor());
        }
    }//GEN-LAST:event_btnPdfVentasActionPerformed

    private void TableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVentasMouseClicked
        // TODO add your handling code here:
        int fila = TableVentas.rowAtPoint(evt.getPoint());
        txtIdVenta.setText(TableVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TableVentasMouseClicked


    //////////////////////////////////////////////////////////////////////////////////////////////
    private void RegistrarVenta() {
        int cliente = cl.getId();
        String vendedor = "Sistema";
        String numeroTotal = labelTotal.getText();
        double total = Double.parseDouble(numeroTotal);

        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(total);
        v.setFecha(fechaActual);
        Vdao.RegistrarVenta(v);
    }
    private void RegistrarDetalle() {
        int id = Vdao.IdVenta();

        for (int i = 0; i < modeloLista.size(); i++) {
            Productos producto = modeloLista.getElementAt(i);
            // Aquí puedes hacer lo que necesites con los detalles del producto
            int cant=contarProducto(producto);
            Dv.setId_pro(producto.getId());
            Dv.setCantidad(cant);
            Dv.setPrecio(producto.getPrecio());
            Dv.setId(id);
            ActualizarStock(producto.getId(),cant);
            Vdao.RegistrarDetalle(Dv);
        }
        int cliente = cl.getId();
        Vdao.pdfV(id, cliente, Totalpagar, "Sistema");
    }

    private int contarProducto(Productos producto) {
        int cantidad = 0;
        for (int i = 0; i < modeloLista.size(); i++) {
            if (modeloLista.getElementAt(i).equals(producto)) {
                cantidad++;
            }
        }
        return cantidad;
    }
    private void ActualizarStock(int id,int cant) {

            pro = proDao.BuscarId(id);
            int StockActual = pro.getStock() - cant;
            Vdao.ActualizarStock(StockActual, id);


    }
   ////////////////////////////////////////////////////////////////
    private JPanel crearComponenteProducto(Productos producto) {
    	JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
        Border bordeInterior = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(BorderFactory.createCompoundBorder(bordeNegro, bordeInterior));

        // Cargamos la imagen del producto desde la ruta de la imagen
        if (producto.getImg() != null) {
            try {
                BufferedImage imagen = ImageIO.read(new File(producto.getImg()));
                Image imagenRedimensionada = imagen.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                JLabel labelImagen = new JLabel(new ImageIcon(imagenRedimensionada));
                panel.add(labelImagen, BorderLayout.CENTER);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Agregamos el nombre y el precio del producto
        JLabel labelNombre = new JLabel(producto.getNombre());
        JLabel labelStock = new JLabel(producto.getStock()+" disponible");
        JLabel labelPrecio = new JLabel(String.format("$%.2f", producto.getPrecio()));
        JPanel panelInfo = new JPanel(new GridLayout(0, 1, 5, 5));
        panelInfo.add(labelNombre);
        panelInfo.add(labelPrecio);
        panelInfo.add(labelStock);
        panel.add(panelInfo, BorderLayout.SOUTH);

        // Agregamos un botón para agregar el producto al carrito
        JButton botonAgregar = new JButton("Agregar al carrito");
        botonAgregar.addActionListener(e -> agregarAlCarrito(producto));
        panel.add(botonAgregar, BorderLayout.EAST);

        return panel;
    }


    private void agregarAlCarrito(Productos producto) {
    	panelCarrito.setLayout(new BoxLayout(panelCarrito, BoxLayout.Y_AXIS));
    	//panelCarrito.setBorder(BorderFactory.createTitledBorder("Carrito"));
    	panelCarrito.add(scrollPane2);
    	botonEliminar.setEnabled(false);

    	panelCarrito.add(botonEliminar);

    	carrito.add(producto); // Agregar producto al carrito
        actualizarListaCarrito(); // Actualizar la lista de productos en el carrito
        actualizarTotal(); // Actualizar el total del carrito


    }
    private void actualizarListaCarrito() {
        modeloLista.clear();
        for (Productos producto : carrito) {
            modeloLista.addElement(producto);
        }
    }
    private void actualizarTotal() {
        double total = 0;
        for (Productos producto : carrito) {
            total += producto.getPrecio();
        }
        labelTotal.setText(String.valueOf(total));
    }




    private  List<Productos> carrito = new ArrayList<>();
    DefaultListModel<Productos> modeloLista = new DefaultListModel<>();
    private  JList<Productos> listaProductos = new JList<>(modeloLista);
    private  JLabel labelTotal;

    private JScrollPane scrollPane2;
    private  JButton botonEliminar = new JButton("Eliminar");
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JTable TableVentas;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnNuevaCompra;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnVentas;
    private JButton btnSalir;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;

    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel tipo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private JPanel panelCarrito;
    private JPanel panelComprar;
    private JButton btncomprar;
}
