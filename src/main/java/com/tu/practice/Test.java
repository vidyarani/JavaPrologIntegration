package com.tu.practice;

import alice.tuprolog.*;
import alice.tuprolog.event.OutputEvent;
import alice.tuprolog.event.OutputListener;

import java.io.*;

public class Test {
    public static void main(String[] args) throws NoMoreSolutionException, InvalidTheoryException, MalformedGoalException, IOException {
        Test test = new Test();
        test.execute();

    }

    private void execute() throws IOException, InvalidTheoryException, MalformedGoalException, NoMoreSolutionException {
        Prolog engine = new Prolog();
        engine.addTheory(new Theory(createFileTheory()));
        engine.addOutputListener(createOutputListener());
        SolveInfo solution = engine.solve("grandfather(Who, ram).");
        while (solution.isSuccess()){
            System.out.println(solution);
            if(engine.hasOpenAlternatives()){
                solution = engine.solveNext();
            }
        }
    }

    private InputStream createFileTheory() throws FileNotFoundException {
        InputStream file = this.getClass().getResourceAsStream("/familytree.pl");
        return file;
    }

    private static OutputListener createOutputListener() {
        return new OutputListener() {
            @Override
            public void onOutput(OutputEvent e) {
                System.out.println("output: "+ e.getMsg());
            }
        };
    }
}
