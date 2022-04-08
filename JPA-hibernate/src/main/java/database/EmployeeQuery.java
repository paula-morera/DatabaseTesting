package database;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class EmployeeQuery {

    EntityManager entityManager;
    Employee employee;

    public EmployeeQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Employee> getAllEmployees(){
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public List<Employee> getEmployeeByLastName(String lastName){
        Query query = entityManager.createQuery("select e from Employee e where e.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public Boolean addEmployee(int idEmployee, String firstName, String lastName, String email,String phoneNumber, String address,
                               double salary, Date birthDate, int idCompany, int idInstitution){
        employee = new Employee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,idCompany,idInstitution);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return entityManager.contains(employee);
    }

    public Boolean modifyEmployee(int idEmployee, String firstName, String lastName,String email, String phoneNumber, String address,
                                  double salary, Date birthDate, int idCompany, int idInstitution){

        employee = new Employee();
        employee = entityManager.find(Employee.class, idEmployee);
        if(employee != null){
            employee.setIdEmployee(idEmployee);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setAddress(address);
            employee.setSalary(salary);
            employee.setBirthDate(birthDate);
            employee.setIdCompany(idCompany);
            employee.setIdInstitution(idInstitution);

            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();

            return entityManager.contains(employee);
        }
        return false;
    }

    public Boolean removeEmployee(int idEmployee){
        employee = new Employee();
        employee = entityManager.find(Employee.class,idEmployee);
        if (employee != null){
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();

            return !entityManager.contains(employee);
        }
        return false;
    }
}
