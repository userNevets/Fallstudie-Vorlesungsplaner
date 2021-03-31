package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse stellt eine Vorlesung dar.
 */
@Entity
@Table(name = "lecture")
public class Lecture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "lecture name")
    private String lectureName;
    
    @Column(name = "modul name")
    private String modulName;
    
    @Column(name = "duration")
    private Integer duration;
    
    @OneToMany
    @JoinColumn(name ="course name", nullable = false)
    private Set <Lecture> course1;
    
    @OneToMany(mappedBy = "lecture1")
    private Set<Lecturer> lecturer;
    
    @OneToMany(mappedBy = "lecture2")
    private Set<LectureDate> lectureDates;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLectureName() {
        return lectureName;
    }
    
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
    
    public String getModulName() {
        return modulName;
    }
    
    public void setModulName(String modulName) {
        this.modulName = modulName;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    public Lecture lectureName(String lectureName){
        this.lectureName = lectureName;
        return this;
    }
    
    public Lecture moduleName(String moduleName){
        this.moduleName = moduleName;
        return this;
    }
    
    public Lecture duration(Integer duration){
        this.duration = duration;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lecture)) {
            return false;
        }
        return id != null && id.equals(((Lecture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Lecture{" +
            "id=" + getId() +
            ", lectureName='" + getLectureName() + "'" +
            ", modulName='" + getModulName() + "'" +
            ", duration=" + getDuration() +
            "}";
    }
}
