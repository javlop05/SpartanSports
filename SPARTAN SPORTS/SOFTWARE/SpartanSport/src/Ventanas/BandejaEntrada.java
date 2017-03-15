/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import auxiliar.MensajesRecibidosCellRenderer;
import auxiliar.MyListModel;
import auxiliar.UsuariosCellRender;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferMensaje;
import transfer.TransferUsuario;
import Comunicaciones.ControladorComunicaciones;
import Usuarios.ControladorUsuarios;

public class BandejaEntrada extends JPanel {
	
	//Atritubos graficos.
    private JButton bAtrasInicio;
    private JButton bRedactar;
    private JButton bSalida;
    private JButton bVer;
    private JList <TransferMensaje> buzonEntrada;
    private JComboBox <TipoOrdenacion> combBuscar;
    private JComboBox <TipoOrdenacion> combOrdenar;
    private JLabel eBuscar;
    private JLabel eCorreo;
    private JLabel eCorreo1;
    private JLabel eDescripcion;
    private JLabel eEnviados;
    private JLabel eOrdenar;
    private JLabel eRedactar;
    private JLabel eReservaPista;
    private JLabel eUsername;
    private JLabel eVer;
    private JScrollPane jScrollPane1;
    private JTextField tBuscar;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorComunicaciones c;
   
    public BandejaEntrada(TransferUsuario usuario, JFrame v) {
    	this.c =  new ControladorComunicaciones();
    	this.ventanaPrincipal = v;
        this.usuario = usuario;
        this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Bandeja de Entrada");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    
    private void initComponents() {
    	
    	List <TransferMensaje> listaMensajesRecibidos = c.consultarListaMensajesRecibidos(this.usuario.getIdUser(), TipoOrdenacion.NINGUNO, "");
        eCorreo = new javax.swing.JLabel();
        eUsername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eRedactar = new javax.swing.JLabel();
        eEnviados = new javax.swing.JLabel();
        bSalida = new javax.swing.JButton();
        bRedactar = new javax.swing.JButton();
        bAtrasInicio = new javax.swing.JButton();
        eVer = new javax.swing.JLabel();
        bVer = new javax.swing.JButton();
        eCorreo1 = new javax.swing.JLabel();
        eDescripcion = new javax.swing.JLabel();
        eReservaPista = new javax.swing.JLabel();
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new javax.swing.JComboBox <TipoOrdenacion> ();
        eBuscar = new javax.swing.JLabel();
        combBuscar = new javax.swing.JComboBox<TipoOrdenacion>();
        tBuscar = new javax.swing.JTextField();

        eCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo.setText("Correo de: ");

        
        eUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Integer username = this.usuario.getDni();
        eUsername.setText(username.toString());


        

        eRedactar.setText("Redactar");

        eEnviados.setText("Enviados");

        bSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mail-snd-icono-5317-48.png"))); // NOI18N
        bSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalidaActionPerformed(evt);
            }
        });
        

        bRedactar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz-icono-7539-48.png"))); // NOI18N
        bRedactar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bRedactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRedactarActionPerformed(evt);
            }
        });

        buzonEntrada = new JList<TransferMensaje>(new MyListModel<TransferMensaje>(listaMensajesRecibidos));
        buzonEntrada.setCellRenderer(new MensajesRecibidosCellRenderer());
        jScrollPane1.setViewportView(buzonEntrada);
        
        bAtrasInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Atras.png"))); // NOI18N
        bAtrasInicio.setBorder(null);
        bAtrasInicio.setBorderPainted(false);
        bAtrasInicio.setContentAreaFilled(false);
        bAtrasInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAtrasInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasInicioActionPerformed(evt);
            }
        });

        eVer.setText("Ver");

        bVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xeyes-icono-4881-48.png"))); // NOI18N
        bVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerActionPerformed(evt);
            }
        });

        eCorreo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eCorreo1.setText("@spartansports.com");

        eDescripcion.setText("A continuación aparecen los correos que has recibido.");

        eReservaPista.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eReservaPista.setText("BANDEJA DE ENTRADA");

        eOrdenar.setText("Ordenar por");

        combOrdenar.addItem(TipoOrdenacion.EMISOR);
        combOrdenar.addItem(TipoOrdenacion.FECHA);
        combOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combOrdenarActionPerformed(evt);
            }
        });

        eBuscar.setText("Buscar");

        combBuscar.addItem(TipoOrdenacion.EMISOR);
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
                            .addComponent(bAtrasInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eReservaPista)
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
                                        .addComponent(bVer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(eVer)
                                            .addGap(16, 16, 16)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eEnviados))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(eVer))
                                    .addComponent(bVer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bAtrasInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(eReservaPista)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(eDescripcion)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(53, 53, 53)
                                            .addComponent(eEnviados))
                                        .addComponent(bSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(bRedactar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7)
                                            .addComponent(eRedactar)))))
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

    private void bSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalidaActionPerformed
        new BandejaSalida(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bSalidaActionPerformed

    private void bAtrasInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        if (this.usuario.getTipoUser()== TipoUsuario.ADMINISTRADOR) {
            new InicioAdmin(usuario, this.ventanaPrincipal);
        }else {
        	new InicioUser(usuario, this.ventanaPrincipal);
        }
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bRedactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRedactarActionPerformed
        new RedactarCorreo(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bRedactarActionPerformed

    private void bVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerActionPerformed
    	if(!buzonEntrada.isSelectionEmpty()) {
    		new verMensaje(usuario, buzonEntrada.getSelectedValue(), ventanaPrincipal);
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar un mensaje de la lista",
        			"Mensaje seleccionado inexistente",
        			JOptionPane.CANCEL_OPTION);
    	}
    }//GEN-LAST:event_bVerActionPerformed

    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combOrdenarActionPerformed
    	MyListModel <TransferMensaje> lista = (MyListModel<TransferMensaje>) buzonEntrada.getModel();
    	List <TransferMensaje> listaMensajes = new ArrayList<TransferMensaje>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaMensajes.add(lista.getElementAt(i));
    	
    	if(combOrdenar.getSelectedItem() == TipoOrdenacion.EMISOR) {
        	listaMensajes = c.ordenarListaMensajes(TipoOrdenacion.DNI,listaMensajes);
    	}
    	else if(combOrdenar.getSelectedItem() == TipoOrdenacion.FECHA) {
    		listaMensajes = c.ordenarListaMensajes(TipoOrdenacion.NOMBRE, listaMensajes);
    	}
    	
    	buzonEntrada.setModel(new MyListModel <TransferMensaje> (listaMensajes));
    }//GEN-LAST:event_combOrdenarActionPerformed

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combBuscarActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
        String busqueda = tBuscar.getText();
        TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
        
        List <TransferMensaje> listaMensajesRecibidos = new ArrayList<TransferMensaje>();
        
        if(!busqueda.isEmpty())
        	listaMensajesRecibidos = c.consultarListaMensajesRecibidos(this.usuario.getIdUser(), tipo, busqueda);
        else
        	listaMensajesRecibidos = c.consultarListaMensajesRecibidos(this.usuario.getIdUser(), TipoOrdenacion.NINGUNO, "");
        
        buzonEntrada.setModel(new MyListModel<TransferMensaje>(listaMensajesRecibidos));
    }//GEN-LAST:event_tBuscarActionPerformed
}
