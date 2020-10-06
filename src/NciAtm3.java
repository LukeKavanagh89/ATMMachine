/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author sarasb
 */
public class NciAtm3 extends javax.swing.JFrame {
    ArrayList<Accounts> accounts = Utility.readFile("accounts.txt");
    Accounts currentAccount;
    
    private void initiateAccounts(){
        
        for (Accounts a: accounts){
            AccountDropDown.addItem(a);
        }
    }
    /**
     * Creates new form BankApp
     */
    public NciAtm3() {
        initComponents();
        this.setLocationRelativeTo(null);
        initiateAccounts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        AccountDropDown = new javax.swing.JComboBox<Accounts>();
        jbtnDeposit = new javax.swing.JButton();
        jbtnWithDraw = new javax.swing.JButton();
        jbtnTransfer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtnBack = new javax.swing.JButton();
        jbtnExit1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Account Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 180, 120, 40);

        jLabel2.setText("Customer Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 250, 110, 30);

        jLabel4.setText("Balance");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 310, 90, 40);

        customerField.setEditable(false);
        getContentPane().add(customerField);
        customerField.setBounds(320, 240, 140, 40);

        balanceField.setEditable(false);
        getContentPane().add(balanceField);
        balanceField.setBounds(320, 300, 140, 40);

        AccountDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountDropDownActionPerformed(evt);
            }
        });
        getContentPane().add(AccountDropDown);
        AccountDropDown.setBounds(320, 180, 140, 40);

        jbtnDeposit.setBackground(new java.awt.Color(51, 255, 51));
        jbtnDeposit.setText("Deposit");
        jbtnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDepositActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnDeposit);
        jbtnDeposit.setBounds(50, 190, 99, 50);

        jbtnWithDraw.setBackground(new java.awt.Color(255, 102, 102));
        jbtnWithDraw.setText("Withdraw");
        jbtnWithDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnWithDrawActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnWithDraw);
        jbtnWithDraw.setBounds(50, 320, 99, 50);

        jbtnTransfer.setBackground(new java.awt.Color(255, 255, 102));
        jbtnTransfer.setText("Transfer");
        jbtnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTransferActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnTransfer);
        jbtnTransfer.setBounds(50, 260, 98, 50);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel5.setText("NCI Group Bank");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 40, 410, 62);

        jLabel6.setText("Welcome Sarunas Kryzevicius ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 130, 180, 30);

        jbtnBack.setText("Back");
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBack);
        jbtnBack.setBounds(280, 400, 96, 36);

        jbtnExit1.setText("Exit");
        jbtnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExit1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnExit1);
        jbtnExit1.setBounds(140, 400, 96, 36);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/met2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 530, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountDropDownActionPerformed
        currentAccount = (Accounts) AccountDropDown.getSelectedItem();
        customerField.setText(currentAccount.getAccountHolder());
        balanceField.setText(String.valueOf(currentAccount.getBalance()));
    }//GEN-LAST:event_AccountDropDownActionPerformed

    private void jbtnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTransferActionPerformed
     String accountNumber = JOptionPane.showInputDialog(this, "Enter Account Number To Transfer ", "Transfer", JOptionPane.PLAIN_MESSAGE );
     Accounts transferAccount =null;
     for (Accounts a : accounts) {
         if (a.toString().equals(accountNumber)){
             transferAccount = a;
             break;
         }
     }
     String amountString = JOptionPane.showInputDialog(this, "Enter Transfer Amount ", "Transfer", JOptionPane.PLAIN_MESSAGE );
     double amount = Double.parseDouble(amountString);
     if (transferAccount !=null){
     currentAccount.transfer(transferAccount, amount);
     balanceField.setText(String.valueOf(currentAccount.getBalance()));
     Utility.writeFile(accounts, "accounts.txt");
    }//GEN-LAST:event_jbtnTransferActionPerformed
    }
    private void jbtnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDepositActionPerformed
     String amountString = JOptionPane.showInputDialog(this, "Enter Deposit Amount ", "Deposit", JOptionPane.PLAIN_MESSAGE );
     double amount = Double.parseDouble(amountString);
     currentAccount.deposit(amount);
     balanceField.setText(String.valueOf(currentAccount.getBalance()));
     Utility.writeFile(accounts, "accounts.txt");
    }//GEN-LAST:event_jbtnDepositActionPerformed

    private void jbtnWithDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnWithDrawActionPerformed
     String amountString = JOptionPane.showInputDialog(this, "Enter Withdraw Amount", "WithDraw", JOptionPane.PLAIN_MESSAGE );
     double amount = Double.parseDouble(amountString);
     currentAccount.withdraw(amount);
     balanceField.setText(String.valueOf(currentAccount.getBalance()));
     Utility.writeFile(accounts, "accounts.txt");
    }//GEN-LAST:event_jbtnWithDrawActionPerformed

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        Lobby Info = new Lobby();
        Info.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtnBackActionPerformed

    private void jbtnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExit1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtnExit1ActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NciAtm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NciAtm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NciAtm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NciAtm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NciAtm().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Accounts> AccountDropDown;
    private javax.swing.JTextField balanceField;
    private javax.swing.JTextField customerField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnDeposit;
    private javax.swing.JButton jbtnExit1;
    private javax.swing.JButton jbtnTransfer;
    private javax.swing.JButton jbtnWithDraw;
    // End of variables declaration//GEN-END:variables
}