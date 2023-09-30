package university.service;

import java.util.Arrays;
import java.util.Scanner;
import university.ComputerDiscipline;
import university.Discipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;

public class ComputerDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public ComputerDisciplineHandler() {
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

        System.out.println("Machine resource time: ");
        int resourceTime = inputExceptionHandler.consoleReadInteger();

        System.out.print("Base product name: ");
        String productName = in.nextLine();
        return new ComputerDiscipline(name, hours, controlForm, resourceTime, productName);
    }
}
