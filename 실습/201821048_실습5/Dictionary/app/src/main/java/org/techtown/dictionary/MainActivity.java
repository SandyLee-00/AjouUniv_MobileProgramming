package org.techtown.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements word_fragment.OnWordSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){
            word_fragment wordsFragment = new word_fragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.fragment_container, wordsFragment).commit();
        }
    }

    public void onWordSelected(int position){
        if(findViewById(R.id.fragment_container) != null){
            Def_Fragment newFragment = new Def_Fragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}