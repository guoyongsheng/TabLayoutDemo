package xmen.doshr.com.tablayoutdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xmen.doshr.com.tablayoutdemo.R;

/**
 * Created by wesley on 2016/4/11.
 */
public class ContentFragment extends Fragment
{
    private String title;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        title = bundle.getString("title");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.content, null);
        TextView textTitle = (TextView) view.findViewById(R.id.content);
        textTitle.setText(title);
        return view;
    }
}
