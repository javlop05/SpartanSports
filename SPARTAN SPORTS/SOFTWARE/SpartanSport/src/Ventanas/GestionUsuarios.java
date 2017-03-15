/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import auxiliar.AbonosCellRenderer;
import auxiliar.MyListModel;
import auxiliar.UsuariosCellRender;
import Reservas.ControladorReservas;
import Usuarios.ControladorUsuarios;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferAbono;
import transfer.TransferReserva;
import transfer.TransferUsuario;

public class GestionUsuarios extends JPanel {

	//Atributos graficos.
    private JButton bAlta;
    private JButton bAtras;
    private JButton bBaja;
    private JButton bUsuario;
    private JComboBox <TipoOrdenacion> combBuscar;
    private JComboBox <TipoOrdenacion> combOrdenar;
    private JLabel eBuscar;
    private JLabel eDescripcion;
    private JLabel eOrdenar;
    private JLabel eReservaPista;
    private JScrollPane jScrollPane1;
    private JList <TransferUsuario> lUsuarios;
    private JTextField tBuscar;

    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorUsuarios c;
    
    public GestionUsuarios(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorUsuarios();
    	this.ventanaPrincipal = v;
    	this.usuario = usuario;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Admin: Gestion usuarios");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    private void initComponents() {

    	List <TransferUsuario> listaUsuarios = c.consultarListaUsuarios(TipoOrdenacion.NINGUNO, "");
        bAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bAlta = new javax.swing.JButton();
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new JComboBox();
        eBuscar = new javax.swing.JLabel();
        tBuscar = new javax.swing.JTextField();
        combBuscar = new JComboBox();
        bUsuario = new javax.swing.JButton();
        bBaja = new javax.swing.JButton();
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

        lUsuarios = new JList<TransferUsuario>(new MyListModel<TransferUsuario>(listaUsuarios));
        lUsuarios.setCellRenderer(new UsuariosCellRender());

        jScrollPane1.setViewportView(lUsuarios);

        bAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISAltaUser.png"))); // NOI18N
        bAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });

        eOrdenar.setText("Ordenar por");
        
        combOrdenar.addItem(TipoOrdenacion.NOMBRE);
        combOrdenar.addItem(TipoOrdenacion.DNI);
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

        combBuscar.addItem(TipoOrdenacion.NOMBRE);
        combBuscar.addItem(TipoOrdenacion.DNI);
        combBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combBuscarActionPerformed(evt);
            }
        });

        bUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISVerUsuario.png"))); // NOI18N
        bUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsuarioActionPerformed(evt);
            }
        });

        bBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISBajaUser.png"))); // NOI18N
        bBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaActionPerformed(evt);
            }
        });
        eDescripcion.setText("A continuación aparece la lista de usuarios. Puedes dar de alta un nuevo usuario, y modificar o dar de baja uno existente.");

        eReservaPista.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eReservaPista.setText("GESTIÓN USUARIOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eReservaPista)
                            .addComponent(eDescripcion))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eOrdenar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eReservaPista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eDescripcion))
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eOrdenar)
                    .addComponent(combOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBuscar)
                    .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bBaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
       new InicioAdmin(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
       new AltaUser(usuario, null, this.ventanaPrincipal);
    }//GEN-LAST:event_bAltaActionPerformed

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combBuscarActionPerformed

    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combOrdenarActionPerformed
    	
    	MyListModel <TransferUsuario> lista = (MyListModel<TransferUsuario>) lUsuarios.getModel();
    	List <TransferUsuario> listaUsuarios = new ArrayList<TransferUsuario>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaUsuarios.add(lista.getElementAt(i));
    	
    	if(combOrdenar.getSelectedItem() == TipoOrdenacion.DNI) {
        	listaUsuarios = c.ordenarListaUsuarios(TipoOrdenacion.DNI,listaUsuarios);
    	}
    	else if(combOrdenar.getSelectedItem() == TipoOrdenacion.NOMBRE) {
    		listaUsuarios = c.ordenarListaUsuarios(TipoOrdenacion.NOMBRE, listaUsuarios);
    	}
    	
    	lUsuarios.setModel(new MyListModel(listaUsuarios));
    	
    }//GEN-LAST:event_combOrdenarActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
        String busqueda = tBuscar.getText();
        TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
        List <TransferUsuario> listaUsuarios = new ArrayList<TransferUsuario>();
        
        if(!busqueda.isEmpty())
        	listaUsuarios = c.consultarListaUsuarios(tipo, busqueda);
        else
        	listaUsuarios = c.consultarListaUsuarios(TipoOrdenacion.NINGUNO, "");
        
        lUsuarios.setModel(new MyListModel(listaUsuarios));
    }//GEN-LAST:event_tBuscarActionPerformed

    private void bUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsuarioActionPerformed
    	if(!lUsuarios.isSelectionEmpty()) {
    		new AltaUser(this.usuario, lUsuarios.getSelectedValue(), this.ventanaPrincipal);
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar un usuario de la lista",
        			"Usuario seleccionado inexistente",
        			JOptionPane.CANCEL_OPTION);
        }
        
    }//GEN-LAST:event_bUsuarioActionPerformed
    
    private void bBajaActionPerformed(java.awt.event.ActionEvent evt) {
    	ControladorReservas controlReservas = new ControladorReservas();
    	if(!lUsuarios.isSelectionEmpty()) {
    		int idUsuario = lUsuarios.getSelectedValue().getIdUser();
    		List<TransferReserva> listaReservas = controlReservas.consultarListaReservas(idUsuario, TipoOrdenacion.NINGUNO, "");
    		for(TransferReserva reserva: listaReservas) 
    			controlReservas.cancelarReserva(reserva);
    		c.bajaUsuario(lUsuarios.getSelectedValue());
    		final ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/kick2.jpg"));
        	JOptionPane.showMessageDialog(null,
        			"",
        			"Exito al eliminar",
        			JOptionPane.INFORMATION_MESSAGE,
        			icon);
        	List<TransferUsuario> lista = c.consultarListaUsuarios(TipoOrdenacion.NINGUNO,"");
        	lUsuarios.setModel(new MyListModel<TransferUsuario>(lista));
    		
    	}
    	else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar un usuario de la lista",
        			"Usuario seleccionado inexistente",
        			JOptionPane.CANCEL_OPTION);
        }
    }
}
