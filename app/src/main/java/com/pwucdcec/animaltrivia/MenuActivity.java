package com.pwucdcec.animaltrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    String TAG = MenuActivity.class.getSimpleName();

    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnAboutUs)
    Button btnAboutUs;
    @BindView(R.id.btnQuit)
    Button btnQuit;
    @BindView(R.id.imageView)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

    }

//    private void readData() {
//
//        DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
//
//
//        Log.d(TAG, "Count: " + cursor.getCount());
//        while (cursor.moveToNext()) {
//
//            textView.setText(Html.fromHtml(cursor.getString(cursor.getColumnIndex("description"))));
////            int drawable = cursor.getInt(cursor.getColumnIndex("drawable"));
////            Picasso.with(this).load(drawable).into(imageView);
//        }
//
//    }

    @OnClick({R.id.btnPlay, R.id.btnAboutUs, R.id.btnQuit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.btnAboutUs:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.btnQuit:

                break;
        }
    }
}
