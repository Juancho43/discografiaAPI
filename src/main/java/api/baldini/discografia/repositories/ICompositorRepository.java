package api.baldini.discografia.repositories;

import api.baldini.discografia.model.Compositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompositorRepository extends JpaRepository<Compositor,Long> {

}
