package com.uce.edu.repository;

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
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciud = this.seleccionar(id);
		this.entityManager.remove(ciud);
	}

	@Override
	public Empleado seleccionarporCedula(String cedula) {
		// TODO Auto-generated method stub
		//1)SELECT p FROM Padre p(SQL)
		//2)SELECT p FROM Padre p, Hijo h Where l0.....
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano selecionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula =:cedula",Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}


	@Override
	public Ciudadano selecionarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_genero =:genero",Ciudadano.class);
		myQuery.setParameter("genero", genero);
		return (Ciudadano) myQuery.getSingleResult();
	}
	
	
	@Override
	public Ciudadano selecionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		//SELECT c FROM Ciudadano c WHERE c.apellido = :variable --->SQL normal
		//0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		//1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		
		//2.-Construir el SQL 
		//2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		//Nota: no necesariamnete el from es igual al tipo de retorno
		//SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato 
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);//FROM Ciudadano
		
		//2.2 Construir las condiciones (WHERE) del SQL
		//En criteria API Query las condiciones se las conoce como "Predicate" en español como Predicado
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido); //el primero pertenece a que atributo se le aplica la condición este caso apellido pero es el atributo que corresponde a la clase que llamamos en el Root, que luego se compara con otro valor que es el que se recibe por parámetro
		
		//3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		
		//4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano selecionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		//1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		
		//2.-Construir el SQL 
		//2.1 Determinamos el FROM
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		
		//2.2 Construir las condiciones (WHERE)
		
		Predicate condicionGenerica = null;
				
		if(cedula.startsWith("17")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		}else if(cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		}else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		}
							
		//3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		
		//4.Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano selecionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
				
		//1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
				
		//2.-Construir el SQL 
		//2.1 Determinamos el FROM
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
				
		//2.2 Construir las condiciones (WHERE)
				
		Predicate condicionTotal = null;
		
		//c.nombre = :nombre
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		
		//c.apellido = :apellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
						
		if(cedula.startsWith("17")) {
			//c.nombre = :nombre or c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);
		}else if(cedula.startsWith("05")) {
			//c.nombre = :nombre and c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionApellido);
		}
									
		//3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);
				
		//4.Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}
}
