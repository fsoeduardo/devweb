/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo Junior
 */
@Entity
@Table(name = "SAIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s")
    , @NamedQuery(name = "Saida.findById", query = "SELECT s FROM Saida s WHERE s.id = :id")
    , @NamedQuery(name = "Saida.findByLocalidade", query = "SELECT s FROM Saida s WHERE s.localidade = :localidade")
    , @NamedQuery(name = "Saida.findByDescricao", query = "SELECT s FROM Saida s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Saida.findByStatus", query = "SELECT s FROM Saida s WHERE s.status = :status")
    , @NamedQuery(name = "Saida.findByDuracao", query = "SELECT s FROM Saida s WHERE s.duracao = :duracao")
    , @NamedQuery(name = "Saida.findByCusto", query = "SELECT s FROM Saida s WHERE s.custo = :custo")
    , @NamedQuery(name = "Saida.findByNumMax", query = "SELECT s FROM Saida s WHERE s.numMax = :numMax")
    , @NamedQuery(name = "Saida.findByNumMin", query = "SELECT s FROM Saida s WHERE s.numMin = :numMin")})
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 64)
    @Column(name = "LOCALIDADE")
    private String localidade;
    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACAO")
    private int duracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTO")
    private double custo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_MAX")
    private int numMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_MIN")
    private int numMin;
    @ManyToMany(mappedBy = "saidaList")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "USER_FAZ", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario userFaz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saidaId")
    private List<Avaliacaoesporte> avaliacaoesporteList;

    public Saida() {
    }

    public Saida(Integer id) {
        this.id = id;
    }

    public Saida(Integer id, Boolean status, int duracao, double custo, int numMax, int numMin) {
        this.id = id;
        this.status = status;
        this.duracao = duracao;
        this.custo = custo;
        this.numMax = numMax;
        this.numMin = numMin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getNumMax() {
        return numMax;
    }

    public void setNumMax(int numMax) {
        this.numMax = numMax;
    }

    public int getNumMin() {
        return numMin;
    }

    public void setNumMin(int numMin) {
        this.numMin = numMin;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getUserFaz() {
        return userFaz;
    }

    public void setUserFaz(Usuario userFaz) {
        this.userFaz = userFaz;
    }

    @XmlTransient
    public List<Avaliacaoesporte> getAvaliacaoesporteList() {
        return avaliacaoesporteList;
    }

    public void setAvaliacaoesporteList(List<Avaliacaoesporte> avaliacaoesporteList) {
        this.avaliacaoesporteList = avaliacaoesporteList;
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
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Saida[ id=" + id + " ]";
    }
    
}
