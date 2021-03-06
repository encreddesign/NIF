package nif.encreddesign.processes;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Joshua on 11/02/17.
 */
public class ProcessObject implements Serializable {

    // properties
    private String pName;

    private String pDescription;

    private String pTask;

    private String pCarry;

    private String pId;

    /*
    * @method constructor
    * */
    public ProcessObject () {

        this.pName = null;
        this.pDescription = null;
        this.pTask = null;
        this.pCarry = null;
        this.pId = null;

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
    * @method setId
    * */
    public void setId ( String id ) {

        this.pId = id;

    }

    /*
    * @method getId
    * */
    public String getId () {

        return this.pId;

    }

    /*
    * @method setProcessData
    * */
    public void setProcessData ( HashMap<String, String> data ) {

        if( data.get("name") != null ) this.pName = data.get("name");
        if( data.get("description") != null ) this.pDescription = data.get("description");
        if( data.get("task") != null ) this.pTask = data.get("task");
        if( data.get("carry") != null ) this.pCarry = data.get("carry");
        if( data.get("id") != null ) this.pId = data.get("id");

    }

}
