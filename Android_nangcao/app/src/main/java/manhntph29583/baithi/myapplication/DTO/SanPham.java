package manhntph29583.baithi.myapplication.DTO;

public class SanPham {
    int maSanPham;
    String tenSanPham;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }

    public SanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
}
