package com.x.cart;

/**
 * Copy from http://www.monkey1024.com/javase/596
 * For using BDD Cucumber
 * Modified by:sam
 * Date:2020-6-22
 */

import java.math.BigDecimal;

public class Product {
    private int no;
    private String name;
    private BigDecimal price;
    private String note;// add this, for using Doc Strings in BDD Cucumber

    public Product() {
    }

    public Product(int no, String name, BigDecimal price,String note) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[编号：" + no + ",名称：" + name + ",单价：" + price + "元/斤]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + no;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (no != other.no)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

}
