package manhntph29583.baithi.ph29290matlkhoa181cp18103.Model;

public class HoaDon {
    private int IDHoaDon;
    private String ngayNhap;
    private String ngayXuat;

    public HoaDon() {
    }

    public HoaDon(int IDHoaDon, String ngayNhap, String ngayXuat) {
        this.IDHoaDon = IDHoaDon;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
}
