package com.example.exp10navi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class exp7 extends AppCompatActivity {
    Button b,ar,b3,mc;
    private static NotificationManagerCompat notificationManager;
    static List<Message> messages= new ArrayList<>();

    private static final String KEY_TEXT_REPLY = "key_text_reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp7);
        b=findViewById(R.id.button);
        ar=findViewById(R.id.ar);
        b3=findViewById(R.id.button3);
        mc=findViewById(R.id.button4);
        messages.add(new Message("Good morning!","Rani"));
        messages.add(new Message("Hello","Sri"));
        messages.add(new Message("Hii!!!","Devi"));
        messages.add(new Message("Em dng","Siva"));
        messages.add(new Message("Reading","Prathyusha"));

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("Mynotification","mynotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplenotify();
            }
        });
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autorply();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagenotify();
            }
        });
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediactrl();
            }
        });




    }

    private void mediactrl() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.saavn);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Mynotification");
        builder.setContentTitle("Jio Saavn");
        builder.setContentText("Believer");
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setAutoCancel(true);
        builder.setLargeIcon(bitmap);
        builder.addAction(R.drawable.ic_rewind, "rewind", null);
        builder.addAction(R.drawable.ic_previous, "back", null);
        builder.addAction(R.drawable.ic_pause, "play", null);
        builder.addAction(R.drawable.ic_next, "move", null);
        builder.addAction(R.drawable.ic_forward, "forward", null);
//        builder.setStyle(new MediaStyle().setShowActionsInCompactView(1, 2));
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(exp7.this);
        managerCompat.notify(1, builder.build());
    }

    private void imagenotify() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andr);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(exp7.this, "Mynotification");
        builder.setContentTitle("Hello!!!");
        builder.setContentText("Welcome to Android");
        builder.setSmallIcon(R.drawable.ic_image);
        builder.setAutoCancel(true);
        builder.setLargeIcon(bitmap);
        builder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(bitmap)
                .bigLargeIcon(null));
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(exp7.this);
        managerCompat.notify(1, builder.build());
    }

    public void autorply(){
        autorplynotification(this);
    }
    public static void autorplynotification(Context context) {
        Intent ai=new Intent(context,exp7.class);
        PendingIntent ci=PendingIntent.getActivity(context,0,ai,PendingIntent.FLAG_MUTABLE);
        RemoteInput remoteInput=new RemoteInput.Builder("key_text_reply")
                .setLabel("Your Answer ...")
                .build();
        Intent rplyi=new Intent(context,directrplyreceiver.class);
        PendingIntent rpi=PendingIntent.getBroadcast(context,0,rplyi,PendingIntent.FLAG_MUTABLE);
        NotificationCompat.Action ra=new NotificationCompat.Action.Builder(
                R.drawable.ic_rply,"Reply",rpi
        ).addRemoteInput(remoteInput).build();
        NotificationCompat.MessagingStyle messagingStyle=new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");
        for (Message chatmessage: messages){
            NotificationCompat.MessagingStyle.Message notificationMessage=new NotificationCompat.MessagingStyle.Message(
                    chatmessage.getText(),
                    chatmessage.getTimestamp(),
                    chatmessage.getSender()
            );
            messagingStyle.addMessage(notificationMessage);
        }

        Notification notification=new NotificationCompat.Builder(context,"Mynotification")
                .setSmallIcon(R.drawable.ic_sms_notification)
                .setStyle(messagingStyle)
                .addAction(ra)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(ci)
                .setAutoCancel(true)
//                .setOnlyAlertOnce(true)
                .build();
        notificationManager=NotificationManagerCompat.from(context);
        notificationManager.notify(1,notification);
    }

    private void simplenotify() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(exp7.this,"Mynotification");
        builder.setContentTitle("SMS");
        builder.setContentText("Hello, Rani");
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setAutoCancel(true);
        Intent intent1=new Intent(exp7.this,likeact.class);
        intent1.putExtra("LIKE",true);
        intent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent1= PendingIntent.getActivity(exp7.this,0,intent1, PendingIntent.FLAG_MUTABLE);
        Intent intent2=new Intent(exp7.this,dislikeact.class);
        intent2.putExtra("DISLIKE",false);
        intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent2= PendingIntent.getActivity(exp7.this,0,intent2, PendingIntent.FLAG_MUTABLE);
        builder.addAction(R.drawable.ic_like,"LIKE",pendingIntent1);
        builder.addAction(R.drawable.ic_dislike,"DISLIKE",pendingIntent2);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(exp7.this);
        managerCompat.notify(1, builder.build());
    }


   
}