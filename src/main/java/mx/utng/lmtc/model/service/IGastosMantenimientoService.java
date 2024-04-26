package mx.utng.lmtc.model.service;

import mx.utng.lmtc.model.entity.GastosMantenimiento;
import java.util.List;

public interface IGastosMantenimientoService {
    List<GastosMantenimiento> list();
    void save(GastosMantenimiento gastosMantenimiento);
    GastosMantenimiento getById(Long id);
    void delete(Long id);
}
