/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ariekurniawan
 */
public class Setting extends javax.swing.JFrame {

    private String user;
    private int i;
    public MainMenu m;
    public Aplikasi app;
    /**
     * Creates new form Setting
     */
    public Setting(MainMenu m, Aplikasi app, String user, int i) {
        this.m = m;
        this.app = app;
        this.user = user;
        this.i = i;
        initComponents();
    }
    public Setting() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        LabelSetting = new javax.swing.JLabel();
        LabelPilihOpsi = new javax.swing.JLabel();
        ComboBoxSetting = new javax.swing.JComboBox();
        LabelPassword = new javax.swing.JLabel();
        LabelPasswordBaru = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        TextPasswordBaru = new javax.swing.JPasswordField();
        ButtonGo = new javax.swing.JButton();
        ButtonMainMenu = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelSetting.setText("Setting user: " + this.user);

        LabelPilihOpsi.setText("Pilih Opsi");

        ComboBoxSetting.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ubah Password", "Hapus Akun" }));
        ComboBoxSetting.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxSettingItemStateChanged(evt);
            }
        });
        ComboBoxSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSettingActionPerformed(evt);
            }
        });

        LabelPassword.setText("Password");

        LabelPasswordBaru.setText("Konfirmasi Password");

        ButtonGo.setText("Go");
        ButtonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGoActionPerformed(evt);
            }
        });

        ButtonMainMenu.setText("Main Menu");
        ButtonMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelPilihOpsi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(LabelPassword)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(128, 128, 128)
                                    .addComponent(ButtonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(LabelPasswordBaru)
                                    .addGap(30, 30, 30)
                                    .addComponent(TextPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(LabelSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonMainMenu)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelSetting)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPilihOpsi)
                    .addComponent(ComboBoxSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPasswordBaru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonGo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(ButtonMainMenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGoActionPerformed
        if(ComboBoxSetting.getSelectedIndex()==0){
            if(TextPassword.getText().equals(TextPasswordBaru.getText())){
                try {
                    app.ubahPassword(TextPassword.getText(), i);
                    JOptionPane.showMessageDialog(null,"Password berhasil diubah!","Ubah Password Sukses",1);
                } catch (IOException ex) {
                    Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else JOptionPane.showMessageDialog(null,"Password retype mismatch!","Ubah Password Gagal",2);
            
        }else{
            try {
                boolean cek = app.hapusAkun(i, TextPassword.getText());
                if(cek){
                    JOptionPane.showMessageDialog(null,"Akun berhasil dihapus!","Hapus Akun Sukses",1);
                    this.setVisible(false);
                    GUI g = new GUI();
                    g.setLocationRelativeTo(null);
                    g.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null,"Password salah!","Hapus Akun Gagal",2);
            } catch (IOException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ButtonGoActionPerformed

    private void ButtonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMainMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }//GEN-LAST:event_ButtonMainMenuActionPerformed

    private void ComboBoxSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSettingActionPerformed
        // TODO add your handling code here:
        if(ComboBoxSetting.getSelectedIndex()==0){
            TextPasswordBaru.setEnabled(true);
            LabelPasswordBaru.setEnabled(true);
        }else{
            LabelPasswordBaru.setEnabled(false);
            TextPasswordBaru.setEnabled(false);
        }
    }//GEN-LAST:event_ComboBoxSettingActionPerformed

    private void ComboBoxSettingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxSettingItemStateChanged
        // TODO add your handling code here:
        if(ComboBoxSetting.getSelectedIndex()==0){
            TextPasswordBaru.setEnabled(true);
            LabelPasswordBaru.setEnabled(true);
        }else{
            LabelPasswordBaru.setEnabled(false);
            TextPasswordBaru.setEnabled(false);
        }
    }//GEN-LAST:event_ComboBoxSettingItemStateChanged

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
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Setting s = new Setting();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonGo;
    private javax.swing.JButton ButtonMainMenu;
    private javax.swing.JComboBox ComboBoxSetting;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelPasswordBaru;
    private javax.swing.JLabel LabelPilihOpsi;
    private javax.swing.JLabel LabelSetting;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JPasswordField TextPasswordBaru;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
