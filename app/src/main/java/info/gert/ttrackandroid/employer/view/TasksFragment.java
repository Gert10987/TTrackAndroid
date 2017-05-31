package info.gert.ttrackandroid.employer.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.gert.ttrackandroid.R;

/**
 * Created by gert on 31.05.17.
 */

public class TasksFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.tasks_fragment, container, false);
        return view;
    }

    public void setText(String txt) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(txt);
    }
}