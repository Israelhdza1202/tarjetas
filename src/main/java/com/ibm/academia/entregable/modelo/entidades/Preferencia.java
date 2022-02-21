package com.ibm.academia.entregable.modelo.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name = "preferencia", schema = "entregable")
@NoArgsConstructor
public class Preferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false, length = 30)
    private String nombre;

    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false )
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "salario_id", foreignKey = @ForeignKey(name = "FK_SALARIO_ID"))
    private Salario salario;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tarjeta_id", foreignKey = @ForeignKey(name = "FK_TARJETA_ID"))
    private Tarjeta tarjeta;


    public Preferencia(Long id, String nombre, String usuarioCreacion, Date fechaCreacion, Date fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioCreacion = usuarioCreacion;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Salario [id=");
        builder.append(id);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append(", usuarioCreacion=");
        builder.append(usuarioCreacion);
        builder.append(", fechaCreacion=");
        builder.append(fechaCreacion);
        builder.append(", fechaModificacion=");
        builder.append(fechaModificacion);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferencia that = (Preferencia) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @PrePersist
    private void antesPersistir()
    {
        this.fechaCreacion=new Date();
    }

    @PreUpdate
    private void antesActualizar()
    {
        this.fechaModificacion=new Date();
    }
}
