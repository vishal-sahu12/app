package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<word> familyMemeber = new ArrayList<>();
        familyMemeber.add(new word("Father", "әpә",R.drawable.family_father));
        familyMemeber.add(new word("Mother", "әta",R.drawable.family_mother));
        familyMemeber.add(new word("Son", "angsi",R.drawable.family_son));
        familyMemeber.add(new word("Daughter", "tune",R.drawable.family_daughter));
        familyMemeber.add(new word("Older Brother", "taachi",R.drawable.family_older_brother));
        familyMemeber.add(new word("Younger Brother", "chalitti",R.drawable.family_younger_brother));
        familyMemeber.add(new word("Older Sister", "tete",R.drawable.family_older_sister));
        familyMemeber.add(new word("Younger Sister", "kolliti",R.drawable.family_younger_sister));
        familyMemeber.add(new word("Grand Mother", "ama",R.drawable.family_grandmother));
        familyMemeber.add(new word("Grand Father", "pappa",R.drawable.family_grandfather));

        WordAdapter itemAdapter = new WordAdapter(this,familyMemeber,R.color.category_family);
        ListView listView = findViewById(R.id.list_family);
        listView.setAdapter(itemAdapter);

    }

}