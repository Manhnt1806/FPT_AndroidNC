package manhntph29583.baithi.myasm_nc.MainCourse;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerCourseAdapter extends FragmentStateAdapter {
    int slPageCourse = 2;
    public PagerCourseAdapter(@NonNull CourseFrag fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new FragMyCourse();
            case 1: return new FragDangKy();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return slPageCourse;
    }

}
