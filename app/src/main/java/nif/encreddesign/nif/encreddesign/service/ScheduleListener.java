package nif.encreddesign.nif.encreddesign.service;

import nif.encreddesign.tasks.carry.ICarry;

/**
 * Created by Joshua on 08/02/17.
 */
public interface ScheduleListener {

    /*
    * @method scheduledUpdate
    * @description callback method triggered on scheduled update
    * */
    public void scheduledUpdate ( String sUid, ICarry carry );

}
