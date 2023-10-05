package university.service.random.impl;

import java.util.Random;
import university.model.Discipline;
import university.model.MathDiscipline;
import university.service.random.RandomFilledDisciplineHandler;

public class RandomFilledMathDiscipline implements RandomFilledDisciplineHandler {
    private static final Random RANDOM = new Random();
    private static int counter = 1;

    @Override
    public Discipline getRandomDiscipline() {
        MathDiscipline mathDiscipline = new MathDiscipline();
        mathDiscipline.setName("MathDiscipline " + counter++);
        mathDiscipline.setHours(RANDOM.nextInt(100, 200));
        mathDiscipline.setCalculationTasksNumber(RANDOM.nextInt(5, 10));
        int randomPosition = RANDOM.nextInt(Discipline.ControlForm.values().length);
        for (int i = 0; i < Discipline.ControlForm.values().length; i++) {
            if (i == randomPosition) {
                mathDiscipline.setControlForm(Discipline.ControlForm.values()[i]);
                break;
            }
        }
        return mathDiscipline;
    }
}
