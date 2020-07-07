package com.bankofapis.core.model.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * The authorisation type request from the TPP.
 */
@Validated
public class OBAuthorisation {
    @JsonProperty("AuthorisationType")
    private OBExternalAuthorisationCode authorisationType = null;

    @JsonProperty("CompletionDateTime")
    private OffsetDateTime completionDateTime = null;

    public OBAuthorisation authorisationType(OBExternalAuthorisationCode authorisationType) {
        this.authorisationType = authorisationType;
        return this;
    }

    @NotNull
    @Valid
    public OBExternalAuthorisationCode getAuthorisationType() {
        return authorisationType;
    }

    public void setAuthorisationType(OBExternalAuthorisationCode authorisationType) {
        this.authorisationType = authorisationType;
    }

    public OBAuthorisation completionDateTime(OffsetDateTime completionDateTime) {
        this.completionDateTime = completionDateTime;
        return this;
    }


    @Valid
    public OffsetDateTime getCompletionDateTime() {
        return completionDateTime;
    }

    public void setCompletionDateTime(OffsetDateTime completionDateTime) {
        this.completionDateTime = completionDateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBAuthorisation obAuthorisation1 = (OBAuthorisation) o;
        return Objects.equals(this.authorisationType, obAuthorisation1.authorisationType) &&
                Objects.equals(this.completionDateTime, obAuthorisation1.completionDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorisationType, completionDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBAuthorisation1 {\n");

        sb.append("    authorisationType: ").append(toIndentedString(authorisationType)).append("\n");
        sb.append("    completionDateTime: ").append(toIndentedString(completionDateTime)).append("\n");
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