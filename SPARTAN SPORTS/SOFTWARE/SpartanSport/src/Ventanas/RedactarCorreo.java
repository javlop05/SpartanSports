/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import javax.swing.*;

import Comunicaciones.ControladorComunicaciones;
import Usuarios.ControladorUsuarios;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferMensaje;
import transfer.TransferUsuario;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class RedactarCorreo extends JPanel {

    //Atributos graficos.
    private JButton bAtras;
    private JButton bEnviar;
    private JLabel eCorreo;
    private JLabel eCorreo1;
    private JLabel eDescripcion;
    private JLabel eDestinatario;
    private JLabel eReservaPista;
    private JLabel eUsername;
    private JLabel jLabel1;
    private JTextField tUsuario;
    private TextArea tRedactar;
    private JTextField tAsunto;
    private JLabel eAsunto;

    
    private JFrame ventanaPrincipal;
    //Atributo admin.
    private TransferUsuario usuario;
    private ControladorComunicaciones c;
    
    public RedactarCorreo(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorComunicaciones();
    	this.ventanaPrincipal = v;
        this.usuario = usuario;
        this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Redactar Correo");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents() {

        bAtras = new javax.swing.JButton();
        eDestinatario = new javax.swing.JLabel();
        eCorreo = new javax.swing.JLabel();
        eUsername = new javax.swing.JLabel();
        tRedactar = new java.awt.TextArea();
        bEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eCorreo1 = new javax.swing.JLabel();
        eReservaPista = new javax.swing.JLabel();
        eDescripcion = new javax.swing.JLabel();
        tUsuario = new javax.swing.JTextField();
        tAsunto = new javax.swing.JTextField();
        eAsunto = new javax.swing.JLabel();
        
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Atras.png"))); // NOI18N
        bAtras.setBorder(null);
        bAtras.setBorderPainted(false);
        bAtras.setContentAreaFilled(false);
        bAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });
      
        eDestinatario.setText("Para:");

        eCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo.setText("Correo de: ");

        eUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Integer username = usuario.getDni();
        eUsername.setText(username.toString());

        bEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISEnviar.png"))); // NOI18N
        bEnviar.setBorder(null);
        bEnviar.setBorderPainted(false);
        bEnviar.setContentAreaFilled(false);
        bEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("@spartansports.com");

        eCorreo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo1.setText("@spartansports.com");

        eReservaPista.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eReservaPista.setText("REDACTAR CORREO");

        eDescripcion.setText("A continuación puedes escribir un correo y enviarlo al usuario seleccionado.");

        eAsunto.setText("Asunto:");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(bEnviar)
                                    .addGap(176, 176, 176))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(eCorreo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(eUsername)
                                            .addGap(2, 2, 2)
                                            .addComponent(eCorreo1))
                                        .addComponent(eReservaPista)
                                        .addComponent(eDescripcion))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tRedactar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eDestinatario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(eAsunto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tAsunto)))
                            .addContainerGap())))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eReservaPista)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eDescripcion)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eCorreo)
                        .addComponent(eUsername)
                        .addComponent(eCorreo1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eDestinatario)
                        .addComponent(jLabel1)
                        .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eAsunto))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tRedactar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addComponent(bEnviar)
                    .addContainerGap())
            );
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
    	if(this.usuario.getTipoUser() != TipoUsuario.ADMINISTRADOR)
    		new BandejaEntrada(usuario, this.ventanaPrincipal);
    	else 
    		new BandejaSalida(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
    	int idUsuario = -1;
    	String dniUsuario = tUsuario.getText();
    	String asunto = tAsunto.getText();
    	DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    	Date dia = new Date();
    	String diaString = formato.format(dia);
    	ControladorUsuarios controlUser = new ControladorUsuarios();
    	java.util.List <TransferUsuario> lista;
        if(tUsuario.getText().equals("") || tRedactar.getText().equals("") || !isNumeric(dniUsuario) || dniUsuario.length() != 8) {
        	JOptionPane.showMessageDialog(null,
        			"Debes rellenar tanto el receptor del mensaje(dni usuario),\n                     como el contenido del mensaje",
        			"Faltan campos por rellenar",
        			JOptionPane.CANCEL_OPTION);
        }
        else {
        	lista = controlUser.consultarListaUsuarios(TipoOrdenacion.DNI, dniUsuario);
        	if(!lista.isEmpty()) {
	        	for(TransferUsuario usuario: lista) {
	        		idUsuario = usuario.getIdUser();
	        	}
	        	try {
	        		Integer dni = Integer.parseInt(dniUsuario);
					TransferMensaje mensaje = new TransferMensaje(this.usuario.getDni(), dni, asunto,
							tRedactar.getText(), formato.parse(diaString), this.usuario.getIdUser(), idUsuario);
					c.enviarMensaje(mensaje);
		        	JOptionPane.showMessageDialog(null,
		        			"Mensaje enviado correctamente",
		        			"Exito al enviar",
		        			JOptionPane.INFORMATION_MESSAGE);
		        	new BandejaSalida(this.usuario, this.ventanaPrincipal);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	        	
        	}
        	else {
            	JOptionPane.showMessageDialog(null,
            			"El usuario introducido no existe",
            			"Usuario inexistente.",
            			JOptionPane.ERROR_MESSAGE);
        	}
        }
    }//GEN-LAST:event_bEnviarActionPerformed
    
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
