package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Alumno implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Alumno_ID_GENERATOR", sequenceName = "Alumno_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alumno_ID_GENERATOR")
	private long id;
	
	private String dni;
	private String nombres;
	
	private String apellidoPaterno;

	
	private String apellidoMaterno;

	@ManyToMany
	@JoinTable(name = "Alumno_curso",
		joinColumns = @JoinColumn(name = "Alumno_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "Curso_id", referencedColumnName = "id"))
	private List<Curso> desaprobados;
	
	public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String dni){
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.dni = dni;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
