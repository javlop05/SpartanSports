/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Toolkit;

import javax.swing.*;

import Usuarios.ControladorUsuarios;
import transfer.TransferUsuario;

public class InicioAdmin extends JPanel {

	//Atributos graficos.
    private JButton bLogout;
    private JButton bCorreo;
    private JButton bPistas;
    private JButton bReservas;
    private JButton bUsuarios;
    private JButton bConsultarAbonos;
    private JLabel logoSuperior;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorUsuarios c;

    public InicioAdmin(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorUsuarios();
    	this.usuario = usuario;
    	this.ventanaPrincipal = v;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Inicio Admin");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    
    private void initComponents() {

        logoSuperior = new javax.swing.JLabel();
        bLogout = new javax.swing.JButton();
        bReservas = new javax.swing.JButton();
        bUsuarios = new javax.swing.JButton();
        bCorreo = new javax.swing.JButton();
        bPistas = new javax.swing.JButton();
        bConsultarAbonos = new javax.swing.JButton();

        logoSuperior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo Admin.png"))); // NOI18N

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

        bReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISGestionReservas.png"))); // NOI18N
        bReservas.setBorder(null);
        bReservas.setBorderPainted(false);
        bReservas.setContentAreaFilled(false);
        bReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservasActionPerformed(evt);
            }
        });

        bUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISGestionUsers.png"))); // NOI18N
        bUsuarios.setBorder(null);
        bUsuarios.setBorderPainted(false);
        bUsuarios.setContentAreaFilled(false);
        bUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsuariosActionPerformed(evt);
            }
        });

        bCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sobre-de-correo-icono-9343-32.png"))); // NOI18N
        bCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCorreoActionPerformed(evt);
            }
        });

        bPistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISGestionPistas.png"))); // NOI18N
        bPistas.setBorder(null);
        bPistas.setBorderPainted(false);
        bPistas.setContentAreaFilled(false);
        bPistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPistasActionPerformed(evt);
            }
        });
        
        bConsultarAbonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISConsultarAbonos.png"))); // NOI18N
        bConsultarAbonos.setBorder(null);
        bConsultarAbonos.setBorderPainted(false);
        bConsultarAbonos.setContentAreaFilled(false);
        bConsultarAbonos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bConsultarAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarAbonosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(logoSuperior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(bCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bConsultarAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bConsultarAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void bUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsuariosActionPerformed
         new GestionUsuarios(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bUsuariosActionPerformed

    private void bReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservasActionPerformed
       new GestionReservas(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bReservasActionPerformed

    private void bCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCorreoActionPerformed
        new BandejaSalida(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bCorreoActionPerformed

    private void bPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPistasActionPerformed
        new GestionPistas(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bPistasActionPerformed
    
    private void bConsultarAbonosActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       new ConsultarAbonos(usuario, this.ventanaPrincipal);
    } 
}
