package manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Helper.DBHelper;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model.HoaDon;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model.HoaDonChiTiet;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model.SanPham;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model.TheLoai;

public class BaiThiDAO {

    SQLiteDatabase db;

    public BaiThiDAO (Context context){
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    //InsertTheLoai

    public long insertTheLoai(TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("maTheLoai",theLoai.getMaTheLoai());
        return db.insert("theLoai",null,values);
    }

    //InsertSanPham

    public long insertSanPham(SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put("maSanPham",sanPham.getMaSanPham());
        values.put("tenSanPham",sanPham.getTenSanPham());
        values.put("nam",sanPham.getNam());
        values.put("maTheLoai",sanPham.getMaTheLoai());
        return db.insert("sanPham",null,values);
    }

    // GetSanPham
    public List<SanPham> getAll(){
        String sql = "SELECT * FROM sanPham";
        return getList(sql);
    }
    public List<SanPham> getID(String id){
        String sql = "SELECT * FROM sanPham Where maSanPham = ?";
        return getList(sql, id);
    }

    @SuppressLint("Range")
    public List<SanPham> getList(String sql, String...SelectArgs){
        List<SanPham> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArgs);
        while (c.moveToNext()){
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(c.getString(c.getColumnIndex("maSanPham")));
            sanPham.setTenSanPham(c.getString(c.getColumnIndex("tenSanPham")));
            sanPham.setMaTheLoai(c.getString(c.getColumnIndex("maTheLoai")));
            list.add(sanPham);
        }
        return list;
    }

    //InsertSanPham

    public long insertHoaDon(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("ngayNhap",hoaDon.getNgayNhap());
        values.put("ngayXuat",hoaDon.getNgayXuat());
        return db.insert("hoaDon",null,values);
    }

    //InsertSanPham

    public long insertHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",hoaDonChiTiet.getIDHoaDon());
        values.put("maSanPham",hoaDonChiTiet.getIDSanPham());
        values.put("soLuongNhap",hoaDonChiTiet.getSoLuongNhap());
        values.put("soLuongXuat",hoaDonChiTiet.getSoLuongXuat());
        values.put("giaNhap",hoaDonChiTiet.getGiaNhap());
        values.put("giaXuat",hoaDonChiTiet.getGiaXuat());
        return db.insert("hoaDonChiTiet",null,values);
    }
}
