package com.gm.sistema.empleados.repositorio;

import com.gm.sistema.empleados.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
