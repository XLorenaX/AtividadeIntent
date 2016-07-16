package com.example.manoel.atividadeintent;

import android.app.SearchManager;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void forGoogleMaps (View view) {
        Uri uri = Uri.parse("https://www.google.com.br/maps?source=tldsi&hl=en");
        Intent in = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(in);

    }

    public void forSendSMS (View view) {
        Intent in = new Intent(Intent.ACTION_VIEW);
        startActivity(in);
        in.setType("vnd.android-dir/mms-sms");
        in.putExtra("address", "999283496");
        in.putExtra("sms_body","Uma mensagem qualquer");
        startActivity(in);
    }

     public void forConfiguracao (View view) {
        Intent in = new Intent(Settings.ACTION_SETTINGS);
         startActivity(in);

     }


    public void forAlarm (View view) {
        Intent in = new Intent(AlarmClock.ACTION_SET_ALARM);
        in.putExtra(AlarmClock.EXTRA_MESSAGE, "Eu sou um alarme XD");
        in.putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt("16"));
        in.putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt("20"));
        startActivity(in);
    }

    public void forBusca (View view) {
        Intent in = new Intent(Intent.ACTION_WEB_SEARCH);
        in.putExtra(SearchManager.QUERY, "Zoboomafoo");
        startActivity(in);
    }

    public void forPlayMusic (View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, "Lana del Rey");
        intent.putExtra(SearchManager.QUERY, "Lana del Rey");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
