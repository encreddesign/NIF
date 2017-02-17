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

        this.core = new ProcessCore( this.getResources(), R.raw.processes, this.nServiceManager );
        this.core.startCore();

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
