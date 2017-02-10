package nif.encreddesign.tasks;

import android.util.Log;

import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 10/02/17.
 */
public class TaskRegistered implements TaskIRegistered {

    /*
    * @method constructor
    * */
    public TaskRegistered () {}

    @Override
    public void onRegistered(String task) {
        // triggered when a task has been registered
        Log.d( Utils.LOG_TAG, ("Registered task[" + task + "]") );
    }

    @Override
    public void onUnregistered(String task) {
        // triggered when a task has been unregistered
        Log.d( Utils.LOG_TAG, ("Unregistered task[" + task + "]") );
    }

}
