package vn.edu.vtn.demo_mvp_splash.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.vtn.demo_mvp_splash.R;
import vn.edu.vtn.demo_mvp_splash.db.HelperModel;
import vn.edu.vtn.demo_mvp_splash.db.model.Info;
import vn.edu.vtn.demo_mvp_splash.db.prefs.SaveInfoLogin;

public class InfoFragment extends Fragment {
    TextView txtName, txtOld, txtHometown, txtWork;
    Info info;

//    public static InfoFragment newInstance(Info info) {
//        InfoFragment infoFragment = new InfoFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("INFO", info);
//        infoFragment.setArguments(bundle);
//        return infoFragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_info, container, false);
        txtName = view.findViewById(R.id.txtName);
        txtOld = view.findViewById(R.id.txtOld);
        txtHometown = view.findViewById(R.id.txtHometown);
        txtWork = view.findViewById(R.id.txtWork);

        SaveInfoLogin saveInfoLogin = new SaveInfoLogin(this.getActivity());
        String username = saveInfoLogin.preferences.getString("user", "");

        HelperModel helperModel = new HelperModel(getActivity());
        Info info = helperModel.getDataFromUsername(username);


        txtName.setText(info.getName());
        txtOld.setText(info.getOld());
        txtHometown.setText(info.getHometown());
        txtWork.setText(info.getWork());
        return view;
    }
}
