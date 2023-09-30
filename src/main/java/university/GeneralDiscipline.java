package university;

import university.service.in.FormatPrintable;

public class GeneralDiscipline extends Discipline implements FormatPrintable {
    private final double lecturesSeminarsRatio;

    public GeneralDiscipline(String name, int hours, ControlForm controlForm,
                             double lecturesSeminarsRatio) {
        super(name, hours, controlForm);
        this.lecturesSeminarsRatio = lecturesSeminarsRatio;
    }

    @Override
    public String toString() {
        return super.toString() + "GeneralDiscipline{"
                + "lecturesSeminarsRatio=" + lecturesSeminarsRatio
                + '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Lectures / seminars ratio: %s",
                lecturesSeminarsRatio);
    }
}
