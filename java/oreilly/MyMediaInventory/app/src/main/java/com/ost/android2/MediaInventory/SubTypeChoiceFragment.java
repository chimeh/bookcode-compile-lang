package com.ost.android2.MediaInventory;

import com.ost.android2.MediaInventory.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class SubTypeChoiceFragment extends DialogFragment {
  private static final String TAG = "SubTypeChoiceFragment";
  public static final String EXTRA_SUBTYPE =
      "com.ost.android2.MediaInventory.subtype";
  private String mSubType;
  
  public static SubTypeChoiceFragment newInstance(String subtype) {
    Log.d(TAG, "newInstance() called"); 
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_SUBTYPE, subtype);
    SubTypeChoiceFragment stpf = new  SubTypeChoiceFragment(); 
    stpf.setArguments(args);
    return stpf;  
  }
  
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Log.d(TAG, "OnCreateDialog() called"); 
    getmSubType(); 
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.subtype_picker_title)
           .setItems(R.array.subtype, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
               String[] subtypes = getResources().getStringArray(R.array.subtype); 
               String subtypeChosen = subtypes[which];
               setmSubType(subtypeChosen);
               sendResult(Activity.RESULT_OK);
           }
    });
    return builder.create();
}

  public void setmSubType(String t)  {
    this.mSubType = t;
    getArguments().putSerializable(EXTRA_SUBTYPE, t);
  }
  
  public void getmSubType()  {
    mSubType =(String)getArguments().getSerializable(EXTRA_SUBTYPE);
  }
    
  public void sendResult(int resultCode) {
    if (getTargetFragment() == null) {
      return;
    }
    Intent i = new Intent();
    i.putExtra(EXTRA_SUBTYPE, mSubType);
    
    getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
  }
  
  }

