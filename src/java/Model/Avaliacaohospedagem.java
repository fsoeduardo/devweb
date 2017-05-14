/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
@Table(name = "AVALIACAOHOSPEDAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacaohospedagem.findAll", query = "SELECT a FROM Avaliacaohospedagem a")
    , @NamedQuery(name = "Avaliacaohospedagem.findById", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacaohospedagem.findByTextohospedeiro", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.textohospedeiro = :textohospedeiro")
    , @NamedQuery(name = "Avaliacaohospedagem.findByStatus", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.status = :status")
    , @NamedQuery(name = "Avaliacaohospedagem.findByTextohospedado", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.textohospedado = :textohospedado")
    , @NamedQuery(name = "Avaliacaohospedagem.findByNotahospedado", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.notahospedado = :notahospedado")
    , @NamedQuery(name = "Avaliacaohospedagem.findByNotahospedeiro", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.notahospedeiro = :notahospedeiro")})
public class Avaliacaohospedagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "TEXTOHOSPEDEIRO")
    private String textohospedeiro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Boolean status;
    @Size(max = 255)
    @Column(name = "TEXTOHOSPEDADO")
    private String textohospedado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTAHOSPEDADO")
    private Double notahospedado;
    @Column(name = "NOTAHOSPEDEIRO")
    private Float notahospedeiro;
    @JoinColumn(name = "HOSPEDADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario hospedadoId;
    @JoinColumn(name = "HOSPEDEIRO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario hospedeiroId;

    public Avaliacaohospedagem() {
    }

    public Avaliacaohospedagem(Integer id) {
        this.id = id;
    }

    public Avaliacaohospedagem(Integer id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextohospedeiro() {
        return textohospedeiro;
    }

    public void setTextohospedeiro(String textohospedeiro) {
        this.textohospedeiro = textohospedeiro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTextohospedado() {
        return textohospedado;
    }

    public void setTextohospedado(String textohospedado) {
        this.textohospedado = textohospedado;
    }

    public Double getNotahospedado() {
        return notahospedado;
    }

    public void setNotahospedado(Double notahospedado) {
        this.notahospedado = notahospedado;
    }

    public Float getNotahospedeiro() {
        return notahospedeiro;
    }

    public void setNotahospedeiro(Float notahospedeiro) {
        this.notahospedeiro = notahospedeiro;
    }

    public Usuario getHospedadoId() {
        return hospedadoId;
    }

    public void setHospedadoId(Usuario hospedadoId) {
        this.hospedadoId = hospedadoId;
    }

    public Usuario getHospedeiroId() {
        return hospedeiroId;
    }

    public void setHospedeiroId(Usuario hospedeiroId) {
        this.hospedeiroId = hospedeiroId;
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
        if (!(object instanceof Avaliacaohospedagem)) {
            return false;
        }
        Avaliacaohospedagem other = (Avaliacaohospedagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Avaliacaohospedagem[ id=" + id + " ]";
    }
    
}
