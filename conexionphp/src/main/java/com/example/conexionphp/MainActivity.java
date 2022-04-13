package com.example.conexionphp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickServidor (View v)
    {
        OneTimeWorkRequest otwr = new OneTimeWorkRequest.Builder(ConexionPHPInsert.class).build();
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(otwr.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo)
                    {
                        if(workInfo != null && workInfo.getState().isFinished())
                        {
                            TextView textViewResult = findViewById(R.id.textView);
                            textViewResult.setText(workInfo.getOutputData().getString("nombres"));
                        }
                    }
                });
        WorkManager.getInstance(this).enqueue(otwr);
    }
}