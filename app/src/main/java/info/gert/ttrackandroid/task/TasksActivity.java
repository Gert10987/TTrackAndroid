package info.gert.ttrackandroid.task;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import info.gert.ttrackandroid.R;
import info.gert.ttrackandroid.employer.fragments.taskFragment.TasksFragment;

/**
 * Created by gert on 31.05.17.
 */

public class TasksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        setContentView(R.layout.tasks_activity);

        // pobieramy dane wysłane przez aktywność główną
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString("msg");
            TasksFragment detailFragment = (TasksFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);

            // ustawiamy tekst fragmentu w tej aktywności
            detailFragment.setText(url);
        }
    }
}