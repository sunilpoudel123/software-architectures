package com.ecommerce.stock;

public class Stock {

    private String productNumber;

    private int stockUnit;

    public Stock(String productNumber, int stockUnit) {
        this.productNumber = productNumber;
        this.stockUnit = stockUnit;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(int stockUnit) {
        this.stockUnit = stockUnit;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "productNumber='" + productNumber + '\'' +
                ", stockUnit=" + stockUnit +
                '}';
    }
}
