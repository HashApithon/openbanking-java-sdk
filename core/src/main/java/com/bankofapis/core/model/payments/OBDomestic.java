package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * The Initiation payload is sent by the initiating party to the ASPSP. It is used to request movement of funds from the debtor account to a creditor for a single domestic payment.
 */
@Validated
public class OBDomestic {
    @JsonProperty("InstructionIdentification")
    private String instructionIdentification = null;

    @JsonProperty("EndToEndIdentification")
    private String endToEndIdentification = null;

    @JsonProperty("LocalInstrument")
    private String localInstrument = null;

    @JsonProperty("InstructedAmount")
    private OBDomesticInstructedAmount instructedAmount = null;

    @JsonProperty("DebtorAccount")
    private OBCashAccountDebtor debtorAccount = null;

    @JsonProperty("CreditorAccount")
    private OBCashAccountCreditor creditorAccount = null;

    @JsonProperty("CreditorPostalAddress")
    private OBPostalAddress creditorPostalAddress = null;

    @JsonProperty("RemittanceInformation")
    private OBRemittanceInformation remittanceInformation = null;

    @JsonProperty("SupplementaryData")
    private OBSupplementaryData supplementaryData = null;

    public OBDomestic instructionIdentification(String instructionIdentification) {
        this.instructionIdentification = instructionIdentification;
        return this;
    }

    /**
     * Unique identification as assigned by an instructing party for an instructed party to unambiguously identify the instruction. Usage: the  instruction identification is a point to point reference that can be used between the instructing party and the instructed party to refer to the individual instruction. It can be included in several messages related to the instruction.
     *
     * @return instructionIdentification
     **/
    @NotNull

    @Size(min = 1, max = 35)
    public String getInstructionIdentification() {
        return instructionIdentification;
    }

    public void setInstructionIdentification(String instructionIdentification) {
        this.instructionIdentification = instructionIdentification;
    }

    public OBDomestic endToEndIdentification(String endToEndIdentification) {
        this.endToEndIdentification = endToEndIdentification;
        return this;
    }

    /**
     * Unique identification assigned by the initiating party to unambiguously identify the transaction. This identification is passed on, unchanged, throughout the entire end-to-end chain. Usage: The end-to-end identification can be used for reconciliation or to link tasks relating to the transaction. It can be included in several messages related to the transaction. OB: The Faster Payments Scheme can only access 31 characters for the EndToEndIdentification field.
     *
     * @return endToEndIdentification
     **/
    @NotNull

    @Size(min = 1, max = 35)
    public String getEndToEndIdentification() {
        return endToEndIdentification;
    }

    public void setEndToEndIdentification(String endToEndIdentification) {
        this.endToEndIdentification = endToEndIdentification;
    }

    public OBDomestic localInstrument(String localInstrument) {
        this.localInstrument = localInstrument;
        return this;
    }

    /**
     * Get localInstrument
     *
     * @return localInstrument
     **/

    @Size(min = 1, max = 50)
    public String getLocalInstrument() {
        return localInstrument;
    }

    public void setLocalInstrument(String localInstrument) {
        this.localInstrument = localInstrument;
    }

    public OBDomestic instructedAmount(OBDomesticInstructedAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
        return this;
    }

    /**
     * Get instructedAmount
     *
     * @return instructedAmount
     **/
    @NotNull

    @Valid

    public OBDomesticInstructedAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(OBDomesticInstructedAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public OBDomestic debtorAccount(OBCashAccountDebtor debtorAccount) {
        this.debtorAccount = debtorAccount;
        return this;
    }

    /**
     * Get debtorAccount
     *
     * @return debtorAccount
     **/
    @Valid
    public OBCashAccountDebtor getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(OBCashAccountDebtor debtorAccount) {
        this.debtorAccount = debtorAccount;
    }

    public OBDomestic creditorAccount(OBCashAccountCreditor creditorAccount) {
        this.creditorAccount = creditorAccount;
        return this;
    }

    /**
     * Get creditorAccount
     *
     * @return creditorAccount
     **/

    @NotNull
    @Valid
    public OBCashAccountCreditor getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(OBCashAccountCreditor creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public OBDomestic creditorPostalAddress(OBPostalAddress creditorPostalAddress) {
        this.creditorPostalAddress = creditorPostalAddress;
        return this;
    }

    /**
     * Get creditorPostalAddress
     *
     * @return creditorPostalAddress
     **/

    @Valid
    public OBPostalAddress getCreditorPostalAddress() {
        return creditorPostalAddress;
    }

    public void setCreditorPostalAddress(OBPostalAddress creditorPostalAddress) {
        this.creditorPostalAddress = creditorPostalAddress;
    }

    public OBDomestic remittanceInformation(OBRemittanceInformation remittanceInformation) {
        this.remittanceInformation = remittanceInformation;
        return this;
    }

    /**
     * Get remittanceInformation
     *
     * @return remittanceInformation
     **/

    @Valid
    public OBRemittanceInformation getRemittanceInformation() {
        return remittanceInformation;
    }

    public void setRemittanceInformation(OBRemittanceInformation remittanceInformation) {
        this.remittanceInformation = remittanceInformation;
    }

    public OBDomestic supplementaryData(OBSupplementaryData supplementaryData) {
        this.supplementaryData = supplementaryData;
        return this;
    }

    /**
     * Get supplementaryData
     *
     * @return supplementaryData
     **/

    @Valid
    public OBSupplementaryData getSupplementaryData() {
        return supplementaryData;
    }

    public void setSupplementaryData(OBSupplementaryData supplementaryData) {
        this.supplementaryData = supplementaryData;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBDomestic obDomestic2 = (OBDomestic) o;
        return Objects.equals(this.instructionIdentification, obDomestic2.instructionIdentification) &&
                Objects.equals(this.endToEndIdentification, obDomestic2.endToEndIdentification) &&
                Objects.equals(this.localInstrument, obDomestic2.localInstrument) &&
                Objects.equals(this.instructedAmount, obDomestic2.instructedAmount) &&
                Objects.equals(this.debtorAccount, obDomestic2.debtorAccount) &&
                Objects.equals(this.creditorAccount, obDomestic2.creditorAccount) &&
                Objects.equals(this.creditorPostalAddress, obDomestic2.creditorPostalAddress) &&
                Objects.equals(this.remittanceInformation, obDomestic2.remittanceInformation) &&
                Objects.equals(this.supplementaryData, obDomestic2.supplementaryData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionIdentification, endToEndIdentification, localInstrument, instructedAmount, debtorAccount, creditorAccount, creditorPostalAddress, remittanceInformation, supplementaryData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBDomestic2 {\n");

        sb.append("    instructionIdentification: ").append(toIndentedString(instructionIdentification)).append("\n");
        sb.append("    endToEndIdentification: ").append(toIndentedString(endToEndIdentification)).append("\n");
        sb.append("    localInstrument: ").append(toIndentedString(localInstrument)).append("\n");
        sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
        sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
        sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
        sb.append("    creditorPostalAddress: ").append(toIndentedString(creditorPostalAddress)).append("\n");
        sb.append("    remittanceInformation: ").append(toIndentedString(remittanceInformation)).append("\n");
        sb.append("    supplementaryData: ").append(toIndentedString(supplementaryData)).append("\n");
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