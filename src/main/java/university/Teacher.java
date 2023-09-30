package university;

import university.service.in.FormatPrintable;

public class Teacher implements FormatPrintable {
    private final long rollNumber;
    private final String nameSurname;
    private final Position position;

    public Teacher(long tabelNumber, String nameSurname, Position position) {
        this.rollNumber = tabelNumber;
        this.nameSurname = nameSurname;
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
                + ", nameSurname='" + nameSurname + '\''
                + ", position=" + position
                + '}';
    }

    @Override
    public String toStringFormat() {
        return String.format("Teacher %s - %s, Position: %s",
                rollNumber, nameSurname, position.name());
    }
}
