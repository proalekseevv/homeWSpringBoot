package pro.sky1.calculators.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServise {
    public float plus (float a, float b) {
        return  a + b ;
    }

    public float minus (float a, float b) {
        return  a - b ;
    }

    public float multiply (float a, float b) {
        return  a * b ;
    }

    public float divide (float a, float b) {
        return  a / b ;
    }




}


