package miu.edu.springmongodemo.domain;

public class Supplier {

    private String supplierId;
    private String name;
    private String contactInfo;

    public Supplier(String supplierId, String name, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public void updateInfo(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}
