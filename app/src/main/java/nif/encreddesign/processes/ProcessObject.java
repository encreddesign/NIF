package nif.encreddesign.processes;

import java.util.ArrayList;

/**
 * Created by Joshua on 11/02/17.
 */
public class ProcessObject {

    // properties
    private String pName;

    private String pDescription;

    private String pTask;

    private String pCarry;

    protected ArrayList<String> pDataHolder;

    /*
    * @method constructor
    * */
    public ProcessObject () {

        this.pDataHolder = new ArrayList<String>();

    }

    /*
    * @method setName
    * */
    public void setName ( String name ) {

        this.pName = name;

    }

    /*
    * @method getName
    * */
    public String getName () {

        return this.pName;

    }

    /*
    * @method setDescription
    * */
    public void setDescription ( String description ) {

        this.pDescription = description;

    }

    /*
    * @method getDescription
    * */
    public String getDescription () {

        return this.pDescription;

    }

    /*
    * @method setTask
    * */
    public void setTask ( String task ) {

        this.pTask = task;

    }

    /*
    * @method getTask
    * */
    public String getTask () {

        return this.pTask;

    }

    /*
    * @method setCarry
    * */
    public void setCarry ( String carry ) {

        this.pCarry = carry;

    }

    /*
    * @method getCarry
    * */
    public String getCarry () {

        return this.pCarry;

    }

    /*
    * @method setProcessData
    * */
    public void setProcessData ( ArrayList<String> data ) {}

    /*
    * @method getProcessObject
    * */
    public ProcessObject getProcessObject () {

        return this;

    }

}
