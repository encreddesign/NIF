package nif.encreddesign.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joshua on 10/02/17.
 */
public class LightData {

    protected static final String LDATA_KEY = "LIGHT_DATA_V1";

    private static Context mContext;
    private static SharedPreferences sPrefs;

    /*
    * @method init
    * */
    public static void init ( Context context ) {

        mContext = context;
        sPrefs = context.getSharedPreferences(LDATA_KEY, Context.MODE_PRIVATE);

    }

    /*
    * @method setLightData
    * */
    public static void setLightData ( String key, String data ) {

        final SharedPreferences.Editor editor = sPrefs.edit();
        editor.putString( key, data );

        editor.commit();

    }

    /*
    * @method setLightDataArray
    * */
    public static void setLightDataArray ( String key, ArrayList<String> data ) {

        final SharedPreferences.Editor editor = sPrefs.edit();
        editor.putString( key, TextUtils.join(",", data) );

        editor.commit();

    }

    /*
    * @method getLightData
    * */
    public static String getLightData ( String key ) {

        return sPrefs.getString( key, null );

    }

    /*
    * @method getLightDataArray
    * */
    public static ArrayList<String> getLightDataArray ( String key ) {

        final String data = sPrefs.getString( key, null );
        final ArrayList<String> toArr = new ArrayList<String>();

        if( data != null ) {

            final String[] split = TextUtils.split(data, ",");
            for(int i = 0; i < split.length; i++) {

                toArr.add(split[i]);

            }

        }

        return toArr;

    }

}
