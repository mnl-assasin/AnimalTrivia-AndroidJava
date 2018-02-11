package com.pwucdcec.animaltrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.containerAmphibians)
    RelativeLayout containerAmphibians;
    @BindView(R.id.containerBirds)
    RelativeLayout containerBirds;
    @BindView(R.id.containerFish)
    RelativeLayout containerFish;
    @BindView(R.id.containerMammals)
    RelativeLayout containerMammals;
    @BindView(R.id.containerReptiles)
    RelativeLayout containerReptiles;

    @BindViews({R.id.progressAmphibians, R.id.progressBirds, R.id.progressFish, R.id.progressMammals, R.id.progressReptiles})
    List<TextView> tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        initData();
    }

    private void initData(){

        ButterKnife.Action<TextView> progressAction = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setText(DatabaseHelper.getProgress(getApplication(), index));
            }
        };

        ButterKnife.apply(tvProgress, progressAction);

    }

    @OnClick({R.id.containerAmphibians, R.id.containerBirds, R.id.containerFish, R.id.containerMammals, R.id.containerReptiles})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.containerAmphibians:
                startActivity(Const.CAT_AMPHIBIANS);
                break;
            case R.id.containerBirds:
                startActivity(Const.CAT_BIRDS);
                break;
            case R.id.containerFish:
                startActivity(Const.CAT_FISH);
                break;
            case R.id.containerMammals:
                startActivity(Const.CAT_MAMMALS);
                break;
            case R.id.containerReptiles:
                startActivity(Const.CAT_REPTILES);
                break;
        }
    }

    private void startActivity(int category) {
        startActivity(new Intent(this, CategoryPreviewActivity.class).putExtra(Const.BUNDLEKEY_CATEGORY, category));
    }
}
