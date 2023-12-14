package manhntph29583.baithi.myapplication.mAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manhntph29583.baithi.myapplication.DAO.SanPhamDAO;
import manhntph29583.baithi.myapplication.DTO.SanPham;
import manhntph29583.baithi.myapplication.R;

public class SPadepter extends RecyclerView.Adapter<SPadepter.SPViewHolder> {
    Context context;
    ArrayList<SanPham> list;
    SanPhamDAO dao;

    public SPadepter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
        dao = new SanPhamDAO(context);
    }
    @NonNull
    @Override
    public SPadepter.SPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.cardview_phanloai, parent, false);
        SPadepter.SPViewHolder viewHolder = new SPadepter.SPViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SPadepter.SPViewHolder holder, int position) {
        SanPham lc = list.get(position);
        holder.tvTenSP.setText(lc.getTenSanPham());
        holder.tvMaSP.setText(lc.getMaSanPham()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SPViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenSP, tvMaSP;
        public SPViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenSP = itemView.findViewById(R.id.tv_tenSp);
            tvMaSP = itemView.findViewById(R.id.tv_maSP);
        }
    }
}
