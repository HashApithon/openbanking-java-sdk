package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OBReadTransaction {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("CreditDebitIndicator")
    private String creditDebitIndicator;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("BookingDateTime")
    private String bookingDateTime;

    @JsonProperty("Amount")
    private OBReadAmount amount;

    @JsonProperty("ProprietaryBankTransactionCode")
    private OBReadProprietaryBankTransactionCode proprietaryBankTransactionCode;

    @JsonProperty("TransactionInformation")
    private String transactionInformation;

    @JsonProperty("Balance")
    private OBReadBalance balance;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(String bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public OBReadAmount getAmount() {
        return amount;
    }

    public void setAmount(OBReadAmount amount) {
        this.amount = amount;
    }

    public OBReadProprietaryBankTransactionCode getProprietaryBankTransactionCode() {
        return proprietaryBankTransactionCode;
    }

    public void setProprietaryBankTransactionCode(OBReadProprietaryBankTransactionCode proprietaryBankTransactionCode) {
        this.proprietaryBankTransactionCode = proprietaryBankTransactionCode;
    }

    public String getTransactionInformation() {
        return transactionInformation;
    }

    public void setTransactionInformation(String transactionInformation) {
        this.transactionInformation = transactionInformation;
    }

    public OBReadBalance getBalance() {
        return balance;
    }

    @JsonProperty("Balance")
    public void setBalance(OBReadBalance balance) {
        this.balance = balance;
    }

}