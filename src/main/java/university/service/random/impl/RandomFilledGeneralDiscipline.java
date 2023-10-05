package university.service.random.impl;

import java.util.Random;
import university.model.Discipline;
import university.model.GeneralDiscipline;
import university.service.random.RandomFilledDisciplineHandler;

public class RandomFilledGeneralDiscipline implements RandomFilledDisciplineHandler {
    private static final Random RANDOM = new Random();
    private static int counter = 1;

    @Override
    public Discipline getRandomDiscipline() {
        GeneralDiscipline generalDiscipline = new GeneralDiscipline();
        generalDiscipline.setName("General Discipline " + counter++);
        generalDiscipline.setHours(RANDOM.nextInt(100, 200));
        generalDiscipline.setLecturesSeminarsRatio(RANDOM.nextDouble(100) / 10);
        int randomPosition = RANDOM.nextInt(Discipline.ControlForm.values().length);
        for (int i = 0; i < Discipline.ControlForm.values().length; i++) {
            if (i == randomPosition) {
                generalDiscipline.setControlForm(Discipline.ControlForm.values()[i]);
                break;
            }
        }
        return generalDiscipline;
    }
}
