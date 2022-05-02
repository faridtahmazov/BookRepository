package model;

public class ProductDetails {
    private String productName;
    private Integer unitPrice;
    private Integer available;
    private String brandName;
    private String categoryName;

    public ProductDetails() {
    }

    public ProductDetails(String productName, Integer unitPrice, Integer available, String brandName, String categoryName) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.available = available;
        this.brandName = brandName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String  toString() {
        return "ProductDetails{" +
                "productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", available=" + available +
                ", brandName='" + brandName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
