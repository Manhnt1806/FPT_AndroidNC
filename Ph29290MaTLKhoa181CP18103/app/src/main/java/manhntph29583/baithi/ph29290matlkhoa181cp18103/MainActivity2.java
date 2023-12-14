package manhntph29583.baithi.ph29290matlkhoa181cp18103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.ph29290matlkhoa181cp18103.Adapter.SanPhamAdapter;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.DAO.BaiThiDAO;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.SanPham;

public class MainActivity2 extends AppCompatActivity {

    List<SanPham> list = new ArrayList<>();
    BaiThiDAO dao;
    ListView lv;
    Context context = this;
    SanPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);
        dao = new BaiThiDAO(context);

        list = dao.getAll();
        adapter = new SanPhamAdapter(context,list);
        lv.setAdapter(adapter);
    }
}