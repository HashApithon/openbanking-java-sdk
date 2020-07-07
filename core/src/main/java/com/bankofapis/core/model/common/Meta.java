package com.bankofapis.core.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Meta Data relevant to the payload
 */
@Validated

public class Meta {
    @JsonProperty("TotalPages")
    private Integer totalPages = null;

    @JsonProperty("FirstAvailableDateTime")
    private String firstAvailableDateTime = null;

    @JsonProperty("LastAvailableDateTime")
    private String lastAvailableDateTime = null;

    public Meta totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * Get totalPages
     *
     * @return totalPages
     **/
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Meta firstAvailableDateTime(String firstAvailableDateTime) {
        this.firstAvailableDateTime = firstAvailableDateTime;
        return this;
    }

    /**
     * Get firstAvailableDateTime
     *
     * @return firstAvailableDateTime
     **/

    public String getFirstAvailableDateTime() {
        return firstAvailableDateTime;
    }

    public void setFirstAvailableDateTime(String firstAvailableDateTime) {
        this.firstAvailableDateTime = firstAvailableDateTime;
    }

    public Meta lastAvailableDateTime(String lastAvailableDateTime) {
        this.lastAvailableDateTime = lastAvailableDateTime;
        return this;
    }

    /**
     * Get lastAvailableDateTime
     *
     * @return lastAvailableDateTime
     **/

    public String getLastAvailableDateTime() {
        return lastAvailableDateTime;
    }

    public void setLastAvailableDateTime(String lastAvailableDateTime) {
        this.lastAvailableDateTime = lastAvailableDateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meta meta = (Meta) o;
        return Objects.equals(this.totalPages, meta.totalPages) &&
                Objects.equals(this.firstAvailableDateTime, meta.firstAvailableDateTime) &&
                Objects.equals(this.lastAvailableDateTime, meta.lastAvailableDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPages, firstAvailableDateTime, lastAvailableDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Meta {\n");

        sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
        sb.append("    firstAvailableDateTime: ").append(toIndentedString(firstAvailableDateTime)).append("\n");
        sb.append("    lastAvailableDateTime: ").append(toIndentedString(lastAvailableDateTime)).append("\n");
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