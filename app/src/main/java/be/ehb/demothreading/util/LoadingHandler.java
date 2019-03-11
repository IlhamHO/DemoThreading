package be.ehb.demothreading.util;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class LoadingHandler extends Handler {

    private ProgressBar progressBar;
    private TextView progressTV;


    public LoadingHandler(ProgressBar progressBar, TextView progressTV) {
        this.progressBar = progressBar;
        this.progressTV = progressTV;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        progressBar.setProgress(msg.arg1);

        int maxProgress = progressBar.getMax();
        String display = String.format(Locale.getDefault(),"%d / %d %%", msg.arg1,maxProgress);
        progressTV.setText(display);

        if(msg.arg1 == maxProgress){
            progressTV.setText("Done");
        }

    }
}
