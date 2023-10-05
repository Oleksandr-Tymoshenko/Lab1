package university.strategy.impl;

import java.util.Scanner;
import university.model.ComputerDiscipline;
import university.model.Discipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;
import university.strategy.DisciplineHandler;

public class ComputerDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public ComputerDisciplineHandler() {
        in = new Scanner(System.in);
        inputExceptionHandler = new InputExceptionHandlerImpl();
    }

    @Override
    public Discipline getDiscipline() {
        ComputerDiscipline computerDiscipline = new ComputerDiscipline();
        computerDiscipline = (ComputerDiscipline) setBasicFields(computerDiscipline);

        System.out.println("Machine resource time: ");
        computerDiscipline.setMachineTime(inputExceptionHandler.consoleReadInteger());

        System.out.print("Base product name: ");
        computerDiscipline.setBaseProductName(in.nextLine());
        return computerDiscipline;
    }
}
