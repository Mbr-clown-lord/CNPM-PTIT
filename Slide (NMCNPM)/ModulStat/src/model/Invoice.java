/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NGUYEN VAN CANH
 */
public class Invoice implements Serializable {

    private int id;
    private Date orderdate;
    private Date paymentdate;
    private String paymenttype;
    private String note;
    private User u;
    private Subsidiary s;
    
    public Subsidiary getS() {
        return s;
    }

    public void setS(Subsidiary s) {
        this.s = s;
    }
    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Invoice() {
        super();
    }

    public Invoice(int id, Date paymentdate, float totalQuantity) {
        this.id = id;
        this.paymentdate = paymentdate;
//        this.total = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
