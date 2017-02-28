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

public class TypeChoiceFragment extends DialogFragment {
  private static final String TAG = "TypeChoiceFragment";
  public static final String EXTRA_TYPE =
      "com.ost.android2.MediaInventory.type";
  private String mType;
  
  public static TypeChoiceFragment newInstance(String type) {
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_TYPE, type);
    TypeChoiceFragment  tpf = new  TypeChoiceFragment(); 
    tpf.setArguments(args);
    return tpf;  
  }
  
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Log.d(TAG, "OnCreateDialog called");
    getmType(); 
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.type_picker_title)
           .setItems(R.array.type, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
               // The 'which' argument contains the index position
               // of the selected item
               String[] types = getResources().getStringArray(R.array.type); 
               String typeChosen = types[which];
               setmType(typeChosen);
               sendResult(Activity.RESULT_OK);
           }
    });
    return builder.create();
}

  public void setmType(String t)  {
    this.mType = t;
    getArguments().putSerializable(EXTRA_TYPE, t);
  }
  
  public void getmType()  {
    mType =(String)getArguments().getSerializable(EXTRA_TYPE);
  }
    
  public void sendResult(int resultCode) {
    if (getTargetFragment() == null) {
      return;
    }
    Intent i = new Intent();
    i.putExtra(EXTRA_TYPE, mType);
    
    getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
  } // end of sendResult
  
  } // end of Type Choice Fragment Class

