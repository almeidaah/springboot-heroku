package almeida.fernando.bootheroku.repository
;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import almeida.fernando.bootheroku.model.Exercicio;

@Repository
public interface ExercicioRepository extends MongoRepository<Exercicio, String>{

}
