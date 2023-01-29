package main.java.com.polezhaiev.homework18;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;



public class Product implements Comparable<Product> {
    private String type;
    private int price;

    private double discount = 0.1;
    private java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
    private Date date;

    public Product(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public java.util.Calendar getCalendar() {
        return calendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCalendar(Calendar calendar) {
        calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }

    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }
}
