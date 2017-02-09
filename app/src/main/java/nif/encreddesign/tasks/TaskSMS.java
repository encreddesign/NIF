package nif.encreddesign.tasks;

import android.util.Log;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskSMS implements ScheduleListener {

    public static final String LOG_TAG = "Log_A";

    /*
    * @method constructor - AjaxUpdate
    * */
    public TaskSMS () {}

    @Override
    public void scheduledUpdate( String sData, String sUid ) {

        // update has been called, do needed with data

        Log.d(LOG_TAG, (sUid + ": " + sData));

    }

}
