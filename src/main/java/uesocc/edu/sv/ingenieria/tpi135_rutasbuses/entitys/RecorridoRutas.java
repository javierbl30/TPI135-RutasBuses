/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys;

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
 * @author pedrojv
 */
@Entity
@Table(name = "RECORRIDO_RUTAS", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecorridoRutas.findAll", query = "SELECT r FROM RecorridoRutas r")
    , @NamedQuery(name = "RecorridoRutas.findByIdRuta", query = "SELECT r FROM RecorridoRutas r WHERE r.recorridoRutasPK.idRuta = :idRuta")
    , @NamedQuery(name = "RecorridoRutas.findByIdParada", query = "SELECT r FROM RecorridoRutas r WHERE r.recorridoRutasPK.idParada = :idParada")
    , @NamedQuery(name = "RecorridoRutas.findByCorrelativo", query = "SELECT r FROM RecorridoRutas r WHERE r.recorridoRutasPK.correlativo = :correlativo")
    , @NamedQuery(name = "RecorridoRutas.findByTiempoDesdeParadaAnterior", query = "SELECT r FROM RecorridoRutas r WHERE r.tiempoDesdeParadaAnterior = :tiempoDesdeParadaAnterior")})
public class RecorridoRutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecorridoRutasPK recorridoRutasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO_DESDE_PARADA_ANTERIOR", nullable = false)
    private int tiempoDesdeParadaAnterior;
    @JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rutas rutas;
    @JoinColumn(name = "ID_PARADA", referencedColumnName = "ID_PARADA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paradas paradas;

    public RecorridoRutas() {
    }

    public RecorridoRutas(RecorridoRutasPK recorridoRutasPK) {
        this.recorridoRutasPK = recorridoRutasPK;
    }

    public RecorridoRutas(RecorridoRutasPK recorridoRutasPK, int tiempoDesdeParadaAnterior) {
        this.recorridoRutasPK = recorridoRutasPK;
        this.tiempoDesdeParadaAnterior = tiempoDesdeParadaAnterior;
    }

    public RecorridoRutas(String idRuta, int idParada, int correlativo) {
        this.recorridoRutasPK = new RecorridoRutasPK(idRuta, idParada, correlativo);
    }

    public RecorridoRutasPK getRecorridoRutasPK() {
        return recorridoRutasPK;
    }

    public void setRecorridoRutasPK(RecorridoRutasPK recorridoRutasPK) {
        this.recorridoRutasPK = recorridoRutasPK;
    }

    public int getTiempoDesdeParadaAnterior() {
        return tiempoDesdeParadaAnterior;
    }

    public void setTiempoDesdeParadaAnterior(int tiempoDesdeParadaAnterior) {
        this.tiempoDesdeParadaAnterior = tiempoDesdeParadaAnterior;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    public Paradas getParadas() {
        return paradas;
    }

    public void setParadas(Paradas paradas) {
        this.paradas = paradas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recorridoRutasPK != null ? recorridoRutasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecorridoRutas)) {
            return false;
        }
        RecorridoRutas other = (RecorridoRutas) object;
        if ((this.recorridoRutasPK == null && other.recorridoRutasPK != null) || (this.recorridoRutasPK != null && !this.recorridoRutasPK.equals(other.recorridoRutasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RecorridoRutas[ recorridoRutasPK=" + recorridoRutasPK + " ]";
    }
    
}
