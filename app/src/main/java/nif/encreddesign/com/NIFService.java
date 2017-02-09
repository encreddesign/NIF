package nif.encreddesign.com;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.EmptyStackException;

import nif.encreddesign.ajax.AjaxUpdate;
import nif.encreddesign.nif.encreddesign.service.NIFExecutorService;
import nif.encreddesign.tasks.TaskAjax;
import nif.encreddesign.tasks.TaskTypes;
import nif.encreddesign.utils.Uid;

/**
 * Created by Joshua on 08/02/17.
 */
public class NIFService extends Service {

    // Helpful constants
    public static final String LOG_TAG = "Log_A";

    protected TaskTypes tTypes;
    protected NIFExecutorService nExecutorService;

    @Override
    public void onCreate() {
        super.onCreate();

        this.nExecutorService = new NIFExecutorService();
        this.tTypes = new TaskTypes();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String dId = Uid.gen();
        Log.d( LOG_TAG, "Started NIF service: " + dId );

        // add the wanted tasks
        this.tTypes.addTaskType( new TaskAjax() );

        if( this.tTypes.getTaskSize() > 0 ) {

            this.nExecutorService.setThreadPoolSize( this.tTypes.getTaskSize() );

            try {

                // Start the schedule serivce
                this.nExecutorService.runSchedule( this.tTypes.getTaskTypes() );

            } catch (EmptyStackException ex) {
                Log.e( LOG_TAG, ex.getMessage() );
            }

        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
