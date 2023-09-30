package university.service;

import java.util.Arrays;
import java.util.Scanner;
import university.Discipline;
import university.GeneralDiscipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;

public class GeneralDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public GeneralDisciplineHandler() {
        in = new Scanner(System.in);
        inputExceptionHandler = new InputExceptionHandlerImpl();
    }

    @Override
    public Discipline getDiscipline() {
        System.out.print("Discipline name: ");
        String name = in.nextLine();

        System.out.print("Discipline hours: ");
        int hours = inputExceptionHandler.consoleReadInteger();

        System.out.println("Choose discipline control form: ");
        Arrays.stream(Discipline.ControlForm.values())
                .forEach(System.out::println);
        Discipline.ControlForm controlForm = (Discipline.ControlForm) inputExceptionHandler
                .consoleReadEnum(Discipline.ControlForm.class);

        System.out.println("Lecture / Seminars ratio: ");
        double lecSemRation = inputExceptionHandler.consoleReadDouble();
        return new GeneralDiscipline(name, hours, controlForm, lecSemRation);
    }
}
