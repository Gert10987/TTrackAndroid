package info.gert.ttrackandroid.employer.presenter;

import info.gert.ttrackandroid.employer.model.Employer;
import info.gert.ttrackandroid.employer.view.IEmployerView;

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

    public String getFirstName(){

        return employer.getFirstName();
    }

    public String getLastName(){

        return employer.getLastName();
    }

    public String getSsoId(){

        return employer.getSsoId();
    }

    private Employer setEmployerFromIntent() {

        if(employerView != null)
            return this.employerView.getModelFromIntent();

        return null;
    }
}
