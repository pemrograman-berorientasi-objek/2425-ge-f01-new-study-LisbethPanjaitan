package pbo;

import javax.persistence.*;
import java.util.*;
import pbo.model.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("study_plan_pu");
        EntityManager em = factory.createEntityManager();

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            String[] arr = input.split("#");
            String cmd = arr[0];

            if (cmd.equals("student-add")) {
                String nim = arr[1], nama = arr[2], prodi = arr[3];
                List<Student> cek = em.createQuery("SELECT s FROM Student s WHERE s.nim = :nim", Student.class)
                        .setParameter("nim", nim).getResultList();
                if (cek.isEmpty()) {
                    em.getTransaction().begin();
                    em.persist(new Student(nim, nama, prodi));
                    em.getTransaction().commit();
                }
            } else if (cmd.equals("student-show-all")) {
                List<Student> list = em.createQuery("SELECT s FROM Student s ORDER BY s.nim ASC", Student.class).getResultList();
                for (Student s : list)
                    System.out.println(s.getNim() + "|" + s.getNama() + "|" + s.getProdi());
            } else if (cmd.equals("course-add")) {
                String kode = arr[1], nama = arr[2];
                int semester = Integer.parseInt(arr[3]);
                int kredit = Integer.parseInt(arr[4]);
                List<Course> cek = em.createQuery("SELECT c FROM Course c WHERE c.kode = :kode", Course.class)
                        .setParameter("kode", kode).getResultList();
                if (cek.isEmpty()) {
                    em.getTransaction().begin();
                    em.persist(new Course(kode, nama, semester, kredit));
                    em.getTransaction().commit();
                }
            } else if (cmd.equals("course-show-all")) {
                List<Course> list = em.createQuery("SELECT c FROM Course c ORDER BY c.semester ASC, c.kode ASC", Course.class).getResultList();
                for (Course c : list)
                    System.out.println(c.getKode() + "|" + c.getNama() + "|" + c.getSemester() + "|" + c.getKredit());
            } else if (cmd.equals("enroll")) {
                String nim = arr[1], kode = arr[2];
                List<Enrollment> cek = em.createQuery("SELECT e FROM Enrollment e WHERE e.nim = :nim AND e.kode = :kode", Enrollment.class)
                        .setParameter("nim", nim).setParameter("kode", kode).getResultList();
                if (cek.isEmpty()) {
                    em.getTransaction().begin();
                    em.persist(new Enrollment(nim, kode));
                    em.getTransaction().commit();
                }
            } else if (cmd.equals("student-show")) {
                String nim = arr[1];
                Student s = em.find(Student.class, nim);
                if (s != null) {
                    System.out.println(s.getNim() + "|" + s.getNama() + "|" + s.getProdi());
                    List<Enrollment> enrolls = em.createQuery("SELECT e FROM Enrollment e WHERE e.nim = :nim", Enrollment.class)
                            .setParameter("nim", nim).getResultList();
                    List<Course> courses = new ArrayList<>();
                    for (Enrollment e : enrolls) {
                        Course c = em.find(Course.class, e.getKode());
                        if (c != null) courses.add(c);
                    }
                    courses.sort(Comparator.comparingInt(Course::getSemester).thenComparing(Course::getKode));
                    for (Course c : courses)
                        System.out.println(c.getKode() + "|" + c.getNama() + "|" + c.getSemester() + "|" + c.getKredit());
                }
            }
        }
        em.close();
        factory.close();
        sc.close();
    }
}