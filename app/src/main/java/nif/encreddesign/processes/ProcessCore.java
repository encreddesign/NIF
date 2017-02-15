package nif.encreddesign.processes;

import android.content.res.Resources;
import android.util.Log;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.utils.Json;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 15/02/17.
 */
public class ProcessCore {

    private Process pcProcess;
    private Resources pcResources;
    private NIFServiceManager pcServiceManager;

    protected int resId = 0;

    /*
    * @method constructor
    * */
    public ProcessCore ( Resources resources, int resId, NIFServiceManager nServiceManager ) {

        this.resId = resId;
        this.pcResources = resources;
        this.pcServiceManager = nServiceManager;

    }

    /*
    * @method startCore
    * */
    public void startCore () {

        final String json = Json.loadFromRes( this.pcResources, this.resId );

        try {

            if( json.length() <= 0 ) throw new ProcessException("Unable to use empty json array");
            this.pcProcess = new Process( json, this.pcServiceManager );
            this.pcProcess.addAllProcesses();

            this.pcServiceManager.start();

        } catch (ProcessException ex) {
            Log.e( Utils.LOG_TAG, "Process Core Error", ex );
        }

    }

}
