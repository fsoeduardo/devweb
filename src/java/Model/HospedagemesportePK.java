/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo Junior
 */
@Embeddable
public class HospedagemesportePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "HOSPEDAGEM_FK")
    private int hospedagemFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPORTE_FK")
    private int esporteFk;

    public HospedagemesportePK() {
    }

    public HospedagemesportePK(int hospedagemFk, int esporteFk) {
        this.hospedagemFk = hospedagemFk;
        this.esporteFk = esporteFk;
    }

    public int getHospedagemFk() {
        return hospedagemFk;
    }

    public void setHospedagemFk(int hospedagemFk) {
        this.hospedagemFk = hospedagemFk;
    }

    public int getEsporteFk() {
        return esporteFk;
    }

    public void setEsporteFk(int esporteFk) {
        this.esporteFk = esporteFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hospedagemFk;
        hash += (int) esporteFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospedagemesportePK)) {
            return false;
        }
        HospedagemesportePK other = (HospedagemesportePK) object;
        if (this.hospedagemFk != other.hospedagemFk) {
            return false;
        }
        if (this.esporteFk != other.esporteFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HospedagemesportePK[ hospedagemFk=" + hospedagemFk + ", esporteFk=" + esporteFk + " ]";
    }
    
}
