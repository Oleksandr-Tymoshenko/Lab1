package university.service.in.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import university.model.ComputerDiscipline;
import university.model.Discipline;
import university.model.GeneralDiscipline;
import university.model.MathDiscipline;
import university.model.Teacher;
import university.model.Workload;
import university.service.in.WorkloadInput;

public class WorkloadTextFileInput implements WorkloadInput {
    private static final Map<String, Discipline> DISCIPLINE_MAP;
    private String fileName = "workloadData.txt";

    static {
        DISCIPLINE_MAP = new HashMap<>();
        DISCIPLINE_MAP.put("MathDiscipline", new MathDiscipline());
        DISCIPLINE_MAP.put("GeneralDiscipline", new GeneralDiscipline());
        DISCIPLINE_MAP.put("ComputerDiscipline", new ComputerDiscipline());
    }

    public WorkloadTextFileInput() {
    }

    public WorkloadTextFileInput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Workload load() {
        Workload workload = new Workload();
        try {
            String s = Files.readString(Path.of(fileName));
            List<String> list = Arrays.stream(s.split("\n"))
                    .map(str -> str.replace("Workload{", "")
                            .replace("Teacher{", "")
                            .replace("}", ""))
                    .toList();
            Discipline discipline = null;
            for (String line : list.get(0).split(", ")) {
                String[] splitLine = line.split("=");
                if (splitLine[0].equals("type")) {
                    discipline = DISCIPLINE_MAP.get(splitLine[1]);
                }
                if (discipline != null) {
                    if (splitLine[0].equals("name")) {
                        discipline.setName(splitLine[1]);
                        continue;
                    }
                    if (splitLine[0].equals("hours")) {
                        discipline.setHours(Integer.parseInt(splitLine[1]));
                        continue;
                    }
                    if (splitLine[0].equals("controlForm")) {
                        discipline.setControlForm(Discipline.ControlForm
                                .valueOf(splitLine[1].toUpperCase()));
                        continue;
                    }
                    if (discipline instanceof GeneralDiscipline) {
                        if (splitLine[0].equals("lecturesSeminarsRatio")) {
                            ((GeneralDiscipline) discipline)
                                    .setLecturesSeminarsRatio(Double
                                            .parseDouble(splitLine[1]
                                                    .replace(",", ".")));
                            continue;
                        }
                    }
                    if (discipline instanceof MathDiscipline) {
                        if (splitLine[0].equals("calculationTasksNumber")) {
                            ((MathDiscipline) discipline)
                                    .setCalculationTasksNumber(Integer
                                            .parseInt(splitLine[1]));
                            continue;
                        }
                    }
                    if (discipline instanceof ComputerDiscipline) {
                        if (splitLine[0].equals("machineTime")) {
                            ((ComputerDiscipline) discipline)
                                    .setMachineTime(Integer.parseInt(splitLine[1]));
                            continue;
                        }
                        if (splitLine[0].equals("baseProductName")) {
                            ((ComputerDiscipline) discipline)
                                    .setBaseProductName(splitLine[1]);
                        }
                    }
                }
            }
            workload.setDiscipline(discipline);
            Teacher teacher = new Teacher();
            for (String line : list.get(1).split(", ")) {
                String[] splitLine = line.split("=");
                if (splitLine[0].equals("rollNumber")) {
                    teacher.setRollNumber(Long.parseLong(splitLine[1]));
                    continue;
                }
                if (splitLine[0].equals("nameSurname")) {
                    teacher.setNameSurname(splitLine[1]);
                    continue;
                }
                if (splitLine[0].equals("position")) {
                    teacher.setPosition(Teacher.Position.valueOf(splitLine[1].toUpperCase()));
                }
            }
            workload.setTeacher(teacher);
            for (String line : list.get(2).split(", ")) {
                String[] splitLine = line.split("=");
                if (splitLine[0].equals("workloadType")) {
                    workload.setWorkloadType(Workload.WorkloadType
                            .valueOf(splitLine[1].toUpperCase()));
                    continue;
                }
                if (splitLine[0].equals("hours")) {
                    workload.setHours(Integer.parseInt(splitLine[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        return workload;
    }
}
