package sky.pro.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class calculatorServiceImpl implements calculatorService {


    public String getHello() {
        return "Добро пожаловать в калькулятор";
    }
    public Integer plus(Integer num1, Integer num2) {
        if ((num2 != null) & (num1 != null)){
            return num1 + num2;
        }
        throw new NullPointerException("Введите оба числа");
    }
    public Integer minus(Integer num1, Integer num2) {
        if ((num2 != null) & (num1 != null)){
            return num1 - num2;
        }
        throw new NullPointerException("Введите оба числа");
    }
    public Integer multiply(Integer num1, Integer num2) {
        if ((num2 != null) & (num1 != null)){
            return num1 * num2;
        }
        throw new NullPointerException("Введите оба числа");
    }
    public Integer divide(Integer num1, Integer num2) {
        if ((num2 != null) & (num1 != null)){
            if (num2 != 0) {
                return num1 / num2;
            }
            throw new IllegalArgumentException("На ноль делить нельзя");
        }
        throw new NullPointerException("Введите оба числа");
    }

}
