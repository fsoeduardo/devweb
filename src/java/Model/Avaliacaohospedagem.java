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
@Table(name = "AVALIACAOHOSPEDAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacaohospedagem.findAll", query = "SELECT a FROM Avaliacaohospedagem a")
    , @NamedQuery(name = "Avaliacaohospedagem.findById", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacaohospedagem.findByAvaAnfitriaoText", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.avaAnfitriaoText = :avaAnfitriaoText")
    , @NamedQuery(name = "Avaliacaohospedagem.findByAvaHospedeText", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.avaHospedeText = :avaHospedeText")
    , @NamedQuery(name = "Avaliacaohospedagem.findByNotaAnfitriao", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.notaAnfitriao = :notaAnfitriao")
    , @NamedQuery(name = "Avaliacaohospedagem.findByNotaHospede", query = "SELECT a FROM Avaliacaohospedagem a WHERE a.notaHospede = :notaHospede")})
public class Avaliacaohospedagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "AVA_ANFITRIAO_TEXT")
    private String avaAnfitriaoText;
    @Size(max = 255)
    @Column(name = "AVA_HOSPEDE_TEXT")
    private String avaHospedeText;
    @Column(name = "NOTA_ANFITRIAO")
    private Integer notaAnfitriao;
    @Column(name = "NOTA_HOSPEDE")
    private Integer notaHospede;
    @JoinColumn(name = "HOSPEDAGEM_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hospedagem hospedagemFk;
    @JoinColumn(name = "ANFITRIAO_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario anfitriaoFk;
    @JoinColumn(name = "HOSPEDE_FK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario hospedeFk;

    public Avaliacaohospedagem() {
    }

    public Avaliacaohospedagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvaAnfitriaoText() {
        return avaAnfitriaoText;
    }

    public void setAvaAnfitriaoText(String avaAnfitriaoText) {
        this.avaAnfitriaoText = avaAnfitriaoText;
    }

    public String getAvaHospedeText() {
        return avaHospedeText;
    }

    public void setAvaHospedeText(String avaHospedeText) {
        this.avaHospedeText = avaHospedeText;
    }

    public Integer getNotaAnfitriao() {
        return notaAnfitriao;
    }

    public void setNotaAnfitriao(Integer notaAnfitriao) {
        this.notaAnfitriao = notaAnfitriao;
    }

    public Integer getNotaHospede() {
        return notaHospede;
    }

    public void setNotaHospede(Integer notaHospede) {
        this.notaHospede = notaHospede;
    }

    public Hospedagem getHospedagemFk() {
        return hospedagemFk;
    }

    public void setHospedagemFk(Hospedagem hospedagemFk) {
        this.hospedagemFk = hospedagemFk;
    }

    public Usuario getAnfitriaoFk() {
        return anfitriaoFk;
    }

    public void setAnfitriaoFk(Usuario anfitriaoFk) {
        this.anfitriaoFk = anfitriaoFk;
    }

    public Usuario getHospedeFk() {
        return hospedeFk;
    }

    public void setHospedeFk(Usuario hospedeFk) {
        this.hospedeFk = hospedeFk;
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
        if (!(object instanceof Avaliacaohospedagem)) {
            return false;
        }
        Avaliacaohospedagem other = (Avaliacaohospedagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Avaliacaohospedagem[ id=" + id + " ]";
    }
    
}
