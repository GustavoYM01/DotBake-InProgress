package telas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import objetos.Usuario;

public class Tela_Receitas extends javax.swing.JFrame {

    Usuario user = new Usuario();
    
    public Tela_Receitas() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(null);
        
        String nomeUsuario = "";
        
        String emailUsuario = user.getEmailUsuario();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dot_bake", "root", "123456");
            
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            
            String SQL = "SELECT * FROM receitas;";
            String SQL2 = "SELECT nome_usuario FROM usuarios WHERE email = " + "'" + emailUsuario + "';";
            
            ResultSet rs = stmt.executeQuery(SQL);
            ResultSet rs2 = stmt2.executeQuery(SQL2);
    
            if(rs2.next()) { 
                nomeUsuario = rs2.getString("nome_usuario");
                String titulo = "Usuário: ";
                Campo_usuario.append(titulo);
                Campo_usuario.append(nomeUsuario);
                user.setNomeUsuario2(nomeUsuario); 
            }
            
            while(rs.next()) {
              String respons_receita = "RESPONSÁVEL PELA RECEITA: ";
              String nome_usuario = rs.getString("respons_receita");
              CampoReceitas.append(respons_receita);
              CampoReceitas.append(nome_usuario);
              CampoReceitas.append("\n\n");
              String titulo = rs.getString("titulo");
              CampoReceitas.append(titulo.toUpperCase());
              String separador = ": ";
              CampoReceitas.append(separador);
              CampoReceitas.append("\n");
              String descricao = rs.getString("descricao");
              CampoReceitas.append(descricao);
              CampoReceitas.append("\n==========================================================================\n\n");
            }
        } catch (Exception e) {
            System.out.println("Erro " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        BotaoHome = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BotaoAddReceita = new javax.swing.JButton();
        BotaoPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoReceitas = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Campo_usuario = new javax.swing.JTextArea();
        logoff = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotaoHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/correctHomeButtonLight-dotbake.png"))); // NOI18N
        BotaoHome.setBorder(null);
        BotaoHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoHomeActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 190, 40, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/NewCloseButton-dotbake.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 70, 50));

        BotaoAddReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/NewAddReceitaButton-dotbake.png"))); // NOI18N
        BotaoAddReceita.setBorder(null);
        BotaoAddReceita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoAddReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAddReceitaActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoAddReceita, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 630, 80, 80));

        BotaoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/searchButtonDark-dotbake.png"))); // NOI18N
        BotaoPesquisa.setBorder(null);
        BotaoPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 293, 40, -1));

        CampoReceitas.setEditable(false);
        CampoReceitas.setBackground(new java.awt.Color(255, 227, 205));
        CampoReceitas.setColumns(20);
        CampoReceitas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoReceitas.setLineWrap(true);
        CampoReceitas.setRows(5);
        jScrollPane1.setViewportView(CampoReceitas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 48, 850, 650));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/darkDeleteButton-dotBake.png"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 390, 50, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/correctRefreshButtonDotbake.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 480, 50, 50));

        Campo_usuario.setEditable(false);
        Campo_usuario.setBackground(new java.awt.Color(255, 214, 182));
        Campo_usuario.setColumns(20);
        Campo_usuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Campo_usuario.setLineWrap(true);
        Campo_usuario.setRows(5);
        Campo_usuario.setBorder(null);
        jScrollPane2.setViewportView(Campo_usuario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, -1));

        logoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/logoff2-dotbake.png"))); // NOI18N
        logoff.setBorder(null);
        logoff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoffActionPerformed(evt);
            }
        });
        getContentPane().add(logoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 570, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_img/tela receitas (admin).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAddReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAddReceitaActionPerformed
        Tela_AddReceitas tar = new Tela_AddReceitas();
        tar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotaoAddReceitaActionPerformed

    private void BotaoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoHomeActionPerformed
        
    }//GEN-LAST:event_BotaoHomeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BotaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisaActionPerformed
        Tela_Pesquisa_Receita tpr = new Tela_Pesquisa_Receita();
        tpr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotaoPesquisaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Tela_Deleta_Receita tdr = new Tela_Deleta_Receita();
        tdr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tela_Atualiza_Receita tar = new Tela_Atualiza_Receita();
        tar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoffActionPerformed
        Tela_Login tl = new Tela_Login();
        tl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoffActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Receitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Receitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Receitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Receitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Receitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAddReceita;
    private javax.swing.JButton BotaoHome;
    private javax.swing.JButton BotaoPesquisa;
    private javax.swing.JTextArea CampoReceitas;
    private javax.swing.JTextArea Campo_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoff;
    // End of variables declaration//GEN-END:variables
}
