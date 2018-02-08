package com.pwucdcec.animaltrivia;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalInformationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvScientificName)
    TextView tvScientificName;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.container)
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_information);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        Bundle extras = getIntent().getExtras();
        int category = extras.getInt(Const.BUNDLEKEY_CATEGORY);
        int index = extras.getInt(Const.BUNDLEKEY_INDEX);

        AnimalItem item = DatabaseHelper.getAnimalItem(this, category, index);


        container.setBackgroundResource(Const.GAME_BACKGROUND[category]);
        Picasso.with(this).load(item.getDrawable()).into(imageView);
        tvName.setText(item.getName());
        tvScientificName.setText(item.getScientificName());
        tvDescription.setText(Html.fromHtml(item.getDescription()));

//        tvDescription.setText(item.getDescription());
    }
}
