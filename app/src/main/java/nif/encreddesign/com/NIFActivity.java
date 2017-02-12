package nif.encreddesign.com;

import android.app.Activity;
import android.os.Bundle;

import nif.encreddesign.nif.encreddesign.service.NIFServiceManager;
import nif.encreddesign.processes.Process;

public class NIFActivity extends Activity {

    protected Process process;
    protected NIFServiceManager nServiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.nServiceManager = new NIFServiceManager(this, NIFService.class);

        process = new Process( "[{\"name\":\"Wifi\"},{\"name\":\"Bluetooth\"}]", this.nServiceManager );
        process.addAllProcesses();

        // handle adding tasks from UI
        this.nServiceManager.addSpecTask( "TaskAjax" );
        this.nServiceManager.addSpecTask( "TaskSMS" );
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
