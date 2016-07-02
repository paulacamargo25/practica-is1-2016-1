package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Matricula;
import domain.Alumno;
import domain.Curso;;



public interface MatriculaRepository extends CrudRepository<Matricula, Integer>{
	void matricular(Alumno alumno, Curso curso, String semestre);
	
	@Query("SELECT c FROM Matricula AS c WHERE curso=:curso and semestre=:semestre")
	List<Matricula> List_By_curso_semestre(String curso,String semestre);
	
	
}
