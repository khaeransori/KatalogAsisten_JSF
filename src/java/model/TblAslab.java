/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khaer Ansori
 */
@Entity
@Table(name = "tbl_aslab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAslab.findAll", query = "SELECT t FROM TblAslab t"),
    @NamedQuery(name = "TblAslab.findByNim", query = "SELECT t FROM TblAslab t WHERE t.nim = :nim"),
    @NamedQuery(name = "TblAslab.findByNama", query = "SELECT t FROM TblAslab t WHERE t.nama = :nama"),
    @NamedQuery(name = "TblAslab.findByAngkatan", query = "SELECT t FROM TblAslab t WHERE t.angkatan = :angkatan"),
    @NamedQuery(name = "TblAslab.findByPraktikum", query = "SELECT t FROM TblAslab t WHERE t.praktikum = :praktikum"),
    @NamedQuery(name = "TblAslab.findByBab", query = "SELECT t FROM TblAslab t WHERE t.bab = :bab"),
    @NamedQuery(name = "TblAslab.findByFoto", query = "SELECT t FROM TblAslab t WHERE t.foto = :foto")})
public class TblAslab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nim")
    private String nim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "angkatan")
    private int angkatan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "praktikum")
    private String praktikum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bab")
    private String bab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "foto")
    private String foto;

    public TblAslab() {
    }

    public TblAslab(String nim) {
        this.nim = nim;
    }

    public TblAslab(String nim, String nama, int angkatan, String praktikum, String bab, String foto) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
        this.praktikum = praktikum;
        this.bab = bab;
        this.foto = foto;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getPraktikum() {
        return praktikum;
    }

    public void setPraktikum(String praktikum) {
        this.praktikum = praktikum;
    }

    public String getBab() {
        return bab;
    }

    public void setBab(String bab) {
        this.bab = bab;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAslab)) {
            return false;
        }
        TblAslab other = (TblAslab) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblAslab[ nim=" + nim + " ]";
    }
    
}
