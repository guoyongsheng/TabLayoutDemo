package xmen.doshr.com.tablayoutdemo;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.Gravity;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import xmen.doshr.com.tablayoutdemo.adapter.ContentAdapter;
import xmen.doshr.com.tablayoutdemo.fragment.ContentFragment;

/**
 * tablayout测试
 */
public class MainActivity extends FragmentActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ContentAdapter contentAdapter;
    private List<Fragment> list = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();

    private DrawerLayout drawerLayout;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    //初始化view
    private void initView()
    {
        initTitle();
        tabLayout = (TabLayout) findViewById(R.id.taglayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        contentAdapter = new ContentAdapter(getSupportFragmentManager(), getListFragment(), listTitle, this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        relativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
        viewPager.setAdapter(contentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        Point point = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(point);
        int screeWidth = point.x;
        int width = (int) (screeWidth * (3.0 / 4));
        DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(width, DrawerLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.START;
        relativeLayout.setLayoutParams(params);
    }


    //获取listfragment
    private List<Fragment> getListFragment()
    {
        int size = listTitle.size();
        for (int i = 0; i < size; i++)
        {
            ContentFragment contentFragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", listTitle.get(i));
            contentFragment.setArguments(bundle);
            list.add(contentFragment);
        }

        return list;
    }

    //初始化标题
    private void initTitle()
    {
        for (int i = 0; i < 12; i++)
        {
            listTitle.add("标题" + i);
        }
    }
}
