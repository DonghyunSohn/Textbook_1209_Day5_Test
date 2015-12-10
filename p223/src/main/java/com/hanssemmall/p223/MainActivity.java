package com.hanssemmall.p223;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    TextView txtMsg;
    String msg;

    public static final int REQUEST_CODE_ANOTHER = 1001;


    public static int startCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView) findViewById(R.id.txtMsg);

        processIntent();
    }

    public void onButton1Clicked(View v) {
        startCount++;


        Intent intent = new Intent(getBaseContext(), AnotherActivity.class);

        intent.putExtra("startCount", startCount);


        startActivityForResult(intent, REQUEST_CODE_ANOTHER);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent();

        super.onNewIntent(intent);
    }

    private void processIntent() {
        Intent receivedIntent = getIntent();
        startCount = receivedIntent.getIntExtra("startCount", 0);

        msg = "전달된 startCount : " + startCount;
        txtMsg.setText(msg);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ANOTHER) {
            Toast toast = Toast.makeText(this, "onActivityResult() 메소드가 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}