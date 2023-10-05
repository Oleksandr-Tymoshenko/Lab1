package university.service.random.impl;

import java.util.Random;
import university.model.ComputerDiscipline;
import university.model.Discipline;
import university.service.random.RandomFilledDisciplineHandler;

public class RandomFilledComputerDiscipline implements RandomFilledDisciplineHandler {
    private static final Random RANDOM = new Random();
    private static int counter = 1;

    @Override
    public Discipline getRandomDiscipline() {
        ComputerDiscipline computerDiscipline = new ComputerDiscipline();
        computerDiscipline.setName("Computer Discipline " + counter);
        computerDiscipline.setHours(RANDOM.nextInt(100, 200));
        computerDiscipline.setBaseProductName("Base product name " + counter++);
        computerDiscipline.setMachineTime(RANDOM.nextInt(10, 20));
        int randomPosition = RANDOM.nextInt(Discipline.ControlForm.values().length);
        for (int i = 0; i < Discipline.ControlForm.values().length; i++) {
            if (i == randomPosition) {
                computerDiscipline.setControlForm(Discipline.ControlForm.values()[i]);
                break;
            }
        }
        return computerDiscipline;
    }
}
