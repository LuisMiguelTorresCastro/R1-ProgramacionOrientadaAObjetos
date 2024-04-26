package mx.utng.lmtc.model.dao;

import java.util.List;

import mx.utng.lmtc.model.entity.GastosMantenimiento;

public interface IGastosMantenimientoDao {
    List<GastosMantenimiento> list();
    void save(GastosMantenimiento gastosMantenimiento);
    GastosMantenimiento getById(Long id);
    void delete(Long id);
}
