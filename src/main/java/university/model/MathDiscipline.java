package university.model;

import java.io.Serializable;
import university.service.out.FormatPrintable;

public class MathDiscipline extends Discipline implements FormatPrintable, Serializable {
    private int calculationTasksNumber;

    public MathDiscipline() {
    }

    public MathDiscipline(String name, int hours, ControlForm controlForm,
                          int calculationTasksNumber) {
        super(name, hours, controlForm);
        this.calculationTasksNumber = calculationTasksNumber;
    }

    public int getCalculationTasksNumber() {
        return calculationTasksNumber;
    }

    public void setCalculationTasksNumber(int calculationTasksNumber) {
        this.calculationTasksNumber = calculationTasksNumber;
    }

    @Override
    public String toString() {
        return super.toString()
                + "calculationTasksNumber=" + calculationTasksNumber
                + '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Calculation tasks number: %s",
                calculationTasksNumber);
    }
}
