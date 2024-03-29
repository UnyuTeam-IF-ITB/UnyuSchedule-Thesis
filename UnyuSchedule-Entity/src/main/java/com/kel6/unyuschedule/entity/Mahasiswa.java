/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.unyuschedule.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "mahasiswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNim", query = "SELECT m FROM Mahasiswa m WHERE m.nim = :nim"),
    @NamedQuery(name = "Mahasiswa.findByNmMhs", query = "SELECT m FROM Mahasiswa m WHERE m.nmMhs = :nmMhs"),
    @NamedQuery(name = "Mahasiswa.findByAlmtMhs", query = "SELECT m FROM Mahasiswa m WHERE m.almtMhs = :almtMhs"),
    @NamedQuery(name = "Mahasiswa.findByJnsKlmnMhs", query = "SELECT m FROM Mahasiswa m WHERE m.jnsKlmnMhs = :jnsKlmnMhs")})
public class Mahasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private String nim;
    @Column(name = "nm_mhs")
    private String nmMhs;
    @Column(name = "almt_mhs")
    private String almtMhs;
    @Column(name = "jns_klmn_mhs")
    private Integer jnsKlmnMhs;
    @JoinColumn(name = "id_ka", referencedColumnName = "id_ka")
    @ManyToOne
    private KaryaAkhir idKa;
    @OneToMany(mappedBy = "nim")
    private List<KaryaAkhir> karyaAkhirList;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNmMhs() {
        return nmMhs;
    }

    public void setNmMhs(String nmMhs) {
        this.nmMhs = nmMhs;
    }

    public String getAlmtMhs() {
        return almtMhs;
    }

    public void setAlmtMhs(String almtMhs) {
        this.almtMhs = almtMhs;
    }

    public Integer getJnsKlmnMhs() {
        return jnsKlmnMhs;
    }

    public void setJnsKlmnMhs(Integer jnsKlmnMhs) {
        this.jnsKlmnMhs = jnsKlmnMhs;
    }

    public KaryaAkhir getIdKa() {
        return idKa;
    }

    public void setIdKa(KaryaAkhir idKa) {
        this.idKa = idKa;
    }

    @XmlTransient
    public List<KaryaAkhir> getKaryaAkhirList() {
        return karyaAkhirList;
    }

    public void setKaryaAkhirList(List<KaryaAkhir> karyaAkhirList) {
        this.karyaAkhirList = karyaAkhirList;
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
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.Mahasiswa[ nim=" + nim + " ]";
    }
    
}
