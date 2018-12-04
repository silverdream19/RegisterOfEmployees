package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@XmlRootElement(name="Issures")
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"issures"})
public class ListWrapper implements Serializable {

    private Set<Issure> issures;

    public ListWrapper() {

    }

    public Set<Issure> getIssures() {
        return issures;
    }

    public void setIssures(Set<Issure> issures) {
        this.issures = issures;
    }
}
