package com.pwucdcec.animaltrivia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class  GameActivity extends AppCompatActivity {

    String TAG = "LOG_" + GameActivity.class.getSimpleName();

    @BindViews({R.id.btnOption1, R.id.btnOption2, R.id.btnOption3, R.id.btnOption4})
    List<Button> btnOptions;

    @BindView(R.id.container)
    ConstraintLayout container;

    @BindView(R.id.imageView)
    ImageView imageView;


    Bundle extras;
    AnimalItem item;
    int tempAnswer;

    List<String> animalNames;
    List<String> tempAnswers;

    Random random;

    int mistake = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        extras = getIntent().getExtras();

        int category = extras.getInt(Const.BUNDLEKEY_CATEGORY);
        int index = extras.getInt(Const.BUNDLEKEY_INDEX);

        container.setBackgroundResource(Const.GAME_BACKGROUND[category]);

        item = DatabaseHelper.getAnimalItem(this, category, index);

        Log.d(TAG, "Name: " + item.getName() + " Drawable: " + item.getDrawable());

        Picasso.with(this).load(item.getDrawable()).into(imageView);

        animalNames = DatabaseHelper.getAnimalNames(this, category, index);
        tempAnswers = new ArrayList<>();
        random = new Random();
        tempAnswer = random.nextInt(4);
        Log.d(TAG, "TempAnswer: " + tempAnswer);


        ButterKnife.Action<Button> btnOptionActions = new ButterKnife.Action<Button>() {
            @Override
            public void apply(@NonNull Button view, final int i) {

                if (tempAnswer == i) {
                    tempAnswers.add(item.getName());
                    view.setText(tempAnswers.get(i));
                } else
                    view.setText(getOption());


                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setEnabled(false);
                        selectAnswer(i);
                    }
                });
            }
        };

        ButterKnife.apply(btnOptions, btnOptionActions);
    }

    private void selectAnswer(int i) {

        // Answer Correct;
        if (i == tempAnswer) {

            startActivity(new Intent(this, AnimalInformationActivity.class).putExtras(extras));
            DatabaseHelper.updateAnimals(this, item.getCategory(), item.getId());
            finish();

        } else {
            mistake++;
            if (mistake == 1) {
                DialogBuilder.createAlertDialog(this, "Incorrect!",
                        "Sorry! You answer is wrong. You have last chance to choose the correct answer",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
            } else {
                DialogBuilder.createAlertDialog(this, "Incorrect!",
                        "Sorry you answered incorrect twice please try again later!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
            }

        }

    }

    private String getOption() {
        int option = random.nextInt(animalNames.size());

        String tempOption = animalNames.get(option);
        if (isExist(tempAnswers, tempOption))
            while (isExist(tempAnswers, tempOption)) {
                option = random.nextInt(animalNames.size());
                tempOption = animalNames.get(option);
            }
        tempAnswers.add(tempOption);
        return tempOption;
    }

    public static boolean isExist(List<String> list, String x) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).equals(x))
                return true;

        return false;
    }
}
