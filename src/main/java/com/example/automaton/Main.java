package com.example.automaton;

public class Main {
    public static void main(String[] args) {
        FiniteAutomaton automaton = new FiniteAutomaton();

        String input1 = "abcTESTabc";
        automaton.processString(input1);
        if (automaton.isFinalState()) {
            System.out.println(input1 + " -> F");
        } else {
            System.out.println(input1 + " -> " + automaton.processString(input1));
        }

        automaton = new FiniteAutomaton();
        String input2 = "abcTES";
        automaton.processString(input2);
        if (automaton.isFinalState()) {
            System.out.println(input2 + " -> F");
        } else {
            System.out.println(input2 + " -> " + automaton.processString(input2));
        }
    }
}
