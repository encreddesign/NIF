package nif.encreddesign.utils;

import java.util.UUID;

/**
 * Created by Joshua on 08/02/17.
 */
public class Uid {

    /*
    * @method gen
    * @return unique id
    * */
    public static final String gen () {

        return UUID.randomUUID().toString();

    }

    /*
    * @method genLong
    * @return unique id
    * */
    public static final long genLong () {

        return Long.parseLong( UUID.randomUUID().toString().replace("-", "") );

    }

}
