package manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String nam;
    private String maTheLoai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String nam, String maTheLoai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.nam = nam;
        this.maTheLoai = maTheLoai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
}
