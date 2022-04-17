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
import kg.geektech.newsapp42.ui.home.NewsAdapter;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private String[] titles = new String[] {"Привет", "Hello", "Салам"};
    private String[] descriptions = new String[] {"Вау алала", "блаблабла", "Салам алекум"};
    private int[] images = new int[] {R.drawable.burger_1, R.drawable.burger_2, R.drawable.burger_3};
    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
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
        private TextView textTitle, description;
        private Button btnStart;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.pager_title);
            btnStart = itemView.findViewById(R.id.btn_start);
            description = itemView.findViewById(R.id.pager_desk);
            image = itemView.findViewById(R.id.pager_image);
        }


        public void bind(int position) {
            textTitle.setText(titles[position]);
            description.setText(descriptions[position]);
            image.setImageResource(images[position]);
            if (position == titles.length-1) {
                btnStart.setVisibility(View.VISIBLE);
                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                });
            } else btnStart.setVisibility(View.INVISIBLE);
        }
    }
}
