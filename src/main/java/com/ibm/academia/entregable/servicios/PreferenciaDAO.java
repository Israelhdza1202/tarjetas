package com.ibm.academia.entregable.servicios;

import com.ibm.academia.entregable.modelo.entidades.Preferencia;
import com.ibm.academia.entregable.modelo.entidades.Tarjeta;

import java.util.Optional;

public interface PreferenciaDAO extends GenericoDAO<Preferencia>{

    public Optional<Preferencia> buscarPorId(Integer id);
    public Iterable<Preferencia> buscarPreferenciaPorNombre(String nombre);
}
