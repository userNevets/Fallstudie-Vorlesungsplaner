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

    private Integer number;
    private LocalDate startDate;
    private LocalDate endDate;

    private Long semesterNumber;
    private String name;
    private Course course;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getSemesterNumber() {
        return this.semesterNumber;
    }

    public void setSemesterNumber(Long semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



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
