package university;

import university.service.in.FormatPrintable;

public class Workload implements FormatPrintable {
    private final Discipline discipline;
    private final Teacher teacher;
    private final WorkloadType workloadType;
    private final int hours;

    public Workload(Discipline discipline, Teacher teacher, WorkloadType workloadType) {
        this.discipline = discipline;
        this.teacher = teacher;
        this.workloadType = workloadType;
        this.hours = discipline.getHours();
    }

    @Override
    public String toString() {
        return "Workload{"
                + "discipline=" + discipline
                + ", teacher=" + teacher
                + ", workloadType=" + workloadType
                + ", hours=" + hours
                + '}';
    }

    @Override
    public String toStringFormat() {
        return "Workload: " + System.lineSeparator()
                + discipline.toStringFormat() + System.lineSeparator()
                + teacher.toStringFormat() + System.lineSeparator()
                + String.format("Workload type: %s", workloadType.name());
    }

    public enum WorkloadType {
        LECTURES,
        SEMINARS,
        LABORATORY_WORKS
    }
}
