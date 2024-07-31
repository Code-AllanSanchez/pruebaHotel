package hn.unah.lenguajes.hotel.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;
import hn.unah.lenguajes.hotel.servicios.TipoHabitacionServicio;




@RestController
@RequestMapping("/api/tipohabitacion")
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionServicio tipoHabitacionServicio;

    @GetMapping("/obtener/todos")
    public List<TipoHabitacion> obtenerTodos() {
        return this.tipoHabitacionServicio.obtenerTiposHabitacion();
    }

    @PostMapping("/crear/nuevo")
    public TipoHabitacion crearNuevo(@RequestParam String descripcion, @RequestParam Double valorAdicional) {
        
        return this.tipoHabitacionServicio.nuevaHabitacion(descripcion, valorAdicional);
    }

    @GetMapping("/obtener/{id}")
    public TipoHabitacion obtenerPorId(@PathVariable long id) {
        return this.tipoHabitacionServicio.buscarPorId(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable(name="id") long id){
        return this.tipoHabitacionServicio.eliminarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public TipoHabitacion putMethodName(@PathVariable(name="id") long id, @RequestBody TipoHabitacion tipoHabitacion) {
                
        return this.tipoHabitacionServicio.actualizarPorId(id, tipoHabitacion);
    }

    @GetMapping("/obtenerPorDescripcion")
    public List<TipoHabitacion> obtenerPorDescripcion(@RequestParam String descripcion) {
        return this.tipoHabitacionServicio.obtenerPorDescripcion(descripcion);
    }
    
 

}
