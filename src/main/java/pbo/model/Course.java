package pbo.model;
/**
* author 
* 12S23041 - Lisbeth Panjaitan
* 12S23021 - Eunike Purba
*/

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name = "kode", nullable = false, length = 20)
    private String kode;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "kredit", nullable = false)
    private int kredit;

    public Course() {}

    public Course(String kode, String nama, int semester, int kredit) {
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.kredit = kredit;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSemester() { return semester; }
    public int getKredit() { return kredit; }
}