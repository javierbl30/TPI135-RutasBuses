/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedrojv
 */
@Entity
@Table(name = "HORARIOS", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findByIdRuta", query = "SELECT h FROM Horarios h WHERE h.horariosPK.idRuta = :idRuta")
    , @NamedQuery(name = "Horarios.findByPlacaBus", query = "SELECT h FROM Horarios h WHERE h.horariosPK.placaBus = :placaBus")
    , @NamedQuery(name = "Horarios.findByHoraSalida", query = "SELECT h FROM Horarios h WHERE h.horaSalida = :horaSalida")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorariosPK horariosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_SALIDA", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @JoinColumn(name = "PLACA_BUS", referencedColumnName = "PLACA_BUS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Buses buses;
    @JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rutas rutas;

    public Horarios() {
    }

    public Horarios(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
    }

    public Horarios(HorariosPK horariosPK, Date horaSalida) {
        this.horariosPK = horariosPK;
        this.horaSalida = horaSalida;
    }

    public Horarios(String idRuta, String placaBus) {
        this.horariosPK = new HorariosPK(idRuta, placaBus);
    }

    public HorariosPK getHorariosPK() {
        return horariosPK;
    }

    public void setHorariosPK(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
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
        hash += (horariosPK != null ? horariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.horariosPK == null && other.horariosPK != null) || (this.horariosPK != null && !this.horariosPK.equals(other.horariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios[ horariosPK=" + horariosPK + " ]";
    }
    
}
