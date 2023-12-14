package manhntph29583.baithi.ph29290matlkhoa181cp18103.Model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String maTheLoai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String maTheLoai) {
        this.maSanPham = maSanPham;
        this.maTheLoai = maTheLoai;
        this.tenSanPham = tenSanPham;
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

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
}
