package nif.encreddesign.utils;

import android.content.Context;
import android.util.Log;

import nif.encreddesign.com.NIFActivity;

/**
 * Created by Joshua on 10/02/17.
 */
public class Utils {

    // Helpful constants
    public static final String LOG_TAG = "Log_A";
    public static final String TASK_TYPE = "taskType";

    public static final String PACKAGE_COM = "nif.encreddesign.com";
    public static final String PACKAGE_SERVICE = "nif.encreddesign.service";
    public static final String PACKAGE_TASKS = "nif.encreddesign.tasks";
    public static final String PACKAGE_TASKS_CARRY = "nif.encreddesign.tasks.carry";

    /*
    * @method getClassByName
    * */
    public static Object getClassByName ( final String name, final String pkg ) {

        Object instance = null;
        final String pkgName = (pkg + "." + name);

        try {

            final Class<?> cls = Class.forName(pkgName);
            instance = cls.newInstance();

        } catch (ClassNotFoundException ex) {
            Log.e( LOG_TAG, ex.getMessage(), ex );
        } catch (IllegalAccessException ex) {
            Log.e( LOG_TAG, ex.getMessage(), ex );
        } catch (InstantiationException ex) {
            Log.e( LOG_TAG, ex.getMessage(), ex );
        }

        return instance;

    }

}
