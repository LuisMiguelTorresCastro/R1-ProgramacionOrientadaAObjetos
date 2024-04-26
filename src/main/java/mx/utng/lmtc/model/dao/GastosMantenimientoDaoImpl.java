package mx.utng.lmtc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmtc.model.entity.GastosMantenimiento;

@Repository
public class GastosMantenimientoDaoImpl implements IGastosMantenimientoDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<GastosMantenimiento> list() {
        return em.createQuery("from GastosMantenimiento").getResultList();
    }

    @Override
    public void save(GastosMantenimiento gastosMantenimiento) {
        System.out.println("GastosMantenimiento id="+gastosMantenimiento.getId());
        if(gastosMantenimiento.getId() != null && gastosMantenimiento.getId() >0){
            em.merge(gastosMantenimiento);
        }else{
            em.persist(gastosMantenimiento);
        }
    }

    @Override
    public GastosMantenimiento getById(Long id) {
        return em.find(GastosMantenimiento.class, id);
    }

    @Override
    public void delete(Long id) {
        GastosMantenimiento gastosMantenimiento = getById(id);
        em.remove(gastosMantenimiento);
    }

    
}