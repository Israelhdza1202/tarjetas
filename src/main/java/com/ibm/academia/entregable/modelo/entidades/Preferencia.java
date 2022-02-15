package com.ibm.academia.entregable.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "pasiones")
public class Preferencia implements Serializable {

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
		
		public Preferencia(Integer id, String nombre, String usuarioCreacion) {
			
			this.id = id;
			this.nombre = nombre;
			this.usuarioCreacion = usuarioCreacion;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Preferencia [id=");
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
		public int hashCode() {
			return Objects.hash(nombre);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Preferencia other = (Preferencia) obj;
			return Objects.equals(nombre, other.nombre);
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
		
		private static final long serialVersionUID = 772141231067269066L;

		
}