package manhntph29583.baithi.myapplication.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import manhntph29583.baithi.myapplication.DTO.SanPham;
import manhntph29583.baithi.myapplication.Database.DbHelper;

public class SanPhamDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public ArrayList<SanPham> getAll(){
        db = dbHelper.getReadableDatabase();
        ArrayList<SanPham> listLT = new ArrayList<>();
        Cursor cs = db.rawQuery("SELECT * FROM tb_sanpham ORDER BY maSanPham ASC", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int _id = cs.getInt(0);
            String _tenSP = cs.getString(1);
            SanPham lt = new SanPham(_id, _tenSP);
            listLT.add(lt);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return listLT;
    }
}
