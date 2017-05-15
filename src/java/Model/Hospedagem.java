/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo Junior
 */
@Entity
@Table(name = "HOSPEDAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospedagem.findAll", query = "SELECT h FROM Hospedagem h")
    , @NamedQuery(name = "Hospedagem.findById", query = "SELECT h FROM Hospedagem h WHERE h.id = :id")
    , @NamedQuery(name = "Hospedagem.findByDataInicio", query = "SELECT h FROM Hospedagem h WHERE h.dataInicio = :dataInicio")
    , @NamedQuery(name = "Hospedagem.findByDataTermino", query = "SELECT h FROM Hospedagem h WHERE h.dataTermino = :dataTermino")
    , @NamedQuery(name = "Hospedagem.findByQtdHospedes", query = "SELECT h FROM Hospedagem h WHERE h.qtdHospedes = :qtdHospedes")
    , @NamedQuery(name = "Hospedagem.findBySituacaoAnfitriao", query = "SELECT h FROM Hospedagem h WHERE h.situacaoAnfitriao = :situacaoAnfitriao")
    , @NamedQuery(name = "Hospedagem.findByJustificativa", query = "SELECT h FROM Hospedagem h WHERE h.justificativa = :justificativa")
    , @NamedQuery(name = "Hospedagem.findByConfirmacaoSolicitante", query = "SELECT h FROM Hospedagem h WHERE h.confirmacaoSolicitante = :confirmacaoSolicitante")})
public class Hospedagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_TERMINO")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_HOSPEDES")
    private int qtdHospedes;
    @Column(name = "SITUACAO_ANFITRIAO")
    private Boolean situacaoAnfitriao;
    @Size(max = 40)
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Column(name = "CONFIRMACAO_SOLICITANTE")
    private Boolean confirmacaoSolicitante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedagem")
    private List<Hospedagemesporte> hospedagemesporteList;
    @JoinColumn(name = "SOLICITANTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario solicitanteId;
    @JoinColumn(name = "ANFITRIAO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario anfitriaoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospedagemFk")
    private List<Avaliacaohospedagem> avaliacaohospedagemList;

    public Hospedagem() {
    }

    public Hospedagem(Integer id) {
        this.id = id;
    }

    public Hospedagem(Integer id, Date dataInicio, Date dataTermino, int qtdHospedes) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.qtdHospedes = qtdHospedes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(int qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }

    public Boolean getSituacaoAnfitriao() {
        return situacaoAnfitriao;
    }

    public void setSituacaoAnfitriao(Boolean situacaoAnfitriao) {
        this.situacaoAnfitriao = situacaoAnfitriao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Boolean getConfirmacaoSolicitante() {
        return confirmacaoSolicitante;
    }

    public void setConfirmacaoSolicitante(Boolean confirmacaoSolicitante) {
        this.confirmacaoSolicitante = confirmacaoSolicitante;
    }

    @XmlTransient
    public List<Hospedagemesporte> getHospedagemesporteList() {
        return hospedagemesporteList;
    }

    public void setHospedagemesporteList(List<Hospedagemesporte> hospedagemesporteList) {
        this.hospedagemesporteList = hospedagemesporteList;
    }

    public Usuario getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Usuario solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Usuario getAnfitriaoId() {
        return anfitriaoId;
    }

    public void setAnfitriaoId(Usuario anfitriaoId) {
        this.anfitriaoId = anfitriaoId;
    }

    @XmlTransient
    public List<Avaliacaohospedagem> getAvaliacaohospedagemList() {
        return avaliacaohospedagemList;
    }

    public void setAvaliacaohospedagemList(List<Avaliacaohospedagem> avaliacaohospedagemList) {
        this.avaliacaohospedagemList = avaliacaohospedagemList;
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
        if (!(object instanceof Hospedagem)) {
            return false;
        }
        Hospedagem other = (Hospedagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Hospedagem[ id=" + id + " ]";
    }
    
}
