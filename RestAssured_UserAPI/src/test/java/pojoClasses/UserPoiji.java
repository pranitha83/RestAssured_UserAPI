package pojoClasses;

import java.io.File;
import java.util.List;

import com.poiji.annotation.ExcelCellName;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import endPoints.URLs;
import lombok.Builder;
import lombok.Data;



	
	
	public class UserPoiji {
		@ExcelCellName("user_first_name")
		String user_first_name;
		
		@ExcelCellName("user_last_name")
		String user_last_name;
		
		@ExcelCellName("user_contact_number")
		String user_contact_number;
		
		@ExcelCellName("user_email_id")
		String user_email_id;
		
		@ExcelCellName("plotNumber")
		String plotNumber;
		
		@ExcelCellName("state")
		String state;
		
		@ExcelCellName("street")
		String street;
		
		@ExcelCellName("country")
		String country;
		
		@ExcelCellName("zipCode")
		String zipCode;
//		
//		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
//		        .addListDelimiter(";") 
//		        .build();
//		List<Create_UserPoiji> userdata= Poiji.fromExcel(new File(URLs.Excelpath), Create_UserPoiji.class, options);
//		
//	
		
		
//		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
//		        .addListDelimiter(";") 
//		        .build();
		List<UserPoiji> userdata = Poiji.fromExcel(new File("employees.xls"), UserPoiji.class);
		// alternatively
//		InputStream stream = new FileInputStream(new File("employees.xls"))
//		List<Employee> employees = Poiji.fromExcel(stream, PoijiExcelType.XLS, Employee.class, options);

//		userdata.
//		// 3
//		Employee firstEmployee = employees.get(0);
//		// Employee{rowIndex=1, employeeId=123923, name='Joe', surname='Doe', age=30, single=true, emails=[joe@doe.com, joedoe@gmail.com], biils=[123,10, 99.99]}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
