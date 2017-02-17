package nif.encreddesign.nif.encreddesign.service;

import nif.encreddesign.tasks.carry.ICarry;
import nif.encreddesign.utils.Uid;

/**
 * Created by Joshua on 08/02/17.
 */
public class ScheduledCallback implements Runnable {

    protected String pId;
    protected ICarry iCarry;
    protected ScheduleListener sListener;

    /*
    * @method constructor - AjaxUpdate
    * */
    public ScheduledCallback ( ScheduleListener sListener, ICarry iCarry, String uId ) {

        this.pId = uId;
        this.sListener = sListener;
        this.iCarry = iCarry;

    }

    @Override
    public void run() {

        // trigger the update
        this.sListener.scheduledUpdate(this.pId, this.iCarry);

    }

}
