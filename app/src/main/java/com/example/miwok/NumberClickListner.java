package com.example.miwok;

import android.view.View;
import android.widget.Toast;

public class NumberClickListner implements View.OnClickListener {
    @Override
    public void onClick(View view){
        Toast makeToast = Toast.makeText(view.getContext(), "Open List Of numbers",Toast.LENGTH_SHORT);
        makeToast.show();
    }
}
