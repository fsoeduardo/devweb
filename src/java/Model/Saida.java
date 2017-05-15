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
import javax.persistence.JoinTable;
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
    , @NamedQuery(name = "Saida.findByDuracao", query = "SELECT s FROM Saida s WHERE s.duracao = :duracao")
    , @NamedQuery(name = "Saida.findByCusto", query = "SELECT s FROM Saida s WHERE s.custo = :custo")
    , @NamedQuery(name = "Saida.findByQtdMax", query = "SELECT s FROM Saida s WHERE s.qtdMax = :qtdMax")
    , @NamedQuery(name = "Saida.findByQtdMin", query = "SELECT s FROM Saida s WHERE s.qtdMin = :qtdMin")
    , @NamedQuery(name = "Saida.findByDescricao", query = "SELECT s FROM Saida s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Saida.findByRua", query = "SELECT s FROM Saida s WHERE s.rua = :rua")
    , @NamedQuery(name = "Saida.findByNumero", query = "SELECT s FROM Saida s WHERE s.numero = :numero")
    , @NamedQuery(name = "Saida.findByBairro", query = "SELECT s FROM Saida s WHERE s.bairro = :bairro")
    , @NamedQuery(name = "Saida.findByComplemento", query = "SELECT s FROM Saida s WHERE s.complemento = :complemento")})
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACAO")
    private double duracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTO")
    private double custo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_MAX")
    private int qtdMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_MIN")
    private int qtdMin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NUMERO")
    private Integer numero;
    @Size(max = 40)
    @Column(name = "BAIRRO")
    private String bairro;
    @Size(max = 40)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @JoinTable(name = "SAIDAUSUARIO", joinColumns = {
        @JoinColumn(name = "SAIDA_FK", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER_FK", referencedColumnName = "ID")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saidaFk")
    private List<Avaliacaosaida> avaliacaosaidaList;
    @JoinColumn(name = "CIDADE_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cidade cidadeFk;
    @JoinColumn(name = "ESPORTE_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Esporte esporteFk;
    @JoinColumn(name = "ANFITRIAO_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario anfitriaoFk;

    public Saida() {
    }

    public Saida(Integer id) {
        this.id = id;
    }

    public Saida(Integer id, double duracao, double custo, int qtdMax, int qtdMin, String descricao, String rua) {
        this.id = id;
        this.duracao = duracao;
        this.custo = custo;
        this.qtdMax = qtdMax;
        this.qtdMin = qtdMin;
        this.descricao = descricao;
        this.rua = rua;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public int getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(int qtdMin) {
        this.qtdMin = qtdMin;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Avaliacaosaida> getAvaliacaosaidaList() {
        return avaliacaosaidaList;
    }

    public void setAvaliacaosaidaList(List<Avaliacaosaida> avaliacaosaidaList) {
        this.avaliacaosaidaList = avaliacaosaidaList;
    }

    public Cidade getCidadeFk() {
        return cidadeFk;
    }

    public void setCidadeFk(Cidade cidadeFk) {
        this.cidadeFk = cidadeFk;
    }

    public Esporte getEsporteFk() {
        return esporteFk;
    }

    public void setEsporteFk(Esporte esporteFk) {
        this.esporteFk = esporteFk;
    }

    public Usuario getAnfitriaoFk() {
        return anfitriaoFk;
    }

    public void setAnfitriaoFk(Usuario anfitriaoFk) {
        this.anfitriaoFk = anfitriaoFk;
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
