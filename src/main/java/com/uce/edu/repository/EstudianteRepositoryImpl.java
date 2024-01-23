package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu = this.seleccionar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e Where e.apellido = :apellido", Estudiante.class);
		myQuery.setParameter("apellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante selecionarPorCriteria(String nombre, String apellido, Integer edad) {
		// TODO Auto-generated method stub
		// 0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Estudiante> myCriteriaQuery = myCriteriaBuilder.createQuery(Estudiante.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos el FROM
		Root<Estudiante> myFrom = myCriteriaQuery.from(Estudiante.class);

		// 2.2 Construir las condiciones (WHERE)

		Predicate condicionGenerica = null;

		if (edad.equals(15)) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} else if (edad.equals(17)) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("edad"), edad);
		}

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		// 4.Ejecutamos la consulta con un TypedQuery
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public Estudiante selecionarPorCriteriaAndOr(String nombre, String apellido, String grado, Integer edad) {
		// TODO Auto-generated method stub
		// 0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Estudiante> myCriteriaQuery = myCriteriaBuilder.createQuery(Estudiante.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos el FROM
		Root<Estudiante> myFrom = myCriteriaQuery.from(Estudiante.class);

		// 2.2 Construir las condiciones (WHERE)

		Predicate condicionTotal = null;

		// c.nombre = :nombre
		Predicate condicionEdad = myCriteriaBuilder.equal(myFrom.get("edad"), edad);

		// c.apellido = :apellido
		Predicate condicionGrado = myCriteriaBuilder.equal(myFrom.get("grado"), grado);

		if (grado.startsWith("deci")) {
			// c.nombre = :nombre or c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.or(condicionEdad, condicionGrado);
		} else if (grado.startsWith("ter")) {
			// c.nombre = :nombre and c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.and(condicionEdad, condicionGrado);
		}

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);

		// 4.Ejecutamos la consulta con un TypedQuery
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
