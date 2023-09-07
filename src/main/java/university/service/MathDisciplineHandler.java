package university.service;

import university.Discipline;
import university.MathDiscipline;
import java.util.Arrays;
import java.util.Scanner;

public class MathDisciplineHandler implements DisciplineHandler {
    private final Scanner in;

    public MathDisciplineHandler() {
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
        System.out.println("Calculation task number: ");
        int taskNumber = in.nextInt();
        return new MathDiscipline(name, hours, Discipline.ControlForm.valueOf(controlForm),
                taskNumber);
    }
}
