package nif.encreddesign.tasks;

import java.util.ArrayList;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskTypes {

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
    public void addTaskType ( final ScheduleListener sListener ) {

        this.localList.add( sListener );

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
