package be.ehb.demo_orm1.controllers;

import be.ehb.demo_orm1.model.Employee;
import be.ehb.demo_orm1.model.EmployeeDAO;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeDAO empDao;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity maakBeest(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "naam") String naam,
                                    @RequestParam(value = "email") String email,
                                    @RequestParam(value = "telefoonNr") int telefoonNr){
        Employee nieuwEmployee = new Employee();
        nieuwEmployee.setNaam(naam);
        nieuwEmployee.setId(id);

        empDao.save(nieuwEmployee);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{naam=x:}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Employee> zoekEmployeeOpNaam(@PathVariable(value = "naam") String naam){
        return empDao.findByNaam(naam);
    }
    @RequestMapping(value = "/{x:}",method = RequestMethod.GET)
    public Optional<Employee>zoekEmployeeOpId(@PathVariable(value ="id" )int id){
        return empDao.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> toonEmployees(){
        return empDao.findAll();
    }


}
