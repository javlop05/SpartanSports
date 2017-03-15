package Ventanas;

import java.awt.Color;

import javax.swing.JFrame;

import Comunicaciones.ControladorComunicaciones;
import transfer.TransferMensaje;
import transfer.TransferUsuario;

public class verMensaje extends javax.swing.JPanel {

    private javax.swing.JButton bAtras;
    private javax.swing.JLabel eEmisor;
    private javax.swing.JLabel eReceptor;
    private javax.swing.JLabel eReceptor1;
    private javax.swing.JLabel eReceptor2;
    private javax.swing.JLabel eReceptor3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    
    private TransferUsuario usuario;
    private TransferMensaje mensaje;
    private JFrame ventanaPrincipal;
    private ControladorComunicaciones c;
    
    public verMensaje(TransferUsuario usuario, TransferMensaje mensaje, JFrame ventanaPrincipal) {
    	this.c = new ControladorComunicaciones();
    	this.usuario = usuario;
    	this.mensaje = mensaje;
    	this.ventanaPrincipal = ventanaPrincipal;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Ver mensaje");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
                   
    private void initComponents() {

        eEmisor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eReceptor = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        eReceptor1 = new javax.swing.JLabel();
        eReceptor2 = new javax.swing.JLabel();
        eReceptor3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        eEmisor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Integer emisor = mensaje.getEmisor();
        eEmisor.setText(emisor.toString());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("@spartansports.com");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("@spartansports.com");

        eReceptor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Integer receptor = mensaje.getReceptor();
        eReceptor.setText(receptor.toString());

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

        eReceptor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eReceptor1.setText("Asunto:");

        eReceptor2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eReceptor2.setText(mensaje.getAsunto());

        eReceptor3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eReceptor3.setText(mensaje.getFecha().toString());

        jTextPane1.setText(mensaje.getContenido());
        jTextPane1.disable();
        jTextPane1.setDisabledTextColor(Color.black);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eReceptor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eEmisor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eReceptor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eReceptor2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(eReceptor3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(eEmisor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(eReceptor))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eReceptor1)
                    .addComponent(eReceptor2)
                    .addComponent(eReceptor3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }                      

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {          
    	if(usuario.getIdUser() == mensaje.getIdEmisor())
    		new BandejaSalida(usuario, this.ventanaPrincipal);
    	else if (usuario.getIdUser() == mensaje.getIdReceptor())
    		new BandejaEntrada(usuario, this.ventanaPrincipal);
    }                                      
        
}