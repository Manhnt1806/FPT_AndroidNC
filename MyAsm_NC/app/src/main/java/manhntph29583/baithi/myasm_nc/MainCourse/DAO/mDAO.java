package manhntph29583.baithi.myasm_nc.MainCourse.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import manhntph29583.baithi.myasm_nc.MainCourse.DTO.mObject;
import manhntph29583.baithi.myasm_nc.MainCourse.DataBase.DbHelper;

public class mDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public mDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    public ArrayList<mObject> getAll() {
        ArrayList<mObject> listKC = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM class ORDER BY id ASC";
        Cursor cs = db.rawQuery(sql, null);
        if (cs.getCount() > 0) {
            cs.moveToFirst();
            do {
                int id = cs.getInt(0);
                String _kiHoc = cs.getString(1);
                String _monHoc = cs.getString(2);
                Date _ngayHoc = new Date(System.currentTimeMillis());
                try {
                    _ngayHoc = sdf.parse(cs.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date _ngayThi = new Date(System.currentTimeMillis());
                try {
                    _ngayThi = sdf.parse(cs.getString(4));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String _lopHoc = cs.getString(5);
                listKC.add(new mObject(id, _kiHoc, _monHoc, _ngayHoc, _ngayThi, _lopHoc));
            } while (cs.moveToNext());
        }
        cs.close();
        db.close();
        return listKC;
    }

    public boolean insertRow(mObject objKhoanchi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kiHoc", objKhoanchi.getKiHoc());
        values.put("monHoc", objKhoanchi.getMonHoc());
        values.put("ngayHoc", sdf.format(objKhoanchi.getNgayHoc()));
        values.put("ngayThi", sdf.format(objKhoanchi.getNgayThi()));
        values.put("lopHoc", objKhoanchi.getLopHoc());
        long row = db.insert("class", null, values);
        return (row > 0);
    }

    public boolean updateRow(mObject objKhoanchi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kiHoc", objKhoanchi.getKiHoc());
        values.put("monHoc", objKhoanchi.getMonHoc());
        values.put("ngayHoc", sdf.format(objKhoanchi.getNgayHoc()));
        values.put("ngayThi", sdf.format(objKhoanchi.getNgayThi()));
        values.put("lopHoc", objKhoanchi.getLopHoc());
        String[] tham_so = new String[]{objKhoanchi.getId() + ""};
        int row = db.update("class", values, "id = ?", tham_so);
        return (row > 0);
    }

    public boolean deleteRow(int objKhoanchi) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] tham_so = new String[]{objKhoanchi + ""};
        int row = db.delete("class", "id=?", tham_so);
        return (row > 0);
    }

}
