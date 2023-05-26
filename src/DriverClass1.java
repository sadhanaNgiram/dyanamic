import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import CommonFunctionsPackage1.Utility_CommonFunction;

public class DriverClass1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ArrayList<String>testcaserun=Utility_CommonFunction.readDataExcel("postrunner","testcasetoexecute");
		int count =testcaserun.size();
		System.out.println("count of tc:"+count);
		for (int i=1;i<count;i++)
		{
		String testcasename=testcaserun.get(i);
		System.out.println("test case name :"+testcasename);
		
		// call the testcaseclass on runtime by using java.lang.reflect package
		Class<?> testclassname= Class.forName("TestClassPackage1."+testcasename);
		
		// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
		Method executemethod=testclassname.getDeclaredMethod("execute");
		
		// set the accessibility of method true 
		executemethod.setAccessible(true);
		
		// create the instance of testclass captured in variable name testclassname
		Object instanceoftestclass=testclassname.getDeclaredConstructor().newInstance();
		
		// execute the testclass captured in variable name testclass name
		executemethod.invoke(instanceoftestclass);
		}
		}
			}


