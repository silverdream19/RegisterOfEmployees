package entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@XmlRootElement(name = "Issure")
@XmlType(propOrder = {"date", "descr", "projects", "users"})
//@Entity
//@Table(name = "ISSURE")
public class Issure implements Serializable {

    //@Id
    private long id;
    //@Column(name = "DATE")
    private String date;
    //@Column(name = "DESCRIPTION")
    private String descr;
    //@ManyToMany(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
  /*  @JoinTable(
            name = "ISS_PROJ",
            joinColumns = @JoinColumn(name = "ISSURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )*/
    private Set<Project> projects;

 /*  @ManyToMany(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @JoinTable(
            name = "ISS_USER",
            joinColumns = @JoinColumn(name = "ISSURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )*/
    private Set<User> users;

    public Issure(long id, String date, String descr) {
        this.id = id;
        this.date = date;
        this.descr = descr;
    }

    public Issure() {
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescr() {
        return descr;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Issure{" +
                "id=" + id +
                ", date=" + date +
                ", descripcion='" + descr + '\'' +
                '}';
    }




}
