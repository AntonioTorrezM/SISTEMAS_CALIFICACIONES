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
@Table(name = "notas_periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasPeriod.findAll", query = "SELECT n FROM NotasPeriod n"),
    @NamedQuery(name = "NotasPeriod.findByIdPeriodo", query = "SELECT n FROM NotasPeriod n WHERE n.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "NotasPeriod.findByNotaPeriodo1", query = "SELECT n FROM NotasPeriod n WHERE n.notaPeriodo1 = :notaPeriodo1"),
    @NamedQuery(name = "NotasPeriod.findByNotaPeriodo2", query = "SELECT n FROM NotasPeriod n WHERE n.notaPeriodo2 = :notaPeriodo2"),
    @NamedQuery(name = "NotasPeriod.findByNotaPeriodo3", query = "SELECT n FROM NotasPeriod n WHERE n.notaPeriodo3 = :notaPeriodo3"),
    @NamedQuery(name = "NotasPeriod.findByNotaPeriodo4", query = "SELECT n FROM NotasPeriod n WHERE n.notaPeriodo4 = :notaPeriodo4"),
    @NamedQuery(name = "NotasPeriod.findByPromedioAnual", query = "SELECT n FROM NotasPeriod n WHERE n.promedioAnual = :promedioAnual")})
public class NotasPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Periodo")
    private Integer idPeriodo;
    @Size(max = 45)
    @Column(name = "Nota_Periodo1")
    private String notaPeriodo1;
    @Size(max = 45)
    @Column(name = "Nota_Periodo2")
    private String notaPeriodo2;
    @Size(max = 45)
    @Column(name = "Nota_Periodo3")
    private String notaPeriodo3;
    @Size(max = 45)
    @Column(name = "Nota_Periodo4")
    private String notaPeriodo4;
    @Size(max = 45)
    @Column(name = "Promedio_Anual")
    private String promedioAnual;
    @JoinColumn(name = "id_Periodo", referencedColumnName = "idNotas", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Nota nota;

    public NotasPeriod() {
    }

    public NotasPeriod(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNotaPeriodo1() {
        return notaPeriodo1;
    }

    public void setNotaPeriodo1(String notaPeriodo1) {
        this.notaPeriodo1 = notaPeriodo1;
    }

    public String getNotaPeriodo2() {
        return notaPeriodo2;
    }

    public void setNotaPeriodo2(String notaPeriodo2) {
        this.notaPeriodo2 = notaPeriodo2;
    }

    public String getNotaPeriodo3() {
        return notaPeriodo3;
    }

    public void setNotaPeriodo3(String notaPeriodo3) {
        this.notaPeriodo3 = notaPeriodo3;
    }

    public String getNotaPeriodo4() {
        return notaPeriodo4;
    }

    public void setNotaPeriodo4(String notaPeriodo4) {
        this.notaPeriodo4 = notaPeriodo4;
    }

    public String getPromedioAnual() {
        return promedioAnual;
    }

    public void setPromedioAnual(String promedioAnual) {
        this.promedioAnual = promedioAnual;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasPeriod)) {
            return false;
        }
        NotasPeriod other = (NotasPeriod) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.NotasPeriod[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
