package com.benny.smsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (!intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            return //verifying that only sms is received
        }
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        smsMessages.forEach {
            val sender = it.displayOriginatingAddress
            val sms = it.displayOriginatingAddress
            Toast.makeText(context, "$sender : $sms", Toast.LENGTH_LONG).show()
            Log.d("MESSAGE_RECEIVED", sender) //Displaying the message
            Log.d("MESSAGE_RECEIVED", sms) //Displaying the number of the sender


            if (it.displayOriginatingAddress.equals("011188282822") || it.displayMessageBody.contains(
                    "dear"
                )
            ) {}
        }
    }
}