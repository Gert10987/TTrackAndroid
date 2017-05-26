package info.gert.ttrackandroid.login.model;

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onConnectionError();

        void onWrongCredentialsError();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
