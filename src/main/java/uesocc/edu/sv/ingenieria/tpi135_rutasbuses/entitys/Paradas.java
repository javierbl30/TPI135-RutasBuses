/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
@Table(name = "PARADAS", catalog = "rutasbuses", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paradas.findAll", query = "SELECT p FROM Paradas p")
    , @NamedQuery(name = "Paradas.findByIdParada", query = "SELECT p FROM Paradas p WHERE p.idParada = :idParada")
    , @NamedQuery(name = "Paradas.findByReferencia", query = "SELECT p FROM Paradas p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Paradas.findByCoordenadas", query = "SELECT p FROM Paradas p WHERE p.coordenadas = :coordenadas")})
public class Paradas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARADA", nullable = false)
    private Integer idParada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "REFERENCIA", nullable = false, length = 80)
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COORDENADAS", nullable = false, length = 50)
    private String coordenadas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "FOTO", nullable = false)
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paradas")
    private List<RecorridoRutas> recorridoRutasList;

    public Paradas() {
    }

    public Paradas(Integer idParada) {
        this.idParada = idParada;
    }

    public Paradas(Integer idParada, String referencia, String coordenadas, byte[] foto) {
        this.idParada = idParada;
        this.referencia = referencia;
        this.coordenadas = coordenadas;
        this.foto = foto;
    }

    public Integer getIdParada() {
        return idParada;
    }

    public void setIdParada(Integer idParada) {
        this.idParada = idParada;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    @JsonbTransient
    public List<RecorridoRutas> getRecorridoRutasList() {
        return recorridoRutasList;
    }

    public void setRecorridoRutasList(List<RecorridoRutas> recorridoRutasList) {
        this.recorridoRutasList = recorridoRutasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParada != null ? idParada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paradas)) {
            return false;
        }
        Paradas other = (Paradas) object;
        if ((this.idParada == null && other.idParada != null) || (this.idParada != null && !this.idParada.equals(other.idParada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas[ idParada=" + idParada + " ]";
    }
    
}
