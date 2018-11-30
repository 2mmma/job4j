package ru.job4j.profession;

/**
 * Наследование на примере профессий
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 11.2018
 */

public class Profession {
    private String name;
    private String profession;

    public String getName() {
        return name;
    }

    public class Doctor extends Profession {
        private String diagnose;
        public String treatPatient(Patient patient) {
            return(diagnose);
        }
    }

    public class Engineer extends Profession {
        private String house;
        public String buildBuilding(Building building) {
            return(house);
        }
    }

    public class Teacher extends Profession {
        private String marks;
        public String teachStudent(Student student) {
            return(marks);
        }
    }

    public class Patient { private String name; }

    public class Building { private String name; }

    public class Student { private String name; }
}