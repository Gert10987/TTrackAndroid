package info.gert.ttrackandroid.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.gert.ttrackandroid.R;
import info.gert.ttrackandroid.employer.EmployerActivity;

public class LoginActivity extends Activity implements LoginView{

    //region MEMBERS
    @BindView(R.id.progress)
    private ProgressBar progressBar;

    @BindView(R.id.username)
    private EditText username;

    @BindView(R.id.password)
    private EditText password;

    private LoginPresenter presenter;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this);
    }

    //region PresenterMethods
    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    public void navigateToHome() {
        startActivity(new Intent(this, EmployerActivity.class));
        finish();
    }

    @OnClick(R.id.button)
    public void buttonClick() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
    //endregion
}
