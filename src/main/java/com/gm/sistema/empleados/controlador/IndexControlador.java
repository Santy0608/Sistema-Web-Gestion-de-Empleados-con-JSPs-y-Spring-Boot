package com.gm.sistema.empleados.controlador;

import com.gm.sistema.empleados.domain.Empleado;
import com.gm.sistema.empleados.servicio.EmpleadoServicio;
import com.gm.sistema.empleados.servicio.IEmpleadoServicio;
import jakarta.persistence.Index;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; //agregar.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        System.out.println("Empleado a agregar " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/"; //Redirige al path "/"
    }

    @GetMapping("/editar")
    public String mostrarEditar(@RequestParam("id") int id, Model model){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        model.addAttribute("empleadoForma", empleado);
        return "editar";
    }

    @PutMapping("/editar")
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        System.out.println("Empleado a editar: " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/"; //Redirige al path "/"
    }

}
