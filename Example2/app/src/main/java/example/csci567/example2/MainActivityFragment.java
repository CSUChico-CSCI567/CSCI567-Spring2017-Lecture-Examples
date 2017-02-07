package example.csci567.example2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.tv3) TextView tv3;
    @BindView(R.id.tv1)
    EditText tv1;

    @OnClick(R.id.button1)
    public void clicked(View view) {
        Toast.makeText(getContext(),tv1.getText(),Toast.LENGTH_SHORT).show();
        // TODO submit data to server...
    }

    @OnLongClick(R.id.button1)
    public boolean longclicked(View view){
        Toast.makeText(getContext(),"Button Long Clicked", Toast.LENGTH_LONG).show();
        return true;
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
//        Button button = (Button) view.findViewById(R.id.button1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"Button Clicked",Toast.LENGTH_SHORT).show();
//            }
//        });
        tv3.setText("Goodbye world");
        return view;
    }
}
