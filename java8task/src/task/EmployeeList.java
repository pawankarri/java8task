package task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeList {
	public static void main(String[] args) {
	List<Employee> emplist = new ArrayList<Employee>();
emplist.add(new Employee(963,"pawan",24,"male","it",2015,20000.0));
emplist.add(new Employee(125,"venkat",26,"male","bpm",2017,13500.0));
emplist.add(new Employee(69,"devi",35,"female","hr",2016,25000.0));
emplist.add(new Employee(52,"prasad",32,"male","finance",2012,12000.0));
emplist.add(new Employee(112,"nagendra",30,"male","marketing",2013,26000.0));
emplist.add(new Employee(152,"monica",42,"female","developer",2012,120000.0));
emplist.add(new Employee(63,"swamy",27,"male","hr",2018,16500.0));
emplist.add(new Employee(562,"mizan",25,"male","civil",2019,10000.0));
emplist.add(new Employee(312,"laxmi",19,"female","auditor",2021,28000.0));
emplist.add(new Employee(256,"manikanta",26,"male","airforce",2021,5000.0));
emplist.add(new Employee(452,"mahesh",54,"male","it",2006,150000.0));
emplist.add(new Employee(707,"pooja",36,"female","manager",2002,250000.0));
emplist.add(new Employee(23,"nagaraju",56,"male","auditor",2002,120000.0));
emplist.add(new Employee(452,"anpuma",27,"female","bpm",2016,20000.0));
emplist.add(new Employee(361,"nikitha",22,"female","finance",2022,16000.0));

System.out.print("TOTAL NO OF EMPLOYEES : ");
long totalnoofemployees = emplist.stream().collect(Collectors.counting());
System.out.println(totalnoofemployees);




Map<String, Long> noOfMaleAndFemaleEmployees=
emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
         System.out.print("NO.OF FEMALE AND MALE EMPLOYEES = " );
System.out.println(noOfMaleAndFemaleEmployees);
System.out.println();


System.out.println("DEPARTMENTS PRESENT IN THE COMPANY:");
System.out.println("==================================");
System.out.println();
emplist.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);


Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
System.out.println("AVERAGE AGE OF FEMALE AND MALE : ");
System.out.println(avgAgeOfMaleAndFemaleEmployees);
System.out.println();


Optional<Employee> highestPaidEmployeeWrapper=
emplist.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
  Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();

System.out.println("Details Of Highest Paid Employee : ");
         
System.out.println("==================================");
         
System.out.println("ID : "+highestPaidEmployee.getId());
         
System.out.println("Name : "+highestPaidEmployee.getName());
         
System.out.println("Age : "+highestPaidEmployee.getAge());
         
System.out.println("Gender : "+highestPaidEmployee.getGender());
         
System.out.println("Department : "+highestPaidEmployee.getDepartment());
         
System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
         
System.out.println("Salary : "+highestPaidEmployee.getSalary());

System.out.println("NAME OF THE EMPLOYEES : ");

System.out.println("==================================");

emplist.stream()
.map(Employee::getName)
.forEach(System.out::println);



System.out.println("COUNT OF NUMBER OF EMPLOYEES IN EACH DEPARTMENT : ");
System.out.println("================================");
Map<String, Long> employeeCountByDepartment=
emplist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
         
Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
         
for (Entry<String, Long> entry : entrySet)
{
    System.out.println(entry.getKey()+" : "+entry.getValue());
}




System.out.println("AVERAGE SALARY OF THE EMPLOYEES");
System.out.println("==============================");
Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=
emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
         
System.out.println(avgSalaryOfMaleAndFemaleEmployees);

	}

}
