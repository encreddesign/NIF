package nif.encreddesign.utils;

import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

                final HashMap<String, String> mapped = Json.buildHashMap( jParser.getJSONObject(i) );
                $return.add( mapped );

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
        if( obj != null ) {

            try {

                final JSONArray keys = obj.names();
                for(int i = 0; i < keys.length(); i++) {

                    map.put( keys.getString(i), obj.getString(keys.getString(i)) );

                }

            } catch (JSONException ex) {
                Log.e( Utils.LOG_TAG, "JSON Parsing error", ex );
            }

        }

        return map;

    }

    /*
    * @method loadFromRes
    * */
    public static String loadFromRes ( Resources resources, int resId ) {

        final InputStream input = resources.openRawResource(resId);
        final StringBuilder builder = new StringBuilder();

        try {

            BufferedReader reader = new BufferedReader( new InputStreamReader(input, "UTF-8"));
            String line = null;

            while ( (line = reader.readLine()) != null ) {

                builder.append( line );

            }

        } catch (Exception ex) {
            Log.e( Utils.LOG_TAG, "Error reading from stream", ex );
        } finally {

            try {

                input.close();

            } catch (IOException ex) {
                Log.e( Utils.LOG_TAG, "Error closing resource stream", ex );
            }

        }

        return builder.toString();

    }

}
