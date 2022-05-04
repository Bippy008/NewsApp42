package kg.geektech.newsapp42.ui.profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.cast.framework.media.ImagePicker;

import java.io.File;
import java.net.URISyntaxException;

import kg.geektech.newsapp42.Prefs;
import kg.geektech.newsapp42.R;
import kg.geektech.newsapp42.databinding.FragmentHomeBinding;
import kg.geektech.newsapp42.databinding.FragmentProfileBinding;
import kg.geektech.newsapp42.models.Avatar;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Prefs prefs = new Prefs(requireContext());


        ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                //getActivity().grantUriPermission(getActivity().getPackageName(), result, FLAG_GRANT_READ_URI_PERMISSION);
                binding.profileImage.setImageURI(result);
                prefs.saveAvatar(result.getPath());
                binding.profileImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        Avatar avatar = new Avatar(result);
                        bundle.putSerializable("avatar_image", avatar);
                        getParentFragmentManager().setFragmentResult("rk_avatar", bundle);
                        NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.action_navigation_profile_to_avatarFragment);
                    }
                });
            }
        });
        binding.profileBtn.setOnClickListener(view1 -> launcher.launch("image/*"));

        binding.profileNameEt.setText(prefs.getName());
        binding.profileNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = binding.profileNameEt.getText().toString();
                prefs.saveName(name);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}