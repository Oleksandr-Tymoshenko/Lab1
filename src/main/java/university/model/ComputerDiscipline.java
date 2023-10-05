package university.model;

import java.io.Serializable;
import university.service.out.FormatPrintable;

public class ComputerDiscipline extends Discipline implements FormatPrintable, Serializable {
    private int machineTime;
    private String baseProductName;

    public ComputerDiscipline() {
    }

    public ComputerDiscipline(String name, int hours, ControlForm controlForm, int machineTime,
                              String baseProductName) {
        super(name, hours, controlForm);
        this.machineTime = machineTime;
        this.baseProductName = baseProductName;
    }

    public int getMachineTime() {
        return machineTime;
    }

    public void setMachineTime(int machineTime) {
        this.machineTime = machineTime;
    }

    public String getBaseProductName() {
        return baseProductName;
    }

    public void setBaseProductName(String baseProductName) {
        this.baseProductName = baseProductName;
    }

    @Override
    public String toString() {
        return super.toString()
                + "machineTime=" + machineTime
                + ", baseProductName=" + baseProductName
                + '}';
    }

    @Override
    public String toStringFormat() {
        return super.toStringFormat() + String.format(" Machine time: %s, Base product name: %s",
                machineTime, baseProductName);
    }
}
