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

    Display an iOS action sheet. The options object must contain one or more of:

    options (array of strings) - a list of button titles (required)
    cancelButtonIndex (int) - index of cancel button in options
    destructiveButtonIndex (int) - index of destructive button in options
    title (string) - a title to show above the action sheet
    message (string) - a message to show below the title
    anchor (number) - the node to which the action sheet should be anchored (used for iPad)
    tintColor (string) - the color used for non-destructive button titles

    The 'callback' function takes one parameter, the zero-based index of the selected item.
  */

  @ReactMethod
  public void showActionSheetWithOptions(ReadableMap options, final Callback callback) {

    ArrayList<Object> optionsList = options.getArray("options").toArrayList();
    // cancel & destructive button indeces matter to android's bottom sheet design pattern
    //String title = options.getString("title");
    //String message = options.getString("message");
    // anchor and tintColor is irrelevant to android

    final ListBottomSheetDialog actionSheet = new ListBottomSheetDialog(getCurrentActivity());

    actionSheet.setChoices(optionsList.toArray(new String[0]));
    actionSheet.setOnItemClickListener(new ListBottomSheetDialog.OnItemClickListener(){
      @Override
      public void onItemClick(int position){
        actionSheet.dismiss();
        callback.invoke(position);
      }
    });

    // TODO: add functionality for title and description

    actionSheet.show();

    // try{
    //     final FragmentActivity activity = (FragmentActivity) getReactApplicationContext().getApplicationContext();
    //
    //     actionSheet.show(activity.getSupportFragmentManager(), getName().concat("Fragment"));
    //
    // } catch (ClassCastException e) {
    //   throw e;
    // }
    //


  }



}
