package mx.utng.lmtc.model.dao;

import java.util.List;

import mx.utng.lmtc.model.entity.ListaDeseosMascota;

public interface IListaDeseosMascotaDao {
    List<ListaDeseosMascota> list();
    void save(ListaDeseosMascota listaDeseosMascota);
    ListaDeseosMascota getById(Long id);
    void delete(Long id);
}
