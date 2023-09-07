package university;

import university.service.in.FormatPrintable;

public class MathDiscipline extends Discipline implements FormatPrintable {
    private final int calculationTasksNumber;

    public MathDiscipline(String name, int hours, ControlForm controlForm,
                          int calculationTasksNumber) {
        super(name, hours, controlForm);
        this.calculationTasksNumber = calculationTasksNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "MathDiscipline{" +
                "calculationTasksNumber=" + calculationTasksNumber +
                '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Calculation tasks number: %s",
                calculationTasksNumber);
    }
}
