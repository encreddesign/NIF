package nif.encreddesign.tasks;

import android.util.Log;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;
import nif.encreddesign.tasks.carry.ICarry;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskAjax implements ScheduleListener {

    private String cTaskName = null;

    /*
    * @method constructor - AjaxUpdate
    * */
    public TaskAjax () {

        this.cTaskName = this.getClass().getName();

    }

    @Override
    public void scheduledUpdate( String sUid, ICarry carry ) {

        // update has been called, do needed with data

        Log.d(Utils.LOG_TAG, sUid);

    }

}
