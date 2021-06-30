/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
    @NamedQuery(name = "Grad.findByIdGrado", query = "SELECT g FROM Grad g WHERE g.idGrado = :idGrado"),
    @NamedQuery(name = "Grad.findByGrado", query = "SELECT g FROM Grad g WHERE g.grado = :grado"),
    @NamedQuery(name = "Grad.findBySeccion", query = "SELECT g FROM Grad g WHERE g.seccion = :seccion"),
    @NamedQuery(name = "Grad.findByTutor", query = "SELECT g FROM Grad g WHERE g.tutor = :tutor")})
public class Grad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrado")
    private Integer idGrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Grado")
    private String grado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Seccion")
    private String seccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "Tutor")
    private String tutor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grad")
    private Estudiant estudiant;

    public Grad() {
    }

    public Grad(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Grad(Integer idGrado, String grado, String seccion, String tutor) {
        this.idGrado = idGrado;
        this.grado = grado;
        this.seccion = seccion;
        this.tutor = tutor;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Estudiant getEstudiant() {
        return estudiant;
    }

    public void setEstudiant(Estudiant estudiant) {
        this.estudiant = estudiant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Grad[ idGrado=" + idGrado + " ]";
    }
    
}
