package info.gert.ttrackandroid.employer.view;

import info.gert.ttrackandroid.employer.model.Employer;

/**
 * Created by gert on 26.05.17.
 */

public interface IEmployerView {

    void init();

    Employer getModelFromIntent();
}
