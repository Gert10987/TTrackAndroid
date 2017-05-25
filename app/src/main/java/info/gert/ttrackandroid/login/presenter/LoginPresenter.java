package info.gert.ttrackandroid.login.presenter;

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
