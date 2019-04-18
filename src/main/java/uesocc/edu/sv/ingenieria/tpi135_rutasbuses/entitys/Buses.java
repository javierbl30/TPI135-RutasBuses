/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author pedrojv
 */
@Entity
@Table(name = "BUSES", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b")
    , @NamedQuery(name = "Buses.findByPlacaBus", query = "SELECT b FROM Buses b WHERE b.placaBus = :placaBus")
    , @NamedQuery(name = "Buses.findByCapacidad", query = "SELECT b FROM Buses b WHERE b.capacidad = :capacidad")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PLACA_BUS", nullable = false, length = 8)
    private String placaBus;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "MARCA", nullable = false, length = 65535)
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "COLOR", nullable = false, length = 65535)
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD", nullable = false)
    private int capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buses")
    private List<RutasBuses> rutasBusesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buses")
    private List<Horarios> horariosList;

    public Buses() {
    }

    public Buses(String placaBus) {
        this.placaBus = placaBus;
    }

    public Buses(String placaBus, String marca, String color, int capacidad) {
        this.placaBus = placaBus;
        this.marca = marca;
        this.color = color;
        this.capacidad = capacidad;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public List<RutasBuses> getRutasBusesList() {
        return rutasBusesList;
    }

    public void setRutasBusesList(List<RutasBuses> rutasBusesList) {
        this.rutasBusesList = rutasBusesList;
    }

    @XmlTransient
    public List<Horarios> getHorariosList() {
        return horariosList;
    }

    public void setHorariosList(List<Horarios> horariosList) {
        this.horariosList = horariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placaBus != null ? placaBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.placaBus == null && other.placaBus != null) || (this.placaBus != null && !this.placaBus.equals(other.placaBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses[ placaBus=" + placaBus + " ]";
    }
    
}
