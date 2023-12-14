package manhntph29583.baithi.manhntph29583_androidk173_2023cp18103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Adapter.SanPhamAdapter;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.DAO.BaiThiDAO;
import manhntph29583.baithi.manhntph29583_androidk173_2023cp18103.Model.SanPham;

public class MainActivity2 extends AppCompatActivity {

    List<SanPham> list = new ArrayList<>();
    BaiThiDAO dao;
    SanPham sp = new SanPham();
    ListView lv;
    Button btn33;
    EditText edNam;
    Context context = this;
    SanPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);
        edNam = findViewById(R.id.edNam2);
        btn33 = findViewById(R.id.button12);
        dao = new BaiThiDAO(context);
        list = dao.getAll();
        adapter = new SanPhamAdapter(context,list);
        lv.setAdapter(adapter);
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    list = dao.getID(edNam.getText().toString());
                    adapter = new SanPhamAdapter(context,list);
                    lv.setAdapter(adapter);
            }
        });
    }
}