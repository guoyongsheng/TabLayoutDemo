package xmen.doshr.com.tablayoutdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by wesley on 2016/4/11.
 * 适配器
 */
public class ContentAdapter extends FragmentStatePagerAdapter
{
    private List<Fragment> listFragment;
    private List<String> listTitle;
    private Context context;
    public ContentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public ContentAdapter(FragmentManager fm, List<Fragment> listFragment, List<String> listTitle, Context context)
    {
        super(fm);
        this.listFragment = listFragment;
        this.listTitle = listTitle;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        if (listFragment != null && listFragment.size() > position)
        {
            return listFragment.get(position);
        }
        return null;
    }

    @Override
    public int getCount()
    {
        if (listFragment != null)
        {
            return listFragment.size();
        }
        return 0;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return listTitle.get(position);
    }
}
