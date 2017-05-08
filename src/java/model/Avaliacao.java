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
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a")
    , @NamedQuery(name = "Avaliacao.findById", query = "SELECT a FROM Avaliacao a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacao.findByText", query = "SELECT a FROM Avaliacao a WHERE a.text = :text")
    , @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(length = 255)
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int nota;
    @JoinColumn(name = "TIPO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Tipo tipo;
    @JoinColumn(name = "USER_FAZ", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario userFaz;
    @JoinColumn(name = "USER_RECEBE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario userRecebe;

    public Avaliacao() {
    }

    public Avaliacao(Integer id) {
        this.id = id;
    }

    public Avaliacao(Integer id, int nota) {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUserFaz() {
        return userFaz;
    }

    public void setUserFaz(Usuario userFaz) {
        this.userFaz = userFaz;
    }

    public Usuario getUserRecebe() {
        return userRecebe;
    }

    public void setUserRecebe(Usuario userRecebe) {
        this.userRecebe = userRecebe;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Avaliacao[ id=" + id + " ]";
    }
    
}
