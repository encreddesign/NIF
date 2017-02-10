package nif.encreddesign.tasks;

import java.util.ArrayList;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskTypes {

    protected TaskIRegistered tIRegistered;

    // list of tasks
    private ArrayList<ScheduleListener> localList;

    /*
    * @method constructor
    * */
    public TaskTypes () {

        this.localList = new ArrayList<ScheduleListener>();

    }

    /*
    * @method addTaskType
    * */
    public void addTaskType ( final ScheduleListener sListener, final TaskIRegistered tRegistered ) {

        this.localList.add( sListener );
        this.tIRegistered = tRegistered;

        // trigger needed callbacks
        final String cTaskName = sListener.getClass().getSimpleName();
        this.tIRegistered.onRegistered( cTaskName );

    }

    /*
    * @method addTaskType
    * */
    public int getTaskSize () {

        return this.localList.size();

    }

    /*
    * @method getTaskTypes
    * */
    public ArrayList<ScheduleListener> getTaskTypes () {

        return this.localList;

    }

}
