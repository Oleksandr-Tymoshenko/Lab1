package university.service;

import java.util.Arrays;
import java.util.Scanner;
import university.Discipline;
import university.MathDiscipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;

public class MathDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public MathDisciplineHandler() {
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

        System.out.println("Calculation task number: ");
        int taskNumber = inputExceptionHandler.consoleReadInteger();
        return new MathDiscipline(name, hours, controlForm, taskNumber);
    }
}
