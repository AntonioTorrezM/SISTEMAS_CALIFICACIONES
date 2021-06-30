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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPersonal", query = "SELECT p FROM Person p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "Person.findByNombre", query = "SELECT p FROM Person p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Person.findByApellidos", query = "SELECT p FROM Person p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Person.findByUsuario", query = "SELECT p FROM Person p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Person.findByClave", query = "SELECT p FROM Person p WHERE p.clave = :clave")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonal")
    private Integer idPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Clave")
    private String clave;
    @JoinColumn(name = "Id_curso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curs idcurso;
    @JoinColumn(name = "IdTipo_usuario", referencedColumnName = "idTipo_Usuario")
    @ManyToOne(optional = false)
    private TipoUsuar idTipousuario;

    public Person() {
    }

    public Person(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Person(Integer idPersonal, String nombre, String apellidos, String usuario, String clave) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Curs getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curs idcurso) {
        this.idcurso = idcurso;
    }

    public TipoUsuar getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(TipoUsuar idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Person[ idPersonal=" + idPersonal + " ]";
    }
    
}
