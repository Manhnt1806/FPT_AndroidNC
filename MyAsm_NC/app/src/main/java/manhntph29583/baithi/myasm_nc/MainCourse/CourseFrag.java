package manhntph29583.baithi.myasm_nc.MainCourse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import manhntph29583.baithi.myasm_nc.R;

public class CourseFrag extends Fragment {
    ViewPager2 viewPager2;
    PagerCourseAdapter adapter;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_course_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.pager_Course);
        tabLayout = view.findViewById(R.id.tab_Course);
        adapter = new PagerCourseAdapter(this);
        viewPager2.setAdapter(adapter);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("My Course");
                        break;
                    case 1:
                        tab.setText("Sign in");
                        break;
                }
            }
        });
        mediator.attach();
    }
}
