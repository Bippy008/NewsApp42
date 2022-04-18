package kg.geektech.newsapp42.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import kg.geektech.newsapp42.OnItemClickListener;
import kg.geektech.newsapp42.R;
import kg.geektech.newsapp42.databinding.FragmentBoardBinding;


public class BoardFragment extends Fragment implements OnItemClickListener {
    private BoardAdapter adapter;
    private FragmentBoardBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new BoardAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.setOnItemClickListener(this);
        /*
        viewPager2 = view.findViewById(R.id.view_pager);
        viewPager2.setAdapter(adapter);
        wormDotsIndicator = (WormDotsIndicator) view.findViewById(R.id.worm_dots_indicator);
        wormDotsIndicator.setViewPager2(viewPager2);
         */

        //wormDotsIndicator = (WormDotsIndicator) view.findViewById(R.id.worm_dots_indicator);
        //viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager);
        binding.viewPager.setAdapter(adapter);
        binding.wormDotsIndicator.setViewPager2(binding.viewPager);
    }

    @Override
    public void onItemClick(int position) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }

    @Override
    public void onItemLongClick(int position) {

    }


}