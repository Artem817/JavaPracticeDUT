package com.example.automaton;

public class FiniteAutomaton {
    private int state;

    public FiniteAutomaton() {
        this.state = 0;
    }

    public void processChar(char c) {
        c = Character.toUpperCase(c);
        switch (state) {
            case 0:
                if (c == 'T') {
                    state = 1;
                }
                break;
            case 1:
                if (c == 'E') {
                    state = 2;
                } else if (c == 'T') {
                    state = 1;
                } else {
                    state = 0;
                }
                break;
            case 2:
                if (c == 'S') {
                    state = 3;
                } else if (c == 'T') {
                    state = 1;
                } else {
                    state = 0;
                }
                break;
            case 3:
                if (c == 'T') {
                    state = 4;
                } else {
                    state = 0;
                }
                break;
            case 4:
                break;
            default:
                state = 0;
                break;
        }
    }


    public int processString(String input) {
        for (char c : input.toCharArray()) {
            processChar(c);
        }
        return state;
    }

    public boolean isFinalState() {
        return state == 4;
    }
}
