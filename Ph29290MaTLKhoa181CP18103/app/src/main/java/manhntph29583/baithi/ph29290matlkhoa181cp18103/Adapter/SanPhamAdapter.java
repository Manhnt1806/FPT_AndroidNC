package manhntph29583.baithi.ph29290matlkhoa181cp18103.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.ph29290matlkhoa181cp18103.Model.SanPham;
import manhntph29583.baithi.ph29290matlkhoa181cp18103.R;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private List<SanPham> list =new ArrayList<>();

    public SanPhamAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder{
        private TextView tvMaSanPham,tvTenSanPham,tvMaTheLoai;

        public ViewHolder() {
        }
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.sanpham_item,null);
            viewHolder.tvMaSanPham = convertView.findViewById(R.id.tvMaSP);
            viewHolder.tvTenSanPham = convertView.findViewById(R.id.tvTenSP);
            viewHolder.tvMaTheLoai = convertView.findViewById(R.id.tvMaLoai);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tvMaSanPham.setText("Mã sản phẩm: "+list.get(position).getMaSanPham());
        viewHolder.tvTenSanPham.setText("Tên sản phẩm: "+list.get(position).getTenSanPham());
        viewHolder.tvMaTheLoai.setText("Mã loại sản phẩm: "+list.get(position).getMaTheLoai());
        return convertView;
    }
}
