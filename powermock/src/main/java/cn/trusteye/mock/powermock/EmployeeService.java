package cn.trusteye.mock.powermock;

/**
 * @author rayman
 * @date 16:29
 */
public class EmployeeService {
    public void saveOrUpdate(Employee employee){
        final EmployeeDao employeeDao = new EmployeeDao();
        long count = employeeDao.getCount(employee);
        if(count > 0){
            employeeDao.updateEmployee(employee);
        }else {
            employeeDao.saveEmployee(employee);
        }
    }
}
