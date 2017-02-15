package nif.encreddesign.com;

import android.app.Activity;
import android.os.Bundle;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.processes.ProcessCore;

public class NIFActivity extends Activity {

    protected ProcessCore core;
    protected NIFServiceManager nServiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.nServiceManager = new NIFServiceManager(this, NIFService.class);

        this.core = new ProcessCore( this.getResources(), 0, this.nServiceManager );
        this.core.startCore();

        // handle adding tasks from UI
        //this.nServiceManager.addSpecTask( "TaskAjax" );
        //this.nServiceManager.addSpecTask( "TaskSMS" );
        //this.nServiceManager.start();

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
