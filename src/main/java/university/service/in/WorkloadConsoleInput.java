package university.service.in;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import university.Discipline;
import university.Teacher;
import university.Workload;
import university.service.DisciplineHandler;
import university.service.DisciplineStrategyImpl;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;

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
    public Workload input() {
        System.out.println("Choose discipline type: ");
        IntStream.range(0, disciplineHandlerList.size())
                .mapToObj(i -> i + ") " + disciplineHandlerList.get(i).getClass().getSimpleName())
                .map(s -> s.replaceAll("Handler", ""))
                .forEach(System.out::println);
        System.out.print("Input a number: ");
        int num;
        Discipline discipline;
        while (true) {
            try {
                num = inputExceptionHandler.consoleReadInteger();
                discipline = new DisciplineStrategyImpl(disciplineHandlerList)
                        .getDiscipline(num).getDiscipline();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }

        System.out.print("Teacher roll number: ");
        long rollNumber = inputExceptionHandler.consoleReadLong();

        System.out.print("Teacher name: ");
        String name = in.nextLine();

        System.out.println("Choose teacher position: ");
        Arrays.stream(Teacher.Position.values()).forEach(System.out::println);
        Teacher.Position position = (Teacher.Position) inputExceptionHandler
                .consoleReadEnum(Teacher.Position.class);
        Teacher teacher = new Teacher(rollNumber, name, position);

        System.out.println("Choose workload type: ");
        Arrays.stream(Workload.WorkloadType.values()).forEach(System.out::println);
        Workload.WorkloadType workloadType = (Workload.WorkloadType) inputExceptionHandler
                .consoleReadEnum(Workload.WorkloadType.class);
        return new Workload(discipline, teacher, workloadType);
    }
}
