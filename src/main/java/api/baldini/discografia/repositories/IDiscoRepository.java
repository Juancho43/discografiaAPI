package api.baldini.discografia.repositories;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscoRepository extends JpaRepository<Disco,Long> {

}
