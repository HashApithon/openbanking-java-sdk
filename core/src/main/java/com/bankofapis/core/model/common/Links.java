package com.bankofapis.core.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Links relevant to the payload
 */
@Validated
public class Links {
    @JsonProperty("Self")
    private String self = null;

    @JsonProperty("First")
    private String first = null;

    @JsonProperty("Prev")
    private String prev = null;

    @JsonProperty("Next")
    private String next = null;

    @JsonProperty("Last")
    private String last = null;

    public Links self(String self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     *
     * @return self
     **/

    @NotNull


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Links first(String first) {
        this.first = first;
        return this;
    }

    /**
     * Get first
     *
     * @return first
     **/

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Links prev(String prev) {
        this.prev = prev;
        return this;
    }

    /**
     * Get prev
     *
     * @return prev
     **/

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public Links next(String next) {
        this.next = next;
        return this;
    }

    /**
     * Get next
     *
     * @return next
     **/


    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Links last(String last) {
        this.last = last;
        return this;
    }

    /**
     * Get last
     *
     * @return last
     **/

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Links links = (Links) o;
        return Objects.equals(this.self, links.self) &&
                Objects.equals(this.first, links.first) &&
                Objects.equals(this.prev, links.prev) &&
                Objects.equals(this.next, links.next) &&
                Objects.equals(this.last, links.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self, first, prev, next, last);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Links {\n");

        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
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