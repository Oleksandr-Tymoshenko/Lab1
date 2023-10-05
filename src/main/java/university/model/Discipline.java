package university.model;

import java.io.Serializable;
import university.service.out.FormatPrintable;

public abstract class Discipline implements FormatPrintable, Serializable {
    private String name;
    private int hours;
    private ControlForm controlForm;

    public Discipline() {
    }

    public Discipline(String name, int hours, ControlForm controlForm) {
        this.name = name;
        this.hours = hours;
        this.controlForm = controlForm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public ControlForm getControlForm() {
        return controlForm;
    }

    public void setControlForm(ControlForm controlForm) {
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
        return "type=" + getClass().getSimpleName()
                + ", name=" + name
                + ", hours=" + hours
                + ", controlForm=" + controlForm.name() + ", ";
    }

    @Override
    public String toStringFormat() {
        return String.format("%s %s, hours: %s, controlForm: %s ",
                getClass().getSimpleName(), name, hours, controlForm.name());
    }
}
