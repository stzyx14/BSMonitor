package gmcc.bsmonitor.activity;

import gmcc.bsmonitor.R;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    
    //显示4种状态基站数量的数字；
    private TextView mOverallTextView;
    private TextView mNormalTextView;
    private TextView mOutOfServiceTextView;	
    private TextView mPowerOffTextView;
    
    //以下四个View为按钮，点击进入对应状态基站告警列表；
    private LinearLayout mOverallView;
    private LinearLayout mNormalView;
    private LinearLayout mOutServiceView;
    private LinearLayout mPowerOffView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
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
    	View rootView = inflater.inflate(R.layout.fragment_list, container, false);

    	//此处判断传入的对象非空
    	if(true){
    		initView(rootView);
    	}
    	
    	return rootView;   
    }

    private void initView(View rootView) {
		// TODO Auto-generated method stub
    	mOverallTextView = (TextView) rootView.findViewById(R.id.tv_list_overall);
    	mNormalTextView = (TextView) rootView.findViewById(R.id.tv_list_normal);
    	mOutOfServiceTextView = (TextView) rootView.findViewById(R.id.tv_list_out_of_service);
    	mPowerOffTextView = (TextView) rootView.findViewById(R.id.tv_list_power_off);
    	
    	mOverallView = (LinearLayout) rootView.findViewById(R.id.ll_list_overall);
    	mOverallView.setOnClickListener(this);
    	mNormalView = (LinearLayout) rootView.findViewById(R.id.ll_list_normal);
    	mNormalView.setOnClickListener(this);
    	mOutServiceView = (LinearLayout) rootView.findViewById(R.id.ll_list_out_of_service);
    	mOutServiceView.setOnClickListener(this);
    	mPowerOffView = (LinearLayout) rootView.findViewById(R.id.ll_list_power_off);
    	mPowerOffView.setOnClickListener(this);
    	
	}

	// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
//            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
    	case R.id.ll_list_overall:
    		//跳转至OverallList
    		Toast.makeText(getActivity(), "ll_list_overall", Toast.LENGTH_SHORT).show();
    		break;
    	case R.id.ll_list_normal:
    		//跳转至NormalList
    		Toast.makeText(getActivity(), "ll_list_normal", Toast.LENGTH_SHORT).show();
    		break;
    	case R.id.ll_list_out_of_service:
    		//跳转至退服告警列表
    		Toast.makeText(getActivity(), "ll_list_out_of_service", Toast.LENGTH_SHORT).show();
    		break;
    	case R.id.ll_list_power_off:
    		//jump 2 list of poweroff alarm
    		Toast.makeText(getActivity(), "ll_list_power_off", Toast.LENGTH_SHORT).show();
    		break;
		default:
			break;
	}
	}

}
