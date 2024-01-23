package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;
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
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habi = this.seleccionar(id);
		this.entityManager.remove(habi);
	}

	@Override
	public Habitacion seleccionarPorClase(String clase) {
		// TODO Auto-generated method stub
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Habitacion> myCriteriaQuery = myCriteriaBuilder.createQuery(Habitacion.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);// FROM Habitacion

		// 2.2 Construir las condiciones (WHERE) del SQL
		// En criteria API Query las condiciones se las conoce como "Predicate" en
		// español como Predicado
		Predicate condicionClase = myCriteriaBuilder.equal(myFrom.get("clase"), clase);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionClase);

		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
