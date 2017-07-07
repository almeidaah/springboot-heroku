package almeida.fernando.bootheroku;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import almeida.fernando.bootheroku.model.Exercicio;
import almeida.fernando.bootheroku.repository.ExercicioRepository;
import almeida.fernando.bootheroku.services.ExercicioService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExercicioServiceTest {

	@Autowired
	private ExercicioService exercicioService;
	
	@Before
	
	public void 
	beforeTests(){
		//exercicioService = Mockito.mock(ExercicioService.class);
		
		System.out.println("Before Testing");
	}
	 
	@Test
	public void
	should_verify_database_have_exercises(){
		List<Exercicio> listEx = exercicioService.findAll();
		assertTrue(listEx.size() > 0); 
	}
	
	@Test
	public void
	should_create_and_save_an_exercise(){
		Exercicio e = new Exercicio();
		e.setNome("Supino");
		e.setNivel("I");
		e.setDescricao("myDescription"); 
		
		exercicioService.insert(e);
		
		assertTrue(!StringUtils.isEmpty(e.getId())); 
	}
	
	
}
