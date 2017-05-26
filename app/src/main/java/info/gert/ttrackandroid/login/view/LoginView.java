package info.gert.ttrackandroid.login.view;

import info.gert.ttrackandroid.employer.model.Employer;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome(Employer employer);

    void setConnectionError();

    void setWrongCredentialsError();
}
