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
@XmlType(propOrder = {"name"})
/*@Entity
@Table(name = "PROJECT")*/
public class Project implements Serializable {
    //@Id
    private long id;
    //@Column(name = "NAME")
    private String name;
    //@ManyToMany(mappedBy = "projects")
    private Set<Issure> issures;

    public Project() {
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Issure> getIssures() {
        return issures;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssures(Set<Issure> issures) {
        this.issures = issures;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
