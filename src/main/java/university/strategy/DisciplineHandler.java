package university.strategy;

import java.util.Arrays;
import java.util.Scanner;
import university.model.Discipline;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;

public interface DisciplineHandler {
    Discipline getDiscipline();

    default Discipline setBasicFields(Discipline discipline) {
        Scanner in = new Scanner(System.in);
        System.out.print("Discipline name: ");
        discipline.setName(in.nextLine());

        InputExceptionHandler inputExceptionHandler = new InputExceptionHandlerImpl();
        System.out.print("Discipline hours: ");
        discipline.setHours(inputExceptionHandler.consoleReadInteger());

        System.out.println("Choose discipline control form: ");
        Arrays.stream(Discipline.ControlForm.values())
                .forEach(System.out::println);
        Discipline.ControlForm controlForm = (Discipline.ControlForm) inputExceptionHandler
                .consoleReadEnum(Discipline.ControlForm.class);
        discipline.setControlForm(controlForm);
        return discipline;
    }
}
