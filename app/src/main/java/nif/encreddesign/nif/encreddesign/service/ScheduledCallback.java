package nif.encreddesign.nif.encreddesign.service;

import nif.encreddesign.tasks.carry.ICarry;
import nif.encreddesign.utils.Uid;

/**
 * Created by Joshua on 08/02/17.
 */
public class ScheduledCallback implements Runnable {

    protected ICarry iCarry;
    protected ScheduleListener sListener;

    /*
    * @method constructor - AjaxUpdate
    * */
    public ScheduledCallback ( ScheduleListener sListener, ICarry iCarry ) {

        this.sListener = sListener;
        this.iCarry = iCarry;

    }

    @Override
    public void run() {

        // Generate unique id for this schedule
        final String uId = Uid.gen();
        // Ajaxy stuff goes here
        final String tData = ( "Recycled at: " + System.currentTimeMillis() );

        // trigger the update
        this.sListener.scheduledUpdate(tData, uId);

    }

}
