package com.uce.edu.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empl = this.seleccionar(id);
		this.entityManager.remove(empl);
	}

	@Override
	public Empleado selecionarPorPuesto(String puesto) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM empleado e WHERE e.empl_puesto =:puesto",
				Empleado.class);
		myQuery.setParameter("puesto", puesto);
		return (Empleado) myQuery.getSingleResult();
	}

	@Override
	public Empleado seleccionarPorSalario(String puesto, BigDecimal salario) {
		// TODO Auto-generated method stub
		// 0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Empleado> myCriteriaQuery = myCriteriaBuilder.createQuery(Empleado.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos el FROM
		Root<Empleado> myFrom = myCriteriaQuery.from(Empleado.class);

		// 2.2 Construir las condiciones (WHERE)

		Predicate condicionGenerica = null;

		if (salario.equals(new BigDecimal(1500))) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("puesto"), puesto);
		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("salario"), salario);
		}

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		// 4.Ejecutamos la consulta con un TypedQuery
		TypedQuery<Empleado> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
