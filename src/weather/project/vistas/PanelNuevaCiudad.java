/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.vistas;

import weather.project.controlador.AñadirNuevaCiudad;
import weather.project.principal.WeatherAppFrame;

/**
 *
 * @author fabio
 */
public class PanelNuevaCiudad extends javax.swing.JPanel {
    WeatherAppFrame frame;

    /**
     * Creates new form PanelNuevaCiudad
     */
    public PanelNuevaCiudad(WeatherAppFrame frame) {
        initComponents();
        this.frame = frame;
        System.out.println("aaaaa");
    }
    
    public javax.swing.JTextField getTxtCiudad(){
        return txtCiudad;
    }
    
    public void setTxtCiudad(String msg){
        txtCiudad.setText(msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCiudad = new javax.swing.JLabel();
        btnConfirma = new javax.swing.JButton();
        txtCiudad = new javax.swing.JTextField();

        lblCiudad.setText("Nueva ciudad");

        btnConfirma.setText("Confirma");
        btnConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfirmaMousePressed(evt);
            }
        });
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnConfirma)
                .addContainerGap(174, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btnConfirmaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmaMousePressed
        // TODO add your handling code here:
        AñadirNuevaCiudad añadirNuevaCiudad = new AñadirNuevaCiudad(this);
        añadirNuevaCiudad.añadirCiudad();
    }//GEN-LAST:event_btnConfirmaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirma;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JTextField txtCiudad;
    // End of variables declaration//GEN-END:variables
}
