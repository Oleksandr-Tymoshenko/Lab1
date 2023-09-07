package university.service;

import university.ComputerDiscipline;
import university.Discipline;

import java.util.Arrays;
import java.util.Scanner;

public class ComputerDisciplineHandler implements DisciplineHandler {
    private final Scanner in;

    public ComputerDisciplineHandler() {
        in = new Scanner(System.in);
    }

    @Override
    public Discipline getDiscipline() {
        System.out.print("Discipline name: ");
        String name = in.next();
        System.out.print("Discipline hours: ");
        int hours = in.nextInt();
        System.out.println("Choose discipline control form: ");
        Arrays.stream(Discipline.ControlForm.values())
                .forEach(System.out::println);
        String controlForm = in.next().toUpperCase();
        System.out.println("Machine resource time: ");
        int resourceTime = in.nextInt();
        System.out.print("Base product name: ");
        String productName = in.next();
        return new ComputerDiscipline(name, hours, Discipline.ControlForm.valueOf(controlForm),
                resourceTime, productName);
    }
}
