package kg.geektech.newsapp42;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.newsapp42.databinding.FragmentHomeBinding;
import kg.geektech.newsapp42.databinding.FragmentNewsBinding;
import kg.geektech.newsapp42.databinding.FragmentProfileBinding;
import kg.geektech.newsapp42.models.Article;

public class NewsFragment extends Fragment{
    private FragmentNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        String text = binding.etText.getText().toString();
        Bundle bundle = new Bundle();
        Article article = new Article(text, System.currentTimeMillis());
        bundle.putSerializable("article", article);
        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        closeFragment();
    }

    private void closeFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}