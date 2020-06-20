package Models;

import java.util.Objects;

public class Order {
    private String id;
    private String status;
    private String product;
    private int quantity;
    private String name;
    private String address;
    private String date;
    private String payment;
    private String mail;
    private String cardNumber="";
    private String expirationDate="";
    private String cvv="";

    public Order(String id, String status, String product, int quantity, String name, String address, String date, String payment,String mail) {
        this.id = id;
        this.status = status;
        this.product = product;
        this.quantity = quantity;
        this.name = name;
        this.address = address;
        this.date = date;
        this.payment = payment;
        this.mail=mail;
    }

    public Order(String id, String status, String product, int quantity, String name, String address, String date, String payment, String mail, String cardNumber, String expirationDate, String cvv) {
        this.id = id;
        this.status = status;
        this.product = product;
        this.quantity = quantity;
        this.name = name;
        this.address = address;
        this.date = date;
        this.payment = payment;
        this.mail=mail;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                status.equals(order.status) &&
                product.equals(order.product) &&
                name.equals(order.name) &&
                address.equals(order.address) &&
                date.equals(order.date) &&
                payment.equals(order.payment) &&
                mail.equals(order.mail) &&
                cardNumber.equals(order.cardNumber) &&
                expirationDate.equals(order.expirationDate) &&
                cvv.equals(order.cvv) &&
                id.equals(order.id);
    }

    @Override
    public int hashCode() {
        int result = 31*status.hashCode();
        result = result*31 + product.hashCode();
        result = result*31 + name.hashCode();
        result = result*31 + address.hashCode();
        result = result*31 + date.hashCode();
        result = result*31 + payment.hashCode();
        result = result*31 + mail.hashCode();
        result = result*31 + cardNumber.hashCode();
        result = result*31 + expirationDate.hashCode();
        result = result*31 + cvv.hashCode();
        result = result*31 + id.hashCode();
        return result*31 + quantity;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", payment='" + payment + '\'' +
                ", mail='" + mail + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
