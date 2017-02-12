package nif.encreddesign.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joshua on 12/02/17.
 */
public class Json {

    /*
    * @method getAsArray
    * */
    public static ArrayList<HashMap<String, String>> getAsArray ( final String json ) {

        final ArrayList<HashMap<String, String>> $return = new ArrayList<HashMap<String, String>>();
        try {

            final JSONArray jParser = new JSONArray(json);
            for(int i = 0; i < jParser.length(); i++) {

                Log.d( Utils.LOG_TAG, jParser.getString(i) );

            }

        } catch (JSONException ex) {
            Log.e( Utils.LOG_TAG, "JSON Parsing error", ex );
        }

        return $return;

    }

    /*
    * @method buildHashMap
    * */
    private static HashMap<String, String> buildHashMap ( final JSONObject obj ) {

        final HashMap<String, String> map = new HashMap<String, String>();
        if( obj != null ) {}

        return map;

    }

}
