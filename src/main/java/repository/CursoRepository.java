package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Alumno;
import domain.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer>{
	List<Curso> findAll();
	
	@Query("SELECT c FROM Curso AS c WHERE codigo = :codigo")
	Curso Find_For_Codigo(String codigo);
	
	@Query("SELECT c FROM Curso AS c WHERE nombre like ':nombre%'")
	List<Curso> Find_By_Name(String nombre);
	
}
