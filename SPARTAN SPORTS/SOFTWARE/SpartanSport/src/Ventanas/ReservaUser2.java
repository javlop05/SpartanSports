/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import transfer.TipoDeporte;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferPista;
import transfer.TransferReserva;
import transfer.TransferUsuario;
import Pistas.ControladorPistas;
import Reservas.ControladorReservas;

import com.toedter.calendar.*;
public class ReservaUser2 extends JPanel {
    
	//Atributos graficos.
    private JDateChooser Calendario;
    private JButton bAtras;
    private JButton bReserva;
    private JComboBox <String> combDeporte;
    private JComboBox combHora;
    private JLabel eDeporte;
    private JLabel eDescripcion;
    private JLabel eDescripcion2;
    private JLabel eDia;
    private JLabel eHora;
    private JLabel eReserva;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorReservas c;
    
   
    public ReservaUser2(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorReservas();
    	this.ventanaPrincipal = v;
        this.usuario = usuario;
        this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Realizar/Modificar reserva");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents() {

    	ControladorPistas c = new ControladorPistas();
    	List <TransferPista> listaPistas = c.consultarListaPistas(TipoOrdenacion.NINGUNO, "");
        eHora = new javax.swing.JLabel();
        combDeporte = new javax.swing.JComboBox <String>();
        eDescripcion2 = new javax.swing.JLabel();
        combHora = new javax.swing.JComboBox();
        bAtras = new javax.swing.JButton();
        eReserva = new javax.swing.JLabel();
        eDescripcion = new javax.swing.JLabel();
        bReserva = new javax.swing.JButton();
        eDeporte = new javax.swing.JLabel();
        eDia = new javax.swing.JLabel();
        Calendario = new com.toedter.calendar.JDateChooser();

        eHora.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eHora.setText("Hora:");

        for(TransferPista pista: listaPistas) {
        	combDeporte.addItem("Pista " + pista.getNumPista() + " " + pista.getTipo());
        }
        combDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combDeporteActionPerformed(evt);
            }
        });

        eDescripcion2.setText("A continuación, apareceren las horas:");

        combHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10:00", "11:00", "12:00", "13:00", "17:00", "18:00", "19:00", "20:00" }));
        
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

        eReserva.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eReserva.setText("REALIZAR RESERVA");

        eDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        eDescripcion.setText("Rellena los campos que aparecen a continuación para efectuar/modificar una reserva.");

        bReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISConfReserva.png"))); // NOI18N
        bReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservaActionPerformed(evt);
            }
        });

        eDeporte.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eDeporte.setText("Deporte:");

        eDia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eDia.setText("Día:");

        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(new Date()); 
        calendar.add(Calendar.DATE, 1);
        
        Calendario.getDateEditor().setEnabled(false);
        Calendario.setMinSelectableDate(calendar.getTime());
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(eReserva)
                        .addComponent(eDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eDeporte)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(eDia)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eDescripcion2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eHora)
                                    .addGap(28, 28, 28)
                                    .addComponent(combHora, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(96, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(185, 185, 185))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eDeporte)
                        .addComponent(combDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                            .addComponent(eDia)
                            .addGap(36, 36, 36)))
                    .addComponent(eDescripcion2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eHora)
                        .addComponent(combHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41))
            );
    }// </editor-fold>//GEN-END:initComponents

    private void combDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combDeporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combDeporteActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
            new GestionReservas(usuario, this.ventanaPrincipal);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservaActionPerformed
    	//TERMINARTERMINARTERMINAR TERMINAR!!!
        Date fecha = Calendario.getDate();
        if(fecha != null) {
	    	ControladorPistas controlPistas = new ControladorPistas();
	    	int idPista = -1;
	    	List <TransferPista> listaPistas;
	        String pista = combDeporte.getSelectedItem().toString();
	        String [] pistaElegida = pista.split(" ");
	        String numPista = pistaElegida[1];
	        listaPistas = controlPistas.consultarListaPistas(TipoOrdenacion.PISTA, numPista);
	        if(!listaPistas.isEmpty()) idPista = listaPistas.get(0).getIdPista();
	        TipoDeporte deporte = TipoDeporte.FUTBOL;
	        //HACER UN CONVERSOR DE TIPO EN EL ENUMERADO!
	        deporte = deporte.String2Deporte(pistaElegida[2]);
	        int idUsuario = this.usuario.getIdUser();
	        int dni = this.usuario.getDni();
	        String hora = combHora.getSelectedItem().toString();
	        TransferReserva reservaElegida = new TransferReserva(idPista, idUsuario,
	    			fecha, hora, dni, Integer.parseInt(numPista), deporte);
	        if(c.hacerReserva(reservaElegida)) {
	        	JOptionPane.showMessageDialog(null,
	        			"Se ha cursado la reserva satisfactoriamente.",
	        			"Exito al reservar",
	        			JOptionPane.INFORMATION_MESSAGE);
	        	new GestionReservas(usuario, this.ventanaPrincipal);
	        }
	        else {
	        	JOptionPane.showMessageDialog(null,
	        			"Ya hay una reserva en la fecha elegida, por favor escoge otra.",
	        			"Reserva existente",
	        			JOptionPane.INFORMATION_MESSAGE);
	        }
        }
        else {
        	JOptionPane.showMessageDialog(null,
        			"Debes seleccionar un día en el calendario.",
        			"Faltan datos.",
        			JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bReservaActionPerformed
}
