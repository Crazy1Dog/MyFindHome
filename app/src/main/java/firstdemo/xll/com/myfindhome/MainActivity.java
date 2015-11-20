package firstdemo.xll.com.myfindhome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import firstdemo.xll.com.myfindhome.fragments.DiscoverFragment;
import firstdemo.xll.com.myfindhome.fragments.HomeFragment;
import firstdemo.xll.com.myfindhome.fragments.MessageFragment;
import firstdemo.xll.com.myfindhome.fragments.MineFragment;

public class MainActivity extends ActionBarActivity {
    @ViewInject(R.id.rg_main)
    private RadioGroup radioGroup;
    @ViewInject(R.id.rb_home)
    private RadioButton homeButton;
    @ViewInject(R.id.rb_discover)
    private RadioButton discoverButton;
    @ViewInject(R.id.rb_message)
    private RadioButton messageButton;
    @ViewInject(R.id.rb_mine)
    private RadioButton mineButton;
    private RadioButton lastButton;
    private Fragment lastFragment;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment homeFragment = new HomeFragment();
        transaction.add(R.id.ll_fragment, homeFragment, "homeFragment")
                .commit();
        lastFragment = homeFragment;
        homeButton.setChecked(true);
        lastButton = homeButton;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                RadioButton currentButton = (RadioButton) findViewById(checkedId);
                switch (checkedId) {
                    case R.id.rb_home:
                        lastButton.setChecked(false);
                        currentButton.setChecked(true);
                        lastButton = currentButton;
                        fragmentManager.beginTransaction().hide(lastFragment).commit();
                        Fragment homeFragment = fragmentManager.findFragmentByTag("homeFragment");
                        fragmentManager.beginTransaction().show(homeFragment).commit();
                        lastFragment = homeFragment;
                        break;
                    case R.id.rb_discover:
                        lastButton.setChecked(false);
                        currentButton.setChecked(true);
                        lastButton = currentButton;
                        fragmentManager.beginTransaction().hide(lastFragment).commit();
                        Fragment discoverFragment = fragmentManager.findFragmentByTag("discoverFragment");
                        if (discoverFragment == null) {
                            discoverFragment = new DiscoverFragment();
                            fragmentManager.beginTransaction().add(R.id.ll_fragment, discoverFragment, "discoverFragment").commit();
                        } else {
                            fragmentManager.beginTransaction().show(discoverFragment).commit();
                        }
                        lastFragment = discoverFragment;
                        break;
                    case R.id.rb_message:
                        lastButton.setChecked(false);
                        currentButton.setChecked(true);
                        lastButton = currentButton;
                        fragmentManager.beginTransaction().hide(lastFragment).commit();
                        Fragment messageFragment = fragmentManager.findFragmentByTag("messageFragment");
                        if (messageFragment == null) {
                            messageFragment = new MessageFragment();
                            fragmentManager.beginTransaction().add(R.id.ll_fragment, messageFragment, "messageFragment").commit();
                        } else {
                            fragmentManager.beginTransaction().show(messageFragment).commit();
                        }
                        lastFragment = messageFragment;
                        break;
                    case R.id.rb_mine:
                        lastButton.setChecked(false);
                        currentButton.setChecked(true);
                        lastButton = currentButton;
                        fragmentManager.beginTransaction().hide(lastFragment).commit();
                        Fragment mineFragment = fragmentManager.findFragmentByTag("mineFragment");
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            fragmentManager.beginTransaction().add(R.id.ll_fragment, mineFragment, "mineFragent").commit();
                        } else {
                            fragmentManager.beginTransaction().show(mineFragment).commit();
                        }
                        lastFragment = mineFragment;
                        break;

                    default:
                        break;
                }

            }
        });
    }
}
