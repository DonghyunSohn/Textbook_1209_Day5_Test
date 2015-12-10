package com.hanssemmall.p227;

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

    /**
     * 부가 데이터를 위해 정의한 키 값
     */
    public static final String KEY_SIMPLE_DATA = "data";

    /**
     * 텍스트뷰
     */
    TextView txtMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        Button backBtn = (Button) findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", "mike");


                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        processIntent();
    }


    private void processIntent() {

        Bundle bundle = getIntent().getExtras();

        SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA); // 텍스트뷰에 값을 보여줍니다.
        txtMsg.setText("Parcelable 객체로 전달된 값\nNumber : " + data.getNumber() + "\nMessage : " + data.getMessage());
    }

}
