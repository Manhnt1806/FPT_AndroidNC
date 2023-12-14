package manhntph29583.baithi.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import manhntph29583.baithi.myapplication.DAO.SanPhamDAO;
import manhntph29583.baithi.myapplication.DTO.SanPham;
import manhntph29583.baithi.myapplication.mAdapter.SPadepter;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rcv;
    SanPhamDAO dao;
    ArrayList<SanPham> list = new ArrayList<>();
    SPadepter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rcv = findViewById(R.id.rcv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
        rcv.setLayoutManager(layoutManager);
        dao = new SanPhamDAO(MainActivity2.this);
        list = dao.getAll();
        adapter = new SPadepter(this, list);
        rcv.setAdapter(adapter);
    }
}