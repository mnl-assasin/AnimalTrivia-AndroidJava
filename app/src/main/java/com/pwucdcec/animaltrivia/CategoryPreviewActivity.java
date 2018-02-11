package com.pwucdcec.animaltrivia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class CategoryPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "LOG_" + CategoryPreviewActivity.class.getSimpleName();

    @BindViews({R.id.ivItem0, R.id.ivItem1, R.id.ivItem2, R.id.ivItem3,
            R.id.ivItem4, R.id.ivItem5, R.id.ivItem6, R.id.ivItem7,
            R.id.ivItem8, R.id.ivItem9, R.id.ivItem10, R.id.ivItem11,
            R.id.ivItem12, R.id.ivItem13, R.id.ivItem14, R.id.ivItem15,
            R.id.ivItem16, R.id.ivItem17, R.id.ivItem18, R.id.ivItem19})
    List<ImageView> ivItems;
    List<AnimalItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_preview);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {

        items = new ArrayList<>();
        final int category = getIntent().getExtras().getInt(Const.BUNDLEKEY_CATEGORY, 0);
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, "category =?", new String[]{String.valueOf(category)}, null, null, null);
        if (cursor != null)
            while (cursor.moveToNext())
                items.add(new AnimalItem(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5), cursor.getString(6)));


        ButterKnife.Action<ImageView> ivItemActions = new ButterKnife.Action<ImageView>() {
            @Override
            public void apply(@NonNull ImageView view, final int index) {

                if (items.get(index).getIsSolved() == 0)
                    view.setImageBitmap(BlurBuilder.blur(getApplicationContext(), BitmapFactory.decodeResource(getResources(), items.get(index).getDrawable())));
                else
                    Picasso.with(getApplicationContext()).load(items.get(index).getDrawable()).into(view);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle extras = new Bundle();
                        extras.putInt(Const.BUNDLEKEY_CATEGORY, category);
                        extras.putInt(Const.BUNDLEKEY_INDEX, index + 1);

                        if (items.get(index).getIsSolved() == 0)
                            startActivity(new Intent(getApplicationContext(), GameActivity.class).putExtras(extras));
                        else
                            startActivity(new Intent(getApplicationContext(), AnimalInformationActivity.class).putExtras(extras));
                    }
                });

            }
        };

        ButterKnife.apply(ivItems, ivItemActions);


//        for(int i = 0; i < items.size(); i++){
//            Picasso.with(this).load(items.get(i).getDrawable()).into(ivItems.get(i));
//            ivItems.get(i).setOnClickListener(this);
//        }

    }

    @Override
    public void onClick(View view) {

    }
}
