package kg.geektech.newsapp42.ui.profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import kg.geektech.newsapp42.R;
import kg.geektech.newsapp42.databinding.FragmentAvatarBinding;
import kg.geektech.newsapp42.databinding.FragmentProfileBinding;
import kg.geektech.newsapp42.models.Article;
import kg.geektech.newsapp42.models.Avatar;


public class AvatarFragment extends Fragment {
    private FragmentAvatarBinding binding;
    private Avatar avatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAvatarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        getParentFragmentManager().setFragmentResultListener("rk_avatar", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Avatar avatar = (Avatar) result.getSerializable("avatar_image");
                binding.avatarImage.setImageURI(avatar.getUri());
            }
        });

    }
}