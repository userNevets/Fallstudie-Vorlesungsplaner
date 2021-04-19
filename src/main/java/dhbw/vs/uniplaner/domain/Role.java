package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse beschreibt mögliche Rollen von Benutzern im System (z.B. Dozent, Admin, Student, etc.)
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
    private String roleUid;
    
    @ManyToMany
    @JoinTable(
        name = "role_uni_user",
        joinColumns = @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "uni_user_id",
            referencedColumnName = "id"
        )
    )
    private Set<UniUser> uniUsers = new HashSet<>();

    protected Role() {}

    public Role(String roleName, String roleUid) {
        this.roleName = roleName;
        this.roleUid = roleUid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleUid() {
        return this.roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public Set<UniUser> getUniUsers() {
        return this.uniUsers;
    }

    public Role addUniUser(UniUser uniUser) {
        this.uniUsers.add(uniUser);
        return this;
    }

    public Role removeUniUser(UniUser uniUser) {
        this.uniUsers.remove(uniUser);
        return this;
    }

    public void setUniUsers(Set<UniUser> uniUsers) {
        this.uniUsers = uniUsers;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        return id != null && id.equals(((Role) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Role{" +
            "id=" + getId() +
            ", roleName='" + getRoleName() + "'" +
            ", roleUid='" + getRoleUid() + "'" +
            "}";
    }
}
