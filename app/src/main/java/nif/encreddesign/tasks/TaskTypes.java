package nif.encreddesign.tasks;

import java.util.ArrayList;

import nif.encreddesign.nif.encreddesign.service.ScheduleListener;
import nif.encreddesign.tasks.carry.ICarry;

/**
 * Created by Joshua on 09/02/17.
 */
public class TaskTypes {

    protected TaskIRegistered tIRegistered;

    // list of tasks
    private ArrayList<ICarry> carryList;
    private ArrayList<String> processIds;
    private ArrayList<ScheduleListener> localList;

    /*
    * @method constructor
    * */
    public TaskTypes () {

        this.carryList = new ArrayList<ICarry>();
        this.processIds = new ArrayList<String>();
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
    * @method addCarryType
    * */
    public void addCarryType ( final ICarry iCarry ) {

        this.carryList.add( iCarry );

    }

    /*
    * @method addProcId
    * */
    public void addProcId ( final String uid ) {

        this.processIds.add( uid );

    }

    /*
    * @method getTaskSize
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

    /*
    * @method getCarryTypes
    * */
    public ArrayList<ICarry> getCarryTypes () {

        return this.carryList;

    }

    /*
    * @method getCarryTypes
    * */
    public ArrayList<String> getProcIds () {

        return this.processIds;

    }

}
