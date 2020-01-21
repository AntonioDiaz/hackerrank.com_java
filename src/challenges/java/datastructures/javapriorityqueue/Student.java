package challenges.java.datastructures.javapriorityqueue;

public class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private Double cgpa;

    public Student(Integer id, String name, Double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa.compareTo(o.cgpa)!=0) {
            return this.cgpa.compareTo(o.cgpa);
        } else if (this.name.compareTo(o.name)!=0) {
            return this.name.compareTo(o.name) * -1;
        }
        return this.id.compareTo(o.id) * -1;
    }
}
