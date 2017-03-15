/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Comunicaciones.ControladorComunicaciones;
import auxiliar.MensajesEnviadosCellRenderer;
import auxiliar.MyListModel;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferMensaje;
import transfer.TransferUsuario;

public class BandejaSalida extends JPanel {
    
    //Atributos graficos.
    private JButton bAtrasEntrada;
    private JButton bVer;
    private JComboBox <TipoOrdenacion> combBuscar;
    private JComboBox <TipoOrdenacion> combOrdenar;
    private JLabel eBuscar;
    private JLabel eCorreo;
    private JLabel eCorreo1;
    private JLabel eDescripcion;
    private JLabel eOrdenar;
    private JLabel eRecibidos;
    private JLabel eBandejaSalida;
    private JLabel eUsername;
    private JLabel eVer;
    private JScrollPane jScrollPane1;
    private JList <TransferMensaje> lBandejaSalida;
    private JTextField tBuscar;
    private JLabel eRedactar;
    private JButton bRedactar;

    
    private JFrame ventanaPrincipal;
    //Atributo admin.
    private TransferUsuario usuario;
    private ControladorComunicaciones c;

    public BandejaSalida(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorComunicaciones();
    	this.ventanaPrincipal = v;
    	this.usuario = usuario;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Bandeja de Salida");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    
    private void initComponents() {
    	
    	List <TransferMensaje> listaMensajesEnviados = c.consultarListaMensajesEnviados(this.usuario.getIdUser(), TipoOrdenacion.NINGUNO, "");
        eUsername = new javax.swing.JLabel();
        eCorreo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eRecibidos = new javax.swing.JLabel();
        bAtrasEntrada = new javax.swing.JButton();
        bVer = new javax.swing.JButton();
        eVer = new javax.swing.JLabel();
        eDescripcion = new javax.swing.JLabel();
        eBandejaSalida = new javax.swing.JLabel();
        eCorreo1 = new javax.swing.JLabel();
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new javax.swing.JComboBox <TipoOrdenacion>();
        eBuscar = new javax.swing.JLabel();
        combBuscar = new javax.swing.JComboBox <TipoOrdenacion>();
        tBuscar = new javax.swing.JTextField();
        bRedactar = new javax.swing.JButton();
        eRedactar = new javax.swing.JLabel("Redactar");

        eUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Integer username = this.usuario.getDni();
        eUsername.setText(username.toString());

        eCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo.setText("Correo de: ");



        bRedactar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz-icono-7539-48.png"))); // NOI18N
        bRedactar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bRedactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRedactarActionPerformed(evt);
            }
        });
        
        lBandejaSalida = new JList<TransferMensaje>(new MyListModel<TransferMensaje>(listaMensajesEnviados));
        lBandejaSalida.setCellRenderer(new MensajesEnviadosCellRenderer());
        jScrollPane1.setViewportView(lBandejaSalida);

        eRecibidos.setText("Recibidos");

        bAtrasEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Atras.png"))); // NOI18N
        bAtrasEntrada.setBorder(null);
        bAtrasEntrada.setBorderPainted(false);
        bAtrasEntrada.setContentAreaFilled(false);
        bAtrasEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAtrasEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xeyes-icono-4881-48.png"))); // NOI18N
        bVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerActionPerformed(evt);
            }
        });

        eVer.setText("   Ver");

        eDescripcion.setText("A continuación aparecen los correos que has enviado.");

        eBandejaSalida.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eBandejaSalida.setText("BANDEJA DE SALIDA");

        eCorreo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo1.setText("@spartansports.com");

        eOrdenar.setText("Ordenar por");

        combOrdenar.addItem(TipoOrdenacion.RECEPTOR);
        combOrdenar.addItem(TipoOrdenacion.FECHA);
        combOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combOrdenarActionPerformed(evt);
            }
        });

        eBuscar.setText("Buscar");
        
        combBuscar.addItem(TipoOrdenacion.RECEPTOR);
        combBuscar.addItem(TipoOrdenacion.FECHA);
        combBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combBuscarActionPerformed(evt);
            }
        });

        tBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bAtrasEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eBandejaSalida)
                                .addComponent(eDescripcion)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eCorreo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eUsername)
                                    .addGap(2, 2, 2)
                                    .addComponent(eCorreo1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(eVer)
                                            .addGap(16, 16, 16))
                                        .addComponent(bVer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eRedactar, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bRedactar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eOrdenar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eBuscar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(21, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eCorreo)
                                .addComponent(eUsername)
                                .addComponent(eCorreo1))
                            .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bAtrasEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eBandejaSalida)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eDescripcion)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bRedactar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(eRedactar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(eVer))
                                .addComponent(bVer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eOrdenar)
                        .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eBuscar)
                        .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(71, Short.MAX_VALUE))
            );
    }// </editor-fold>//GEN-END:initComponents

    private void bRedactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRedactarActionPerformed
        new RedactarCorreo(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bRedactarActionPerformed
    
    private void bRecibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRecibidosActionPerformed
        new BandejaEntrada(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bRecibidosActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
    	if(this.usuario.getTipoUser() != TipoUsuario.ADMINISTRADOR)
    		new BandejaEntrada(usuario, this.ventanaPrincipal);
    	else 
    		new InicioAdmin(this.usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void lBandejaSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lBandejaSalidaMouseClicked
        new VentanaLogin(this.ventanaPrincipal);
    }//GEN-LAST:event_lBandejaSalidaMouseClicked

    private void bVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerActionPerformed
    	if(!lBandejaSalida.isSelectionEmpty()) {
    		new verMensaje(usuario, lBandejaSalida.getSelectedValue(), ventanaPrincipal);
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar un mensaje de la lista",
        			"Mensaje seleccionado inexistente",
        			JOptionPane.CANCEL_OPTION);
    	}
    }//GEN-LAST:event_bVerActionPerformed

    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combOrdenarActionPerformed
    	MyListModel <TransferMensaje> lista = (MyListModel<TransferMensaje>) lBandejaSalida.getModel();
    	List <TransferMensaje> listaMensajes = new ArrayList<TransferMensaje>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaMensajes.add(lista.getElementAt(i));
    	
    	if(combOrdenar.getSelectedItem() == TipoOrdenacion.RECEPTOR) {
        	listaMensajes = c.ordenarListaMensajes(TipoOrdenacion.DNI,listaMensajes);
    	}
    	else if(combOrdenar.getSelectedItem() == TipoOrdenacion.FECHA) {
    		listaMensajes = c.ordenarListaMensajes(TipoOrdenacion.NOMBRE, listaMensajes);
    	}
    	
    	lBandejaSalida.setModel(new MyListModel <TransferMensaje> (listaMensajes));
    }//GEN-LAST:event_combOrdenarActionPerformed

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combBuscarActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
        String busqueda = tBuscar.getText();
        TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
        
        List <TransferMensaje> listaMensajesEnviados = new ArrayList<TransferMensaje>();
        
        if(!busqueda.isEmpty())
        	listaMensajesEnviados = c.consultarListaMensajesEnviados(this.usuario.getIdUser(), tipo, busqueda);
        else
        	listaMensajesEnviados = c.consultarListaMensajesEnviados(this.usuario.getIdUser(), TipoOrdenacion.NINGUNO, "");
        
        lBandejaSalida.setModel(new MyListModel<TransferMensaje>(listaMensajesEnviados));
    }//GEN-LAST:event_tBuscarActionPerformed
}
