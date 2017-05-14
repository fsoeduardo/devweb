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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByStatus", query = "SELECT u FROM Usuario u WHERE u.status = :status")
    , @NamedQuery(name = "Usuario.findByLocalidade", query = "SELECT u FROM Usuario u WHERE u.localidade = :localidade")
    , @NamedQuery(name = "Usuario.findByQntvisitante", query = "SELECT u FROM Usuario u WHERE u.qntvisitante = :qntvisitante")})
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
    @Size(min = 1, max = 64)
    @Column(name = "SENHA")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Boolean status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "LOCALIDADE")
    private String localidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QNTVISITANTE")
    private int qntvisitante;
    @JoinTable(name = "SAIDAUSUARIO", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SAIDA_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Saida> saidaList;
    @JoinTable(name = "AMIZADE", joinColumns = {
        @JoinColumn(name = "AMIGO_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Usuario> usuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFaz")
    private List<Avaliacaoamizade> avaliacaoamizadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRecebe")
    private List<Avaliacaoamizade> avaliacaoamizadeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFaz")
    private List<Saida> saidaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedadoId")
    private List<Avaliacaohospedagem> avaliacaohospedagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedeiroId")
    private List<Avaliacaohospedagem> avaliacaohospedagemList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRecebe")
    private List<Avaliacaoesporte> avaliacaoesporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFaz")
    private List<Avaliacaoesporte> avaliacaoesporteList1;
    @JoinColumn(name = "ESPORTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Esporte esporteId;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String senha, String email, Boolean status, String localidade, int qntvisitante) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.status = status;
        this.localidade = localidade;
        this.qntvisitante = qntvisitante;
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

    public int getQntvisitante() {
        return qntvisitante;
    }

    public void setQntvisitante(int qntvisitante) {
        this.qntvisitante = qntvisitante;
    }

    @XmlTransient
    public List<Saida> getSaidaList() {
        return saidaList;
    }

    public void setSaidaList(List<Saida> saidaList) {
        this.saidaList = saidaList;
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
    public List<Avaliacaoamizade> getAvaliacaoamizadeList() {
        return avaliacaoamizadeList;
    }

    public void setAvaliacaoamizadeList(List<Avaliacaoamizade> avaliacaoamizadeList) {
        this.avaliacaoamizadeList = avaliacaoamizadeList;
    }

    @XmlTransient
    public List<Avaliacaoamizade> getAvaliacaoamizadeList1() {
        return avaliacaoamizadeList1;
    }

    public void setAvaliacaoamizadeList1(List<Avaliacaoamizade> avaliacaoamizadeList1) {
        this.avaliacaoamizadeList1 = avaliacaoamizadeList1;
    }

    @XmlTransient
    public List<Saida> getSaidaList1() {
        return saidaList1;
    }

    public void setSaidaList1(List<Saida> saidaList1) {
        this.saidaList1 = saidaList1;
    }

    @XmlTransient
    public List<Avaliacaohospedagem> getAvaliacaohospedagemList() {
        return avaliacaohospedagemList;
    }

    public void setAvaliacaohospedagemList(List<Avaliacaohospedagem> avaliacaohospedagemList) {
        this.avaliacaohospedagemList = avaliacaohospedagemList;
    }

    @XmlTransient
    public List<Avaliacaohospedagem> getAvaliacaohospedagemList1() {
        return avaliacaohospedagemList1;
    }

    public void setAvaliacaohospedagemList1(List<Avaliacaohospedagem> avaliacaohospedagemList1) {
        this.avaliacaohospedagemList1 = avaliacaohospedagemList1;
    }

    @XmlTransient
    public List<Avaliacaoesporte> getAvaliacaoesporteList() {
        return avaliacaoesporteList;
    }

    public void setAvaliacaoesporteList(List<Avaliacaoesporte> avaliacaoesporteList) {
        this.avaliacaoesporteList = avaliacaoesporteList;
    }

    @XmlTransient
    public List<Avaliacaoesporte> getAvaliacaoesporteList1() {
        return avaliacaoesporteList1;
    }

    public void setAvaliacaoesporteList1(List<Avaliacaoesporte> avaliacaoesporteList1) {
        this.avaliacaoesporteList1 = avaliacaoesporteList1;
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
        return "Model.Usuario[ id=" + id + " ]";
    }
    
}
