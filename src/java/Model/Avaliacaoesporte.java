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
@Table(name = "AVALIACAOESPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacaoesporte.findAll", query = "SELECT a FROM Avaliacaoesporte a")
    , @NamedQuery(name = "Avaliacaoesporte.findById", query = "SELECT a FROM Avaliacaoesporte a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacaoesporte.findByNota", query = "SELECT a FROM Avaliacaoesporte a WHERE a.nota = :nota")
    , @NamedQuery(name = "Avaliacaoesporte.findByTexto", query = "SELECT a FROM Avaliacaoesporte a WHERE a.texto = :texto")})
public class Avaliacaoesporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA")
    private int nota;
    @Size(max = 255)
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "SAIDA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Saida saidaId;
    @JoinColumn(name = "USER_RECEBE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario userRecebe;
    @JoinColumn(name = "USER_FAZ", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario userFaz;

    public Avaliacaoesporte() {
    }

    public Avaliacaoesporte(Integer id) {
        this.id = id;
    }

    public Avaliacaoesporte(Integer id, int nota) {
        this.id = id;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Saida getSaidaId() {
        return saidaId;
    }

    public void setSaidaId(Saida saidaId) {
        this.saidaId = saidaId;
    }

    public Usuario getUserRecebe() {
        return userRecebe;
    }

    public void setUserRecebe(Usuario userRecebe) {
        this.userRecebe = userRecebe;
    }

    public Usuario getUserFaz() {
        return userFaz;
    }

    public void setUserFaz(Usuario userFaz) {
        this.userFaz = userFaz;
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
        if (!(object instanceof Avaliacaoesporte)) {
            return false;
        }
        Avaliacaoesporte other = (Avaliacaoesporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Avaliacaoesporte[ id=" + id + " ]";
    }
    
}
