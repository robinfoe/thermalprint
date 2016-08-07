package com.sgdeals.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgdeals.lib.printer.PrintExecutor;
import com.sgdeals.web.response.GenericResponse;


@Controller
public class PrintController {
	
	
	@CrossOrigin(origins = "*")
    @RequestMapping("/printreceipt")
    public @ResponseBody GenericResponse printreceipt(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        PrintExecutor printer = new PrintExecutor();
        printer.init();
        
        
        return GenericResponse.generate("print job sent");
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}



