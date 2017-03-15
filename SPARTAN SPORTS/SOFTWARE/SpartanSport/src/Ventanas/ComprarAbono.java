/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import transfer.TipoAbono;
import transfer.TransferAbono;
import transfer.TransferUsuario;
import Abonos.ControladorAbonos;

public class ComprarAbono extends JPanel {
	
	//Atributos graficos.
    private JButton bAtras;
    private JButton bCompra;
    private JComboBox combActividad;
    private JComboBox <TipoAbono> combTiempo;
    private JLabel eActividad;
    private JLabel eComprarAbono;
    private JLabel eDescripcion;
    private JLabel eTipoAbono;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorAbonos c;
   
    public ComprarAbono(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorAbonos();
    	this.usuario = usuario;
    	this.ventanaPrincipal = v;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Comprar abono");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }

    private void initComponents() {

        eDescripcion = new javax.swing.JLabel();
        eActividad = new javax.swing.JLabel();
        combTiempo = new javax.swing.JComboBox <TipoAbono>(TipoAbono.values());
        eTipoAbono = new javax.swing.JLabel();
        combActividad = new javax.swing.JComboBox();
        bCompra = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        eComprarAbono = new javax.swing.JLabel();
        
        eDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        eDescripcion.setText("A continuación, selecciona una actividad, y el tipo de abono que deseas comprar.");

        eActividad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eActividad.setText("Actividad:");

        combTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTiempoActionPerformed(evt);
            }
        });

        eTipoAbono.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eTipoAbono.setText("Tipo de abono:");

        combActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gimnasio", "Piscina" }));
        combActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combActividadActionPerformed(evt);
            }
        });

        bCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonISConfCompra.png"))); // NOI18N
        bCompra.setBorder(null);
        bCompra.setBorderPainted(false);
        bCompra.setContentAreaFilled(false);
        bCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCompraActionPerformed(evt);
            }
        });

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

        eComprarAbono.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eComprarAbono.setText("COMPRAR UN ABONO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(eComprarAbono))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eDescripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bCompra)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eActividad)
                                    .addComponent(eTipoAbono))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(combActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eComprarAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eDescripcion)
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eActividad)
                            .addComponent(combActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eTipoAbono)
                    .addComponent(combTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(bCompra)
                .addGap(59, 59, 59))
        );

        this.ventanaPrincipal.pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
       JPanel obj = new InicioUser(this.usuario, this.ventanaPrincipal);
       obj.setVisible(true);
       this.ventanaPrincipal.add(obj);
       this.ventanaPrincipal.revalidate();
       this.ventanaPrincipal.pack();
    }//GEN-LAST:event_bAtrasActionPerformed

    private void combActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combActividadActionPerformed

    private void combTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combTiempoActionPerformed

    private void bCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCompraActionPerformed
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        c.setTime(new Date()); // Now use today date.
        switch ((TipoAbono)combTiempo.getSelectedItem()) {
        case MENSUAL:
        	c.add(Calendar.DATE, 30);
        	break;
        case TRIMESTRAL:
        	c.add(Calendar.DATE, 90);
        	break;
        case ANUAL:
        	c.add(Calendar.DATE, 365);
        	break;
        }
        String fechaInicial = formato.format(c2.getTime());
        String fechaFinal = formato.format(c.getTime());
        TransferAbono abono;
		try {
			abono = new TransferAbono (combActividad.getSelectedItem().toString(), formato.parse(fechaInicial), formato.parse(fechaFinal), this.usuario.getIdUser(), this.usuario.getDni());
	        if(this.c.comprarAbono(abono)) {
	        	JOptionPane.showMessageDialog(null,
	        			"Se ha cursado la compra satisfactoriamente",
	        			"Exito al comprar",
	        			JOptionPane.INFORMATION_MESSAGE);
	        }
	        else {
	        	JOptionPane.showMessageDialog(null,
	        			"Tienes un abono activo todavía,\n      caduca el día " + abono.getFechaFinal(),
	        			"Error al comprar",
	        			JOptionPane.CANCEL_OPTION);
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    }//GEN-LAST:event_bCompraActionPerformed
}
