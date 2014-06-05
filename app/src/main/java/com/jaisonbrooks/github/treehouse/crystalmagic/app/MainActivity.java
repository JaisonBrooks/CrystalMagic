package com.jaisonbrooks.github.treehouse.crystalmagic.app;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Random;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private String answer;
    private TextSwitcher answerSwitcher;
    private TextView answerTextView;
    private int[] colors;
    private CrystalMagic crystalMagic = new CrystalMagic();
    private Typeface robotoThin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
        initialize();
        setupTextSwitcher();
    }

    private void findViewByIds() {
        Button askCrystal = (Button) findViewById(R.id.btn_answer);
        askCrystal.setOnClickListener(this);
    }

    public void initialize() {
        answer = getString(R.string.title_answer);
        colors = getApplication().getResources().getIntArray(R.array.colors);
    }

    private void setupTextSwitcher() {
        String temp = "\"" + answer + "\"";
        answerSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher); // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        answerSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                answerTextView = new TextView(MainActivity.this);
                float textSize = getResources().getDimension(R.dimen.activity_answer_textsize);
                answerTextView.setTextSize(textSize);
                answerTextView.setTextColor(getResources().getColor(android.R.color.holo_purple));
                answerTextView.setTypeface(Typeface.createFromAsset(getAssets(),"Roboto-Thin.ttf"));
                return answerTextView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        in.setDuration(350);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        out.setDuration(350);
        answerSwitcher.setInAnimation(in); // set the animation type of textSwitcher
        answerSwitcher.setOutAnimation(out); // set the animation type of textSwitcher
        answerSwitcher.setText(temp);
    }

    @Override
    public void onClick(View view) {
         // Set answer to UI

        String magicAnswer = crystalMagic.getAnswer();
        answerSwitcher.setText("\"" + magicAnswer + "\"");
        Log.d("onClick", "Your Answer is " + "\"" + magicAnswer + "\"");
        int x = crystalMagic.getInt();
        answerTextView.setTextColor(crystalMagic.getInt());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
