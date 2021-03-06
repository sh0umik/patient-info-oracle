package hosman;

import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Patient_Retrieve.java
 *
 * Created on 12 Nov, 2011, 7:24:15 PM
 */
/**
 *
 * @author avp
 */
public class Patient_Retrieve extends javax.swing.JFrame {

    /** Creates new form Patient_Retrieve */
    public Patient_Retrieve() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        patientsQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Patients p");
        patientsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : patientsQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        submit_id = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        submit_name = new javax.swing.JButton();
        submit_age = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        close = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patient ID");

        submit_id.setText("Submit");
        submit_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_idActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, patientsList, table);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${age}"));
        columnBinding.setColumnName("Age");
        columnBinding.setColumnClass(java.math.BigInteger.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sex}"));
        columnBinding.setColumnName("Sex");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contact}"));
        columnBinding.setColumnName("Contact");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ddate}"));
        columnBinding.setColumnName("Ddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${adate}"));
        columnBinding.setColumnName("Adate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(table);

        jLabel2.setText("Name");

        submit_name.setText("Submit");
        submit_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_nameActionPerformed(evt);
            }
        });

        submit_age.setText("Submit");
        submit_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_ageActionPerformed(evt);
            }
        });

        jLabel3.setText("Age");

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        clear.setText("Clear All");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submit_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submit_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submit_age, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(499, 499, 499)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submit_id)
                                .addGap(18, 18, 18)
                                .addComponent(submit_name)
                                .addGap(28, 28, 28)
                                .addComponent(submit_age))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel3))))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clear)
                        .addGap(18, 18, 18)
                        .addComponent(close)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_idActionPerformed
            int n =0, id = Integer.parseInt(jTextField1.getText());
            
//            String result1 = jTextField1.getText();
            ResultSet rs = null;
        try {
            JDBC pr = new JDBC();
            rs = pr.Retrieve_Patient_id(id);
            while (rs.next())
            {
                table.setValueAt(rs.getString(1), n, 0);
                table.setValueAt(rs.getString(2), n, 1);
                table.setValueAt(rs.getString(3), n, 2);
                table.setValueAt(rs.getString(4), n, 3);
                table.setValueAt(rs.getString(5), n, 4);
                table.setValueAt(rs.getString(6), n, 5);
                table.setValueAt(rs.getString(7), n, 6);
                table.setValueAt(rs.getString(8), n, 7);
                n++;
            }
            jTextField2.setText("");
            jTextField3.setText("");
        }
            catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Exception : " + e.getMessage());
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_submit_idActionPerformed

        private void submit_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_nameActionPerformed
            int n = 0;
            String name = jTextField2.getText();
            ResultSet rs = null;
        try {
            JDBC pr = new JDBC();
            rs = pr.Retrieve_Patient_name(name);
            while (rs.next())
            {
                table.setValueAt(rs.getString(1), n, 0);
                table.setValueAt(rs.getString(2), n, 1);
                table.setValueAt(rs.getString(3), n, 2);
                table.setValueAt(rs.getString(4), n, 3);
                table.setValueAt(rs.getString(5), n, 4);
                table.setValueAt(rs.getString(6), n, 5);
                table.setValueAt(rs.getString(7), n, 6);
                table.setValueAt(rs.getString(8), n, 7);
                n++;
            }
            jTextField1.setText("");
            jTextField3.setText("");
        }
            catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Exception : " + e.getMessage());
        }
    }//GEN-LAST:event_submit_nameActionPerformed

    private void submit_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_ageActionPerformed
            int n =0, age = Integer.parseInt(jTextField3.getText());
            ResultSet rs = null;
        try {
            JDBC pr = new JDBC();
            rs = pr.Retrieve_Patient_age(age);
            while (rs.next())
            {
                table.setValueAt(rs.getString(1), n, 0);
                table.setValueAt(rs.getString(2), n, 1);
                table.setValueAt(rs.getString(3), n, 2);
                table.setValueAt(rs.getString(4), n, 3);
                table.setValueAt(rs.getString(5), n, 4);
                table.setValueAt(rs.getString(6), n, 5);
                table.setValueAt(rs.getString(7), n, 6);
                table.setValueAt(rs.getString(8), n, 7);
                n++;
            }
            jTextField1.setText("");
            jTextField2.setText("");
        }
            catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Exception : " + e.getMessage());
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_submit_ageActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_closeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        for (int n=0; n<50; n++)
        {
                table.setValueAt("", n, 0);
                table.setValueAt("", n, 1);
                table.setValueAt("", n, 2);
                table.setValueAt("", n, 3);
                table.setValueAt("", n, 4);
                table.setValueAt("", n, 5);
                table.setValueAt("", n, 6);
                table.setValueAt("", n, 7);
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed
        
    /**
     * @param args the command line arguments
     */
    public void NewMain() {
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
            java.util.logging.Logger.getLogger(Patient_Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Patient_Retrieve().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.util.List<hosman.Patients> patientsList;
    private javax.persistence.Query patientsQuery;
    private javax.swing.JButton submit_age;
    private javax.swing.JButton submit_id;
    private javax.swing.JButton submit_name;
    private javax.swing.JTable table;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
