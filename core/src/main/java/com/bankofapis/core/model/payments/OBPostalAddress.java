package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Information that locates and identifies a specific address, as defined by postal services.
 */
@Validated
public class OBPostalAddress {
    @JsonProperty("AddressType")
    private OBAddressTypeCode addressType = null;

    @JsonProperty("Department")
    private String department = null;

    @JsonProperty("SubDepartment")
    private String subDepartment = null;

    @JsonProperty("StreetName")
    private String streetName = null;

    @JsonProperty("BuildingNumber")
    private String buildingNumber = null;

    @JsonProperty("PostCode")
    private String postCode = null;

    @JsonProperty("TownName")
    private String townName = null;

    @JsonProperty("CountrySubDivision")
    private String countrySubDivision = null;

    @JsonProperty("Country")
    private String country = null;

    @JsonProperty("AddressLine")
    @Valid
    private List<String> addressLine = null;

    public OBPostalAddress addressType(OBAddressTypeCode addressType) {
        this.addressType = addressType;
        return this;
    }

    /**
     * Get addressType
     *
     * @return addressType
     **/

    @Valid
    public OBAddressTypeCode getAddressType() {
        return addressType;
    }

    public void setAddressType(OBAddressTypeCode addressType) {
        this.addressType = addressType;
    }

    public OBPostalAddress department(String department) {
        this.department = department;
        return this;
    }

    /**
     * Identification of a division of a large organisation or building.
     *
     * @return department
     **/

    @Size(min = 1, max = 70)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public OBPostalAddress subDepartment(String subDepartment) {
        this.subDepartment = subDepartment;
        return this;
    }

    /**
     * Identification of a sub-division of a large organisation or building.
     *
     * @return subDepartment
     **/

    @Size(min = 1, max = 70)
    public String getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(String subDepartment) {
        this.subDepartment = subDepartment;
    }

    public OBPostalAddress streetName(String streetName) {
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

    public OBPostalAddress buildingNumber(String buildingNumber) {
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

    public OBPostalAddress postCode(String postCode) {
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

    public OBPostalAddress townName(String townName) {
        this.townName = townName;
        return this;
    }

    /**
     * Name of a built-up area, with defined boundaries, and a local government.
     *
     * @return townName
     **/

    @Size(min = 1, max = 35)
    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public OBPostalAddress countrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
        return this;
    }

    /**
     * Identifies a subdivision of a country such as state, region, county.
     *
     * @return countrySubDivision
     **/

    @Size(min = 1, max = 35)
    public String getCountrySubDivision() {
        return countrySubDivision;
    }

    public void setCountrySubDivision(String countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    public OBPostalAddress country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Nation with its own government.
     *
     * @return country
     **/

    @Pattern(regexp = "^[A-Z]{2,2}$")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public OBPostalAddress addressLine(List<String> addressLine) {
        this.addressLine = addressLine;
        return this;
    }

    public OBPostalAddress addAddressLineItem(String addressLineItem) {
        if (this.addressLine == null) {
            this.addressLine = new ArrayList<String>();
        }
        this.addressLine.add(addressLineItem);
        return this;
    }

    /**
     * Information that locates and identifies a specific address, as defined by postal services, presented in free format text.
     *
     * @return addressLine
     **/

    @Size(min = 0, max = 7)
    public List<String> getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(List<String> addressLine) {
        this.addressLine = addressLine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBPostalAddress obPostalAddress6 = (OBPostalAddress) o;
        return Objects.equals(this.addressType, obPostalAddress6.addressType) &&
                Objects.equals(this.department, obPostalAddress6.department) &&
                Objects.equals(this.subDepartment, obPostalAddress6.subDepartment) &&
                Objects.equals(this.streetName, obPostalAddress6.streetName) &&
                Objects.equals(this.buildingNumber, obPostalAddress6.buildingNumber) &&
                Objects.equals(this.postCode, obPostalAddress6.postCode) &&
                Objects.equals(this.townName, obPostalAddress6.townName) &&
                Objects.equals(this.countrySubDivision, obPostalAddress6.countrySubDivision) &&
                Objects.equals(this.country, obPostalAddress6.country) &&
                Objects.equals(this.addressLine, obPostalAddress6.addressLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressType, department, subDepartment, streetName, buildingNumber, postCode, townName, countrySubDivision, country, addressLine);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBPostalAddress6 {\n");

        sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
        sb.append("    department: ").append(toIndentedString(department)).append("\n");
        sb.append("    subDepartment: ").append(toIndentedString(subDepartment)).append("\n");
        sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
        sb.append("    buildingNumber: ").append(toIndentedString(buildingNumber)).append("\n");
        sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
        sb.append("    townName: ").append(toIndentedString(townName)).append("\n");
        sb.append("    countrySubDivision: ").append(toIndentedString(countrySubDivision)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    addressLine: ").append(toIndentedString(addressLine)).append("\n");
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