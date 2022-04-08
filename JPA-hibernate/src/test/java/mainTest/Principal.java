package mainTest;

import helper.CrudEmployee;

import java.sql.Date;

public class Principal {

    protected static CrudEmployee crudEmployee = new CrudEmployee();

    public static void main(String[] args)
    {
        crudEmployee.getAllEmployees();
        crudEmployee.findEmployeeByLastName("Ramirez");
        crudEmployee.addNewEmployee(80,"Paula","Morera","paula.morera","3007290622",
                                    "50 Something st",3569.0, Date.valueOf("2000-08-14"),2,3);
        crudEmployee.modifyEmployee(80,"Paula","Morera","paula.morera","3007290622",
                                 "50 modified st",3569.0, Date.valueOf("2000-08-14"),2,3);
        crudEmployee.removeEmployee(80);
    }
}
