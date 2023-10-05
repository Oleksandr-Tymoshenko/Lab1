package university.service.in.impl;

import java.util.List;
import java.util.Random;
import university.model.Workload;
import university.service.in.WorkloadInput;
import university.service.random.RandomFilledDisciplineHandler;
import university.service.random.RandomFilledTeacherHandler;
import university.service.random.impl.RandomFilledTeacherHandlerImpl;

public class WorkloadRandomInput implements WorkloadInput {
    private static final Random RANDOM = new Random();
    private final RandomFilledTeacherHandler randomFilledTeacherHandler;
    private final List<RandomFilledDisciplineHandler> disciplines;

    public WorkloadRandomInput(List<RandomFilledDisciplineHandler> disciplines) {
        this.disciplines = disciplines;
        this.randomFilledTeacherHandler = new RandomFilledTeacherHandlerImpl();
    }

    @Override
    public Workload load() {
        Workload workload = new Workload();
        workload.setDiscipline(disciplines.get(RANDOM.nextInt(disciplines.size()))
                .getRandomDiscipline());
        workload.setTeacher(randomFilledTeacherHandler.getRandomTeacher());
        workload.setHours(RANDOM.nextInt(10, 20));
        int randomPosition = RANDOM.nextInt(Workload.WorkloadType.values().length);
        for (int i = 0; i < Workload.WorkloadType.values().length; i++) {
            if (i == randomPosition) {
                workload.setWorkloadType(Workload.WorkloadType.values()[i]);
                break;
            }
        }
        return workload;
    }
}
