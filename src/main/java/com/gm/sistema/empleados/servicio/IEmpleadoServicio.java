package com.gm.sistema.empleados.servicio;

import com.gm.sistema.empleados.domain.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Integer id);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);

    public void eliminarPorId(Integer id);
}
