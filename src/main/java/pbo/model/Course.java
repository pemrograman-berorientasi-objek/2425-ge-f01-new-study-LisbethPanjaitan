package pbo.model;

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
    public void setKode(String kode) { this.kode = kode; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    public int getKredit() { return kredit; }
    public void setKredit(int kredit) { this.kredit = kredit; }
}