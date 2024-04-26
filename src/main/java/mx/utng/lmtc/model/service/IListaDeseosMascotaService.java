package mx.utng.lmtc.model.service;

import mx.utng.lmtc.model.entity.ListaDeseosMascota;
import java.util.List;

public interface IListaDeseosMascotaService {
    List<ListaDeseosMascota> list();
    void save(ListaDeseosMascota listaDeseosMascota);
    ListaDeseosMascota getById(Long id);
    void delete(Long id);
}
