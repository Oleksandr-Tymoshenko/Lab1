package university.model;

import java.io.Serializable;
import university.service.out.FormatPrintable;

public class Teacher implements FormatPrintable, Serializable {
    private long rollNumber;
    private String nameSurname;
    private Position position;

    public Teacher() {
    }

    public Teacher(long tabelNumber, String nameSurname, Position position) {
        this.rollNumber = tabelNumber;
        this.nameSurname = nameSurname;
        this.position = position;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public enum Position {
        PROFESSOR,
        ASSOCIATE,
        SENIOR,
        ASSISTANT
    }

    @Override
    public String toString() {
        return "Teacher{"
                + "rollNumber=" + rollNumber
                + ", nameSurname=" + nameSurname
                + ", position=" + position
                + '}';
    }

    @Override
    public String toStringFormat() {
        return String.format("Teacher %s - %s, Position: %s",
                rollNumber, nameSurname, position.name());
    }
}
