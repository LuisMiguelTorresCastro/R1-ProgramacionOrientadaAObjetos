package mx.utng.lmtc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.lmtc.model.entity.ConsumoVideoStreaming;

@Repository
public class ConsumoVideoStreamingDaoImpl implements IConsumoVideoStreamingDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ConsumoVideoStreaming> list() {
        return em.createQuery("from ConsumoVideoStreaming").getResultList();
    }

    @Override
    public void save(ConsumoVideoStreaming consumoVideoStreaming) {
        System.out.println("ConsumoVideoStreaming id="+consumoVideoStreaming.getId());
        if(consumoVideoStreaming.getId() != null && consumoVideoStreaming.getId() >0){
            em.merge(consumoVideoStreaming);
        }else{
            em.persist(consumoVideoStreaming);
        }
    }

    @Override
    public ConsumoVideoStreaming getById(Long id) {
        return em.find(ConsumoVideoStreaming.class, id);
    }

    @Override
    public void delete(Long id) {
        ConsumoVideoStreaming consumoVideoStreaming = getById(id);
        em.remove(consumoVideoStreaming);
    }

    
}