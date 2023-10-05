package university.strategy.impl;

import java.util.Scanner;
import university.model.Discipline;
import university.model.MathDiscipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;
import university.strategy.DisciplineHandler;

public class MathDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public MathDisciplineHandler() {
        in = new Scanner(System.in);
        inputExceptionHandler = new InputExceptionHandlerImpl();
    }

    @Override
    public Discipline getDiscipline() {
        MathDiscipline mathDiscipline = new MathDiscipline();
        mathDiscipline = (MathDiscipline) setBasicFields(mathDiscipline);

        System.out.println("Calculation task number: ");
        mathDiscipline.setCalculationTasksNumber(inputExceptionHandler.consoleReadInteger());
        return mathDiscipline;
    }
}
