package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import domain.Alumno;
import domain.Curso;
import domain.Matricula;

public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{
	List<Alumno> findAll();
	@Query("SELECT c FROM Alumno AS c WHERE apellidoMaterno= ':apellido'")
	Alumno Find_By_Apellido_Materno(String apellido);
	
}
