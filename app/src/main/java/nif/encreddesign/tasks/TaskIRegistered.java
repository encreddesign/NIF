package nif.encreddesign.tasks;

/**
 * Created by Joshua on 10/02/17.
 */
public interface TaskIRegistered {

    /*
    * @method onRegistered
    * @param String task - Name of the task just registered
    * */
    public void onRegistered ( String task );

    /*
    * @method onUnregistered
    * @param String task - Name of the task just unregistered
    * */
    public void onUnregistered ( String task );

}
