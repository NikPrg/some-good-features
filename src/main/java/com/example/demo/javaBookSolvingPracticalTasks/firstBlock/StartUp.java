package com.example.demo.javaBookSolvingPracticalTasks.firstBlock;

import com.example.demo.javaBookSolvingPracticalTasks.firstBlock.solutions.Solution;
import com.example.demo.javaBookSolvingPracticalTasks.firstBlock.solutions.impl.CountDuplicateCharacter;
import com.example.demo.javaBookSolvingPracticalTasks.firstBlock.solutions.impl.FirstNonRepeatedCharacter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import static com.example.demo.javaBookSolvingPracticalTasks.utils.StringConstants.DEFAULT_STRING_MESSAGE;

@RequiredArgsConstructor
@Component
public class StartUp {

    public static void main(String[] args) {
        val startUp = new StartUp();

        startUp.run(new FirstNonRepeatedCharacter(), DEFAULT_STRING_MESSAGE);
        startUp.run(new CountDuplicateCharacter(), DEFAULT_STRING_MESSAGE);

    }

    public void run(Solution solution, String str){
        solution.perform(str);
    }



}

















