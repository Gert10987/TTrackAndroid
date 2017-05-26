package info.gert.ttrackandroid.login.model;

import android.os.Handler;
import android.text.TextUtils;

import info.gert.ttrackandroid.HttpApi.ApiClient;
import info.gert.ttrackandroid.HttpApi.ITTrackService;
import info.gert.ttrackandroid.employer.model.Employer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error) {

                    ApiClient.login(username, password);

                    ITTrackService apiService =
                            ApiClient.retrofit.create(ITTrackService.class);

                    Call<Employer> call = apiService.getEmployer(username);
                    call.enqueue(new Callback<Employer>() {
                        @Override
                        public void onResponse(Call<Employer> call, Response<Employer> response) {
                            if (response.isSuccessful())
                                listener.onSuccess();
                            else
                                listener.onWrongCredentialsError();
                        }

                        @Override
                        public void onFailure(Call<Employer> call, Throwable t) {
                            listener.onConnectionError();
                        }
                    });
                }
            }
        });
    }
}
