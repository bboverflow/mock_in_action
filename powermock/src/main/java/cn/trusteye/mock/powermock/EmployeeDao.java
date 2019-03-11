package cn.trusteye.mock.powermock;

/**
 * @author rayman
 * @date 16:18
 */
public class EmployeeDao {
    public void saveEmployee(Employee employee){
        throw new UnsupportedOperationException();
    }

    public void updateEmployee(Employee employee){
        throw new UnsupportedOperationException();
    }

    public long getCount(Employee employee){
        throw new UnsupportedOperationException();
    }
}
