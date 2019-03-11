package cn.trusteye.mock.powermock.verify;

import cn.trusteye.mock.powermock.Employee;
import cn.trusteye.mock.powermock.EmployeeDao;
import cn.trusteye.mock.powermock.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testSaveOrUpdateCountLessZero(){
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class)
                    .withNoArguments()
                    .thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(employee);

            Mockito.verify(employeeDao).saveEmployee(employee);
            Mockito.verify(employeeDao,Mockito.never()).updateEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountMoreThanZero() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments()
                    .thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(1L);
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(employee);
            Mockito.verify(employeeDao).updateEmployee(employee);
            Mockito.verify(employeeDao,
                    Mockito.never()).saveEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}