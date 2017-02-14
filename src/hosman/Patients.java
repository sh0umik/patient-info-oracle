/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hosman;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author fahim
 */
@Entity
@Table(name = "PATIENTS", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findById", query = "SELECT p FROM Patients p WHERE p.id = :id"),
    @NamedQuery(name = "Patients.findByAge", query = "SELECT p FROM Patients p WHERE p.age = :age"),
    @NamedQuery(name = "Patients.findByAdate", query = "SELECT p FROM Patients p WHERE p.adate = :adate"),
    @NamedQuery(name = "Patients.findByDdate", query = "SELECT p FROM Patients p WHERE p.ddate = :ddate"),
    @NamedQuery(name = "Patients.findByName", query = "SELECT p FROM Patients p WHERE p.name = :name"),
    @NamedQuery(name = "Patients.findBySex", query = "SELECT p FROM Patients p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patients.findByAddress", query = "SELECT p FROM Patients p WHERE p.address = :address"),
    @NamedQuery(name = "Patients.findByContact", query = "SELECT p FROM Patients p WHERE p.contact = :contact")})
public class Patients implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "AGE")
    private BigInteger age;
    @Column(name = "ADATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adate;
    @Column(name = "DDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CONTACT")
    private String contact;

    public Patients() {
    }

    public Patients(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        BigDecimal oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        BigInteger oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        Date oldAdate = this.adate;
        this.adate = adate;
        changeSupport.firePropertyChange("adate", oldAdate, adate);
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        Date oldDdate = this.ddate;
        this.ddate = ddate;
        changeSupport.firePropertyChange("ddate", oldDdate, ddate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        String oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hosman.Patients[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
