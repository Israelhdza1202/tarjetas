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
@ToString
@Entity
@NoArgsConstructor
@Table(name = "salario", schema = "entregable")
public class Salario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "salario")
	private String salario;
	
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false )
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@OneToMany(mappedBy = "salario", fetch = FetchType.LAZY)
	private Set<Preferencia> preferencia ;

	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "edad_id", foreignKey = @ForeignKey(name = "FK_EDAD_ID"))
	private Edad edad;


	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "tarjeta_id", foreignKey = @ForeignKey(name = "FK_TARJETA_ID"))
	private Tarjeta tarjeta;

	
	public Salario(Integer id, String salario, String usuarioCreacion) {
	
		this.id = id;
		this.salario = salario;
		this.usuarioCreacion = usuarioCreacion;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Salario [id=");
		builder.append(id);
		builder.append(", salario=");
		builder.append(salario);
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
		return Objects.hash(salario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salario other = (Salario) obj;
		return Objects.equals(salario, other.salario);
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
	
	private static final long serialVersionUID = -1226116878708555113L;

}
