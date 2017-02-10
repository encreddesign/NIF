package nif.encreddesign.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.tasks.TaskAjax;

public class NIFActivity extends Activity {

    protected NIFServiceManager nServiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.nServiceManager = new NIFServiceManager(this, NIFService.class);

        // handle adding tasks from UI
        this.nServiceManager.addSpecTask( "TaskAjax" );
        this.nServiceManager.start();

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
