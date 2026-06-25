package com.example.calculator.service;

import com.example.calculator.model.CalcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.calculator.repository.CalcRepository;

import java.util.List;

@Service
public class CalcService {

    @Autowired
    private CalcRepository calcRepository;

    private double result = 0;

    public CalcModel calculate(CalcModel calcModel) {
        switch (calcModel.getOperation()) {
            case "+":
                result = calcModel.getNum1() + calcModel.getNum2();
                break;
            case "-":
                result = calcModel.getNum1() - calcModel.getNum2();
                break;
            case "*":
                result = calcModel.getNum1() * calcModel.getNum2();
                break;
            case "/":
                result = calcModel.getNum1() / calcModel.getNum2();
                break;
        }
        calcModel.setResult(result);
        return calcRepository.save(calcModel);
    }

    public List<CalcModel> getHistory() {
        return calcRepository.findAll();
    }

    public void deleteHistory() {
        calcRepository.deleteAll();
    }
}
