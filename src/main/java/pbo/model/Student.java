package pbo.model;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "nim", nullable = false, length = 20)
    private String nim;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "prodi", nullable = false, length = 100)
    private String prodi;

    public Student() {}

    public Student(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }
}