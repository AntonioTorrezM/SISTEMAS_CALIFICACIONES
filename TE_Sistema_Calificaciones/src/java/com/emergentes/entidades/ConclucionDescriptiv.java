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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "conclucion_descriptiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConclucionDescriptiv.findAll", query = "SELECT c FROM ConclucionDescriptiv c"),
    @NamedQuery(name = "ConclucionDescriptiv.findByIdConcluciondescriptiva", query = "SELECT c FROM ConclucionDescriptiv c WHERE c.idConcluciondescriptiva = :idConcluciondescriptiva"),
    @NamedQuery(name = "ConclucionDescriptiv.findByIdEstudiante", query = "SELECT c FROM ConclucionDescriptiv c WHERE c.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "ConclucionDescriptiv.findByIdpersona", query = "SELECT c FROM ConclucionDescriptiv c WHERE c.idpersona = :idpersona"),
    @NamedQuery(name = "ConclucionDescriptiv.findByDescripcion", query = "SELECT c FROM ConclucionDescriptiv c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "ConclucionDescriptiv.findByPeriodo", query = "SELECT c FROM ConclucionDescriptiv c WHERE c.periodo = :periodo")})
public class ConclucionDescriptiv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConclucion_descriptiva")
    private Integer idConcluciondescriptiva;
    @Size(max = 45)
    @Column(name = "Id_Estudiante")
    private String idEstudiante;
    @Size(max = 45)
    @Column(name = "Id_persona")
    private String idpersona;
    @Size(max = 85)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "Periodo")
    private String periodo;
    @JoinColumn(name = "idConclucion_descriptiva", referencedColumnName = "idEstudiante", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estudiant estudiant;

    public ConclucionDescriptiv() {
    }

    public ConclucionDescriptiv(Integer idConcluciondescriptiva) {
        this.idConcluciondescriptiva = idConcluciondescriptiva;
    }

    public Integer getIdConcluciondescriptiva() {
        return idConcluciondescriptiva;
    }

    public void setIdConcluciondescriptiva(Integer idConcluciondescriptiva) {
        this.idConcluciondescriptiva = idConcluciondescriptiva;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        hash += (idConcluciondescriptiva != null ? idConcluciondescriptiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConclucionDescriptiv)) {
            return false;
        }
        ConclucionDescriptiv other = (ConclucionDescriptiv) object;
        if ((this.idConcluciondescriptiva == null && other.idConcluciondescriptiva != null) || (this.idConcluciondescriptiva != null && !this.idConcluciondescriptiva.equals(other.idConcluciondescriptiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.ConclucionDescriptiv[ idConcluciondescriptiva=" + idConcluciondescriptiva + " ]";
    }
    
}
