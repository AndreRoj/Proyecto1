/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Camino;
import Clases.Ciudad;
import Clases.ListaCiudad;
import Clases.NodoCiudad;
import Funciones.Global;
import Clases.ListaCaminos;
import javax.swing.JOptionPane;


/**
 *
 * @author Jose
 */
public class Ventana7 extends javax.swing.JFrame {

    ListaCiudad listaciudad = Global.getListaciudades();
    ListaCaminos listacaminos = Global.getListacaminos();

    public Ventana7() {
        initComponents();
        // llenado de los combo box
        NodoCiudad aux = listaciudad.getHead();
        while(aux != null){
            String numero = Integer.toString(aux.getElement().getName());
            ciudad1.addItem("Ciudad: "+numero);
            ciudad2.addItem("Ciudad: "+numero);
            aux = aux.getNext();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        ciudad2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        conectar = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        ciudad1 = new javax.swing.JComboBox<>();
        distancia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jPanel2.setBackground(new java.awt.Color(253, 253, 253));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(76, 60, 76));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 60, 76));
        jLabel1.setText("Agregar caminos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 210, 80));

        panelRound1.setBackground(new java.awt.Color(76, 60, 76));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ciudad2.setBackground(new java.awt.Color(137, 109, 137));
        ciudad2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ciudad2.setForeground(new java.awt.Color(253, 253, 253));
        ciudad2.setBorder(null);
        ciudad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudad2ActionPerformed(evt);
            }
        });
        panelRound1.add(ciudad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 120, 30));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(253, 253, 253));
        jLabel5.setText("Distancia");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 60, 20));

        conectar.setBackground(new java.awt.Color(137, 109, 137));
        conectar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        conectar.setForeground(new java.awt.Color(253, 253, 253));
        conectar.setText("Crear Camino");
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });
        panelRound1.add(conectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 110, -1));

        menu.setBackground(new java.awt.Color(137, 109, 137));
        menu.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(253, 253, 253));
        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        panelRound1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, -1));

        ciudad1.setBackground(new java.awt.Color(137, 109, 137));
        ciudad1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ciudad1.setForeground(new java.awt.Color(253, 253, 253));
        ciudad1.setBorder(null);
        ciudad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudad1ActionPerformed(evt);
            }
        });
        panelRound1.add(ciudad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 30));

        distancia.setBackground(new java.awt.Color(137, 109, 137));
        distancia.setForeground(new java.awt.Color(253, 253, 253));
        distancia.setText("0");
        distancia.setBorder(null);
        distancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaActionPerformed(evt);
            }
        });
        panelRound1.add(distancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 50, 20));

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(253, 253, 253));
        jLabel6.setText("Ciudades a conectar");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, -1));

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 420, 230));

        jPanel3.setBackground(new java.awt.Color(76, 60, 76));
        jPanel3.setForeground(new java.awt.Color(76, 60, 76));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 50, 100, 10));

        jPanel4.setBackground(new java.awt.Color(76, 60, 76));
        jPanel4.setForeground(new java.awt.Color(76, 60, 76));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ciudad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudad2ActionPerformed

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
        //Se obtienen las ciudades a conectar
        String ciudad11 = ciudad1.getSelectedItem().toString();
        String ciudad22 = ciudad2.getSelectedItem().toString();
        
        
        char ciudad111 = ciudad11.charAt(ciudad11.length() - 1);
        char ciudad222 = ciudad22.charAt(ciudad22.length() - 1);
        
        int numero1F = Character.getNumericValue(ciudad111);
        int numero2F = Character.getNumericValue(ciudad222);
        
        Ciudad ciudad1F = listaciudad.definirCiudad(numero1F);
        Ciudad ciudad2F = listaciudad.definirCiudad(numero2F);
        // si la ciudad es la misma se le notifica al usuario que no es posible
        if(ciudad1F.getName() == ciudad2F.getName()){
            JOptionPane.showMessageDialog(this, "No puedes conectar la misma ciudad!");
        }else{
            // se crea el camino
            int distancia = Integer.parseInt(this.distancia.getText());
        
            Camino camino = new Camino(ciudad1F, ciudad2F, distancia);

            listacaminos.insertFinal(camino);
            listacaminos.print();

            Global.setListacaminos(listacaminos);
        }
        
        
       

        
    }//GEN-LAST:event_conectarActionPerformed
    // cerrar ventana e ir al menu
    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed

        Ventana3 ventana3 = new Ventana3();
        ventana3.setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_menuActionPerformed

    private void ciudad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudad1ActionPerformed
        
    }//GEN-LAST:event_ciudad1ActionPerformed

    private void distanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaActionPerformed

    }//GEN-LAST:event_distanciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana7().setVisible(true);
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ciudad1;
    private javax.swing.JComboBox<String> ciudad2;
    private javax.swing.JButton conectar;
    private javax.swing.JTextField distancia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton menu;
    private Clases.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
