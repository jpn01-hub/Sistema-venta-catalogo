
package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.LoginDAO;
import Modelo.login;

public class Login extends javax.swing.JFrame {

    // Declaración de variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPass;

    //fin de declaracion de variables

    login lg = new login();
    LoginDAO login = new LoginDAO();

    Cliente cl= new Cliente();
    ClienteDao clDao= new ClienteDao();
    private JButton btnRegistrarse;

    public Login() {
    	btnRegistrarse = new JButton("Registrarse");
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void validar(){
        String correo = txtCorreo.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if (!"".equals(correo) || !"".equals(pass)) {
            lg = login.log(correo, pass);
            if (lg.getCorreo()!= null && lg.getPass() != null) {
            	if("Cliente".equals(lg.getRol())){
            		Sistema_cliente sisC=new Sistema_cliente(lg);
            		sisC.setVisible(true);
            		dispose();

            	}else {
            		Sistema sis = new Sistema(lg);
	                sis.setVisible(true);
	                dispose();
            	}

            }else{
                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
            }
        }
    }
    /**
     * Este método se llama desde dentro del constructor para inicializar el formulario..
     * regenerado por el Editor de formularios.
     */
    private void initComponents() {
     	login.obtenerID("maria@mail.com");
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(160, 10, 128, 128);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(30, 102, 128, 17);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(30, 175, 80, 17);
        txtCorreo = new javax.swing.JTextField();
        txtCorreo.setBounds(30, 132, 226, 30);
        txtPass = new javax.swing.JPasswordField();
        txtPass.setBounds(30, 199, 226, 30);
        btnIniciar = new javax.swing.JButton();
        btnIniciar.setBounds(103, 239, 106, 34);
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new Color(128, 128, 128));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iniciar Sesión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new ImageIcon(Login.class.getResource("/Img/usuario-iniciar.png"))); // NOI18N
        jPanel2.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(0, 0, 0));
        jLabel3.setText("Correo Electr\u00F3nico");
        jPanel2.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Contrase\u00F1a");
        jPanel2.add(jLabel4);

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo);
        jPanel2.add(txtPass);

        btnIniciar.setBackground(new Color(255, 255, 255));
        btnIniciar.setForeground(new Color(0, 0, 0));
        btnIniciar.setText("Ingresar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 280, 380));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 99, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel5.setLayout(jPanel5Layout);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 40, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 420));

        jLabel1.setIcon(new ImageIcon(Login.class.getResource("/Img/login1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 240, 420));
        btnRegistrarse.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRegistrarse.setBackground(new Color(255, 255, 255));
        btnRegistrarse.setBounds(103, 284, 106, 30);
        jPanel2.add(btnRegistrarse);

        pack();

        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el panel que se mostrará en el JOptionPane
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(6, 1));

                panel.add(new JLabel("Din/Rnc:"));
                JTextField dniTextField = new JTextField();
                panel.add(dniTextField);

                panel.add(new JLabel("Nombre:"));
                JTextField nombreTextField = new JTextField();
                panel.add(nombreTextField);

                panel.add(new JLabel("Dirección:"));
                JTextField direccionTextField = new JTextField();
                panel.add(direccionTextField);

                panel.add(new JLabel("Teléfono:"));
                JTextField telTextField = new JTextField();
                panel.add(telTextField);

                panel.add(new JLabel("Correo:"));
                JTextField correoTextField = new JTextField();
                panel.add(correoTextField);

                panel.add(new JLabel("Contraseña:"));
                JPasswordField contrTextField = new JPasswordField();
                panel.add(contrTextField);

                // Mostrar el JOptionPane con el panel
                int opcion = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Registrarse",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Registrar", "Cancelar"},
                    "Registrar");

                // Si se presionó el botón "Registrar", obtener los valores del panel
                if (opcion == JOptionPane.OK_OPTION) {
                	int id;
                	lg.setCorreo(correoTextField.getText());
                	lg.setPass(String.valueOf(contrTextField.getPassword()));
                	lg.setNombre(nombreTextField.getText());
                	lg.setRol("Cliente");
                	login.Registrar(lg);
                	id=login.obtenerID(correoTextField.getText());
                	lg.setId(id);

                    //registrat cliente
                	cl.setDireccion(direccionTextField.getText());
                	cl.setDni(dniTextField.getText());
                	cl.setId_usuario(id);
                	cl.setNombre(nombreTextField.getText());
                	cl.setTelefono(telTextField.getText());
                	clDao.RegistrarCliente(cl);
                	///////////////////////////////////////////
                	txtCorreo.setText(correoTextField.getText());
                    txtPass.setText(String.valueOf(contrTextField.getPassword()));


                }
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
      validar();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

}
