package manhntph29583.baithi.ph29290matlkhoa181cp18103.Model;

public class HoaDonChiTiet {
    private int IDHoaDonChiTiet;
    private int IDHoaDon;
    private String IDSanPham;
    private int soLuongNhap;
    private int soLuongXuat;
    private double giaNhap;
    private double giaXuat;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IDHoaDonChiTiet, int IDHoaDon, String IDSanPham, int soLuongNhap, int soLuongXuat, double giaNhap, double giaXuat) {
        this.IDHoaDonChiTiet = IDHoaDonChiTiet;
        this.IDHoaDon = IDHoaDon;
        this.IDSanPham = IDSanPham;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
    }

    public int getIDHoaDonChiTiet() {
        return IDHoaDonChiTiet;
    }

    public void setIDHoaDonChiTiet(int IDHoaDonChiTiet) {
        this.IDHoaDonChiTiet = IDHoaDonChiTiet;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public String getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(String IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }
}
