package com.bottom_action_sheet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListBottomSheetDialog extends BottomSheetDialog {



    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    String[] mChoices;
    ListView mListView;

    public ListBottomSheetDialog(@NonNull Context context) {
        super(context);

        mListView = new ListView(context);
        mListView.setDivider(null);
        mListView.setDividerHeight(0);
    }

    public void setChoices(String[] choices){
        mChoices = choices;
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public void show() {
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.sheet_item, mChoices);
        mListView.setAdapter(adapter);

        setContentView(mListView);

        super.show();
    }

}
