package com.example.greetings.dataClasses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greetings.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.greetings.R.id.counterOld;

public class HeaderFragment extends Fragment {

    View root;

    @BindView(R.id.counterAll)
    TextView counterAll;
    @BindView(R.id.counterNew)
    TextView counterNew;
    @BindView(R.id.counterOld)
    TextView counterOld;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        root = inflater.inflate(R.layout.fragment_header, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    public void setCounterNew(int value) {counterNew.setText(String.valueOf(value));}

    public void setCounterAll(int value) {counterAll.setText(String.valueOf(value));}

    public void setCounterOld(int value) {counterOld.setText(String.valueOf(value));}

}
