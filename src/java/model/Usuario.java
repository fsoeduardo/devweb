/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByStatus", query = "SELECT u FROM Usuario u WHERE u.status = :status")
    , @NamedQuery(name = "Usuario.findByLocalidade", query = "SELECT u FROM Usuario u WHERE u.localidade = :localidade")
    , @NamedQuery(name = "Usuario.findByQntvisitante", query = "SELECT u FROM Usuario u WHERE u.qntvisitante = :qntvisitante")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Boolean status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "LOCALIDADE")
    private String localidade;
    @Column(name = "QNTVISITANTE")
    private Integer qntvisitante;
    @Size(max = 30)
    @Column(name = "SENHA")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @JoinTable(name = "AMIZADE", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "AMIGO_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Usuario> usuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFaz")
    private List<Avaliacao> avaliacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRecebe")
    private List<Avaliacao> avaliacaoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedadoId")
    private List<Avaliacaocomposta> avaliacaocompostaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospederoId")
    private List<Avaliacaocomposta> avaliacaocompostaList1;
    @JoinColumn(name = "ESPORTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Esporte esporteId;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, Boolean status, String localidade) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.localidade = localidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Integer getQntvisitante() {
        return qntvisitante;
    }

    public void setQntvisitante(Integer qntvisitante) {
        this.qntvisitante = qntvisitante;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList1() {
        return usuarioList1;
    }

    public void setUsuarioList1(List<Usuario> usuarioList1) {
        this.usuarioList1 = usuarioList1;
    }

    @XmlTransient
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @XmlTransient
    public List<Avaliacao> getAvaliacaoList1() {
        return avaliacaoList1;
    }

    public void setAvaliacaoList1(List<Avaliacao> avaliacaoList1) {
        this.avaliacaoList1 = avaliacaoList1;
    }

    @XmlTransient
    public List<Avaliacaocomposta> getAvaliacaocompostaList() {
        return avaliacaocompostaList;
    }

    public void setAvaliacaocompostaList(List<Avaliacaocomposta> avaliacaocompostaList) {
        this.avaliacaocompostaList = avaliacaocompostaList;
    }

    @XmlTransient
    public List<Avaliacaocomposta> getAvaliacaocompostaList1() {
        return avaliacaocompostaList1;
    }

    public void setAvaliacaocompostaList1(List<Avaliacaocomposta> avaliacaocompostaList1) {
        this.avaliacaocompostaList1 = avaliacaocompostaList1;
    }

    public Esporte getEsporteId() {
        return esporteId;
    }

    public void setEsporteId(Esporte esporteId) {
        this.esporteId = esporteId;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ id=" + id + " ]";
    }
    
}
