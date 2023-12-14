package manhntph29583.baithi.ph29290matlkhoa181cp18103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.ph29290matlkhoa181cp18103.DAO.BaiThiDAO;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.HoaDon;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.HoaDonChiTiet;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.SanPham;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.TheLoai;

public class MainActivity extends AppCompatActivity {

    List<SanPham> list = new ArrayList<>();
    EditText edMaLoai,edMaSP,edTenSP,edSoLuongNhap,edSoLuongXuat,edDonGiaNhap,edDonGiaXuat,edNgayNhap,edNgayXuat;
    Button btn1,btn2,btn3,btn4;
    Context context = this;
    BaiThiDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMaLoai = findViewById(R.id.edMaLoai);
        edMaSP = findViewById(R.id.edMaSP);
        edTenSP = findViewById(R.id.edTenSP);
        edSoLuongNhap = findViewById(R.id.edSoLuongNhap);
        edSoLuongXuat = findViewById(R.id.edSoLuongXuat);
        edDonGiaNhap = findViewById(R.id.edDonGiaNhap);
        edDonGiaXuat = findViewById(R.id.edDonGiaXuat);
        edNgayNhap = findViewById(R.id.edNgayNhap);
        edNgayXuat = findViewById(R.id.edNgayXuat);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        dao = new BaiThiDAO(context);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()>0){
                    TheLoai theLoai = new TheLoai();
                    SanPham sanPham = new SanPham();
                    HoaDon hoaDon = new HoaDon();
                    HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

                    //The loai
                    theLoai.setMaTheLoai(edMaLoai.getText().toString());
                    //San pham
                    sanPham.setMaSanPham(edMaSP.getText().toString());
                    sanPham.setTenSanPham(edTenSP.getText().toString());
                    sanPham.setMaTheLoai(edMaLoai.getText().toString());
                    //Hoa don
                    hoaDon.setNgayNhap(edNgayNhap.getText().toString());
                    hoaDon.setNgayXuat(edNgayXuat.getText().toString());
                    //Hoa don chi tiet
                    hoaDonChiTiet.setIDHoaDon(hoaDon.getIDHoaDon());
                    hoaDonChiTiet.setIDSanPham(edMaSP.getText().toString());
                    hoaDonChiTiet.setSoLuongNhap(Integer.parseInt(edSoLuongNhap.getText().toString()));
                    hoaDonChiTiet.setSoLuongXuat(Integer.parseInt(edSoLuongXuat.getText().toString()));
                    hoaDonChiTiet.setGiaNhap(Double.parseDouble(edDonGiaNhap.getText().toString()));
                    hoaDonChiTiet.setGiaXuat(Double.parseDouble(edDonGiaXuat.getText().toString()));

                    if (dao.insertTheLoai(theLoai)>0&&
                    dao.insertSanPham(sanPham)>0&&
                    dao.insertHoaDon(hoaDon)>0&&
                    dao.insertHoaDonChiTiet(hoaDonChiTiet)>0){
                        Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "Thêm không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = dao.getAll();
                Toast.makeText(context, "Số lượng sản phẩm là: "+list.size(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public int validate(){
        int check = 1;
        if (edMaLoai.getText().toString().isEmpty()||
        edMaSP.getText().toString().isEmpty()||
        edTenSP.getText().toString().isEmpty()||
        edSoLuongNhap.getText().toString().isEmpty()||
        edSoLuongXuat.getText().toString().isEmpty()||
        edDonGiaNhap.getText().toString().isEmpty()||
        edDonGiaXuat.getText().toString().isEmpty()||
        edNgayXuat.getText().toString().isEmpty()||
        edNgayNhap.getText().toString().isEmpty()){
            Toast.makeText(this, "Dữ liệu không được để trống", Toast.LENGTH_SHORT).show();
            return check = -1;
        }
        return check;
    }
}