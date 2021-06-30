/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiant.findAll", query = "SELECT e FROM Estudiant e"),
    @NamedQuery(name = "Estudiant.findByIdEstudiante", query = "SELECT e FROM Estudiant e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiant.findByNombre", query = "SELECT e FROM Estudiant e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiant.findByApellidos", query = "SELECT e FROM Estudiant e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Estudiant.findByDni", query = "SELECT e FROM Estudiant e WHERE e.dni = :dni"),
    @NamedQuery(name = "Estudiant.findByCodigoest", query = "SELECT e FROM Estudiant e WHERE e.codigoest = :codigoest"),
    @NamedQuery(name = "Estudiant.findByIdGrado", query = "SELECT e FROM Estudiant e WHERE e.idGrado = :idGrado")})
public class Estudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dni")
    private int dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Codigo_est")
    private String codigoest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdGrado")
    private int idGrado;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idGrado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Grad grad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private Collection<Nota> notaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estudiant")
    private ConclucionDescriptiv conclucionDescriptiv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private Collection<Asistencia> asistenciaCollection;

    public Estudiant() {
    }

    public Estudiant(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiant(Integer idEstudiante, String nombre, String apellidos, int dni, String codigoest, int idGrado) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.codigoest = codigoest;
        this.idGrado = idGrado;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCodigoest() {
        return codigoest;
    }

    public void setCodigoest(String codigoest) {
        this.codigoest = codigoest;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @XmlTransient
    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

    public ConclucionDescriptiv getConclucionDescriptiv() {
        return conclucionDescriptiv;
    }

    public void setConclucionDescriptiv(ConclucionDescriptiv conclucionDescriptiv) {
        this.conclucionDescriptiv = conclucionDescriptiv;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiant)) {
            return false;
        }
        Estudiant other = (Estudiant) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Estudiant[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
