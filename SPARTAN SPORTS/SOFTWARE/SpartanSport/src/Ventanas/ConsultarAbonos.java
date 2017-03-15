package Ventanas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Abonos.ControladorAbonos;
import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferAbono;
import transfer.TransferUsuario;
import Usuarios.ControladorUsuarios;
import auxiliar.*;

public class ConsultarAbonos extends JPanel {

    private javax.swing.JButton bAtras;
    private javax.swing.JComboBox <TipoOrdenacion> combBuscar;
    private javax.swing.JComboBox <TipoOrdenacion> combOrdenar;
    private javax.swing.JLabel eBuscar;
    private javax.swing.JLabel eConsultarAbonos;
    private javax.swing.JLabel eDescripcion;
    private javax.swing.JLabel eOrdenar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList <TransferAbono> lAbonos;
    private javax.swing.JTextField tBuscar;
    
    private JFrame ventanaPrincipal;
    private TransferUsuario usuario;
    private ControladorAbonos c;
    
    public ConsultarAbonos(TransferUsuario usuario, JFrame v) {
    	this.c = new ControladorAbonos();
    	this.ventanaPrincipal = v;
    	this.usuario = usuario;
    	this.ventanaPrincipal.getContentPane().removeAll();
        initComponents();
        this.ventanaPrincipal.setTitle("SpartanSports - Consultar Abonos");
        this.setVisible(true);
        this.ventanaPrincipal.add(this);
        this.ventanaPrincipal.revalidate();
        this.ventanaPrincipal.pack();
    }
    
    private void initComponents() {

    	List <TransferAbono> listaAbonos = c.consultarListaAbonos(TipoOrdenacion.NINGUNO, "");
        jScrollPane1 = new javax.swing.JScrollPane();
        eOrdenar = new javax.swing.JLabel();
        combOrdenar = new javax.swing.JComboBox <TipoOrdenacion>();
        eBuscar = new javax.swing.JLabel();
        combBuscar = new javax.swing.JComboBox <TipoOrdenacion>();
        tBuscar = new javax.swing.JTextField();
        eDescripcion = new javax.swing.JLabel();
        eConsultarAbonos = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
          
        lAbonos = new JList<TransferAbono>(new MyListModel<TransferAbono>(listaAbonos));
        lAbonos.setCellRenderer(new AbonosCellRenderer());
        jScrollPane1.setViewportView(lAbonos);

        eOrdenar.setText("Ordenar por");

        combOrdenar.addItem(TipoOrdenacion.NOMBRE_ABONO);
        combOrdenar.addItem(TipoOrdenacion.FECHA);
        combOrdenar.addItem(TipoOrdenacion.DNI);
        combOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combOrdenarActionPerformed(evt);
            }
        });

        eBuscar.setText("Buscar");

        combBuscar.addItem(TipoOrdenacion.NOMBRE_ABONO);
        combBuscar.addItem(TipoOrdenacion.FECHA);
        combBuscar.addItem(TipoOrdenacion.DNI);
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

        eDescripcion.setText("A continuación aparece la lista de abonos comprados por los clientes.");

        eConsultarAbonos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        eConsultarAbonos.setText("CONSULTAR ABONOS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eConsultarAbonos)
                                .addComponent(eDescripcion)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eConsultarAbonos)
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
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }
    
    private void combOrdenarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	MyListModel <TransferAbono> lista = (MyListModel<TransferAbono>) lAbonos.getModel();
    	List <TransferAbono> listaAbonos = new ArrayList<TransferAbono>();
    	for(int i = 0; i < lista.getSize(); i++)
    		listaAbonos.add(lista.getElementAt(i));
    	
    	switch ((TipoOrdenacion) combOrdenar.getSelectedItem()) {
    	case FECHA:
    		listaAbonos = c.ordenarAbonos(TipoOrdenacion.FECHA, listaAbonos);
    		break;
    	case NOMBRE_ABONO:
    		listaAbonos = c.ordenarAbonos(TipoOrdenacion.NOMBRE_ABONO, listaAbonos);
    		break;
    	case DNI:
    		listaAbonos = c.ordenarAbonos(TipoOrdenacion.DNI, listaAbonos);
    		break;
    	}
    	
    	lAbonos.setModel(new MyListModel <TransferAbono> (listaAbonos));
    }                                           

    private void combBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                           

    }                                          

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                        
   	 String busqueda = tBuscar.getText();
     TipoOrdenacion tipo = (TipoOrdenacion) combBuscar.getSelectedItem();
     
     List <TransferAbono> listaAbonos = new ArrayList<TransferAbono>();
     
     if(!busqueda.isEmpty())
     	listaAbonos = c.consultarListaAbonos(tipo, busqueda);
     else
     	listaAbonos = c.consultarListaAbonos(TipoOrdenacion.NINGUNO, "");

     lAbonos.setModel(new MyListModel <TransferAbono> (listaAbonos));
    }                                       

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                       
        new InicioAdmin(this.usuario, this.ventanaPrincipal);
    }                   
    
}
