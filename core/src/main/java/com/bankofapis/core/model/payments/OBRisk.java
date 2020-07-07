package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * The Risk section is sent by the initiating party to the ASPSP. It is used to specify additional details for risk scoring for Payments.
 */
@Validated
public class OBRisk {
    @JsonProperty("PaymentContextCode")
    private OBExternalPaymentContextCode paymentContextCode = null;

    @JsonProperty("MerchantCategoryCode")
    private String merchantCategoryCode = null;

    @JsonProperty("MerchantCustomerIdentification")
    private String merchantCustomerIdentification = null;

    @JsonProperty("DeliveryAddress")
    private OBRiskDeliveryAddress deliveryAddress = null;

    public OBRisk paymentContextCode(OBExternalPaymentContextCode paymentContextCode) {
        this.paymentContextCode = paymentContextCode;
        return this;
    }

    /**
     * Get paymentContextCode
     *
     * @return paymentContextCode
     **/


    @Valid

    public OBExternalPaymentContextCode getPaymentContextCode() {
        return paymentContextCode;
    }

    public void setPaymentContextCode(OBExternalPaymentContextCode paymentContextCode) {
        this.paymentContextCode = paymentContextCode;
    }

    public OBRisk merchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
        return this;
    }

    /**
     * Category code conform to ISO 18245, related to the type of services or goods the merchant provides for the transaction.
     *
     * @return merchantCategoryCode
     **/

    @Size(min = 3, max = 4)
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public OBRisk merchantCustomerIdentification(String merchantCustomerIdentification) {
        this.merchantCustomerIdentification = merchantCustomerIdentification;
        return this;
    }

    /**
     * The unique customer identifier of the PSU with the merchant.
     *
     * @return merchantCustomerIdentification
     **/

    @Size(min = 1, max = 70)
    public String getMerchantCustomerIdentification() {
        return merchantCustomerIdentification;
    }

    public void setMerchantCustomerIdentification(String merchantCustomerIdentification) {
        this.merchantCustomerIdentification = merchantCustomerIdentification;
    }

    public OBRisk deliveryAddress(OBRiskDeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    /**
     * Get deliveryAddress
     *
     * @return deliveryAddress
     **/

    @Valid

    public OBRiskDeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(OBRiskDeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBRisk obRisk1 = (OBRisk) o;
        return Objects.equals(this.paymentContextCode, obRisk1.paymentContextCode) &&
                Objects.equals(this.merchantCategoryCode, obRisk1.merchantCategoryCode) &&
                Objects.equals(this.merchantCustomerIdentification, obRisk1.merchantCustomerIdentification) &&
                Objects.equals(this.deliveryAddress, obRisk1.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentContextCode, merchantCategoryCode, merchantCustomerIdentification, deliveryAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBRisk1 {\n");

        sb.append("    paymentContextCode: ").append(toIndentedString(paymentContextCode)).append("\n");
        sb.append("    merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode)).append("\n");
        sb.append("    merchantCustomerIdentification: ").append(toIndentedString(merchantCustomerIdentification)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}