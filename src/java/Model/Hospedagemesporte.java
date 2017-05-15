/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo Junior
 */
@Entity
@Table(name = "HOSPEDAGEMESPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospedagemesporte.findAll", query = "SELECT h FROM Hospedagemesporte h")
    , @NamedQuery(name = "Hospedagemesporte.findByHospedagemFk", query = "SELECT h FROM Hospedagemesporte h WHERE h.hospedagemesportePK.hospedagemFk = :hospedagemFk")
    , @NamedQuery(name = "Hospedagemesporte.findByEsporteFk", query = "SELECT h FROM Hospedagemesporte h WHERE h.hospedagemesportePK.esporteFk = :esporteFk")
    , @NamedQuery(name = "Hospedagemesporte.findByQtdEsportista", query = "SELECT h FROM Hospedagemesporte h WHERE h.qtdEsportista = :qtdEsportista")})
public class Hospedagemesporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HospedagemesportePK hospedagemesportePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_ESPORTISTA")
    private int qtdEsportista;
    @JoinColumn(name = "ESPORTE_FK", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Esporte esporte;
    @JoinColumn(name = "HOSPEDAGEM_FK", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hospedagem hospedagem;

    public Hospedagemesporte() {
    }

    public Hospedagemesporte(HospedagemesportePK hospedagemesportePK) {
        this.hospedagemesportePK = hospedagemesportePK;
    }

    public Hospedagemesporte(HospedagemesportePK hospedagemesportePK, int qtdEsportista) {
        this.hospedagemesportePK = hospedagemesportePK;
        this.qtdEsportista = qtdEsportista;
    }

    public Hospedagemesporte(int hospedagemFk, int esporteFk) {
        this.hospedagemesportePK = new HospedagemesportePK(hospedagemFk, esporteFk);
    }

    public HospedagemesportePK getHospedagemesportePK() {
        return hospedagemesportePK;
    }

    public void setHospedagemesportePK(HospedagemesportePK hospedagemesportePK) {
        this.hospedagemesportePK = hospedagemesportePK;
    }

    public int getQtdEsportista() {
        return qtdEsportista;
    }

    public void setQtdEsportista(int qtdEsportista) {
        this.qtdEsportista = qtdEsportista;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospedagemesportePK != null ? hospedagemesportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospedagemesporte)) {
            return false;
        }
        Hospedagemesporte other = (Hospedagemesporte) object;
        if ((this.hospedagemesportePK == null && other.hospedagemesportePK != null) || (this.hospedagemesportePK != null && !this.hospedagemesportePK.equals(other.hospedagemesportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Hospedagemesporte[ hospedagemesportePK=" + hospedagemesportePK + " ]";
    }
    
}
