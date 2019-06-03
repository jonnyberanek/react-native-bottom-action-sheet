// ToastModule.java

package com.bottom_action_sheet;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

import java.util.ArrayList;

import android.support.v4.app.FragmentActivity;

public class BottomActionSheetModule extends ReactContextBaseJavaModule {

  public BottomActionSheetModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "BottomActionSheet";
  }

  /* https://facebook.github.io/react-native/docs/actionsheetios
     static showActionSheetWithOptions(options, callback)
  */
  @ReactMethod
  public void showActionSheetWithOptions(ReadableMap options, final Callback callback) {

    // Pull out list of options as ArrayList
    ArrayList<Object> optionsList = options.getArray("options").toArrayList();
    // TODO: add functionality for title & message
    //String title = options.getString("title");
    //String message = options.getString("message");
    
    // cancel & destructive button indeces do not matter to android's bottom sheet design pattern
    // anchor and tintColor is irrelevant to android

    // Instantiates a new action sheet dialog
    final ListBottomSheetDialog actionSheet = new ListBottomSheetDialog(getCurrentActivity());

    // Set choices and for the items to act accordingly to callback on click
    actionSheet.setChoices(optionsList.toArray(new String[0]));
    actionSheet.setOnItemClickListener(new ListBottomSheetDialog.OnItemClickListener(){
      @Override
      public void onItemClick(int position){
        actionSheet.dismiss();
        callback.invoke(position);
      }
    });

    // TODO: add functionality for title and description
    
    // Display ActionSheet on screen
    actionSheet.show();

  }



}
