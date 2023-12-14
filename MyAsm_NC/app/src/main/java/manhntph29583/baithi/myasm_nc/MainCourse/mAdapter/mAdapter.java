package manhntph29583.baithi.myasm_nc.MainCourse.mAdapter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import manhntph29583.baithi.myasm_nc.MainCourse.DAO.mDAO;
import manhntph29583.baithi.myasm_nc.MainCourse.DTO.mObject;
import manhntph29583.baithi.myasm_nc.R;

public class mAdapter extends RecyclerView.Adapter<mAdapter.mAdapterViewHolder>  {
    Context context;
    ArrayList<mObject> list;
    mDAO dao;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public mAdapter(Context context, ArrayList<mObject> list) {
        this.context = context;
        this.list = list;
        dao = new mDAO(context);
    }
    @NonNull
    @Override
    public mAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_course, parent, false);
        mAdapterViewHolder viewHolder = new mAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mAdapter.mAdapterViewHolder holder, int position) {
        mObject kc = list.get(position);
        holder.tvmonHoc.setText(kc.getMonHoc());
        holder.tvtenLop.setText(kc.getLopHoc());
        holder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setTitle("Bạn có chắc muốn xóa?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dao.deleteRow(kc.getId())){
                            Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(dao.getAll());
                            notifyDataSetChanged();
                            dialogInterface.dismiss();
                        }else{
                            Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                view = inflater.inflate(R.layout.dialog_chi_tiet, null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();

                TextView tvKiHoc = view.findViewById(R.id.tv_ud_kiHoc);
                TextView tvMonHoc = view.findViewById(R.id.tv_ud_monHoc);
                TextView tvNgayHoc = view.findViewById(R.id.tv_ud_ngayHoc);
                TextView tvNgayThi = view.findViewById(R.id.tv_ud_ngayThi);
                TextView tvLopHoc = view.findViewById(R.id.tv_ud_lopHoc);
                ImageView btnBack = view.findViewById(R.id.btn_back_ct);
                Button btnEdit = view.findViewById(R.id.btn_edit);
                tvKiHoc.setText(kc.getKiHoc());
                tvMonHoc.setText(kc.getMonHoc());
                tvNgayHoc.setText(simpleDateFormat.format(kc.getNgayHoc()));
                tvNgayThi.setText(simpleDateFormat.format(kc.getNgayThi()));
                tvLopHoc.setText(kc.getLopHoc());
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                        view = inflater.inflate(R.layout.layout_fragdangky, null);
                        builder.setView(view);
                        Dialog dialog = builder.create();
                        dialog.show();

                        TextView tvDK = view.findViewById(R.id.tv_Dk);
                        TextInputLayout inputKiHoc = view.findViewById(R.id.input_edit_kyhoc);
                        TextInputLayout inputMonHoc = view.findViewById(R.id.input_edit_monhoc);
                        TextInputLayout inputNgayHoc = view.findViewById(R.id.input_edit_lichhoc);
                        TextInputLayout inputNgayThi = view.findViewById(R.id.input_edit_lichthi);
                        TextInputLayout inputLopHoc = view.findViewById(R.id.input_edit_lophoc);
                        Button btnSignIn = view.findViewById(R.id.btn_dangky);

                        tvDK.setText("Chỉnh sửa");
                        inputKiHoc.getEditText().setText(kc.getKiHoc());
                        inputMonHoc.getEditText().setText(kc.getMonHoc());
                        inputNgayHoc.getEditText().setText(simpleDateFormat.format(kc.getNgayHoc()));
                        inputNgayThi.getEditText().setText(simpleDateFormat.format(kc.getNgayThi()));
                        inputLopHoc.getEditText().setText(kc.getLopHoc());
                        inputNgayHoc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTimeInMillis(System.currentTimeMillis());
                                DatePickerDialog dialog = new DatePickerDialog(context,
                                        new DatePickerDialog.OnDateSetListener() {
                                            @Override
                                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                                int nam = i;
                                                int thang = i1;
                                                int ngay = i2;
                                                inputNgayHoc.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                                            }
                                        },
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DATE)
                                );
                                dialog.show();
                            }
                        });
                        inputNgayThi.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTimeInMillis(System.currentTimeMillis());
                                DatePickerDialog dialog = new DatePickerDialog(context,
                                        new DatePickerDialog.OnDateSetListener() {
                                            @Override
                                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                                int nam = i;
                                                int thang = i1;
                                                int ngay = i2;
                                                inputNgayThi.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                                            }
                                        },
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DATE)
                                );
                                dialog.show();
                            }
                        });
                        btnSignIn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                kc.setKiHoc(inputKiHoc.getEditText().getText().toString());
                                kc.setMonHoc(inputMonHoc.getEditText().getText().toString());
                                try {
                                    kc.setNgayThi(simpleDateFormat.parse(inputNgayThi.getEditText().getText().toString()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    kc.setNgayHoc(simpleDateFormat.parse(inputNgayHoc.getEditText().getText().toString()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                kc.setLopHoc(inputLopHoc.getEditText().getText().toString());
                                if (dao.updateRow(kc)) {
                                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    list.clear();
                                    list.addAll(dao.getAll());
                                    notifyDataSetChanged();

                                    tvKiHoc.setText(kc.getKiHoc());
                                    tvMonHoc.setText(kc.getMonHoc());
                                    tvNgayHoc.setText(simpleDateFormat.format(kc.getNgayHoc()));
                                    tvNgayHoc.setText(simpleDateFormat.format(kc.getNgayThi()));
                                    tvLopHoc.setText(kc.getLopHoc());
                                }else{
                                    Toast.makeText(context, "Update thất bại", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvtenLop, tvmonHoc;
        ImageView imgDel;
        CardView cardview;
        public mAdapterViewHolder(View view) {
            super(view);
            tvtenLop = view.findViewById(R.id.ten_lop);
            tvmonHoc = view.findViewById(R.id.Ten_monHoc);
            imgDel = view.findViewById(R.id.imgDel);
            cardview = view.findViewById(R.id.cardview_khoan_thu);
        }
    }
}
