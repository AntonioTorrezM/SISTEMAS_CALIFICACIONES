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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "asistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByIdAsistencias", query = "SELECT a FROM Asistencia a WHERE a.idAsistencias = :idAsistencias"),
    @NamedQuery(name = "Asistencia.findByInasistjustificada", query = "SELECT a FROM Asistencia a WHERE a.inasistjustificada = :inasistjustificada"),
    @NamedQuery(name = "Asistencia.findByInasistInjustificada", query = "SELECT a FROM Asistencia a WHERE a.inasistInjustificada = :inasistInjustificada"),
    @NamedQuery(name = "Asistencia.findByTardJustificada", query = "SELECT a FROM Asistencia a WHERE a.tardJustificada = :tardJustificada"),
    @NamedQuery(name = "Asistencia.findByTardInjustificada", query = "SELECT a FROM Asistencia a WHERE a.tardInjustificada = :tardInjustificada")})
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsistencias")
    private Integer idAsistencias;
    @Size(max = 2)
    @Column(name = "Inasist_justificada")
    private String inasistjustificada;
    @Size(max = 2)
    @Column(name = "Inasist_Injustificada")
    private String inasistInjustificada;
    @Size(max = 2)
    @Column(name = "Tard_Justificada")
    private String tardJustificada;
    @Size(max = 2)
    @Column(name = "Tard_Injustificada")
    private String tardInjustificada;
    @JoinColumn(name = "Id_Estudiante", referencedColumnName = "idEstudiante")
    @ManyToOne(optional = false)
    private Estudiant idEstudiante;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public Integer getIdAsistencias() {
        return idAsistencias;
    }

    public void setIdAsistencias(Integer idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public String getInasistjustificada() {
        return inasistjustificada;
    }

    public void setInasistjustificada(String inasistjustificada) {
        this.inasistjustificada = inasistjustificada;
    }

    public String getInasistInjustificada() {
        return inasistInjustificada;
    }

    public void setInasistInjustificada(String inasistInjustificada) {
        this.inasistInjustificada = inasistInjustificada;
    }

    public String getTardJustificada() {
        return tardJustificada;
    }

    public void setTardJustificada(String tardJustificada) {
        this.tardJustificada = tardJustificada;
    }

    public String getTardInjustificada() {
        return tardInjustificada;
    }

    public void setTardInjustificada(String tardInjustificada) {
        this.tardInjustificada = tardInjustificada;
    }

    public Estudiant getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiant idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistencias != null ? idAsistencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.idAsistencias == null && other.idAsistencias != null) || (this.idAsistencias != null && !this.idAsistencias.equals(other.idAsistencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Asistencia[ idAsistencias=" + idAsistencias + " ]";
    }
    
}
