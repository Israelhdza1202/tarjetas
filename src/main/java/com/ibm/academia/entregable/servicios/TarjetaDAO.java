package com.ibm.academia.entregable.servicios;

import com.ibm.academia.entregable.modelo.entidades.Edad;
import com.ibm.academia.entregable.modelo.entidades.Tarjeta;

import java.util.Optional;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>{

    public Optional<Tarjeta> buscarPorId(Integer id);
    public Iterable<Tarjeta> buscarTarjetaPorPreferencia(String nombre);
    public Iterable<Tarjeta> buscarTarjetaPorSalario(String salario);
    public Iterable<Tarjeta> buscarTarjetaPorEdad(String edad);
}
