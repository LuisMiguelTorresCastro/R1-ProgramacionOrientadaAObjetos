package mx.utng.lmtc.model.service;

import mx.utng.lmtc.model.entity.ConsumoVideoStreaming;
import java.util.List;

public interface IConsumoVideoStreamingService {
    List<ConsumoVideoStreaming> list();
    void save(ConsumoVideoStreaming consumoVideoStreaming);
    ConsumoVideoStreaming getById(Long id);
    void delete(Long id);
}
