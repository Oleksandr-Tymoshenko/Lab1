package university.service.random.impl;

import java.util.Random;
import university.model.Teacher;
import university.service.random.RandomFilledTeacherHandler;

public class RandomFilledTeacherHandlerImpl implements RandomFilledTeacherHandler {
    private static final Random RANDOM = new Random();
    private static int counter = 1;

    @Override
    public Teacher getRandomTeacher() {
        Teacher teacher = new Teacher();
        teacher.setNameSurname("Teacher " + counter++);
        teacher.setRollNumber(RANDOM.nextLong(10000, 100000));
        int randomPosition = RANDOM.nextInt(Teacher.Position.values().length);
        for (int i = 0; i < Teacher.Position.values().length; i++) {
            if (i == randomPosition) {
                teacher.setPosition(Teacher.Position.values()[i]);
                break;
            }
        }
        return teacher;
    }
}
