package sky.pro.calculator.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.calculator.service.calculatorService;

@RestController

public class calculatorController {
    private final calculatorService calculatorService;

    public calculatorController(calculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String getHello(){
        return calculatorService.getHello();
    }
    @GetMapping("/plus")
    public Integer plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return calculatorService.plus(num1,num2);
    }
    @GetMapping("/minus")
    public Integer minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return calculatorService.minus(num1,num2);
    }
    @GetMapping("/multiply")
    public Integer multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return calculatorService.multiply(num1,num2);
    }
    @GetMapping("/divide")
    public Integer divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return calculatorService.divide(num1,num2);
    }
}
