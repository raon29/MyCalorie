package com.example.myapplication2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Administrator on 2015-11-30.
 */
public class Broadcast extends BroadcastReceiver{
    String origNumber, message = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("테그", "메시지받을라고");
        if("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())){
            // SMS 메시지를 파싱합니다.
            Bundle bundle = intent.getExtras();
            Object messages[] = (Object[])bundle.get("pdus");
            SmsMessage smsMessage[] = new SmsMessage[messages.length];

            for(int i = 0; i < messages.length; i++) {
                // PDU 포맷으로 되어 있는 메시지를 복원합니다.
                smsMessage[i] = SmsMessage.createFromPdu((byte[])messages[i]);
            }
            // SMS 수신 시간 확인
            Log.v("테그", "메세지받음");
            origNumber = smsMessage[0].getOriginatingAddress();
            //Toast.makeText(context,"번호"+origNumber,Toast.LENGTH_LONG).show();
            // SMS 메시지 확인
            message = smsMessage[0].getMessageBody().toString();
            //Toast.makeText(context,"문자내용"+message,Toast.LENGTH_LONG).show();

           // if(origNumber.equals("18001111")){
            //if(message.contains("롯데리아")){
                NotificationManager nm;

                nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                Intent intent1 = new Intent(context, parsing_menu.class);
                intent1.putExtra("name", message);
                PendingIntent pintent = PendingIntent.getActivity(context,0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Builder builder = new Notification.Builder(context);

                builder.setSmallIcon(R.drawable.c);
                builder.setTicker("알림!!!");
                builder.setWhen(System.currentTimeMillis());
                builder.setContentTitle("드셨으면!");
                builder.setContentText("지금 바로 등록하세요!");
                builder.setContentIntent(pintent);
                builder.setAutoCancel(true);

                nm.notify(1234, builder.build());
           // }
        }
    }
}
