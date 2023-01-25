package com.example.demo.javaBookSolvingPracticalTasks.firstBlock;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.assertj.core.util.BigIntegerComparator;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.DEFAULT_VALUE;

public class StartUp {

    private static final String DEFAULT_STRING_VALUE = "hello, my friend. Do you want something?";


    public static void main(String[] args) {
        var countDuplicateCharacter = new CountDuplicateCharacter();
//        countDuplicateCharacter.functionalSolution();

        var firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
//        firstNonRepeatedCharacter.findFirstOne();

    }
}


class CountDuplicateCharacter {

    //first solution

    public void mapSolution() {
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : DEFAULT_VALUE.toCharArray()) {
            map.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        System.out.println(map);
    }

    //second solution
    public void functionalSolution() {
        Map<Character, Long> map = DEFAULT_VALUE.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        System.out.println(map);
    }
}


class FirstNonRepeatedCharacter {

    //solution

    public void findFirstOne() {
        Character result = DEFAULT_VALUE.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Character.MIN_VALUE);

        System.out.println(result);
    }
}









