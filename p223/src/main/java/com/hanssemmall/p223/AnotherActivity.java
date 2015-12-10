package com.hanssemmall.p223;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;

/**
 * 새로운 액티비티
 *
 * @author Mike
 */
public class AnotherActivity extends Activity {
    Button backBtn;
    TextView txtMsg;
    String msg;

    int startCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        backBtn = (Button) findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(getBaseContext(), MainActivity.class);
                newIntent.putExtra("startCount", startCount);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(newIntent);
            }
        });
        processIntent();
    }

    private void processIntent() {
        Intent receivedIntent = getIntent();
        startCount = receivedIntent.getIntExtra("startCount", 0);

        msg = "전달된 startCount : " + startCount;
        txtMsg.setText(msg);
    }

}
