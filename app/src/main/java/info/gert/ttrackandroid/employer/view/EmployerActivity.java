package info.gert.ttrackandroid.employer.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.gert.ttrackandroid.R;
import info.gert.ttrackandroid.employer.model.Employer;

public class EmployerActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    public TextView firstName;

    @BindView(R.id.textView2)
    public TextView lastName;

    @BindView(R.id.textView3)
    public TextView ssoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        ButterKnife.bind(this);

        //receive
        Employer model = (Employer) getIntent().getSerializableExtra("CURRENT_EMPLOYER");
        firstName.setText(model.getFirstName());
        lastName.setText(model.getLastName());
        ssoId.setText(model.getSsoId());
    }
}
