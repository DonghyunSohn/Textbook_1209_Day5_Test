package hanssem.p205;

        import android.app.Activity;
        import android.content.ComponentName;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_ANOTHER = 1001;

    public void onButton1Clicked(View v) {
        Intent intent = new Intent();

        ComponentName name = new ComponentName("com.hanssemmall.p212", "com.hanssemmall.p212.AnotherActivity");
        intent.setComponent(name);
        startActivityForResult(intent, REQUEST_CODE_ANOTHER);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_ANOTHER) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult 메소드가 호출됨. 요청코드 : " + requestCode + " , 결과 코드 : " + resultCode,
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
