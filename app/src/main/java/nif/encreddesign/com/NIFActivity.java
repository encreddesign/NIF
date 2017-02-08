package nif.encreddesign.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class NIFActivity extends Activity {

    protected Intent sIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.sIntent = new Intent(this, NIFService.class);
        this.startService(sIntent);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
