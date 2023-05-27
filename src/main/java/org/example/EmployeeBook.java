import java.util.HashMap;
import java.util.Map;
public class EmployeeBook implements EmployeeService {
    private final Map<String, Employee> employees;
    public EmployeeBook() {
        this.employees = new HashMap<>();
    }

    @Override
    public void addEmployee(Employee employee) {
    }
        employees.put(employee.getFullName(), employee);
}

/**
 *   * Удаляет сотрудника по ФИО
 *      *
 *      * @param fullName String
 *      */
 @Override
 public void removeEmployee(String fullName){

        if (employees.containsKey(fullName)) {
        employees.remove(fullName);
        System.out.printf("Сотрудник %s успешно удален!%n", fullName);
        } else {
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
 }
    @Override
    public void removeEmployee(int id) {
        for (Employee employee : employees.values()) {
            if (employee.getId() == id) {
                String key = employee.getFullName();
                employees.remove(key);
                System.out.printf("Сотрудник %s (id: %d) успешно удален!%n", key, id);
                return;
            }
        }
        System.out.printf("Сотрудник с id %d не найден!%n", id);
    }

    public void setSalaryByName(String fullName, int newSalary) {
        Employee foundEmployee = findEmployeeByFullName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setSalary(newSalary);
            System.out.printf("Зарплата сотрудника %s изменена. Новая зарплата: %d руб.%n", fullName, newSalary);
        } else {
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
    }
    public void setDepartmentByName(String fullName, int newDepartment) {
        Employee foundEmployee = findEmployeeByFullName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setDepartment(newDepartment);
            System.out.printf("Отдел сотрудника %s изменён. Новый отдел: %d%n", fullName, newDepartment);
        } else {
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
    }

    private Employee findEmployeeByFullName(String fullName) {
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        return null;
    }  private Map<String, Employee> getEmployeesByDepartment(int department) {
    Map<String, Employee> employeesDepartment = new HashMap<>();
    for (Employee employee : employees.values()) {
        if (employee.getDepartment() == department) {
            employeesDepartment.put(employee.getFullName(), employee);
        }
    }
    return employeesDepartment;
}
    public void printAllEmployeesData() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }
    public int calcTotalMonthlySalary() {
        int total = 0;
        for (Employee employee : employees.values()) {
            total += employee.getSalary();
        }
        return total;
    }

    public int calcTotalMonthlySalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        int total = 0;
        for (Employee employee : departmentEmployees.values()) {
            if (employee != null) {
                System.out.println(employee.getFullName() + " | " + employee.getSalary());
                total += employee.getSalary();
            }
        }
        return total;
    }
    public Employee getEmployeeWithMinSalary() {
        return getEmployeeWithMinSalary(employees);
    }
    public Employee getEmployeeWithMinSalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        return getEmployeeWithMinSalary(departmentEmployees);
    }
    private Employee getEmployeeWithMinSalary(Map<String, Employee> employees) {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : employees.values()) {
            if (emp.getSalary() < min) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public Employee getEmployeeWithMaxSalary() {
        return getEmployeeWithMaxSalary(employees);
    }
    public Employee getEmployeeWithMaxSalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        return getEmployeeWithMaxSalary(departmentEmployees);
    }
    private Employee getEmployeeWithMaxSalary(Map<String, Employee> employees) {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : employees.values()) {
            if (emp.getSalary() > max) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public double calcAverageMonthlySalary() {
        return (double) calcTotalMonthlySalary() / getSize();
    }

    public double calcAverageMonthlySalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        return (double) calcTotalMonthlySalary(department) / departmentEmployees.size();
    }
    public void changeEmployeesSalary(int percent) {
        double coefficient = 1 + percent / 100D;
        for (Employee employee : employees.values()) {
            employee.setSalary((int) (employee.getSalary() * coefficient));
        }
        public void changeEmployeesSalary(int percent, int department) {
            Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
            for (Employee employee : departmentEmployees.values()) {
                int salary = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary(salary);
            }
            public void printEmployeesWithSalaryHigherThanBenchmark(int benchmark) {
                for (Employee employee : employees.values()) {
                    if (employee.getSalary() >= benchmark) {
                        System.out.println(employee);
                    }
                }
            }
            public void printEmployeesWithSalaryLowerThanBenchmark(int benchmark) {
                for (Employee employee : employees.values()) {
                    if (employee.getSalary() < benchmark) {
                        System.out.println(employee);
                    }
                }
            }
            employees.put(employee.getFullName(), employee);
        }
        @Override
        public void removeEmployee(String fullName) {
            if (employees.containsKey(fullName)) {
                employees.remove(fullName);
                System.out.printf("Сотрудник %s успешно удален!%n", fullName);
            } else {
        }
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
    }
    @Override
    public void removeEmployee(int id) {
        for (Employee employee : employees.values()) {
            if (employee.getId() == id) {
                String key = employee.getFullName();
                employees.remove(key);
                System.out.printf("Сотрудник %s (id: %d) успешно удален!%n", key, id);
                return;
            }
        }
        System.out.printf("Сотрудник с id %d не найден!%n", id);
    }

    public void setSalaryByName(String fullName, int newSalary) {
        Employee foundEmployee = findEmployeeByFullName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setSalary(newSalary);
            System.out.printf("Зарплата сотрудника %s изменена. Новая зарплата: %d руб.%n", fullName, newSalary);
        } else {
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
    }
    public void setDepartmentByName(String fullName, int newDepartment) {
        Employee foundEmployee = findEmployeeByFullName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setDepartment(newDepartment);
            System.out.printf("Отдел сотрудника %s изменён. Новый отдел: %d%n", fullName, newDepartment);
        } else {
            System.out.printf("Сотрудник %s не найден!%n", fullName);
        }
    }
    private Employee findEmployeeByFullName(String fullName) {
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        return null;
    }
    private Map<String, Employee> getEmployeesByDepartment(int department) {
        Map<String, Employee> employeesDepartment = new HashMap<>();
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                employeesDepartment.put(employee.getFullName(), employee);
            }
        }
        return employeesDepartment;
    }
    public void printAllEmployeesData() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }
    public int calcTotalMonthlySalary() {
        int total = 0;
        for (Employee employee : employees.values()) {
            total += employee.getSalary();
        }
        return total;
    }
    public int calcTotalMonthlySalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        int total = 0;
        for (Employee employee : departmentEmployees.values()) {
            if (employee != null) {
                System.out.println(employee.getFullName() + " | " + employee.getSalary());
                total += employee.getSalary();
            }
        }
        return total;
    }
            }
public Employee getEmployeeWithMinSalary() {
        return getEmployeeWithMinSalary(employees);
        }
private Employee getEmployeeWithMinSalary(Map<String, Employee> employees) {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : employees.values()) {
        if (emp.getSalary() < min) {
        min = emp.getSalary();
        employee = emp;
        }
        }
        return employee;
        }
public Employee getEmployeeWithMaxSalary() {
        return getEmployeeWithMaxSalary(employees);
        }
public Employee getEmployeeWithMaxSalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        return getEmployeeWithMaxSalary(departmentEmployees);
        }
private Employee getEmployeeWithMaxSalary(Map<String, Employee> employees) {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : employees.values()) {
        if (emp.getSalary() > max) {
        max = emp.getSalary();
        employee = emp;
        }
        }
        return employee;
        }
public double calcAverageMonthlySalary() {
        return (double) calcTotalMonthlySalary() / getSize();
        }

public double calcAverageMonthlySalary(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        return (double) calcTotalMonthlySalary(department) / departmentEmployees.size();
        }
public void changeEmployeesSalary(int percent) {
        double coefficient = 1 + percent / 100D;
        for (Employee employee : employees.values()) {
        employee.setSalary((int) (employee.getSalary() * coefficient));
        }
public void changeEmployeesSalary(int percent, int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees.values()) {
        int salary = employee.getSalary() + employee.getSalary() * percent / 100;
        employee.setSalary(salary);
        }
        }
public void printEmployeesWithSalaryHigherThanBenchmark(int benchmark) {
        for (Employee employee : employees.values()) {
        if (employee.getSalary() >= benchmark) {
        System.out.println(employee);
        }
        }
        }
public void printEmployeesWithSalaryLowerThanBenchmark(int benchmark) {
        for (Employee employee : employees.values()) {
        if (employee.getSalary() < benchmark) {
        System.out.println(employee);
        }
        }
        }
public void printAllEmployeesDataGroupedByDepartment() {
        for (int i = 1; i <= 5; i++) {
        System.out.println("Отдел " + i);
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(i);
        if (departmentEmployees.size() > 0) {
        for (Employee employee : departmentEmployees.values()) {
        System.out.println(employee.getFullName());
        }
        } else {
        System.out.println("В отделе нет сотрудников");
        }
        }
        }

public void printEmployeesFullNames() {
        for (Employee employee : employees.values()) {
        System.out.println(employee.getFullName());
        }
        }

/**
 * Выводит на экран данные сотрудников одного отдела
 *
 * @param department int
 */
public void printDepartmentEmployeesData(int department) {
        Map<String, Employee> departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees.values()) {
        System.out.println(employee.getEmployeeData());
        }
        }

public int getSize() {
        return employees.size();
        }
        }

