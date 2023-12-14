package manhntph29583.baithi.myasm_nc.MainCourse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import manhntph29583.baithi.myasm_nc.MainCourse.DAO.mDAO;
import manhntph29583.baithi.myasm_nc.MainCourse.DTO.mObject;
import manhntph29583.baithi.myasm_nc.MainCourse.mAdapter.mAdapter;
import manhntph29583.baithi.myasm_nc.R;

public class FragMyCourse extends Fragment {
    RecyclerView rcv;
    mDAO dao;
    ArrayList<mObject> list = new ArrayList<>();
    mAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragmycourse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = view.findViewById(R.id.rcv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        dao = new mDAO(getContext());
        list = dao.getAll();
        adapter = new mAdapter(getContext(), list);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
