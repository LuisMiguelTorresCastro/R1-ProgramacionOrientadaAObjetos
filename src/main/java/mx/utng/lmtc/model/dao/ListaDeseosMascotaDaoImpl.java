package mx.utng.lmtc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmtc.model.entity.ListaDeseosMascota;

@Repository
public class ListaDeseosMascotaDaoImpl implements IListaDeseosMascotaDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ListaDeseosMascota> list() {
        return em.createQuery("from ListaDeseosMascota").getResultList();
    }

    @Override
    public void save(ListaDeseosMascota listaDeseosMascota) {
        System.out.println("ListaDeseosMascota id="+listaDeseosMascota.getId());
        if(listaDeseosMascota.getId() != null && listaDeseosMascota.getId() >0){
            em.merge(listaDeseosMascota);
        }else{
            em.persist(listaDeseosMascota);
        }
    }

    @Override
    public ListaDeseosMascota getById(Long id) {
        return em.find(ListaDeseosMascota.class, id);
    }

    @Override
    public void delete(Long id) {
        ListaDeseosMascota listaDeseosMascota = getById(id);
        em.remove(listaDeseosMascota);
    }

    
}