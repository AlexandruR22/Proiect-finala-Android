package Json;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flappybird.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView score;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        score = itemView.findViewById(R.id.score);
    }
}
