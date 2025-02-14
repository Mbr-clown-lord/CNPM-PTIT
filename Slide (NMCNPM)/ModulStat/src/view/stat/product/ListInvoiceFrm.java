/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.stat.product;

/**
 *
 * @author NGUYEN VAN CANH
 */
import dao.InvoiceDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Invoice;
import model.InvoiceProduct;
import model.Product;
import model.User;
import view.user.LoginFrm;

/**
 *
 * @author NGUYEN VAN CANH
 */
public class ListInvoiceFrm extends javax.swing.JFrame {

    private User user;
    public static String productName;
    public static int productId;
    public static Date startDate;
    public static Date endDate;
    private InvoiceDAO invoiceDAO;
    public static DefaultTableModel model;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DetailInvoiceFrm detailInvoiceFrame;
    private Product product;
    public static ArrayList<InvoiceProduct> invoices1;

    /**
     * Creates new form ListInvoiceFrm
     */
    public ListInvoiceFrm(User user, Product product, Date startDate, Date endDate) throws SQLException, ParseException {
        super("Manager Home");
        initComponents();
        this.user = user;
        this.product = product;
        this.startDate = startDate;
        this.endDate = endDate;

        fullnameJLabel.setText("Tài khoản " + user.getFullName());
        idProductLabel.setText("Mã sản phẩm: " + product.getId());
        nameProductLabel.setText("Tên sản phẩm: " + product.getName());
        String sd = sdf.format(startDate);
        String ed = sdf.format(endDate);
        timestatLabel.setText("Thống kê từ ngày " + sd + " đến ngày " + ed);
        model = (DefaultTableModel) listInvoiceTable.getModel();
        listInvoiceTable.setDefaultEditor(Object.class, null);
        this.invoiceDAO = new InvoiceDAO();
        List<InvoiceProduct> invoiceproduct = this.invoiceDAO.getInvoice(this.startDate, this.endDate, product.getId());
//        invoices1 = (ArrayList<InvoiceProduct>) invoiceproduct;
        displayInvoices(invoiceproduct);
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
        fullnameJLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        statButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listInvoiceTable = new javax.swing.JTable();
        idProductLabel = new javax.swing.JLabel();
        nameProductLabel = new javax.swing.JLabel();
        timestatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DANH SÁCH HÓA ĐƠN");

        fullnameJLabel.setText("Tài khoản Manager");

        logoutButton.setText("Đăng xuất");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Đổi mật khẩu");

        jLabel3.setText("TÍNH NĂNG");

        statButton.setText("Xem thống kê");
        statButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statButtonActionPerformed(evt);
            }
        });

        jButton5.setText("Quản lý");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        listInvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Id", "Paymentdate", "Total", "Income"
            }
        ));
        listInvoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listInvoiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listInvoiceTable);
        if (listInvoiceTable.getColumnModel().getColumnCount() > 0) {
            listInvoiceTable.getColumnModel().getColumn(0).setResizable(false);
        }

        idProductLabel.setText("Mã sản phẩm:");

        nameProductLabel.setText("Tên sản phẩm:");

        timestatLabel.setText("Thống kê từ ngày  đến ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idProductLabel)
                        .addGap(27, 27, 27)
                        .addComponent(nameProductLabel))
                    .addComponent(timestatLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1307, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullnameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fullnameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(timestatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idProductLabel)
                            .addComponent(nameProductLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(614, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginFrm loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed
    public int i = 1;

    private void displayInvoices(List<InvoiceProduct> invoices) {
        Map<String, InvoiceProduct> mergedMap = new HashMap<>();
        for (InvoiceProduct invoiceProduct : invoices) {
            String key = invoiceProduct.getInvoice().getId() + "-" + invoiceProduct.getProduct().getId();
            if (mergedMap.containsKey(key)) {
                InvoiceProduct mergedProduct = mergedMap.get(key);
                mergedProduct.setQuanity(mergedProduct.getQuanity() + invoiceProduct.getQuanity());
                mergedProduct.setIncome(mergedProduct.getIncome() + invoiceProduct.getIncome());
            } else {
                mergedMap.put(key, invoiceProduct);
            }
        }

        List<InvoiceProduct> mergedList = new ArrayList<>(mergedMap.values());
        invoices1=(ArrayList<InvoiceProduct>) mergedList;
        for (InvoiceProduct invoice : mergedList) {
            if (invoice.getProduct().getId() == product.getId()) {
                Object[] rowData = {
                    i++, 
                    invoice.getInvoice().getId(),
                    invoice.getInvoice().getPaymentdate(),
                    invoice.getQuanity(),
                    invoice.getIncome(),
                };
                model.addRow(rowData);
            }
        }
    }

    private void statButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statButtonActionPerformed
        SelectStatFrm selectstatFrm = new SelectStatFrm(user);
        selectstatFrm.setVisible(true);
        dispose();
    }//GEN-LAST:event_statButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void listInvoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listInvoiceTableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = listInvoiceTable.rowAtPoint(evt.getPoint());
            int invoiceId = Integer.parseInt(listInvoiceTable.getValueAt(row, 1).toString());
            Invoice invoice = new Invoice();
            invoice.setId(invoiceId);
            try {
                detailInvoiceFrame = new DetailInvoiceFrm(user, invoice, invoices1);
            } catch (SQLException ex) {
                Logger.getLogger(ListInvoiceFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
            detailInvoiceFrame.setVisible(true);
            dispose();
    }//GEN-LAST:event_listInvoiceTableMouseClicked
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        User user = new User();
        Product product = new Product();
//        InvoiceDAO invoiceDAO=new InvoiceDAO();
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
            java.util.logging.Logger.getLogger(ListInvoiceFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListInvoiceFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListInvoiceFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListInvoiceFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ListInvoiceFrm(user, product, startDate, endDate).setVisible(true);

            } catch (SQLException | ParseException ex) {
                Logger.getLogger(ListInvoiceFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fullnameJLabel;
    private javax.swing.JLabel idProductLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listInvoiceTable;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameProductLabel;
    private javax.swing.JButton statButton;
    private javax.swing.JLabel timestatLabel;
    // End of variables declaration//GEN-END:variables
}
