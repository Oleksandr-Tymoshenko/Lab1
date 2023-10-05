package university.model;

import java.io.Serializable;
import university.service.out.FormatPrintable;

public class GeneralDiscipline extends Discipline implements FormatPrintable, Serializable {
    private double lecturesSeminarsRatio;

    public GeneralDiscipline() {
    }

    public GeneralDiscipline(String name, int hours, ControlForm controlForm,
                             double lecturesSeminarsRatio) {
        super(name, hours, controlForm);
        this.lecturesSeminarsRatio = lecturesSeminarsRatio;
    }

    public double getLecturesSeminarsRatio() {
        return lecturesSeminarsRatio;
    }

    public void setLecturesSeminarsRatio(double lecturesSeminarsRatio) {
        this.lecturesSeminarsRatio = lecturesSeminarsRatio;
    }

    @Override
    public String toString() {
        return super.toString()
                + "lecturesSeminarsRatio=" + String.format("%.2f", lecturesSeminarsRatio)
                + '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Lectures \\ seminars ratio: %.2f",
                lecturesSeminarsRatio);
    }
}
