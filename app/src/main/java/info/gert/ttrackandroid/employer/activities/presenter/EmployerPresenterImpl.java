package info.gert.ttrackandroid.employer.activities.presenter;

import info.gert.ttrackandroid.employer.model.Employer;
import info.gert.ttrackandroid.employer.activities.view.IEmployerView;

/**
 * Created by gert on 26.05.17.
 */

public class EmployerPresenterImpl implements IEmployerPresenter {

    private IEmployerView employerView;
    private Employer employer;

    public EmployerPresenterImpl(IEmployerView employerView) {

        this.employerView = employerView;
        this.employer = setEmployerFromIntent();
    }

    @Override
    public void init() {

        if(employerView != null){

            employerView.init();
        }
    }

    @Override
    public String getFirstName(){

        return employer.getFirstName();
    }

    @Override
    public String getLastName(){

        return employer.getLastName();
    }

    @Override
    public String getSsoId() {

        return employer.getSsoId();
    }

    @Override
    public String getCurrentPosition(){

        return employer.getCurrentPosition();
    }

    private Employer setEmployerFromIntent() {

        if(employerView != null)
            return this.employerView.getModelFromIntent();

        return null;
    }
}
