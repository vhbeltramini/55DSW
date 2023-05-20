package com.vhbeltramini.dronezeta.service.dto;


public class PaymentMethodDTO {

    private String cardNumber;

    private String validDate;

    private String cardHolderName;

    private String cvv;

    private Integer user;

    public PaymentMethodDTO(String cardNumber, String validDate, String cardHolderName, String cvv, Integer user) {
        this.cardNumber = cardNumber;
        this.validDate = validDate;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer userID) {
        this.user = userID;
    }
}
