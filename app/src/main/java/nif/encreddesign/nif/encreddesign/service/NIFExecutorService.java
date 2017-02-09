package nif.encreddesign.nif.encreddesign.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joshua on 08/02/17.
 */
public class NIFExecutorService {

    public static final String LOG_TAG = "Log_A";

    // Thread pool size and recycle time
    public static int eThreadPoolSize = 5;
    public static int eThreadRecycleTime = 10;

    private ScheduledCallback sCallback;
    private ScheduledExecutorService eSchedule;

    /*
    * @method constructor - NIFExecutorService
    * */
    public NIFExecutorService ( int...args ) {

        if( args.length > 0 ) {

            eThreadPoolSize = args[0];

        }

        this.eSchedule = Executors.newScheduledThreadPool(eThreadPoolSize);

    }

    /*
    * @method setThreadPoolSize
    * */
    public void setThreadPoolSize ( int size ) {

        this.eThreadPoolSize = size;

    }

    /*
    * @method runSchedule
    * */
    public void runSchedule ( final ArrayList<ScheduleListener> sListener ) {

        if( sListener.size() > 0 ) {

            for(ScheduleListener sl : sListener) {

                this.sCallback = new ScheduledCallback(sl);
                try {

                    this.eSchedule.scheduleAtFixedRate( this.sCallback, eThreadRecycleTime, eThreadRecycleTime, TimeUnit.SECONDS );

                } catch (RejectedExecutionException ex) {

                    // best to catch exception and tell user whats going on, instead of crashing app
                    Log.e( LOG_TAG, ex.getMessage() );

                }

            }

        } else {
            throw new EmptyStackException();
        }

    }

}
