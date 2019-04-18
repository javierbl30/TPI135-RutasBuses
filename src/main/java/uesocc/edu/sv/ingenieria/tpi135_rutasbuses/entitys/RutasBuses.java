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
@Table(name = "RUTAS_BUSES", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RutasBuses.findAll", query = "SELECT r FROM RutasBuses r")
    , @NamedQuery(name = "RutasBuses.findByIdRuta", query = "SELECT r FROM RutasBuses r WHERE r.rutasBusesPK.idRuta = :idRuta")
    , @NamedQuery(name = "RutasBuses.findByPlacaBus", query = "SELECT r FROM RutasBuses r WHERE r.rutasBusesPK.placaBus = :placaBus")
    , @NamedQuery(name = "RutasBuses.findByCosto", query = "SELECT r FROM RutasBuses r WHERE r.costo = :costo")})
public class RutasBuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RutasBusesPK rutasBusesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO", nullable = false)
    private double costo;
    @JoinColumn(name = "PLACA_BUS", referencedColumnName = "PLACA_BUS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Buses buses;
    @JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rutas rutas;

    public RutasBuses() {
    }

    public RutasBuses(RutasBusesPK rutasBusesPK) {
        this.rutasBusesPK = rutasBusesPK;
    }

    public RutasBuses(RutasBusesPK rutasBusesPK, double costo) {
        this.rutasBusesPK = rutasBusesPK;
        this.costo = costo;
    }

    public RutasBuses(String idRuta, String placaBus) {
        this.rutasBusesPK = new RutasBusesPK(idRuta, placaBus);
    }

    public RutasBusesPK getRutasBusesPK() {
        return rutasBusesPK;
    }

    public void setRutasBusesPK(RutasBusesPK rutasBusesPK) {
        this.rutasBusesPK = rutasBusesPK;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutasBusesPK != null ? rutasBusesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutasBuses)) {
            return false;
        }
        RutasBuses other = (RutasBuses) object;
        if ((this.rutasBusesPK == null && other.rutasBusesPK != null) || (this.rutasBusesPK != null && !this.rutasBusesPK.equals(other.rutasBusesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses[ rutasBusesPK=" + rutasBusesPK + " ]";
    }
    
}
