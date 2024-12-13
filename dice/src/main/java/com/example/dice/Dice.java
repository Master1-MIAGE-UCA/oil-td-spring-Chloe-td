package com.example.dice;

import org.springframework.stereotype.Component;
import java.util.Random;



@Component
public class Dice {

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}
