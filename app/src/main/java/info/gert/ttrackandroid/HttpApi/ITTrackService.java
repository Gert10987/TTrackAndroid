package info.gert.ttrackandroid.HttpApi;

import java.util.List;

import info.gert.ttrackandroid.employer.model.Employer;
import info.gert.ttrackandroid.task.model.Task;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gert on 26.05.17.
 */

public interface ITTrackService {

    @GET("login/{employerSsoId}")
    Call<Employer> getEmployer(@Path("employerSsoId") String employer);

    @GET("task/all/employer")
    Call<List<Task>> getTasks(@Path("employer") String employer);
}