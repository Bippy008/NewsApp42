package kg.geektech.newsapp42.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapp42.BuildConfig;
import kg.geektech.newsapp42.OnItemClickListener;
import kg.geektech.newsapp42.R;
import kg.geektech.newsapp42.databinding.PagerBoardBinding;
import kg.geektech.newsapp42.ui.home.NewsAdapter;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private String[] titles = new String[] {"Привет", "Hello", "Салам"};
    private String[] descriptions = new String[] {"Вау алала", "блаблабла", "Салам алекум"};
    private int[] images = new int[] {R.drawable.burger_1, R.drawable.burger_2, R.drawable.burger_3};
    private int[] lotties = new int[] {R.raw.news_animation, R.raw.news2_animation, R.raw.news3_animation};
    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BoardAdapter.ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private PagerBoardBinding binding;


        public ViewHolder(PagerBoardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }


        public void bind(int position) {
            binding.pagerTitle.setText(titles[position]);
            binding.pagerDesk.setText(descriptions[position]);
            binding.pagerImage.setAnimation(lotties[position]);
            if (position == titles.length-1) {
                binding.btnStart.setVisibility(View.INVISIBLE);
                binding.btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                });
            } else binding.btnStart.setVisibility(View.INVISIBLE);
        }
    }
}
