package nif.encreddesign.tasks;

import android.util.Log;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskSMS implements ScheduleListener {

    private String cTaskName = null;

    /*
    * @method constructor - AjaxUpdate
    * */
    public TaskSMS () {

        this.cTaskName = this.getClass().getName();

    }

    @Override
    public void scheduledUpdate( String sData, String sUid ) {

        // update has been called, do needed with data

        Log.d(Utils.LOG_TAG, ("[" + this.cTaskName + "-" + sUid + "]: " + sData));

    }

}
