package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Die Klasse dient dazu, Informationen über Semester (z.B. Start, Endzeitpunkt, etc.) abzubilden.
 */
@Entity
@Table(name = "semester")
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Semester)) {
            return false;
        }
        return id != null && id.equals(((Semester) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Semester{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", semesterNumber=" + getSemesterNumber() +
            ", name='" + getName() + "'" +
            "}";
    }
}
