/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author NGUYEN VAN CANH
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ProductStat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYEN VAN CANH
 */
public class ProductStatDAO extends DAO {

    public ProductStatDAO() {
        super();
    }

    public List<ProductStat> getProductStat(Date startDate, Date endDate) {
        List<ProductStat> result = new ArrayList<>();

        String sql = "SELECT p.id, p.name, SUM(ip.quantity) AS totalQuantity, SUM(ip.quantity*ip.price) AS totalIncome "
                + "FROM products p "
                + "JOIN invoiceproducts ip ON p.id = ip.idProduct "
                + "JOIN invoices i ON ip.idInvoice = i.id "
                + "WHERE i.exportdate >= ? AND i.exportdate <= ? "
                + "GROUP BY p.id, p.name";


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdf.format(startDate));
            ps.setString(2, sdf.format(endDate));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductStat productStat = new ProductStat();
                productStat.setId(rs.getInt("id"));
                productStat.setName(rs.getString("name"));
                productStat.setTotal(rs.getInt("totalQuantity"));
                productStat.setIncome(rs.getFloat("totalIncome"));
                result.add(productStat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
