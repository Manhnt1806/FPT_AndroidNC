package manhntph29583.baithi.myasm_nc.MainCourse.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "table", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE class(id integer NOT NULL PRIMARY KEY AUTOINCREMENT, kiHoc TEXT NOT NULL," +
                " monHoc TEXT NOT NULL, ngayHoc Date NOT NULL, ngayThi Date NOT NULL, lopHoc TEXT NOT NULL )";
        db.execSQL(sql);
        sql = "INSERT INTO class VALUES(null, 'Summer 2023', 'Android cb', 01/01/2023, 14/02/2023, 'CP18103')";
        db.execSQL(sql);
        sql = "INSERT INTO class VALUES(null, 'Fall 2023', 'Android nc', 01/04/2023, 14/05/2023, 'CP18104')";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS class");
        onCreate(db);

    }
}
