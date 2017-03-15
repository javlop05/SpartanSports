/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import auxiliar.MyListModel;
import auxiliar.ReservasCellRenderer;
import Reservas.ControladorReservas;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferReserva;
import transfer.TransferUsuario;

public class GestionReservas extends JPanel {

    //Atributos graficos.
    private JButton bAtras;
    private JButton bCancelarReserva;
    private JButton bReserva;
    private JComboBox <TipoOrdenacion> combBuscar;
    private JComboBox <TipoOrdenacion> combOrdenar;
    private JLabel eBuscar;
    private JLabel eDescripcion;
    private JLabel eOrdenar;
    private JLabel eReservaPista;
    private JScrollPane jScrollPane1;
    private JList <TransferReserva> lReservas;
    private JTextField tBuscar;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorReservas c;
    
    public GestionReservas(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorReservas();
    	this.ventanaPrincipal = v;
        this.usuario = usuario;
        this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Gestion Reservas");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
   private void initComponents() {
	   
	   	List <TransferReserva> listaReservas;
	   	listaReservas = c.consultarListaReservas(this.usuario.getIdUser(),TipoOrdenacion.NINGUNO,"");

        bAtras = new javax.swing.JButton();
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new javax.swing.JComboBox<TipoOrdenacion>();
        eBuscar = new javax.swing.JLabel();
        tBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bReserva = new javax.swing.JButton();
        bCancelarReserva = new javax.swing.JButton();
        combBuscar = new javax.swing.JComboBox<TipoOrdenacion>();
        eDescripcion = new javax.swing.JLabel();
        eReservaPista = new javax.swing.JLabel();

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

        eOrdenar.setText("Ordenar por");
        
        if(this.usuario.getTipoUser() == TipoUsuario.ADMINISTRADOR)
        	combOrdenar.addItem(TipoOrdenacion.DNI);
        
        combOrdenar.addItem(TipoOrdenacion.FECHA);
        combOrdenar.addItem(TipoOrdenacion.HORA);
        combOrdenar.addItem(TipoOrdenacion.DEPORTE);
        combOrdenar.addItem(TipoOrdenacion.PISTA);
        combOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combOrdenarActionPerformed(evt);
            }
        });

        eBuscar.setText("Buscar");

        tBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBuscarActionPerformed(evt);
            }
        });

        
        lReservas = new JList<TransferReserva>(new MyListModel<TransferReserva>(listaReservas));
        lReservas.setCellRenderer(new ReservasCellRenderer());
        jScrollPane1.setViewportView(lReservas);

        bReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISreserva3.png"))); // NOI18N
        bReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservaActionPerformed(evt);
            }
        });

        bCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISDelReserva.png"))); // NOI18N
        bCancelarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarReservaActionPerformed(evt);
            }
        });

        if(this.usuario.getTipoUser() == TipoUsuario.ADMINISTRADOR)
        	combBuscar.addItem(TipoOrdenacion.DNI);
        
        combBuscar.addItem(TipoOrdenacion.FECHA);
        combBuscar.addItem(TipoOrdenacion.HORA);
        combBuscar.addItem(TipoOrdenacion.DEPORTE);
        combBuscar.addItem(TipoOrdenacion.PISTA);
        combBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combBuscarActionPerformed(evt);
            }
        });

        eDescripcion.setText("A continuación aparece la lista de reservas.");

        eReservaPista.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eReservaPista.setText("GESTIÓN RESERVAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eReservaPista)
                            .addComponent(eDescripcion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eOrdenar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eOrdenar)
                    .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBuscar)
                    .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
    	if(this.usuario.getTipoUser() == TipoUsuario.ADMINISTRADOR)
    		new InicioAdmin(usuario, this.ventanaPrincipal);
    	else
    		new InicioUser(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservaActionPerformed
        new ReservaUser2(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bReservaActionPerformed

    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combOrdenarActionPerformed
    	MyListModel <TransferReserva> lista = (MyListModel<TransferReserva>) lReservas.getModel();
    	List <TransferReserva> listaReservas = new ArrayList<TransferReserva>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaReservas.add(lista.getElementAt(i));
    	
    	switch ((TipoOrdenacion) combOrdenar.getSelectedItem()) {
    	case FECHA:
    		listaReservas = c.ordenarListaReservas(TipoOrdenacion.FECHA, listaReservas);
    		break;
    	case HORA:
    		listaReservas = c.ordenarListaReservas(TipoOrdenacion.HORA, listaReservas);
    		break;
    	case DNI:
    		listaReservas = c.ordenarListaReservas(TipoOrdenacion.DNI, listaReservas);
    		break;
    	case DEPORTE:
    		listaReservas = c.ordenarListaReservas(TipoOrdenacion.DEPORTE, listaReservas);
    		break;
    	case PISTA: 
    		listaReservas = c.ordenarListaReservas(TipoOrdenacion.PISTA, listaReservas);
    	}
    	
    	lReservas.setModel(new MyListModel <TransferReserva> (listaReservas));
    }//GEN-LAST:event_combOrdenarActionPerformed

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combBuscarActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
      	 String busqueda = tBuscar.getText();
         TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
         
         List <TransferReserva> listaReservas = new ArrayList<TransferReserva>();
         
         if(!busqueda.isEmpty())
         	listaReservas = c.consultarListaReservas(this.usuario.getIdUser(),tipo, busqueda);
         else
         	listaReservas = c.consultarListaReservas(this.usuario.getIdUser(),TipoOrdenacion.NINGUNO, "");

         lReservas.setModel(new MyListModel <TransferReserva> (listaReservas));
    }//GEN-LAST:event_tBuscarActionPerformed

    private void bCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarReservaActionPerformed
    	MyListModel <TransferReserva> lista = (MyListModel<TransferReserva>) lReservas.getModel();
    	List <TransferReserva> listaReservas = new ArrayList<TransferReserva>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaReservas.add(lista.getElementAt(i));
    	
    	if(!lReservas.isSelectionEmpty()) {
    		c.cancelarReserva(lReservas.getSelectedValue());
        	JOptionPane.showMessageDialog(null,
        			"Reserva cancelada",
        			"Exito al cancelar",
        			JOptionPane.INFORMATION_MESSAGE);
        	listaReservas = c.consultarListaReservas(this.usuario.getIdUser(),TipoOrdenacion.NINGUNO,"");
            lReservas.setModel(new MyListModel<TransferReserva>(listaReservas));    		
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar una reserva de la lista",
        			"Pista seleccionada inexistente",
        			JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_bCancelarReservaActionPerformed
}
