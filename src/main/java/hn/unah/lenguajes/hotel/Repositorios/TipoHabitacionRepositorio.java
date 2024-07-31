package hn.unah.lenguajes.hotel.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;

public interface TipoHabitacionRepositorio extends JpaRepository<TipoHabitacion, Long>{
    
    public List<TipoHabitacion> getByDescripcion(String descipcion);

    @Query("select f from tipoHabitacion f where valorAdicional >:precio")
    public List<TipoHabitacion> obtenerPrecioMayor(@Param("precio") int precio);
}
