package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Alumno;
import domain.Curso;
import domain.Matricula;
import repository.AlumnoRepository;
import repository.CursoRepository;
import repository.MatriculaRepository;

@RestController
public class AcademicoControlador {
	@Autowired
	AlumnoRepository alumnoRepositorio;

	@Autowired
	CursoRepository cursoRepositorio;

	@Autowired
	MatriculaRepository matriculaRepositorio;
	
	@RequestMapping("/alumnos")
	@ResponseBody
	public List<Alumno> alumnos() {
		return alumnoRepositorio.findAll();
	}

	@RequestMapping(value = "/cursos", method = RequestMethod.POST)
	@ResponseBody
	public Curso guardarCurso(@RequestBody Curso curso) {
		return cursoRepositorio.save(curso);
	}

	//@RequestMapping("/cursos")
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> cursos() {
		return cursoRepositorio.findAll();
	}
	
	@RequestMapping(value = "/buscar_curso_codigo", method = RequestMethod.GET)
	@ResponseBody
	public Curso cursos_por_codigo(String codigo) {
		return cursoRepositorio.Find_For_Codigo(codigo);
	}
	
	@RequestMapping(value = "/buscar_curso_nombre", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> cursos_por_nombre(String nombre) {
		return cursoRepositorio.Find_By_Name(nombre);
	}
	
	@RequestMapping(value = "/buscar_alumno_apellidomaterno", method = RequestMethod.GET)
	@ResponseBody
	public Alumno alumno_por_apellido(String apellido) {
		return alumnoRepositorio.Find_By_Apellido_Materno(apellido);
	}
	
	@RequestMapping(value = "/alumno_por_curso_semestre", method = RequestMethod.GET)
	@ResponseBody
	public void alumno_por_curso_semestre(String curso,String semestre) {
		List<Matricula> lista=matriculaRepositorio.List_By_curso_semestre(curso, semestre);
	}
	
	
}
