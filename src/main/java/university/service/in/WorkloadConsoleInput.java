package university.service.in;

import university.Discipline;
import university.Teacher;
import university.Workload;
import university.service.DisciplineHandler;
import university.service.DisciplineStrategyImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WorkloadConsoleInput implements WorkloadInput {
    private final List<DisciplineHandler> disciplineHandlerList;
    private final Scanner in;

    public WorkloadConsoleInput(List<DisciplineHandler> disciplineHandlerList) {
        this.disciplineHandlerList = disciplineHandlerList;
        in = new Scanner(System.in);
    }

    @Override
    public Workload input() {
        System.out.println("Choose discipline type: ");
        IntStream.range(0, disciplineHandlerList.size())
                .mapToObj(i -> i + ") " + disciplineHandlerList.get(i).getClass().getSimpleName())
                .map(s -> s.replaceAll("Handler", ""))
                .forEach(System.out::println);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        Discipline discipline = new DisciplineStrategyImpl(disciplineHandlerList)
                .getDiscipline(num).getDiscipline();
        System.out.print("Teacher roll number: ");
        long rollNumber = in.nextLong();
        System.out.print("Teacher name: ");
        String name = in.next();
        System.out.println("Choose teacher position: ");
        Arrays.stream(Teacher.Position.values()).forEach(System.out::println);
        String position = in.next().toUpperCase();
        Teacher teacher = new Teacher(rollNumber, name, Teacher.Position.valueOf(position));
        System.out.println("Choose workload type: ");
        Arrays.stream(Workload.WorkloadType.values()).forEach(System.out::println);
        String workloadType = in.next().toUpperCase();
        return new Workload(discipline, teacher, Workload.WorkloadType.valueOf(workloadType));
    }
}
