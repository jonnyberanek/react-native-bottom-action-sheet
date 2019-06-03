package com.bottom_action_sheet;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListBottomSheetFragment extends BottomSheetDialogFragment {

  public interface OnItemClickListener{
      void onItemClick(int position);
  }

  String[] mChoices;
  AdapterView.OnItemClickListener mListener;

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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new BottomSheetDialog(getContext());

        ListView listView = new ListView(getContext());
        listView.setDivider(null);
        listView.setDividerHeight(0);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.sheet_item, mChoices);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mListener);

        dialog.setContentView(listView);

        return dialog;
    }
}
