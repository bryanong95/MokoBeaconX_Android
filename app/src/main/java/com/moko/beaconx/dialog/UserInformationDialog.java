package com.moko.beaconx.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moko.beaconx.R;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInformationDialog extends BaseDialog {

    @BindView(R.id.edit_ip)
    EditText ip_add;

    @BindView(R.id.edit_staff_id)
    EditText staff_id;

    @BindView(R.id.btn_done)
    Button btn_done;

    private String ipAdd;
    private String staffId;


    public UserInformationDialog(Context context){
        super(context);
    }
    @Override
    protected int getLayoutResId() {return R.layout.userinformation_dialog;}

    @Override
    protected void renderConvertView(View convertView, Object o) {

    }

    @OnClick({R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_done:
                if(ip_add.getText().toString().matches("")){
                    listener.onDone("",staff_id.getText().toString());
                }
                else if(staff_id.getText().toString().matches("")){
                    listener.onDone(ip_add.getText().toString(),"");
                }
                else {
                    listener.onDone(ip_add.getText().toString(), staff_id.getText().toString());
                }
                dismiss();
                break;

        }
    }

    private OnUserInformationListener listener;

    public void setOnUserInformationListener(OnUserInformationListener listener) {
        this.listener = listener;
    }

    public void setIpAdd(String IpAdd) {
        this.ipAdd = IpAdd;
    }
    public void setStaffId(String staffId){
        this.staffId = staffId;
    }

    public interface OnUserInformationListener{
        void onDone(String ipAdd, String staffId);
    }

}
