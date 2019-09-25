
# react-native-bottom-action-sheet

A node javascript library which provides an Android implementation of ActionSheetIOS for React Native. Adheres to Material Design guidelines for a basic list bottom sheet 

Originally inspired from: https://github.com/yfuks/react-native-action-sheet

### Installation

Install via npm:
```
npm install @tealeav/react-native-bottom-action-sheet
```

React Native >0.60 can utilize autolinking. For React Native <0.60, make sure to link the package:
```
react-native link @tealeav/react-native-bottom-action-sheet
```

### Usage

Works just like [ActionSheetIOS](https://facebook.github.io/react-native/docs/actionsheetios). 

*Note:* Currently, only `showActionSheetWithOptions()` is implemented.

**showActionSheetWithOptions(params, callback)**

*Note:* Currently, only the `options` paramater within `params` is implemented for Android. However, adding other parameters available in iOS will not cause problems with Android devices.

Example
```javascript
import ActionSheet from '@tealeav/react-native-bottom-action-sheet'

ActionSheet.showActionSheetWithOptions(
  {
    options: ["Edit", "Delete"]
  },
  (buttonIndex) => {
    if(buttonIndex === 0){
      console.log("Edited")
    } else {
      console.log("Deleted")
    }
  }
);
```

### TODO

 - Enable title and title description
 
 
##### Contribution & Questions

If you would like to contribute or run into problems, feel free to open a new issue to start a discussion about it!
