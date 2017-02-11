package nif.encreddesign.nif.encreddesign.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import nif.encreddesign.com.NIFService;
import nif.encreddesign.utils.LightData;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 10/02/17.
 */
public class NIFServiceManager {

    protected Intent mIntent;
    protected Context mContext;
    protected Class<NIFService> cService;

    private ArrayList<String> tNames;

    /*
    * @method constructor - NIFServiceManager
    * */
    public NIFServiceManager ( Context context, Class<NIFService> cls ) {

        this.mContext = context;
        this.mIntent = new Intent(context, cls);
        this.tNames = new ArrayList<String>();

        this.cService = cls;

        // init light data, ready store task names
        LightData.init(this.mContext);

    }

    /*
    * @method addSpecTask
    * */
    public void addSpecTask ( String taskName ) {

        if( !this.tNames.contains(taskName) ) {

            this.tNames.add(taskName);

        }

    }

    /*
    * @method isServiceRunning
    * */
    private boolean isServiceRunning () {

        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(Context.ACTIVITY_SERVICE);

        // Loop through the running services
        for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {

            if (this.cService.getName().equals(service.service.getClassName())) {
                return true;
            }

        }

        return false;

    }

    /*
    * @method start
    * */
    public void start () {

        try {

            LightData.setLightDataArray( Utils.TASK_TYPE, this.tNames );
            if( !this.isServiceRunning() ) {

                this.mContext.startService(this.mIntent);

            } else {
                Log.d( Utils.LOG_TAG, "Service already running" );
            }

        } catch (SecurityException ex) {
            // handle errors when unable to start service
            Log.e( Utils.LOG_TAG, ex.getMessage(), ex );
        }

    }

    /*
    * @method stop
    * */
    public void stop () {

        try {

            if( this.isServiceRunning() ) {

                this.mContext.stopService(this.mIntent);

            } else {
                Log.d( Utils.LOG_TAG, "Service has already stopped" );
            }

        } catch (SecurityException ex) {
            // handle errors when unable to start service
            Log.e( Utils.LOG_TAG, ex.getMessage(), ex );
        }

    }

}
