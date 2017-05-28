package info.gert.ttrackandroid.employer.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.gert.ttrackandroid.R;
import info.gert.ttrackandroid.employer.model.Employer;
import info.gert.ttrackandroid.employer.presenter.EmployerPresenterImpl;
import info.gert.ttrackandroid.employer.presenter.IEmployerPresenter;

public class EmployerActivity extends AppCompatActivity implements IEmployerView{

    @BindView(R.id.textView)
    TextView firstName;

    @BindView(R.id.textView2)
    TextView lastName;

    @BindView(R.id.textView3)
    TextView ssoId;

    private IEmployerPresenter employerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        ButterKnife.bind(this);
        employerPresenter = new EmployerPresenterImpl(this);
        employerPresenter.init();
    }

    @Override
    public void init() {

        firstName.setText(employerPresenter.getFirstName());
        lastName.setText(employerPresenter.getLastName());
        ssoId.setText(employerPresenter.getSsoId());
    }

    @Override
    public Employer getModelFromIntent() {

        Employer model = (Employer) getIntent().getSerializableExtra("CURRENT_EMPLOYER");
        return model;
    }
}
