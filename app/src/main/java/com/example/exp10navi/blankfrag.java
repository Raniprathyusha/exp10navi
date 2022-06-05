package com.example.exp10navi;


 import android.content.Context;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link blankfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class blankfrag extends Fragment {
    EditText first,last;
    Button submit;
    public interface Communication{
        public void sendData(Bundle bundle);
    }
    Communication c;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        c= (Communication) context;

    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public blankfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static blankfrag newInstance(String param1, String param2) {
        blankfrag fragment = new blankfrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_blankfrag, container, false);
        first=view.findViewById(R.id.first);
        last=view.findViewById(R.id.last);
        submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("first",first.getText().toString());
                bundle.putString("last",last.getText().toString());
                c.sendData(bundle);
            }
        });
        return view;
    }
}