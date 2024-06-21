/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author NGUYEN VAN CANH
 */
import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;
import model.InvoiceProduct;
import model.Product;
import model.Subsidiary;
import model.User;

/**
 *
 * @author NGUYEN VAN CANH
 */
public class InvoiceDAO extends DAO {

    public InvoiceDAO() {
        super();
    }

    public List<InvoiceProduct> getInvoice(Date startDate, Date endDate, int productId) throws SQLException {
        List<InvoiceProduct> invoiceproduct = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql1 = "SELECT i.id AS invoiceId, i.paymentdate, u.id AS userId, u.fullname, "
        + "s.id AS subsidiaryId, s.name AS subsidiaryName, "
        + "SUM((SELECT SUM(ip2.quantity) FROM invoiceproducts ip2 WHERE ip2.idInvoice = i.id)) AS totalQuantity, "
        + "SUM((SELECT SUM(ip2.price * ip2.quantity) FROM invoiceproducts ip2 WHERE ip2.idInvoice = i.id)) AS totalIncome "
        + "FROM invoices i "
        + "INNER JOIN users u ON i.idUser = u.id "
        + "INNER JOIN subsidiarys s ON i.idSubsidiary = s.id "
        + "INNER JOIN invoiceproducts ip ON i.id = ip.idInvoice "
        +"WHERE i.exportdate >= ? AND i.exportdate <= ? "
        + "AND ip.idProduct = ? "
        + "GROUP BY i.id";

        try (PreparedStatement ps = con.prepareStatement(sql1)) {
            ps.setString(1, sdf.format(startDate));
            ps.setString(2, sdf.format(endDate));
            ps.setInt(3, productId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Invoice invoice = new Invoice();
                    User u=new User();
                    Subsidiary s=new Subsidiary();
                    invoice.setId(resultSet.getInt("invoiceId"));
                    invoice.setPaymentdate(resultSet.getDate("paymentdate"));
                    u.setId(resultSet.getInt("userId"));
                    u.setName(resultSet.getString("fullname"));
                    s.setId(resultSet.getInt("subsidiaryId"));
                    s.setName(resultSet.getString("subsidiaryName"));
                    invoice.setU(u);
                    invoice.setS(s);
                    String sql2 = "SELECT ip.idProduct, p.name AS productName, ip.price, ip.quantity, (ip.price * ip.quantity) AS income "
                            + "FROM invoiceproducts ip "
                            + "INNER JOIN products p ON ip.idProduct = p.id "
                            + "WHERE ip.idInvoice = ?";
                    try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                        ps2.setInt(1, invoice.getId());
                        try (ResultSet rs = ps2.executeQuery()) {
                            while (rs.next()) {
                                InvoiceProduct invoiceProduct = new InvoiceProduct();
                                Product p=new Product();
                                p.setId(rs.getInt("idProduct"));
                                p.setName(rs.getString("productName"));
                                invoiceProduct.setPrice(rs.getFloat("price"));
                                invoiceProduct.setQuanity(rs.getInt("quantity"));
                                invoiceProduct.setIncome(rs.getFloat("income"));
                                invoiceProduct.setProduct(p);
                                invoiceProduct.setInvoice(invoice);
                                invoiceproduct.add(invoiceProduct);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoiceproduct;
    }

}
