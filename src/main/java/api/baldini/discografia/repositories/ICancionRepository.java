package api.baldini.discografia.repositories;

import api.baldini.discografia.model.Cancion;
import api.baldini.discografia.model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICancionRepository extends JpaRepository<Cancion,Long> {

}
