package university;

import university.service.in.FormatPrintable;

public abstract class Discipline implements FormatPrintable {
    String name;
    int hours;
    ControlForm controlForm;

    public Discipline(String name, int hours, ControlForm controlForm) {
        this.name = name;
        this.hours = hours;
        this.controlForm = controlForm;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public enum ControlForm {
        TEST,
        EXAM
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + name + '\'' +
                ", hours=" + hours +
                ", controlForm=" + controlForm +
                '}';
    }

    @Override
    public String toStringFormat() {
        return String.format("%s %s, hours: %s, controlForm: %s ",
                getClass().getSimpleName(), name, hours, controlForm.name());
    }
}
