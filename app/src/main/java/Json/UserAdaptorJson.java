package Json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flappybird.R;

import java.util.ArrayList;

public class UserAdaptorJson extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<UserJson> userJsons;

    public UserAdaptorJson() {
        userJsons = new ArrayList<>();
    }

    public void setData(ArrayList<UserJson> userJsons){
        this.userJsons = userJsons;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View userView = layoutInflater.inflate(R.layout.recycler_layout,parent, false);
        return new UserViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserJson userJson = userJsons.get(position);
        holder.name.setText(userJson.name);
        holder.score.setText(String.valueOf(userJson.score));
    }

    @Override
    public int getItemCount() {
        return userJsons.size();
    }
}
