package br.liveo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import br.liveo.Model.HelpLiveo;
import br.liveo.fragment.CalenderFragment;
import br.liveo.fragment.HomeFragment;

import br.liveo.fragment.TestListPagerFragment;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.User;
import br.liveo.navigationliveo.NavigationLiveo;
import br.liveo.navigationviewpagerliveo.R;
import br.liveo.util.GeneralUtils;
import br.liveo.util.SharedPreferencesUtil;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {
    private HelpLiveo mHelpLiveo;
    private GeneralUtils generalUtils;
    public static final String MAIN_FRAGMENT_STACK = "MAIN";
    @Override
    public void onInt(Bundle bundle) {
        generalUtils = new GeneralUtils(this);
        User user = new SharedPreferencesUtil(this).getUser();
        this.userName.setText(user.getUsername());
        this.userEmail.setText(user.getEmail());
        this.userBackground.setImageResource(R.drawable.ic_profile_background);
        generalUtils.loadProfilePic(this.userPhoto, user.getPicUrl());

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.home), R.mipmap.ic_home_black_24dp);
        //mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.tests), R.mipmap.ic_tests_black_24dp, 7);
        mHelpLiveo.add(getString(R.string.reports), R.mipmap.ic_report_black_24dp);
        mHelpLiveo.add(getString(R.string.message), R.mipmap.ic_message_black_24dp, 200);
        mHelpLiveo.add(getString(R.string.calender), R.mipmap.ic_calendar_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.privacy_policy), R.mipmap.ic_privacy_black_24dp);
        mHelpLiveo.add(getString(R.string.help_and_support), R.mipmap.ic_help_black_24dp);

        with(this).startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .colorNameSubHeader(R.color.nliveo_green_colorPrimary)
                .colorItemSelected(R.color.nliveo_green_colorPrimary)
                .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();
        switch (position){
            case 0:
                mFragment = new HomeFragment();
                break;
            case 2:
                mFragment = new TestListPagerFragment();
                break;
            case 5:
                mFragment = new CalenderFragment();
                break;
            default:
                mFragment = new HomeFragment();
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }
        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };
}