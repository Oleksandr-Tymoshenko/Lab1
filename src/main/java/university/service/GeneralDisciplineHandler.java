package university.service;

import university.Discipline;
import university.GeneralDiscipline;
import java.util.Arrays;
import java.util.Scanner;

public class GeneralDisciplineHandler implements DisciplineHandler {
    private final Scanner in;

    public GeneralDisciplineHandler() {
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
        System.out.println("Lecture / Seminars ratio: ");
        double lecSemRation = in.nextDouble();
        return new GeneralDiscipline(name, hours, Discipline.ControlForm.valueOf(controlForm),
                lecSemRation);
    }
}
