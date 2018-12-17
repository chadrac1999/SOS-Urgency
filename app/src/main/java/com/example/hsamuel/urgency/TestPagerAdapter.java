package com.example.hsamuel.urgency;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chadrac on 11/28/18.
 */

public class TestPagerAdapter extends PagerAdapter{

    Context context;
    List<PagerModel> pagerArr;
    LayoutInflater inflater;

    public TestPagerAdapter(Context context, List<PagerModel> pagerArr){
        this.context = context;
        this.pagerArr = pagerArr;

        inflater = ((Activity) context).getLayoutInflater();
    }

    @Override
    public int getCount() {
        return pagerArr.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.view_indicator, container, false);

        TextView tv = (TextView) view.findViewById(R.id.tv);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView etape = (TextView) view.findViewById(R.id.etape);
        ImageView img = (ImageView) view.findViewById(R.id.image);

        view.setTag(position);

        ((ViewPager) container).addView(view);

        PagerModel model = pagerArr.get(position);

        tv.setText(model.getTitle());
        etape.setText(model.getEtape());
        description.setText(model.getDescription());
        img.setImageResource(model.getImg());

        return view;

    }

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView((View) object);
    }
}
