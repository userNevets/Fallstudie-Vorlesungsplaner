package dhbw.vs.uniplaner.domain;


import dhbw.vs.uniplaner.security.Annotations.ValidEmail;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A UniUser.
 */
@Entity
@Table(name = "uni_user")
public class UniUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;
    
    @ValidEmail
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    public UniUser(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }
    public UniUser(){
    
    }
    
    @ManyToMany
    @JoinTable(name = "uni_user_role",
               joinColumns = @JoinColumn(name = "uni_user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public UniUser first_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public UniUser last_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    

    public Set<Role> getRoles() {
        return roles;
    }

    public UniUser roles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public UniUser addRole(Role role) {
        this.roles.add(role);
        role.getUniUsers().add(this);
        return this;
    }

    public UniUser removeRole(Role role) {
        this.roles.remove(role);
        role.getUniUsers().remove(this);
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public String getemail() {
        return email;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniUser)) {
            return false;
        }
        return id != null && id.equals(((UniUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "UniUser{" +
            "id=" + getId() +
            ", first_name='" + getfirst_name() + "'" +
            ", last_name='" + getlast_name() + "'" +
            "}";
    }
}
