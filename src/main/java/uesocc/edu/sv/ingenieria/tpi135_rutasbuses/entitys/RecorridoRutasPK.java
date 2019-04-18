/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pedrojv
 */
@Embeddable
public class RecorridoRutasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ID_RUTA", nullable = false, length = 6)
    private String idRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARADA", nullable = false)
    private int idParada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private int correlativo;

    public RecorridoRutasPK() {
    }

    public RecorridoRutasPK(String idRuta, int idParada, int correlativo) {
        this.idRuta = idRuta;
        this.idParada = idParada;
        this.correlativo = correlativo;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdParada() {
        return idParada;
    }

    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        hash += (int) idParada;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecorridoRutasPK)) {
            return false;
        }
        RecorridoRutasPK other = (RecorridoRutasPK) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        if (this.idParada != other.idParada) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RecorridoRutasPK[ idRuta=" + idRuta + ", idParada=" + idParada + ", correlativo=" + correlativo + " ]";
    }
    
}
