package manhntph29583.baithi.myasm_nc.MainCourse;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import manhntph29583.baithi.myasm_nc.MainCourse.DAO.mDAO;
import manhntph29583.baithi.myasm_nc.MainCourse.DTO.mObject;
import manhntph29583.baithi.myasm_nc.MainCourse.mAdapter.mAdapter;
import manhntph29583.baithi.myasm_nc.R;

public class FragDangKy extends Fragment {
    TextInputLayout tvKiHoc, tvMonHoc, tvNgayHoc, tvNgayThi, tvLopHoc;
    Button btnSignIn, btnHuyDK;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<mObject> list = new ArrayList<>();
    mDAO dao;
    mAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragdangky, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvKiHoc = view.findViewById(R.id.input_edit_kyhoc);
        tvMonHoc = view.findViewById(R.id.input_edit_monhoc);
        tvNgayHoc = view.findViewById(R.id.input_edit_lichhoc);
        tvNgayThi = view.findViewById(R.id.input_edit_lichthi);
        tvLopHoc = view.findViewById(R.id.input_edit_lophoc);
        btnSignIn = view.findViewById(R.id.btn_dangky);

        tvNgayHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int nam = i;
                                int thang = i1;
                                int ngay = i2;
                                tvNgayHoc.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                dialog.show();
            }

        });
        tvNgayThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int nam = i;
                                int thang = i1;
                                int ngay = i2;
                                tvNgayThi.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                dialog.show();
            }

        });
        dao = new mDAO(getContext());
        list = dao.getAll();
        adapter = new mAdapter(getContext(), list);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kiHoc = tvLopHoc.getEditText().getText().toString();
                String monHoc = tvMonHoc.getEditText().getText().toString();
                Date ngayHoc = null;
                try {
                    ngayHoc = sdf.parse(tvNgayHoc.getEditText().getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date ngayThi = null;
                try {
                    ngayThi = sdf.parse(tvNgayThi.getEditText().getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String tenLop = tvLopHoc.getEditText().getText().toString();
                mObject kt = new mObject(kiHoc, monHoc, ngayHoc, ngayThi, tenLop);
                if (dao.insertRow(kt)) {
                    list.clear();
                    list.addAll(dao.getAll());
                    adapter.notifyDataSetChanged();
                    tvKiHoc.getEditText().setText("");
                    tvMonHoc.getEditText().setText("");
                    tvNgayHoc.getEditText().setText("");
                    tvNgayThi.getEditText().setText("");
                    tvLopHoc.getEditText().setText("");
                    Toast.makeText(getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
