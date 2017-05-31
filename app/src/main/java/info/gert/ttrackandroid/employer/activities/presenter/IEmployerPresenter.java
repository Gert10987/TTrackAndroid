package info.gert.ttrackandroid.employer.activities.presenter;

/**
 * Created by gert on 26.05.17.
 */

public interface IEmployerPresenter {

    void init();

    String getFirstName();

    String getLastName();

    String getSsoId();

    String getCurrentPosition();
}
