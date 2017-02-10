package nif.encreddesign.nif.encreddesign.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import nif.encreddesign.com.NIFService;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 10/02/17.
 */
public class NIFServiceManager {

    protected Intent mIntent;
    protected Context mContext;

    private ArrayList<String> tNames;

    /*
    * @method constructor - NIFServiceManager
    * */
    public NIFServiceManager ( Context context, Class<NIFService> cls ) {

        this.mContext = context;
        this.mIntent = new Intent(context, cls);
        this.tNames = new ArrayList<String>();

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
    * @method start
    * */
    public void start () {

        try {

            this.mIntent.putExtra("taskType", this.tNames);
            this.mContext.startService(this.mIntent);

        } catch (SecurityException ex) {
            // handle errors when unable to start service
            Log.e( Utils.LOG_TAG, ex.getMessage(), ex );
        }

    }

}
