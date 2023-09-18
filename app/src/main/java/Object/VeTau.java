package Object;

public class VeTau {
    private String maVeTau, ngayDatVe, gioDatVe, loaiGhe;
    private int soGhe;
    private float giaVe;
    private User user;
    private ChuyenTau chuyenTau;

    public VeTau() {
    }

    public VeTau(String ngayDatVe, String gioDatVe, String loaiGhe, int soGhe, float giaVe, User user, ChuyenTau chuyenTau) {
        this.ngayDatVe = ngayDatVe;
        this.gioDatVe = gioDatVe;
        this.loaiGhe = loaiGhe;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
        this.user = user;
        this.chuyenTau = chuyenTau;
    }

    public String getMaVeTau() {
        return maVeTau;
    }

    public void setMaVeTau(String maVeTau) {
        this.maVeTau = maVeTau;
    }

    public String getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(String ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public String getGioDatVe() {
        return gioDatVe;
    }

    public void setGioDatVe(String gioDatVe) {
        this.gioDatVe = gioDatVe;
    }

    public String getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(String loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChuyenTau getChuyenTau() {
        return chuyenTau;
    }

    public void setChuyenTau(ChuyenTau chuyenTau) {
        this.chuyenTau = chuyenTau;
    }
}
