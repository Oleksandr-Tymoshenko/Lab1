package university.strategy.impl;

import java.util.Scanner;
import university.model.Discipline;
import university.model.GeneralDiscipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;
import university.strategy.DisciplineHandler;

public class GeneralDisciplineHandler implements DisciplineHandler {
    private final Scanner in;
    private final InputExceptionHandler inputExceptionHandler;

    public GeneralDisciplineHandler() {
        in = new Scanner(System.in);
        inputExceptionHandler = new InputExceptionHandlerImpl();
    }

    @Override
    public Discipline getDiscipline() {
        GeneralDiscipline generalDiscipline = new GeneralDiscipline();
        generalDiscipline = (GeneralDiscipline) setBasicFields(generalDiscipline);

        System.out.println("Lecture / Seminars ratio: ");
        generalDiscipline.setLecturesSeminarsRatio(inputExceptionHandler.consoleReadDouble());
        return generalDiscipline;
    }
}
