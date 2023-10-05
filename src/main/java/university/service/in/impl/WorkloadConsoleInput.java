package university.service.in.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import university.model.Discipline;
import university.model.Teacher;
import university.model.Workload;
import university.service.in.WorkloadInput;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;
import university.strategy.DisciplineHandler;
import university.strategy.impl.DisciplineStrategyImpl;

public class WorkloadConsoleInput implements WorkloadInput {
    private final List<DisciplineHandler> disciplineHandlerList;
    private final InputExceptionHandler inputExceptionHandler;
    private final Scanner in;

    public WorkloadConsoleInput(List<DisciplineHandler> disciplineHandlerList) {
        this.disciplineHandlerList = disciplineHandlerList;
        in = new Scanner(System.in);
        inputExceptionHandler = new InputExceptionHandlerImpl();
    }

    @Override
    public Workload load() {
        System.out.println("Choose discipline type: ");
        IntStream.range(0, disciplineHandlerList.size())
                .mapToObj(i -> i + ") " + disciplineHandlerList.get(i).getClass().getSimpleName())
                .map(s -> s.replaceAll("Handler", ""))
                .forEach(System.out::println);
        System.out.print("Input a number: ");
        Workload newWorkload = new Workload();
        int num;
        while (true) {
            try {
                num = inputExceptionHandler.consoleReadInteger();
                Discipline discipline = new DisciplineStrategyImpl(disciplineHandlerList)
                        .getDiscipline(num).getDiscipline();
                newWorkload.setDiscipline(discipline);
                newWorkload.setHours(discipline.getHours());
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }
        Teacher teacher = new Teacher();
        System.out.print("Teacher roll number: ");
        teacher.setRollNumber(inputExceptionHandler.consoleReadLong());

        System.out.print("Teacher name: ");
        teacher.setNameSurname(in.nextLine());

        System.out.println("Choose teacher position: ");
        Arrays.stream(Teacher.Position.values()).forEach(System.out::println);
        Teacher.Position position = (Teacher.Position) inputExceptionHandler
                .consoleReadEnum(Teacher.Position.class);
        teacher.setPosition(position);
        newWorkload.setTeacher(teacher);

        System.out.println("Choose workload type: ");
        Arrays.stream(Workload.WorkloadType.values()).forEach(System.out::println);
        Workload.WorkloadType workloadType = (Workload.WorkloadType) inputExceptionHandler
                .consoleReadEnum(Workload.WorkloadType.class);
        newWorkload.setWorkloadType(workloadType);
        return newWorkload;
    }
}
