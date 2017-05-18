package employeepackage;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empserv;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String welcome() {
		return "data";
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	protected String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "data";
		else
			empserv.insertEmployee(employee);
		return "redirect:listEmployees";
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	protected String editEmployee(Model m, @RequestParam(value = "idId", required = true) Integer empId) {
		Employee emp = empserv.findById(empId);
		m.addAttribute("employee", emp);
		return "editEmployee";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee emp, BindingResult result) {
		if (result.hasErrors())
			return "editEmployee";
		else
			empserv.updateEmployee(emp);
		return "redirect:listEmployees";
	}

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	protected String listEmployees(Model m) {
		List<Employee> employees = new ArrayList<Employee>();
		employees = empserv.selectEmployee();
		m.addAttribute("Emp", employees);
		return "listEmployees";
	}

	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	protected String viewEmployee(@RequestParam(value = "idId", required = true) Integer empId, Model m) {
		Employee e = empserv.findById(empId);
		m.addAttribute("Emp", e);
		return "viewEmployee";
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	protected String deleteEmployee(@RequestParam(value = "idSalary", required = true) float empSalary,
			@RequestParam(value = "idId", required = true) Integer empId, Model m) {
		if (Math.signum(empSalary) == 0)
			empserv.deleteEmployee(empId);
		return "redirect:listEmployees";
	}
}