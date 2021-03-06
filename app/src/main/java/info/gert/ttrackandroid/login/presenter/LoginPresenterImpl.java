package info.gert.ttrackandroid.login.presenter;

import info.gert.ttrackandroid.employer.model.Employer;
import info.gert.ttrackandroid.login.model.LoginInteractor;
import info.gert.ttrackandroid.login.model.LoginInteractorImpl;
import info.gert.ttrackandroid.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(Employer employer) {
        if (loginView != null) {
            loginView.navigateToHome(employer);
        }
    }

    @Override
    public void onConnectionError() {
        if (loginView != null) {
            loginView.setConnectionError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onWrongCredentialsError() {
        if (loginView != null) {
            loginView.setWrongCredentialsError();
            loginView.hideProgress();
        }
    }
}
