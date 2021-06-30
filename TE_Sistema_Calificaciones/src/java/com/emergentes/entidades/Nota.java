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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findByIdNotas", query = "SELECT n FROM Nota n WHERE n.idNotas = :idNotas"),
    @NamedQuery(name = "Nota.findByNota1", query = "SELECT n FROM Nota n WHERE n.nota1 = :nota1"),
    @NamedQuery(name = "Nota.findByNota2", query = "SELECT n FROM Nota n WHERE n.nota2 = :nota2"),
    @NamedQuery(name = "Nota.findByNota3", query = "SELECT n FROM Nota n WHERE n.nota3 = :nota3"),
    @NamedQuery(name = "Nota.findByNota4", query = "SELECT n FROM Nota n WHERE n.nota4 = :nota4"),
    @NamedQuery(name = "Nota.findByPromedio", query = "SELECT n FROM Nota n WHERE n.promedio = :promedio"),
    @NamedQuery(name = "Nota.findByIdPeriodo", query = "SELECT n FROM Nota n WHERE n.idPeriodo = :idPeriodo")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotas")
    private Integer idNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota1")
    private long nota1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota2")
    private long nota2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota3")
    private long nota3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota4")
    private long nota4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Promedio")
    private long promedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPeriodo")
    private int idPeriodo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nota")
    private NotasPeriod notasPeriod;
    @JoinColumn(name = "Id_Estudiante", referencedColumnName = "idEstudiante")
    @ManyToOne(optional = false)
    private Estudiant idEstudiante;
    @JoinColumn(name = "Id_Curso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curs idCurso;

    public Nota() {
    }

    public Nota(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Nota(Integer idNotas, long nota1, long nota2, long nota3, long nota4, long promedio, int idPeriodo) {
        this.idNotas = idNotas;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.promedio = promedio;
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public long getNota1() {
        return nota1;
    }

    public void setNota1(long nota1) {
        this.nota1 = nota1;
    }

    public long getNota2() {
        return nota2;
    }

    public void setNota2(long nota2) {
        this.nota2 = nota2;
    }

    public long getNota3() {
        return nota3;
    }

    public void setNota3(long nota3) {
        this.nota3 = nota3;
    }

    public long getNota4() {
        return nota4;
    }

    public void setNota4(long nota4) {
        this.nota4 = nota4;
    }

    public long getPromedio() {
        return promedio;
    }

    public void setPromedio(long promedio) {
        this.promedio = promedio;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public NotasPeriod getNotasPeriod() {
        return notasPeriod;
    }

    public void setNotasPeriod(NotasPeriod notasPeriod) {
        this.notasPeriod = notasPeriod;
    }

    public Estudiant getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiant idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Curs getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curs idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Nota[ idNotas=" + idNotas + " ]";
    }
    
}
