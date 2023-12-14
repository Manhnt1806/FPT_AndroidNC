package manhntph29583.baithi.myasm_nc.MainCourse.DTO;

import java.util.Date;

public class mObject {
    int id;
    String kiHoc;
    String monHoc;
    Date ngayHoc;
    Date ngayThi;
    String lopHoc;

    public mObject() {
    }

    public mObject(String kiHoc, String monHoc, Date ngayHoc, Date ngayThi, String lopHoc) {
        this.kiHoc = kiHoc;
        this.monHoc = monHoc;
        this.ngayHoc = ngayHoc;
        this.ngayThi = ngayThi;
        this.lopHoc = lopHoc;
    }

    public mObject(int id, String kiHoc, String monHoc, Date ngayHoc, Date ngayThi, String lopHoc) {
        this.id = id;
        this.kiHoc = kiHoc;
        this.monHoc = monHoc;
        this.ngayHoc = ngayHoc;
        this.ngayThi = ngayThi;
        this.lopHoc = lopHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }
}
