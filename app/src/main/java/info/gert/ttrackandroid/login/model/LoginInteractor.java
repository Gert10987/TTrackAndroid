package info.gert.ttrackandroid.login.model;

import info.gert.ttrackandroid.employer.model.Employer;

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess(Employer employer);

        void onConnectionError();

        void onWrongCredentialsError();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
