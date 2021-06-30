/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "instituci\u00f3n")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituc.findAll", query = "SELECT i FROM Instituc i"),
    @NamedQuery(name = "Instituc.findByIdInstituci\u00f3n", query = "SELECT i FROM Instituc i WHERE i.idInstituci\u00f3n = :idInstituci\u00f3n"),
    @NamedQuery(name = "Instituc.findByNombre", query = "SELECT i FROM Instituc i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instituc.findByNivel", query = "SELECT i FROM Instituc i WHERE i.nivel = :nivel"),
    @NamedQuery(name = "Instituc.findByCodigoModular", query = "SELECT i FROM Instituc i WHERE i.codigoModular = :codigoModular"),
    @NamedQuery(name = "Instituc.findByLogo", query = "SELECT i FROM Instituc i WHERE i.logo = :logo")})
public class Instituc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInstituci\u00f3n")
    private Integer idInstitución;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 85)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Codigo_Modular")
    private String codigoModular;
    @Size(max = 75)
    @Column(name = "Logo")
    private String logo;

    public Instituc() {
    }

    public Instituc(Integer idInstitución) {
        this.idInstitución = idInstitución;
    }

    public Instituc(Integer idInstitución, String nombre, String nivel, String codigoModular) {
        this.idInstitución = idInstitución;
        this.nombre = nombre;
        this.nivel = nivel;
        this.codigoModular = codigoModular;
    }

    public Integer getIdInstitución() {
        return idInstitución;
    }

    public void setIdInstitución(Integer idInstitución) {
        this.idInstitución = idInstitución;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCodigoModular() {
        return codigoModular;
    }

    public void setCodigoModular(String codigoModular) {
        this.codigoModular = codigoModular;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitución != null ? idInstitución.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituc)) {
            return false;
        }
        Instituc other = (Instituc) object;
        if ((this.idInstitución == null && other.idInstitución != null) || (this.idInstitución != null && !this.idInstitución.equals(other.idInstitución))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Instituc[ idInstituci\u00f3n=" + idInstitución + " ]";
    }
    
}
