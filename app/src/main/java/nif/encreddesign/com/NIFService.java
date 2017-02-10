package nif.encreddesign.com;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.EmptyStackException;

import nif.encreddesign.nif.encreddesign.service.NIFExecutorService;
import nif.encreddesign.nif.encreddesign.service.ScheduleListener;
import nif.encreddesign.tasks.TaskRegistered;
import nif.encreddesign.tasks.TaskTypes;
import nif.encreddesign.utils.LightData;
import nif.encreddesign.utils.Uid;
import nif.encreddesign.utils.Utils;

/**
 * Created by Joshua on 08/02/17.
 */
public class NIFService extends Service {

    protected TaskTypes tTypes;
    protected TaskRegistered tRegistered;
    protected NIFExecutorService nExecutorService;

    @Override
    public void onCreate() {
        super.onCreate();

        this.nExecutorService = new NIFExecutorService();
        this.tRegistered = new TaskRegistered();
        this.tTypes = new TaskTypes();

        LightData.init( this );

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String dId = Uid.gen();
        Log.d( Utils.LOG_TAG, "Started NIF service: " + dId );

        final ArrayList<String> tasks = LightData.getLightDataArray( Utils.TASK_TYPE );

        // add the wanted tasks
        if( tasks.size() > 0 ) {

            try {

                if( tasks.size() <= 0 ) throw new EmptyStackException();
                for(String task : tasks) {

                    final ScheduleListener listener = (ScheduleListener) Utils.getClassByName(task, Utils.PACKAGE_TASKS);
                    this.tTypes.addTaskType( listener, this.tRegistered );

                }

            } catch (EmptyStackException ex) {
                Log.e( Utils.LOG_TAG, ("Empty tasks - " + ex.getMessage()), ex );
            }

        }

        if( this.tTypes.getTaskSize() > 0 ) {

            this.nExecutorService.setThreadPoolSize( this.tTypes.getTaskSize() );

            try {

                // Start the schedule service
                this.nExecutorService.runSchedule( this.tTypes.getTaskTypes() );

            } catch (EmptyStackException ex) {
                Log.e( Utils.LOG_TAG, ex.getMessage(), ex );
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
