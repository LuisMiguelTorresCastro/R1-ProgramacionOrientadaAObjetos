package mx.utng.lmtc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmtc.model.dao.IListaDeseosMascotaDao;
import mx.utng.lmtc.model.entity.ListaDeseosMascota;

@Service
public class ListaDeseosMascotaServiceImpl implements IListaDeseosMascotaService{

    @Autowired
    private IListaDeseosMascotaDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseosMascota> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseosMascota listaDeseosMascota) {
        dao.save(listaDeseosMascota);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseosMascota getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
