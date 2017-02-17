package nif.encreddesign.processes;

import android.util.Log;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.utils.Json;
import nif.encreddesign.utils.Utils;

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

        this.buildProcessObjects();

        if( this.pObjectArray.size() > 0 ) {

            for(ProcessObject process : this.pObjectArray) {

                final String TaskAndCarry = ( process.getTask() + ":" + process.getCarry() + ":" + process.getId() );
                this.pNIFServiceManager.addSpecTask( TaskAndCarry );

            }

        }

    }

    /*
    * @method buildProcessObjects
    * */
    protected void buildProcessObjects () {

        final ArrayList<HashMap<String, String>> mapped = Json.getAsArray( this.jsonString );

        try {

            if( mapped.size() <= 0 ) throw new EmptyStackException();
            for(HashMap<String, String> map : mapped){

                ProcessObject pObject = new ProcessObject();
                pObject.setProcessData( map );

                this.pObjectArray.add( pObject );

            }

        } catch (EmptyStackException ex) {
            Log.e( Utils.LOG_TAG, "Empty process objects", ex );
        }

    }

    /*
    * @method getProcessObjects
    * */
    public ArrayList<ProcessObject> getProcessObjects () {

        return this.pObjectArray;

    }

}
