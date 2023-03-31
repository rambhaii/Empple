package com.empeople.Utils;

import android.app.Dialog;
import android.content.Context;

import com.empeople.R;

public class
Loader extends Dialog {

        public Loader(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        public Loader(Context context, int theme) {
            super(context, theme);
            // TODO Auto-generated constructor stub
            setContentView(R.layout.loader);
        }

        public Loader(Context context, boolean cancelable,
                      OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
            // TODO Auto-generated constructor stub
        }
    }

