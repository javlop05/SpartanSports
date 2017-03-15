/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Toolkit;

import javax.swing.*;

import transfer.TransferUsuario;
import Usuarios.ControladorUsuarios;

public class InicioUser extends JPanel {

	//Atributos graficos.
    private JButton bAbonos;
    private JButton bLogout;
    private JButton bCorreo;
    private JButton bPistas;
    private JLabel eBienvenido;
    private JLabel eNombreUser;
    private JLabel ePregunta;
    private JLabel logoSuperior;
    private JFrame ventanaPrincipal;
    
    private TransferUsuario usuario;
    private ControladorUsuarios c;
    
    public InicioUser(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorUsuarios();
    	this.usuario = usuario;
    	this.ventanaPrincipal = v;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents(this.usuario);
        this.ventanaPrincipal.setTitle("SpartanSports - Inicio User");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents(TransferUsuario usuario) {

        bLogout = new javax.swing.JButton();
        logoSuperior = new javax.swing.JLabel();
        bPistas = new javax.swing.JButton();
        ePregunta = new javax.swing.JLabel();
        eBienvenido = new javax.swing.JLabel();
        eNombreUser = new javax.swing.JLabel(this.usuario.getNombre());
        bAbonos = new javax.swing.JButton();
        bCorreo = new javax.swing.JButton();

        bLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        bLogout.setBorder(null);
        bLogout.setBorderPainted(false);
        bLogout.setContentAreaFilled(false);
        bLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });

        logoSuperior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo Spartan Sports.png"))); // NOI18N

        bPistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISResPistas.png"))); // NOI18N
        bPistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPistasActionPerformed(evt);
            }
        });

        ePregunta.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        ePregunta.setText("¿Qué deseas hacer?");

        eBienvenido.setText("Bienvenido,");

        bAbonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISCompAbonos.png"))); // NOI18N
        bAbonos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbonosActionPerformed(evt);
            }
        });

        bCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sobre-de-correo-icono-9343-32.png"))); // NOI18N
        bCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(eBienvenido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eNombreUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logoSuperior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(bCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ePregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoSuperior)
                    .addComponent(bCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBienvenido)
                    .addComponent(eNombreUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ePregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
    	
		Toolkit.getDefaultToolkit().beep();
		int i = JOptionPane.showConfirmDialog(null,
				"¿Realmente desea salir?", 
				"Salir", 
				JOptionPane.YES_NO_OPTION);
		
		if(i == JOptionPane.YES_OPTION){
			new VentanaLogin(this.ventanaPrincipal);
		}
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPistasActionPerformed
        new GestionReservas(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bPistasActionPerformed

    private void bAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbonosActionPerformed
        new ComprarAbono(this.usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAbonosActionPerformed


    private void bCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCorreoActionPerformed
        new BandejaEntrada(usuario, this.ventanaPrincipal);
        this.ventanaPrincipal.pack();
    }//GEN-LAST:event_bCorreoActionPerformed
}
