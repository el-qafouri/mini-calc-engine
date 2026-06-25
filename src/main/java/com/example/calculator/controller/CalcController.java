package com.example.calculator.controller;

import com.example.calculator.model.CalcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.calculator.service.CalcService;

import java.util.List;

@RestController
@RequestMapping("/")
public class CalcController {

    @Autowired
    private CalcService calcService;

    @PostMapping("calculate")
    private ResponseEntity<CalcModel> calculate(@RequestBody CalcModel calcModel) {
        CalcModel result = calcService.calculate(calcModel);
        return ResponseEntity.ok(result);
    }


    @GetMapping("history")
    private ResponseEntity<List<CalcModel>> getHistory() {
        List<CalcModel> history = calcService.getHistory();
        if (history.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(history);
    }

    @DeleteMapping("deleteHistory")
    public ResponseEntity<String> deleteHistory() {
        List<CalcModel> history = calcService.getHistory();
        if (history.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        calcService.deleteHistory();
        return ResponseEntity.ok("History deleted successfully");
    }
}