package nif.encreddesign.processes;

import java.util.ArrayList;
import java.util.HashMap;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.utils.Json;

/**
 * Created by Joshua on 11/02/17.
 */
public class Process {

    private String jsonString = null;
    private ArrayList<ProcessObject> pObjectArray;

    protected NIFServiceManager pNIFServiceManager;

    /*
    * @method constructor
    * */
    public Process ( String json, final NIFServiceManager nServiceManager ) {

        this.jsonString = json;
        this.pObjectArray = new ArrayList<ProcessObject>();
        this.pNIFServiceManager = nServiceManager;

    }

    /*
    * @method addAllProcesses
    * */
    public void addAllProcesses () {

        this.getJsonHashMap();

    }

    /*
    * @method getJsonHashMap
    * */
    protected HashMap<String, String> getJsonHashMap () {

        Json.getAsArray( this.jsonString );

        return null;

    }

}
