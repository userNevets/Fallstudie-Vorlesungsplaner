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
    
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "startDate")
    private LocalDate startDate;
    
    @Column(name = "endDate")
    private LocalDate endDate;
    
    @Column(name = "semesterNumber")
    private Integer semesterNumber;
    
    @Column(name = "name")
    private String name;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public Integer getSemesterNumber() {
        return semesterNumber;
    }
    
    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Semester number(Integer number){
        this.number = number;
        return this;
    }
    
    public Semester startDate(LocalDate startDate){
        this.startDate = startDate;
        return this;
    }
    
    public Semester endDate(LocalDate endDate){
        this.endDate = endDate;
        return this;
    }
    
    public Semester semesterNumber(Integer semesterNumber){
        this.semesterNumber = semesterNumber;
        return this;
    }
    
    public Semester name(String name){
        this.name = name;
        return this;
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
