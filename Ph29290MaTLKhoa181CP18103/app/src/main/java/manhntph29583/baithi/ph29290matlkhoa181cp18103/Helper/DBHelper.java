package manhntph29583.baithi.ph29290matlkhoa181cp18103.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "QLSP";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTheLoai = "CREATE TABLE theLoai(maTheLoai TEXT PRIMARY KEY)";
        db.execSQL(createTableTheLoai);
        String createTableSanPham = "CREATE TABLE sanPham(maSanPham TEXT PRIMARY KEY,tenSanPham TEXT NOT NULL, maTheLoai TEXT REFERENCES theLoai(maTheLoai))";
        db.execSQL(createTableSanPham);
        String createTableHoaDon = "CREATE TABLE hoaDon(maHoaDon INTEGER PRIMARY KEY AUTOINCREMENT, ngayNhap TEXT NOT NULL, ngayXuat TEXT NOT NULL)";
        db.execSQL(createTableHoaDon);
        String createTableHoaDonChiTiet = "CREATE TABLE hoaDonChiTiet(maHoaDonChiTiet INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maHoaDon INTEGER REFERENCES hoaDon(maHoaDon), maSanPham TEXT REFERENCES sanPham(maSanPham)," +
                "soLuongNhap INTEGER NOT NULL, soLuongXuat INTEGER NOT NULL, giaNhap LONG NOT NULL, giaXuat LONG NOT NULL)";
        db.execSQL(createTableHoaDonChiTiet);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
