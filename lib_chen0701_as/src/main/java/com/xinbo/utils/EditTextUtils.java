package com.xinbo.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by admin on 2016/8/20 0020.
 */

// 监听小数点让用户只能输入小数点后两位
public class EditTextUtils
{
    //监听EditText内容变化 控制小数点两位
    public static void setPricePoint(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 3);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    editText.setText(s);
                    editText.setSelection(2);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        editText.setText(s.subSequence(0, 1));
                        editText.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
    }

    //监听小数点让用户只能输入小数点后两位
    public static void setPrice(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {

                if (s.toString().trim().substring(0).equals("0")) {
                    s = "";
                    editText.setText(s);
                    editText.setSelection(0);
                }
                if(s.toString().trim().startsWith("5") && s.length()>1 && !s.toString().trim().subSequence(1,2).equals("0"))
                {
                    s="50";
                    editText.setText(s);
                    editText.setSelection(2);
                }
                if((s.toString().trim().startsWith("6") || s.toString().trim().startsWith("7") || s.toString().trim().startsWith("8")
                        || s.toString().trim().startsWith("9")) && s.length() >1)
                {
                    s=s.toString().trim().substring(0,1);
                    editText.setText(s);
                    editText.setSelection(s.length());
                }else
                {
                    if (s.length()  > 2) {
                        s = s.toString().subSequence(0,2);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                }




            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
    }

}
