package nif.encreddesign.processes;

/**
 * Created by Joshua on 15/02/17.
 */
public class ProcessException extends Exception {

    /*
    * @method constructor
    * */
    public ProcessException (String message) {
        super(message);
    }

    /*
    * @method message
    * */
    public String message () {

        return super.getMessage();

    }

}
