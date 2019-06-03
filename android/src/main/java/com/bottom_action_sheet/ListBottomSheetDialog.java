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
    AdapterView.OnItemClickListener mListener;

    public ListBottomSheetDialog(@NonNull Context context) {
        super(context);
    }

    public void setChoices(String[] choices){
        mChoices = choices;
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        mListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemClick(position);
            }
        };
    }

    @Override
    public void show() {

        ListView listView = new ListView(getContext());
        listView.setDivider(null);
        listView.setDividerHeight(0);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.sheet_item, mChoices);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mListener);

        setContentView(listView);

        super.show();
    }

}
