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
import javax.persistence.JoinColumn;
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
 * @author pedrojv
 */
@Entity
@Table(name = "RUTAS", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r")
    , @NamedQuery(name = "Rutas.findByIdRuta", query = "SELECT r FROM Rutas r WHERE r.idRuta = :idRuta")
    , @NamedQuery(name = "Rutas.findByNombreRuta", query = "SELECT r FROM Rutas r WHERE r.nombreRuta = :nombreRuta")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ID_RUTA", nullable = false, length = 6)
    private String idRuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_RUTA", nullable = false, length = 15)
    private String nombreRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private List<RecorridoRutas> recorridoRutasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private List<RutasBuses> rutasBusesList;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Empresas idEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private List<Horarios> horariosList;

    public Rutas() {
    }

    public Rutas(String idRuta) {
        this.idRuta = idRuta;
    }

    public Rutas(String idRuta, String nombreRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    @XmlTransient
    public List<RecorridoRutas> getRecorridoRutasList() {
        return recorridoRutasList;
    }

    public void setRecorridoRutasList(List<RecorridoRutas> recorridoRutasList) {
        this.recorridoRutasList = recorridoRutasList;
    }

    @XmlTransient
    public List<RutasBuses> getRutasBusesList() {
        return rutasBusesList;
    }

    public void setRutasBusesList(List<RutasBuses> rutasBusesList) {
        this.rutasBusesList = rutasBusesList;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas[ idRuta=" + idRuta + " ]";
    }
    
}
