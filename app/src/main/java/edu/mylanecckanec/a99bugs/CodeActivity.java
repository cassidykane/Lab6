package edu.mylanecckanec.a99bugs;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CodeActivity extends AppCompatActivity implements Button.OnClickListener {

    Button patchAroundButton;
    Integer newBugCount;
    public static final String NEW_BUG_COUNT = "newBugCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        patchAroundButton = (Button)findViewById(R.id.patchAroundButton);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        Integer bugCount = Integer.parseInt(intent.getExtras().getString(MainActivity.BUG_COUNT));
        newBugCount = bugCount + 7;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CodeActivity.class);
        intent.putExtra(NEW_BUG_COUNT, newBugCount);
        startActivity(intent);
    }
}
