package nif.encreddesign.nif.encreddesign.service;

/**
 * Created by Joshua on 08/02/17.
 */
public interface ScheduleListener {

    /*
    * @method scheduledUpdate
    * @description callback method triggered on scheduled update
    * */
    public void scheduledUpdate ( String sData, String sUid );

}
