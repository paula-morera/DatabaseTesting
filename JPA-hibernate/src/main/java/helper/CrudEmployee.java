package helper;

import database.EmployeeQuery;
import entities.Employee;

import java.sql.Date;
import java.util.List;

public class CrudEmployee {

    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsEmployee;

     public void addNewEmployee(int idEmployee, String firstName, String lastName, String email,String phoneNumber, String address,
                                double salary, Date birthDate, int idCompany, int idInstitution){
         Boolean result = employeeQuery.addEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,
                 idCompany,idInstitution);

         if(result){
             System.out.println("Employee added successfully");
         }else{
             System.out.println("Employee could not be added");
         }
     }

     public void getAllEmployees(){
         resultsEmployee = employeeQuery.getAllEmployees();
         System.out.println("Getting all employees");
         printInfo(resultsEmployee);
     }

     public void findEmployeeByLastName(String lastName){
         resultsEmployee = employeeQuery.getEmployeeByLastName(lastName);
         System.out.println("Employees with '"+lastName+"' last name");
         printInfo(resultsEmployee);
     }
     public void modifyEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address,
                                double salary, Date birthDate, int idCompany, int idInstitution){
         Boolean result = employeeQuery.modifyEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,
                 idCompany,idInstitution);
         if(result){
             System.out.println("Employee modified successfully");
         }else{
             System.out.println("Employee could not be modified");
         }

     }

    public void removeEmployee(int idEmployee){
        Boolean result = employeeQuery.removeEmployee(idEmployee);
        if(result){
            System.out.println("Employee removed successfully");
        }else{
            System.out.println("Employee could not be removed");
        }

    }

     public void printInfo(List<Employee> resultsEmployee){
        System.out.println("| Id | FirstName | LastName| phoneNumber | address | salary | birthDate | idCompany | idInstitution");
        for(Employee employee: resultsEmployee){
            System.out.print("| "+employee.getIdEmployee()+" | ");
            System.out.print(employee.getFirstName()+" | ");
            System.out.print(employee.getLastName()+" | ");
            System.out.print(employee.getEmail()+" | ");
            System.out.print(employee.getPhoneNumber()+" | ");
            System.out.print(employee.getAddress()+" | ");
            System.out.print(employee.getSalary()+" | ");
            System.out.print(employee.getBirthDate()+" | ");
            System.out.print(employee.getIdCompany()+" | ");
            System.out.println(employee.getIdInstitution()+" | ");
        }
     }

}
