package info.gert.ttrackandroid.employer.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import info.gert.ttrackandroid.R;

public class EmployerActivity extends AppCompatActivity implements
        EmployerFragment.OverviewFragmentActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        initToolbar();
    }

    private void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();
    }

    // ta metoda pochodzi z OverviewFragmentActivityListener
    @Override
    public void onItemSelected(String msg) {
        TasksFragment fragment = (TasksFragment) getFragmentManager()
                .findFragmentById(R.id.tasksFragment);
        // jeżeli fragment istnieje w tej aktywności,
        // znaczy, że jesteśmy w trybie landscape
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(msg);
        } else {
            // w trybie portrait wywołujemy drugą aktywność
            Intent intent = new Intent(getApplicationContext(),
                    TasksActivity.class);
            intent.putExtra("msg", msg);
            startActivity(intent);
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
