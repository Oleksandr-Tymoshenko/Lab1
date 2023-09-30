package university;

import university.service.in.FormatPrintable;

public class ComputerDiscipline extends Discipline implements FormatPrintable {
    private final int machineTime;
    private final String baseProductName;

    public ComputerDiscipline(String name, int hours, ControlForm controlForm, int machineTime,
                              String baseProductName) {
        super(name, hours, controlForm);
        this.machineTime = machineTime;
        this.baseProductName = baseProductName;
    }

    @Override
    public String toString() {
        return super.toString() + "ComputerDiscipline{"
                + "machineTime=" + machineTime
                + ", baseProductName='" + baseProductName + '\''
                + '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Machine time: %s, Base product name: %s",
                machineTime, baseProductName);
    }
}
