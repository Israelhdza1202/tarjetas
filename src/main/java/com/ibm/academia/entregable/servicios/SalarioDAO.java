package com.ibm.academia.entregable.servicios;

import com.ibm.academia.entregable.modelo.entidades.Salario;
import com.ibm.academia.entregable.modelo.entidades.Tarjeta;

import java.util.Optional;

public interface SalarioDAO extends GenericoDAO<Salario>{

    public Optional<Salario> buscarPorId(Integer id);
    public Iterable<Salario> buscarSalarioPorPreferencia(String nombre);
}
