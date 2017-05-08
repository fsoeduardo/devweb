/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Ricardo Junior
 */
@Entity
@Table(catalog = "", schema = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacaocomposta.findAll", query = "SELECT a FROM Avaliacaocomposta a")
    , @NamedQuery(name = "Avaliacaocomposta.findById", query = "SELECT a FROM Avaliacaocomposta a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacaocomposta.findByTextohospedagem", query = "SELECT a FROM Avaliacaocomposta a WHERE a.textohospedagem = :textohospedagem")
    , @NamedQuery(name = "Avaliacaocomposta.findByTextohospedero", query = "SELECT a FROM Avaliacaocomposta a WHERE a.textohospedero = :textohospedero")
    , @NamedQuery(name = "Avaliacaocomposta.findByNota", query = "SELECT a FROM Avaliacaocomposta a WHERE a.nota = :nota")
    , @NamedQuery(name = "Avaliacaocomposta.findByStatus", query = "SELECT a FROM Avaliacaocomposta a WHERE a.status = :status")})
public class Avaliacaocomposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(length = 255)
    private String textohospedagem;
    @Size(max = 255)
    @Column(length = 255)
    private String textohospedero;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int nota;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Boolean status;
    @JoinColumn(name = "TIPO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Tipo tipo;
    @JoinColumn(name = "HOSPEDADO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario hospedadoId;
    @JoinColumn(name = "HOSPEDERO_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario hospederoId;

    public Avaliacaocomposta() {
    }

    public Avaliacaocomposta(Integer id) {
        this.id = id;
    }

    public Avaliacaocomposta(Integer id, int nota, Boolean status) {
        this.id = id;
        this.nota = nota;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextohospedagem() {
        return textohospedagem;
    }

    public void setTextohospedagem(String textohospedagem) {
        this.textohospedagem = textohospedagem;
    }

    public String getTextohospedero() {
        return textohospedero;
    }

    public void setTextohospedero(String textohospedero) {
        this.textohospedero = textohospedero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getHospedadoId() {
        return hospedadoId;
    }

    public void setHospedadoId(Usuario hospedadoId) {
        this.hospedadoId = hospedadoId;
    }

    public Usuario getHospederoId() {
        return hospederoId;
    }

    public void setHospederoId(Usuario hospederoId) {
        this.hospederoId = hospederoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacaocomposta)) {
            return false;
        }
        Avaliacaocomposta other = (Avaliacaocomposta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Avaliacaocomposta[ id=" + id + " ]";
    }
    
}
