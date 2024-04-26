package mx.utng.lmtc.model.dao;

import java.util.List;

import mx.utng.lmtc.model.entity.ConsumoVideoStreaming;

public interface IConsumoVideoStreamingDao {
    List<ConsumoVideoStreaming> list();
    void save(ConsumoVideoStreaming consumoVideoStreaming);
    ConsumoVideoStreaming getById(Long id);
    void delete(Long id);
}
