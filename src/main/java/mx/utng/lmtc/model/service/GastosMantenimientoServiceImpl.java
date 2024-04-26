package mx.utng.lmtc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmtc.model.dao.IGastosMantenimientoDao;
import mx.utng.lmtc.model.entity.GastosMantenimiento;

@Service
public class GastosMantenimientoServiceImpl implements IGastosMantenimientoService{

    @Autowired
    private IGastosMantenimientoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<GastosMantenimiento> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(GastosMantenimiento gastosMantenimiento) {
        dao.save(gastosMantenimiento);
    }

    @Transactional(readOnly = true)
    @Override
    public GastosMantenimiento getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
