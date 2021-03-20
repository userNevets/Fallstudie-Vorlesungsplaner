package dhbw.vs.uniplaner.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse stellt einen Studiengang (z.B. Wirtschaftsinformatik) in der Hochschule dar.
 */
@Entity
@Table(name = "degree_program")
public class DegreeProgram implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DegreeProgram)) {
            return false;
        }
        return id != null && id.equals(((DegreeProgram) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "DegreeProgram{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", shortName='" + getShortName() + "'" +
            "}";
    }
}
