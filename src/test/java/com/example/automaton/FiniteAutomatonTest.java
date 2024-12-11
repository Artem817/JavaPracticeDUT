package com.example.automaton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "'TeSt', 4",
            "'tEsT', 4",
            "'TEST', 4",
            "'tEST', 4",
            "'TeSTing', 4",
            "'testingTEST', 4",
            "'TesTTEST', 4"
    })
    void testProcessStringCaseInsensitive(String input, int expectedState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        int finalState = automaton.processString(input);
        assertEquals(expectedState, finalState, "Failed for input: " + input);
    }

    @ParameterizedTest
    @CsvSource({
            "'TeSt', true",
            "'tEsT', true",
            "'TEST', true",
            "'tEST', true",
            "'TeSTing', true",
            "'testingTEST', true",
            "'TesTTEST', true"
    })
    void testIsFinalStateCaseInsensitive(String input, boolean expectedFinalState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.processString(input);
        assertEquals(expectedFinalState, automaton.isFinalState(), "Failed for input: " + input);
    }
    @ParameterizedTest
    @CsvSource({
            "'TTEST', 4",
            "'TTTTTEST', 4",
            "'TESTTEST', 4"
    })
    void testRepeatedT(String input, int expectedState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        int finalState = automaton.processString(input);
        assertEquals(expectedState, finalState, "Failed for input: " + input);
    }
}
