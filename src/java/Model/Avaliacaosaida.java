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
@Table(name = "AVALIACAOSAIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacaosaida.findAll", query = "SELECT a FROM Avaliacaosaida a")
    , @NamedQuery(name = "Avaliacaosaida.findById", query = "SELECT a FROM Avaliacaosaida a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacaosaida.findByText", query = "SELECT a FROM Avaliacaosaida a WHERE a.text = :text")
    , @NamedQuery(name = "Avaliacaosaida.findByNota", query = "SELECT a FROM Avaliacaosaida a WHERE a.nota = :nota")})
public class Avaliacaosaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "TEXT")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA")
    private int nota;
    @JoinColumn(name = "SAIDA_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Saida saidaFk;
    @JoinColumn(name = "AVALIADO_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario avaliadoFk;
    @JoinColumn(name = "AVALIADOR_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario avaliadorFk;

    public Avaliacaosaida() {
    }

    public Avaliacaosaida(Integer id) {
        this.id = id;
    }

    public Avaliacaosaida(Integer id, int nota) {
        this.id = id;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Saida getSaidaFk() {
        return saidaFk;
    }

    public void setSaidaFk(Saida saidaFk) {
        this.saidaFk = saidaFk;
    }

    public Usuario getAvaliadoFk() {
        return avaliadoFk;
    }

    public void setAvaliadoFk(Usuario avaliadoFk) {
        this.avaliadoFk = avaliadoFk;
    }

    public Usuario getAvaliadorFk() {
        return avaliadorFk;
    }

    public void setAvaliadorFk(Usuario avaliadorFk) {
        this.avaliadorFk = avaliadorFk;
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
        if (!(object instanceof Avaliacaosaida)) {
            return false;
        }
        Avaliacaosaida other = (Avaliacaosaida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Avaliacaosaida[ id=" + id + " ]";
    }
    
}
