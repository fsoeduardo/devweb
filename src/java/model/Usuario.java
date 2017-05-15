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
    , @NamedQuery(name = "Usuario.findByCpf", query = "SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    , @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone")
    , @NamedQuery(name = "Usuario.findByRecebeVisita", query = "SELECT u FROM Usuario u WHERE u.recebeVisita = :recebeVisita")
    , @NamedQuery(name = "Usuario.findByRua", query = "SELECT u FROM Usuario u WHERE u.rua = :rua")
    , @NamedQuery(name = "Usuario.findByNumero", query = "SELECT u FROM Usuario u WHERE u.numero = :numero")
    , @NamedQuery(name = "Usuario.findByBairro", query = "SELECT u FROM Usuario u WHERE u.bairro = :bairro")
    , @NamedQuery(name = "Usuario.findByComplemento", query = "SELECT u FROM Usuario u WHERE u.complemento = :complemento")
    , @NamedQuery(name = "Usuario.findByMaxVisitante", query = "SELECT u FROM Usuario u WHERE u.maxVisitante = :maxVisitante")
    , @NamedQuery(name = "Usuario.findByMinVisitante", query = "SELECT u FROM Usuario u WHERE u.minVisitante = :minVisitante")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SENHA")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEBE_VISITA")
    private Boolean recebeVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NUMERO")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "BAIRRO")
    private String bairro;
    @Size(max = 40)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "MAX_VISITANTE")
    private Integer maxVisitante;
    @Column(name = "MIN_VISITANTE")
    private Integer minVisitante;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Saida> saidaList;
    @JoinTable(name = "AMIZADE", joinColumns = {
        @JoinColumn(name = "USER1_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER2_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Usuario> usuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliadoFk")
    private List<Avaliacaoamizade> avaliacaoamizadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliadorFk")
    private List<Avaliacaoamizade> avaliacaoamizadeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitanteId")
    private List<Hospedagem> hospedagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anfitriaoId")
    private List<Hospedagem> hospedagemList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliadoFk")
    private List<Avaliacaosaida> avaliacaosaidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliadorFk")
    private List<Avaliacaosaida> avaliacaosaidaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anfitriaoFk")
    private List<Saida> saidaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anfitriaoFk")
    private List<Avaliacaohospedagem> avaliacaohospedagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedeFk")
    private List<Avaliacaohospedagem> avaliacaohospedagemList1;
    @JoinColumn(name = "CIDADE_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cidade cidadeFk;
    @JoinColumn(name = "ESPORTE_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Esporte esporteFk;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String senha, String email, String cpf, String telefone, Boolean recebeVisita, String rua, String bairro) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.recebeVisita = recebeVisita;
        this.rua = rua;
        this.bairro = bairro;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getRecebeVisita() {
        return recebeVisita;
    }

    public void setRecebeVisita(Boolean recebeVisita) {
        this.recebeVisita = recebeVisita;
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

    public Integer getMaxVisitante() {
        return maxVisitante;
    }

    public void setMaxVisitante(Integer maxVisitante) {
        this.maxVisitante = maxVisitante;
    }

    public Integer getMinVisitante() {
        return minVisitante;
    }

    public void setMinVisitante(Integer minVisitante) {
        this.minVisitante = minVisitante;
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
    public List<Hospedagem> getHospedagemList() {
        return hospedagemList;
    }

    public void setHospedagemList(List<Hospedagem> hospedagemList) {
        this.hospedagemList = hospedagemList;
    }

    @XmlTransient
    public List<Hospedagem> getHospedagemList1() {
        return hospedagemList1;
    }

    public void setHospedagemList1(List<Hospedagem> hospedagemList1) {
        this.hospedagemList1 = hospedagemList1;
    }

    @XmlTransient
    public List<Avaliacaosaida> getAvaliacaosaidaList() {
        return avaliacaosaidaList;
    }

    public void setAvaliacaosaidaList(List<Avaliacaosaida> avaliacaosaidaList) {
        this.avaliacaosaidaList = avaliacaosaidaList;
    }

    @XmlTransient
    public List<Avaliacaosaida> getAvaliacaosaidaList1() {
        return avaliacaosaidaList1;
    }

    public void setAvaliacaosaidaList1(List<Avaliacaosaida> avaliacaosaidaList1) {
        this.avaliacaosaidaList1 = avaliacaosaidaList1;
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
