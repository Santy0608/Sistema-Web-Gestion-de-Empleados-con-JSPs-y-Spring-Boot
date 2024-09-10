package com.gm.sistema.empleados.servicio;

import com.gm.sistema.empleados.domain.Empleado;
import com.gm.sistema.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
    @Autowired
    EmpleadoRepositorio empleadoRepositorio;


    @Override
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = empleadoRepositorio.findAll();
        return empleados;
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }

    @Override
    public void eliminarPorId(Integer id) {
        empleadoRepositorio.deleteById(id);
    }
}
