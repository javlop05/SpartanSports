/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import java.awt.Color;

import javax.swing.*;

import Usuarios.ControladorUsuarios;
import transfer.TipoUsuario;
import transfer.TransferUsuario;

public class AltaUser extends JPanel {
	
	//Atributos graficos. 
	private JButton bAtrasGestionUsuarios;
	private JButton bCancel;
	private JButton bSave;
	private JLabel eDomicilio;
	private JLabel eNif;
	private JLabel eNombre;
	private JLabel ePass;
	private JLabel logoSuperior;
	private JTextField tDomicilio;
	private JTextField tNif;
	private JTextField tNombre;
	private JTextField tPass;
	
	private JFrame ventanaPrincipal;
	private TransferUsuario usuario;
	private TransferUsuario existente; 
	private ControladorUsuarios c;
	
    public AltaUser(TransferUsuario usuario, TransferUsuario existente, JFrame v) {
    	this.c = new ControladorUsuarios();
    	this.ventanaPrincipal = v;
    	this.usuario = usuario;
    	this.existente = existente;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Alta/Modificacion usuario");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents() {

        bAtrasGestionUsuarios = new javax.swing.JButton();
        logoSuperior = new javax.swing.JLabel();
        ePass = new javax.swing.JLabel();
        eNif = new javax.swing.JLabel();
        eDomicilio = new javax.swing.JLabel();
        tPass = new javax.swing.JTextField();
        tNif = new javax.swing.JTextField();
        tDomicilio = new javax.swing.JTextField();
        bSave = new javax.swing.JButton();
        eNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        bCancel = new javax.swing.JButton();

        bAtrasGestionUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Atras.png"))); // NOI18N
        bAtrasGestionUsuarios.setBorder(null);
        bAtrasGestionUsuarios.setBorderPainted(false);
        bAtrasGestionUsuarios.setContentAreaFilled(false);
        bAtrasGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAtrasGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasGestionUsuariosActionPerformed(evt);
            }
        });

        logoSuperior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo nuevo user.png"))); // NOI18N

        ePass.setText("Contraseña");

        eNif.setText("NIF (Sin letra)");

        eDomicilio.setText("Domicilio");
        
        if(existente != null) {
        	Integer dni = existente.getDni();
        	this.tNombre.setText(existente.getNombre());
        	this.tNif.setText(dni.toString());
        	tNif.disable();
        	tNif.setDisabledTextColor(Color.black);
        	this.tPass.setText(existente.getPass());
        	this.tDomicilio.setText(existente.getDomicilio());	
        }
        tPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPassActionPerformed(evt);
            }
        });

        tNif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNifActionPerformed(evt);
            }
        });

        tDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDomicilioActionPerformed(evt);
            }
        });

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISGuardarCambios.png"))); // NOI18N
        bSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        eNombre.setText("Nombre");

        tNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNombreActionPerformed(evt);
            }
        });

        bCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISCancelar.png"))); // NOI18N
        bCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAtrasGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoSuperior)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eNif)
                            .addComponent(eDomicilio)
                            .addComponent(ePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(tPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(tNif, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tDomicilio, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoSuperior)
                    .addComponent(bAtrasGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(eNif))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eDomicilio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        new GestionUsuarios(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void tPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPassActionPerformed

    private void tNifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNifActionPerformed

    private void tDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tDomicilioActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
    	String domicilio, nombre, pass, nif;
        int dni;
        
        
        domicilio = this.tDomicilio.getText();
        nombre = this.tNombre.getText();
        pass = this.tPass.getText();
        nif = this.tNif.getText();
        
    	
    	if(domicilio.equals("") || nombre.equals("") || pass.equals("") ||
    			nif.equals("") || !isNumeric(nif) || nif.length() != 8) {
    		
        	JOptionPane.showMessageDialog(null,
        			"Debes rellenar todos los campos, además el dni son 8 digitos sin letra",
        			"Introduccion incorrecta",
        			JOptionPane.ERROR_MESSAGE);
        	
    	}
    	else {
    		
    		dni = Integer.parseInt(nif);
    		
    		if(existente == null) {
    			
	    		TransferUsuario nuevoUsuario = new TransferUsuario(dni, pass, nombre, domicilio, TipoUsuario.CLIENTE);
	    		
	    		if(c.altaUsuario(nuevoUsuario)) {
	    			
		        	JOptionPane.showMessageDialog(null,
		        			"Se ha agregado el nuevo usuario",
		        			"Exito al agregar",
		        			JOptionPane.INFORMATION_MESSAGE);
		        	
		        	new GestionUsuarios(this.usuario, this.ventanaPrincipal);
	    		}
	    		else {
	    			
		        	JOptionPane.showMessageDialog(null,
		        			"El usuario introducido ya existe",
		        			"Error al agregar",
		        			JOptionPane.ERROR_MESSAGE);
		        	
	    		}
    		} else {
    			existente.setDomicilio(domicilio);
    			existente.setNombre(nombre);
    			existente.setPass(pass);
    			c.modificarUsuario(existente);
	        	JOptionPane.showMessageDialog(null,
	        			"Se ha modificado el usuario",
	        			"Exito al modificar",
	        			JOptionPane.INFORMATION_MESSAGE);
	        	new GestionUsuarios(this.usuario, this.ventanaPrincipal);
    		}
    	}
    }//GEN-LAST:event_bSaveActionPerformed

    private void tNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNombreActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        new GestionUsuarios(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bCancelActionPerformed
    
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
}
