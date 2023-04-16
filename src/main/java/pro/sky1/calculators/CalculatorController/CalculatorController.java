package pro.sky1.calculators.CalculatorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky1.calculators.service.CalculatorServise;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    private final CalculatorServise calculatorServise;

    public CalculatorController(CalculatorServise calculatorServise) {
        this.calculatorServise = calculatorServise;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор";

    }

    @GetMapping("/")
    public String plus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b ) {
        return buildView("+", a, b);

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b ) {
        return buildView("-", a, b);

    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b ) {
        return buildView("*", a, b);

    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b ) {
        return buildView("/", a, b);

    }

    private String buildView (String operation, Float operand1 , Float operand2 ) {
        if (operand1 == null ){
            return "Не передано первое значение ";
        } else if ( operand2 == null) {
            return "Не передано второе значение ";
        }
        if ("/".equals(operation) && operand2 == 0) {
            return "Делить на 0 нельзя!";
        }
        float result;
        switch (operation){
            default:
            case "+" :
                result = calculatorServise.plus(operand1,operand2);
                break;

            case "-" :
                result = calculatorServise.minus(operand1,operand2);
                break;
            case "*" :
                result = calculatorServise.multiply(operand1,operand2);
                break;
            case "/" :
                result = calculatorServise.divide(operand1,operand2);
                break;
        }
        return operand1 +" "+ operation + operand2 + " = " + result;
    }




}

