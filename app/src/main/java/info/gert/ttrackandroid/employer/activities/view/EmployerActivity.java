package info.gert.ttrackandroid.employer.activities.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.gert.ttrackandroid.R;
import info.gert.ttrackandroid.employer.activities.presenter.EmployerPresenterImpl;
import info.gert.ttrackandroid.employer.fragments.employerFragment.EmployerFragment;
import info.gert.ttrackandroid.employer.model.Employer;

public class EmployerActivity extends AppCompatActivity implements
        IEmployerView {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.employerName)
    TextView employerName;
    @BindView(R.id.employerSSoId)
    TextView employerSSoId;

    private EmployerPresenterImpl employerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        ButterKnife.bind(this);
        initToolbar();

        employerPresenter = new EmployerPresenterImpl(this);
        employerPresenter.init();
    }

    private void initToolbar() {

        setSupportActionBar(toolbar);
        initCollapsingToolbar();
    }

    private void initCollapsingToolbar() {

        collapsingToolbar.setTitle(" ");
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
                    collapsingToolbar.setTitle(employerPresenter.getSsoId());
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void init() {

        employerName.setText(employerPresenter.getFirstName() +
                " " + employerPresenter.getLastName());
        employerSSoId.setText(employerPresenter.getSsoId());

        String currPosition[] = employerPresenter.getCurrentPosition().split(",");
        EmployerFragment fragment = (EmployerFragment) getFragmentManager()
                .findFragmentById(R.id.employerFragment);

        fragment.setCurrentPosition(currPosition[0],currPosition[1]);
    }

    @Override
    public Employer getModelFromIntent() {

        Employer model = (Employer) getIntent().getSerializableExtra("CURRENT_EMPLOYER");
        return model;
    }
}
