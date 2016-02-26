package robdich.com.introscreen;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import robdich.com.introscreen.adapter.IntroAdapter;
import robdich.com.introscreen.animation.IntroPageTransformer;

/**
 * Created by John Robert Dichoso on 2/26/2016.
 */
public class IntroActivity extends ActionBarActivity {

    private ViewPager mViewPager;

    int[] colors = new int [] { Color.parseColor("#03A9F4"),
            Color.parseColor("#4CAF50"), Color.parseColor("#FFEB3B")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro_layout);

        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // Set an Adapter on the ViewPager
        mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
        mViewPager.setPageTransformer(false, new IntroPageTransformer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position < (mViewPager.getAdapter().getCount() - 1) && position < (colors.length - 1)) {

                    mViewPager.setBackgroundColor((Integer) argbEvaluator
                            .evaluate(positionOffset, colors[position], colors[position + 1]));

                } else {
                    mViewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
