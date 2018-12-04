package entity;


import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name = "Project")
@XmlType(propOrder = {"name", "email"})
/*@Entity
@Table(name = "USER")*/
public class User implements Serializable {

    //@Id
    private long id;
    //@Column(name = "NAME")
    private String name;
    //@Column(name = "EMAIL")
    private String email;
    //@ManyToMany(mappedBy = "users")
    private Set<Issure> issures;

    public User() {
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Issure> getIssures() {
        return issures;
    }

    public void setIssures(Set<Issure> issures) {
        this.issures = issures;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
