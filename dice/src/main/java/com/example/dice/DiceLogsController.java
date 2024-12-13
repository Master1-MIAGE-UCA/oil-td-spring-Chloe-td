package com.example.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class DiceLogsController {

    @Autowired
    private DiceRollLogRepository repository;

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllLogs() {
        return repository.findAll();
    }
}