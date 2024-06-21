/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author NGUYEN VAN CANH
 */
public class ProductStat extends Product implements Serializable  {
    private float total;
    private float income;
    
    public ProductStat() {
        super();
    }
    
    public ProductStat( float total, float income) {
		super();
		this.total = total;
		this.income=income;
	}
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
