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
@Table(name = "jenis_ka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisKa.findAll", query = "SELECT j FROM JenisKa j"),
    @NamedQuery(name = "JenisKa.findByIdJenisKa", query = "SELECT j FROM JenisKa j WHERE j.idJenisKa = :idJenisKa"),
    @NamedQuery(name = "JenisKa.findByNamaJenis", query = "SELECT j FROM JenisKa j WHERE j.namaJenis = :namaJenis")})
public class JenisKa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jenis_ka")
    private Long idJenisKa;
    @Column(name = "nama_jenis")
    private String namaJenis;
    @OneToMany(mappedBy = "idJenisKa")
    private List<KaryaAkhir> karyaAkhirList;

    public JenisKa() {
    }

    public JenisKa(Long idJenisKa) {
        this.idJenisKa = idJenisKa;
    }

    public Long getIdJenisKa() {
        return idJenisKa;
    }

    public void setIdJenisKa(Long idJenisKa) {
        this.idJenisKa = idJenisKa;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
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
        hash += (idJenisKa != null ? idJenisKa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisKa)) {
            return false;
        }
        JenisKa other = (JenisKa) object;
        if ((this.idJenisKa == null && other.idJenisKa != null) || (this.idJenisKa != null && !this.idJenisKa.equals(other.idJenisKa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.unyuschedule.entity.JenisKa[ idJenisKa=" + idJenisKa + " ]";
    }
    
}
