package com.example.archer62.businesscard;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.main_layout);
        final TextView disclaimer = new TextView(this);
        disclaimer.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        disclaimer.setTextSize(R.dimen.textSize);
        disclaimer.setTextColor(Color.BLACK);
        disclaimer.setBackgroundColor(Color.BLACK);

//        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT, // width
//                ViewGroup.LayoutParams.WRAP_CONTENT); // height
//
//        linearLayoutParams.gravity = Gravity.CENTER_HORIZONTAL;
//        disclaimer.setLayoutParams(linearLayoutParams);

//        layout.addView(disclaimer);


        Button sendEmailButton = findViewById(R.id.send_Btn);
        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView messageTextView = findViewById(R.id.message_textView);
                final String message = messageTextView.getText().toString();
                composeEmail(message);
            }
        });

        ImageButton telegramBtn = findViewById(R.id.telegram_Btn);
        telegramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("t.me/QueefyMcQueefius");
            }
        });

        ImageButton vkBtn = findViewById(R.id.vk_Btn);
        vkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("vk.com/id108902346");
            }
        });

        ImageButton gitBtn = findViewById(R.id.git_Btn);
        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("github.com/archer62");
            }
        });

    }

    public void composeEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"archer62@yandex.ru"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "AndroidAcademyFirstExercise");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "No email app found", Toast.LENGTH_LONG).show();
        }
    }

    public void openLink(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        }
        else {
            Toast.makeText(this, "No browser app found", Toast.LENGTH_LONG).show();
        }
    }
}
