package manhntph29583.baithi.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "crub_thi_thu";
    static final int DB_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tb_theloai(maLoai TEXT NOT NULL PRIMARY KEY)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_theloai VALUES('Đồ ăn')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_theloai VALUES('Gia dụng')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_sanpham(maSanPham INTEGER NOT NULL PRIMARY KEY, tenSanPham TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_sanpham VALUES(null, 'Gạo')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_sanpham VALUES(null, 'Chổi')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_hoadonCT(maHoaDonCT INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, maSanPham INTEGER NOT NULL, soLuongNhap INTEGER NOT NULL, soLuongXuat INTEGER NOT NULL," +
                "donGiaNhap INTEGER NOT NULL, donGiaXuat INTEGER NOT NULL, ngayNhap DATE NOT NULL, ngayXuat DATE NOT NULL)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_hoadonCT VALUES(null, 'Gạo', 5, 3, 2000, 3000, '11/11/1982', '18/06/2003')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_hoadonCT VALUES(null, 'Gạo', 5, 3, 2000, 3000, '11/11/1982', '18/06/2003')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_hoadon(maHD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, maSanPham INTEGER NOT NULL, donGiaNhap INTEGER NOT NULL, donGiaXuat INTEGER NOT NULL )";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_hoadon VALUES(null, 1, 5, 3)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_hoadon VALUES(null, 2, 5, 3)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_loaithu");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_loaichi");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_khoanthu");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_khoanchi");
        onCreate(sqLiteDatabase);
    }
}
