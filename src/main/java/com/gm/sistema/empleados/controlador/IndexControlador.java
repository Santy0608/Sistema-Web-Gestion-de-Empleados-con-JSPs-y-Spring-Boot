package com.gm.sistema.empleados.controlador;

import com.gm.sistema.empleados.domain.Empleado;
import com.gm.sistema.empleados.servicio.EmpleadoServicio;
import com.gm.sistema.empleados.servicio.IEmpleadoServicio;
import jakarta.persistence.Index;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexControlador {

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> System.out.println(empleado.toString())));
        //Compartimos modelo con la vista
        modelo.put("empleados", empleados);
        return "index";//index.jsp
    }






}
