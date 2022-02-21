package com.ibm.academia.entregable.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "edad", schema = "entregable")
public class Edad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "edad")
	private String edad;
		
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false )
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;


	@OneToMany(mappedBy = "edad", fetch = FetchType.LAZY)
	private Set<Salario> salario;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "edad", referencedColumnName = "id")
	private Tarjeta tarjeta;

	public Edad(Integer id, String edad, String usuarioCreacion) {

		this.id = id;
		this.edad = edad;
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Edad [id=");
		builder.append(id);
		builder.append(", edad=");
		builder.append(edad);
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
	public int hashCode() {
		return Objects.hash(edad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edad other = (Edad) obj;
		return Objects.equals(edad, other.edad);
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
	
	private static final long serialVersionUID = -2426869084927847841L;

	
}
