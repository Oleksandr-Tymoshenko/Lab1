package university.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import university.service.out.FormatPrintable;

public class Workload implements FormatPrintable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Discipline discipline;
    private Teacher teacher;
    private WorkloadType workloadType;
    private int hours;

    public Workload() {
    }

    public Workload(Discipline discipline, Teacher teacher, WorkloadType workloadType) {
        this.discipline = discipline;
        this.teacher = teacher;
        this.workloadType = workloadType;
        this.hours = discipline.getHours();
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public WorkloadType getWorkloadType() {
        return workloadType;
    }

    public void setWorkloadType(WorkloadType workloadType) {
        this.workloadType = workloadType;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos)
            throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(discipline);
        oos.writeObject(teacher);
    }

    @Serial
    private void readObject(ObjectInputStream ois)
            throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        discipline = (Discipline) ois.readObject();
        teacher = (Teacher) ois.readObject();
    }

    @Override
    public String toString() {
        return "Workload{"
                + discipline
                + "\n" + teacher
                + "\nworkloadType=" + workloadType
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
