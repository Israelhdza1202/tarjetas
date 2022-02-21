package com.ibm.academia.entregable.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tarjeta", schema = "entregable")
public class Tarjeta implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", unique = true, nullable = false, length = 30)
	private String nombre;
	
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false )
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@OneToOne(mappedBy = "tarjeta")
	private Edad edad;

	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	private Set<Salario> salario;

	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	private Set<Preferencia> preferencia;


	public Tarjeta(Integer id, String nombre, String usuarioCreacion, Date fechaCreacion, Date fechaModificacion, Preferencia preferencia, Salario salario, Edad edad) {
		this.id = id;
		this.nombre = nombre;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.edad = edad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjeta [id=");
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
		Tarjeta Tarjeta = (Tarjeta) o;
		return Objects.equals(nombre, Tarjeta.nombre);
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
	
	private static final long serialVersionUID = -4474051824923335731L;

}
