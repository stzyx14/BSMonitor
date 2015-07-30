package gmcc.bsmonitor.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import gmcc.bsmonitor.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private SeekBar mSeekBar;
    private Switch mSwitch;
    private TextView mTextView_UpdateTimes;
    private TextView mTextView_UpdateTimes_label;

    private LinearLayout mLayout_SetUpdateTimes;

    private GISFragment mGISFragment;
    private ListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListenner();

        setupViewPager();

    }

    /**
     * 各种监听器配置方法
     */
    private void initListenner() {

        /**
         * 更新频率的拖动bar监听器
         */
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTextView_UpdateTimes.setText(i + "s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * 更新开关的监听器
         */
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    //此处写开关打开的操作
                    Log.i("TOASTE", "----->switch is on");
                    setUpdateTimesEnable(true);
                } else {
                    //此处写开关关闭的操作
                    Log.i("TOASTE", "----->switch is off");
                    setUpdateTimesEnable(false);
                }
            }
        });

    }

    private void setUpdateTimesEnable(boolean enable) {
        if (enable){
            mTextView_UpdateTimes.setTextAppearance(getApplicationContext(), R.style.PrimaryText_Black_87);
            mTextView_UpdateTimes_label.setTextAppearance(getApplicationContext(), R.style.PrimaryText_Black_87);
            mSeekBar.setEnabled(true);
        }else {
            mTextView_UpdateTimes.setTextColor(getResources().getColor(R.color.BS_Text_Black_26));
            mTextView_UpdateTimes_label.setTextColor(getResources().getColor(R.color.BS_Text_Black_26));
            mSeekBar.setEnabled(false);
        }

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mSeekBar = (SeekBar) findViewById(R.id.sb_UpdateTimes);
        mSwitch = (Switch) findViewById(R.id.switch_IsOnTime);

        mTextView_UpdateTimes = (TextView) findViewById(R.id.tv_UpdateTimes);
        mTextView_UpdateTimes_label = (TextView) findViewById(R.id.tv_UpdateTimes_label);
        mLayout_SetUpdateTimes = (LinearLayout) findViewById(R.id.ll_set_update_times);

        setUpdateTimesEnable(mSwitch.isChecked());
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        List<String> tabLabels = new ArrayList<String>();
        tabLabels.add("GIS");
        tabLabels.add("列表");

        mTabLayout.addTab(mTabLayout.newTab().setText(tabLabels.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabLabels.get(1)));

        List<Fragment> fragments = new ArrayList<>();
        mGISFragment = GISFragment.newInstance(null, null);
        mListFragment = ListFragment.newInstance(null, null);
        fragments.add(mGISFragment);
        fragments.add(mListFragment);

        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments, tabLabels);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);

    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}
