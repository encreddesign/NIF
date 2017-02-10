package nif.encreddesign.tasks;

import android.util.Log;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskSMS implements ScheduleListener {

    /*
    * @method constructor - AjaxUpdate
    * */
    public TaskSMS () {}

    @Override
    public void scheduledUpdate( String sData, String sUid ) {

        // update has been called, do needed with data

        Log.d(Utils.LOG_TAG, (sUid + ": " + sData));

    }

}
