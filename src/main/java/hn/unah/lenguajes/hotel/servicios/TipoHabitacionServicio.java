package hn.unah.lenguajes.hotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.hotel.Repositorios.TipoHabitacionRepositorio;
import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;

@Service
public class TipoHabitacionServicio {

    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    public List<TipoHabitacion> obtenerTiposHabitacion(){
        return tipoHabitacionRepositorio.findAll();
        
    }

    public TipoHabitacion nuevaHabitacion(String descripcion, Double valorAdicional){
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setDescripcion(descripcion);
        tipoHabitacion.setValorAdicional(valorAdicional);
        return this.tipoHabitacionRepositorio.save(tipoHabitacion);
    }

    public TipoHabitacion buscarPorId(long id){
        return this.tipoHabitacionRepositorio.findById(id).get();
    }

    public String eliminarPorId(long id){
        if (this.tipoHabitacionRepositorio.existsById(id)){
            this.tipoHabitacionRepositorio.deleteById(id);
            return "Se ha eliminado el registro";
        }
        return "No existe el registro";
    }

    public TipoHabitacion actualizarPorId(long id, TipoHabitacion tipoHabitacion){
        if(this.tipoHabitacionRepositorio.existsById(id)){
            TipoHabitacion tipoHabitacionActualizar = this.tipoHabitacionRepositorio.findById(id).get();
            tipoHabitacionActualizar.setDescripcion(tipoHabitacion.getDescripcion());
            tipoHabitacionActualizar.setValorAdicional(tipoHabitacion.getValorAdicional());
            this.tipoHabitacionRepositorio.save(tipoHabitacionActualizar);
            return tipoHabitacionActualizar;
        }    
        return null;
    }

    public List<TipoHabitacion> obtenerPorDescripcion(String descripcion){
        return this.tipoHabitacionRepositorio.getByDescripcion(descripcion);
    }

}
