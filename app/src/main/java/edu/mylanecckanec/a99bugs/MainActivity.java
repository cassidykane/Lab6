package edu.mylanecckanec.a99bugs;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    Button oneDownButton;
    Button twoDownButton;
    TextView messageTextView;
    public static final String BUG_COUNT = "bugCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneDownButton = (Button)findViewById(R.id.oneDownButton);
        twoDownButton = (Button)findViewById(R.id.twoDownButton);
        messageTextView = (TextView)findViewById((R.id.messageTextView));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Integer newBugCount;
        Intent intent = getIntent();
        if (intent == null) {
            newBugCount = Integer.parseInt(intent.getExtras().getString(CodeActivity.NEW_BUG_COUNT));
            messageTextView.setText(newBugCount + " little bugs in the code");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.oneDownButton)
            takeBugDownHandler("1");
        else if (v.getId() == R.id.twoDownButton)
            takeBugDownHandler("2");
    }

    public void takeBugDownHandler(String bugCount)
    {
        Intent intent = new Intent(this, CodeActivity.class);
        intent.putExtra(BUG_COUNT, bugCount);
        startActivity(intent);
    }
}
