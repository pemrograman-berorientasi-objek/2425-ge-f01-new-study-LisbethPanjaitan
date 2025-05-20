package pbo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Enrollment")
@IdClass(Enrollment.EnrollmentId.class)
public class Enrollment {
    @Id
    @Column(name = "nim", nullable = false, length = 20)
    private String nim;

    @Id
    @Column(name = "kode", nullable = false, length = 20)
    private String kode;

    public Enrollment() {}

    public Enrollment(String nim, String kode) {
        this.nim = nim;
        this.kode = kode;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public static class EnrollmentId implements Serializable {
        private String nim;
        private String kode;

        public EnrollmentId() {}

        public EnrollmentId(String nim, String kode) {
            this.nim = nim;
            this.kode = kode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EnrollmentId)) return false;
            EnrollmentId that = (EnrollmentId) o;
            return Objects.equals(nim, that.nim) && Objects.equals(kode, that.kode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nim, kode);
        }
    }
}