package com.example.exp10navi;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.NotificationManager;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.widget.TextView;

public class likeact extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeact);
        tv=findViewById(R.id.tv);
        NotificationManager manager=(NotificationManager)getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        manager.cancelAll();
        if(getIntent().hasExtra("LIKE")) {
            tv.setText("You Liked");
            tv.setTextColor(Color.GREEN);
        }

    }
}