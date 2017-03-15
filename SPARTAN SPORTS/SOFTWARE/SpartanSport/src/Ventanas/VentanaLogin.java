/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;
import javax.swing.*;

import transfer.TipoUsuario;
import transfer.TransferUsuario;
import Usuarios.ControladorUsuarios;

public class VentanaLogin extends JPanel {

	//Atributos graficos.
    private JButton bEntrar;
    private JLabel ePass;
    private JLabel eUser;
    private JPanel jPanel1;
    private JLabel logoSpartan;
    private JPasswordField tPassword;
    protected JTextField tUsuario;
    
    private JFrame ventanaPrincipal;
    private ControladorUsuarios c;

    public VentanaLogin(JFrame v) {
	c = new ControladorUsuarios();
    	this.ventanaPrincipal = v;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Login");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoSpartan = new javax.swing.JLabel();
        eUser = new javax.swing.JLabel();
        ePass = new javax.swing.JLabel();
        tUsuario = new javax.swing.JTextField();
        bEntrar = new javax.swing.JButton();
        tPassword = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        logoSpartan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo principal.png"))); // NOI18N

        eUser.setText("Usuario:");

        ePass.setText("Contraseña:");

        tUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUsuarioActionPerformed(evt);
            }
        });

        tPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPasswordActionPerformed(evt);
            }
        });
        bEntrar.setText("Entrar");
        bEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(logoSpartan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ePass)
                            .addComponent(eUser))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tPassword)
                            .addComponent(tUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(bEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoSpartan)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ePass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(bEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	if(tUsuario.getText().equals("") || !isNumeric(tUsuario.getText()) ||
    			tUsuario.getText().length() != 8 || tPassword.getPassword().equals("")) {
    		
    		JOptionPane.showMessageDialog(null,
    				"Debes rellenar todos los campos, además el usuario debe ser el DNI sin letra", 
    				"Error en el login", 
    				JOptionPane.CANCEL_OPTION);
    		
    	} else { 
    		
	        String user = tUsuario.getText();
	        int dni = Integer.parseInt(user);
	        String pass = tPassword.getText();
	        
	        TransferUsuario usuarioInicial = new TransferUsuario(dni, pass);
	        
	        if(this.c.login(usuarioInicial)) {
	        	
	        	TipoUsuario tipo = usuarioInicial.getTipoUser();
	        	
		        if(tipo == TipoUsuario.ADMINISTRADOR) {
		        	new InicioAdmin(usuarioInicial, this.ventanaPrincipal);
		        }
		        else if (tipo == TipoUsuario.CLIENTE) {
		        	new InicioUser(usuarioInicial, this.ventanaPrincipal);
		        }
		        
	        } else {
	        	JOptionPane.showMessageDialog(null,
	        			"Usuario o contraseña incorrectos",
	        			"Error en el login",
	        			JOptionPane.ERROR_MESSAGE);
	        }
	        
    	}
    	
       
    }
	private static boolean isNumeric(String cadena){
		//Declaracion.
		boolean resultado;
		
		
			//Inicializacion.
			resultado = false;
			
		
		try{
			Integer.parseInt(cadena);
			resultado = true;
		}
		catch(NumberFormatException nfe){
			resultado = false;
		}
		return resultado;
	}

	private void tPasswordActionPerformed(java.awt.event.ActionEvent evt) {
		bEntrarActionPerformed(evt);
	}
	
    private void tUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
    	bEntrarActionPerformed(evt);
    }
    
}
