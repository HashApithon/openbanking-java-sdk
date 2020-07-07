package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Information that locates and identifies a specific address, as defined by postal services or in free format text.
 */
@Validated
public class OBRiskDeliveryAddress {

    @JsonProperty("AddressLine")
    @Valid
    private List<String> addressLine = null;

    @JsonProperty("StreetName")
    private String streetName = null;

    @JsonProperty("BuildingNumber")
    private String buildingNumber = null;

    @JsonProperty("PostCode")
    private String postCode = null;

    @JsonProperty("TownName")
    private String townName = null;

    @JsonProperty("CountrySubDivision")
    @Valid
    private List<String> countrySubDivision = null;

    @JsonProperty("Country")
    private String country = null;

    public OBRiskDeliveryAddress addressLine(List<String> addressLine) {
        this.addressLine = addressLine;
        return this;
    }

    public OBRiskDeliveryAddress addAddressLineItem(String addressLineItem) {
        if (this.addressLine == null) {
            this.addressLine = new ArrayList<String>();
        }
        this.addressLine.add(addressLineItem);
        return this;
    }

    /**
     * Information that locates and identifies a specific address, as defined by postal services, that is presented in free format text.
     *
     * @return addressLine
     **/

    @Size(min = 0, max = 2)
    public List<String> getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(List<String> addressLine) {
        this.addressLine = addressLine;
    }

    public OBRiskDeliveryAddress streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    /**
     * Name of a street or thoroughfare.
     *
     * @return streetName
     **/

    @Size(min = 1, max = 70)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public OBRiskDeliveryAddress buildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    /**
     * Number that identifies the position of a building on a street.
     *
     * @return buildingNumber
     **/

    @Size(min = 1, max = 16)
    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public OBRiskDeliveryAddress postCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    /**
     * Identifier consisting of a group of letters and/or numbers that is added to a postal address to assist the sorting of mail.
     *
     * @return postCode
     **/

    @Size(min = 1, max = 16)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public OBRiskDeliveryAddress townName(String townName) {
        this.townName = townName;
        return this;
    }

    /**
     * Name of a built-up area, with defined boundaries, and a local government.
     *
     * @return townName
     **/
    @NotNull

    @Size(min = 1, max = 35)
    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public OBRiskDeliveryAddress countrySubDivision(List<String> countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
        return this;
    }

    public OBRiskDeliveryAddress addCountrySubDivisionItem(String countrySubDivisionItem) {
        if (this.countrySubDivision == null) {
            this.countrySubDivision = new ArrayList<String>();
        }
        this.countrySubDivision.add(countrySubDivisionItem);
        return this;
    }

    /**
     * Identifies a subdivision of a country, for instance state, region, county.
     *
     * @return countrySubDivision
     **/

    @Size(min = 0, max = 2)
    public List<String> getCountrySubDivision() {
        return countrySubDivision;
    }

    public void setCountrySubDivision(List<String> countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    public OBRiskDeliveryAddress country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Nation with its own government, occupying a particular territory.
     *
     * @return country
     **/

    @NotNull

    @Pattern(regexp = "^[A-Z]{2,2}$")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBRiskDeliveryAddress obRisk1DeliveryAddress = (OBRiskDeliveryAddress) o;
        return Objects.equals(this.addressLine, obRisk1DeliveryAddress.addressLine) &&
                Objects.equals(this.streetName, obRisk1DeliveryAddress.streetName) &&
                Objects.equals(this.buildingNumber, obRisk1DeliveryAddress.buildingNumber) &&
                Objects.equals(this.postCode, obRisk1DeliveryAddress.postCode) &&
                Objects.equals(this.townName, obRisk1DeliveryAddress.townName) &&
                Objects.equals(this.countrySubDivision, obRisk1DeliveryAddress.countrySubDivision) &&
                Objects.equals(this.country, obRisk1DeliveryAddress.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine, streetName, buildingNumber, postCode, townName, countrySubDivision, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBRisk1DeliveryAddress {\n");

        sb.append("    addressLine: ").append(toIndentedString(addressLine)).append("\n");
        sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
        sb.append("    buildingNumber: ").append(toIndentedString(buildingNumber)).append("\n");
        sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
        sb.append("    townName: ").append(toIndentedString(townName)).append("\n");
        sb.append("    countrySubDivision: ").append(toIndentedString(countrySubDivision)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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