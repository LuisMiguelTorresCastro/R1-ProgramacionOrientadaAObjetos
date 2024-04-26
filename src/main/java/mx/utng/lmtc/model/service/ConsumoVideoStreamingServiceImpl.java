package mx.utng.lmtc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.lmtc.model.dao.IConsumoVideoStreamingDao;
import mx.utng.lmtc.model.entity.ConsumoVideoStreaming;

@Service
public class ConsumoVideoStreamingServiceImpl implements IConsumoVideoStreamingService{

    @Autowired
    private IConsumoVideoStreamingDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ConsumoVideoStreaming> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ConsumoVideoStreaming consumoVideoStreaming) {
        dao.save(consumoVideoStreaming);
    }

    @Transactional(readOnly = true)
    @Override
    public ConsumoVideoStreaming getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
