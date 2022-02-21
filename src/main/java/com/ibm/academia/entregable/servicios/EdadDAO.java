package com.ibm.academia.entregable.servicios;

import com.ibm.academia.entregable.modelo.entidades.Edad;
import com.ibm.academia.entregable.modelo.entidades.Tarjeta;

import java.util.Optional;

public interface EdadDAO extends GenericoDAO<Edad>
{
        public Optional<Edad> buscarPorId(Integer id);
        public Iterable<Edad> buscarEdadPorPreferencia(String nombre);
        public Iterable<Edad> buscarEdadPorSalario(String salario);

}
