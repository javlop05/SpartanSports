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
import auxiliar.PistasCellRender;
import auxiliar.UsuariosCellRender;
import Pistas.ControladorPistas;
import Reservas.ControladorReservas;
import Usuarios.ControladorUsuarios;
import transfer.TipoDeporte;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferPista;
import transfer.TransferReserva;
import transfer.TransferUsuario;

public class GestionPistas extends JPanel {

	//Atributos graficos.
    private JButton bAgregarPista;
    private JButton bAtras;
    private JButton bDelPista;
    private JComboBox <TipoOrdenacion> combBuscar;
    private JComboBox <TipoOrdenacion> combOrdenar;
    private JComboBox <TipoDeporte> combPistas;
    private JLabel eBuscar;
    private JLabel eDescripcion;
    private JLabel eGestionarPistas;
    private JLabel eOrdenar;
    private JScrollPane jScrollPane1;
    private JList <TransferPista> lPistas;
    private JTextField tBuscar;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorPistas c;

    public GestionPistas(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorPistas();
    	this.ventanaPrincipal = v;
    	this.usuario = usuario;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Admin: Gestión Pistas");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    private void initComponents() {
    	List <TransferPista> listaPistas = c.consultarListaPistas(TipoOrdenacion.NINGUNO, "");

        eDescripcion = new javax.swing.JLabel();
        eGestionarPistas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bAtras = new javax.swing.JButton();
        bDelPista = new javax.swing.JButton();
        bAgregarPista = new javax.swing.JButton();
        combPistas = new javax.swing.JComboBox(TipoDeporte.values());
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new javax.swing.JComboBox();
        eBuscar = new javax.swing.JLabel();
        combBuscar = new javax.swing.JComboBox();
        tBuscar = new javax.swing.JTextField();

        eDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        eDescripcion.setText("Se muestra la lista de pistas, además de poder eliminar y añadir pistas.");

        eGestionarPistas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eGestionarPistas.setText("GESTIONAR PISTAS");

        lPistas = new JList<TransferPista>(new MyListModel<TransferPista>(listaPistas));
        lPistas.setCellRenderer(new PistasCellRender());
        jScrollPane1.setViewportView(lPistas);

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

        bDelPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISEliminarPista.png"))); // NOI18N
        bDelPista.setBorder(null);
        bDelPista.setBorderPainted(false);
        bDelPista.setContentAreaFilled(false);
        bDelPista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bDelPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelPistaActionPerformed(evt);
            }
        });

        bAgregarPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISAgregarPista.png"))); // NOI18N
        bAgregarPista.setBorder(null);
        bAgregarPista.setBorderPainted(false);
        bAgregarPista.setContentAreaFilled(false);
        bAgregarPista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAgregarPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarPistaActionPerformed(evt);
            }
        });

        combPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combPistasActionPerformed(evt);
            }
        });

        eOrdenar.setText("Ordenar por");

        combOrdenar.addItem(TipoOrdenacion.DEPORTE);
        combOrdenar.addItem(TipoOrdenacion.PISTA);
        combOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combOrdenarActionPerformed(evt);
            }
        });

        eBuscar.setText("Buscar");

        combBuscar.addItem(TipoOrdenacion.DEPORTE);
        combBuscar.addItem(TipoOrdenacion.PISTA);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eGestionarPistas)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eDescripcion)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bDelPista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAgregarPista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eGestionarPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eDescripcion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eOrdenar)
                    .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBuscar)
                    .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDelPista, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAgregarPista, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combPistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        new InicioAdmin(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bDelPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelPistaActionPerformed
    	ControladorReservas controlReservas = new ControladorReservas();
    	MyListModel <TransferPista> lista = (MyListModel<TransferPista>) lPistas.getModel();
    	List <TransferPista> listaPistas = new ArrayList<TransferPista>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaPistas.add(lista.getElementAt(i));
    	
    	if(!lPistas.isSelectionEmpty()) {
    		Integer idPista = lPistas.getSelectedValue().getIdPista();
    		List<TransferReserva> listaReservas = controlReservas.consultarListaReservas(0, TipoOrdenacion.NINGUNO, idPista.toString());
    		for(TransferReserva reserva: listaReservas) 
    			controlReservas.cancelarReserva(reserva);
    		c.eliminarPista(lPistas.getSelectedValue());
        	JOptionPane.showMessageDialog(null,
        			"Pista eliminada",
        			"Exito al eliminar",
        			JOptionPane.INFORMATION_MESSAGE);
        	listaPistas = c.consultarListaPistas(TipoOrdenacion.NINGUNO,"");
            lPistas.setModel(new MyListModel<TransferPista>(listaPistas));    		
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar una pista de la lista",
        			"Pista seleccionada inexistente",
        			JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_bDelPistaActionPerformed

    private void bAgregarPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarPistaActionPerformed
		MyListModel <TransferPista> lista = (MyListModel <TransferPista>) lPistas.getModel();
		int numPista = lista.getSize()+1;
    	TransferPista pista = new TransferPista(numPista,(TipoDeporte) combPistas.getSelectedItem());
		
		c.agregarPista(pista);
			
        	JOptionPane.showMessageDialog(null,
        			"Se ha agregado la nueva pista",
        			"Exito al agregar",
        			JOptionPane.INFORMATION_MESSAGE);
        	
           	List <TransferPista> listaPistas = c.consultarListaPistas(TipoOrdenacion.NINGUNO,"");
            lPistas.setModel(new MyListModel <TransferPista> (listaPistas));
    }//GEN-LAST:event_bAgregarPistaActionPerformed

    private void combPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combPistasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combPistasActionPerformed

    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combOrdenarActionPerformed
    	List <TransferPista> listaPistas = new ArrayList <TransferPista>();
    	MyListModel <TransferPista> lista = (MyListModel<TransferPista>) lPistas.getModel();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaPistas.add(lista.getElementAt(i));
    	if(combOrdenar.getSelectedItem() == TipoOrdenacion.DEPORTE) {
    		listaPistas = c.ordenarListaPistas(TipoOrdenacion.DEPORTE,listaPistas);
    	}
    	else if(combOrdenar.getSelectedItem() == TipoOrdenacion.PISTA) {
    		listaPistas = c.ordenarListaPistas(TipoOrdenacion.PISTA, listaPistas);
    	}
    	
        lPistas.setModel(new MyListModel<TransferPista>(listaPistas));

    }//GEN-LAST:event_combOrdenarActionPerformed

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combBuscarActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
    	String busqueda = tBuscar.getText();
        TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
        List <TransferPista> listaPistas = new ArrayList <TransferPista> ();
        if(!busqueda.isEmpty())
        	listaPistas = c.consultarListaPistas(tipo, busqueda);
        else
        	listaPistas = c.consultarListaPistas(TipoOrdenacion.NINGUNO, "");
        
        lPistas.setModel(new MyListModel <TransferPista>(listaPistas));
    }//GEN-LAST:event_tBuscarActionPerformed
}
