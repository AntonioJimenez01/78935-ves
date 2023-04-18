package uv.mx.Perreria;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface iPerro extends CrudRepository<Perro,Integer> {
    void deleteById(Integer bigInteger);

    Optional<Perro> findById(Integer id);
}
