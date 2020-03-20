/*
 * This code is unpublished proprietary trade secret of
 * Visiona Sp. z o.o., ul. Życzkowskiego 14, 31-864 Kraków, Poland.
 *
 * This code is protected under Act on Copyright and Related Rights
 * and may be used only under the terms of license granted by
 * Visiona Sp. z o.o., ul. Życzkowskiego 14, 31-864 Kraków, Poland.
 *
 * Above notice must be preserved in all copies of this code.
 */

package pl.rbsoft.hairdresserbackend.domain;


import java.time.LocalDateTime;
import java.util.Objects;

public class BaseVisit {

    protected LocalDateTime visitDate;
    protected String details;

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseVisit baseVisit = (BaseVisit) o;
        return Objects.equals(visitDate, baseVisit.visitDate) &&
                Objects.equals(details, baseVisit.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitDate, details);
    }
}