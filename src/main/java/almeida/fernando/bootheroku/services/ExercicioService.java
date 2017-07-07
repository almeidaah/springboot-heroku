package almeida.fernando.bootheroku.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almeida.fernando.bootheroku.model.Exercicio;
import almeida.fernando.bootheroku.repository.ExercicioRepository;

@Service
public class ExercicioService {

	@Autowired
	private ExercicioRepository exercicioRepository;

	public List<Exercicio> findAll() {
		return exercicioRepository.findAll();
	}

	@Transactional
	public Exercicio findOne(String id) {
		return exercicioRepository.findOne(id);
	}

	@Transactional
	public void delete(String id) {
		exercicioRepository.delete(id);
	}

	@Transactional
	public Exercicio insert(Exercicio exercicio) {
		
		if(org.springframework.util.StringUtils.isEmpty(exercicio.getId())){
			return exercicioRepository.insert(exercicio);
		}

		return exercicioRepository.save(exercicio);
	}

}
