package Room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flappybird.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestScoreFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    public BestScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_best_score, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);

//        users = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            User user = new User("Raileanu Alexandru #" +i, 10);
//            users.add(user);
//        }

        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

        List<User> users = db.userDao().getAllUsers();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);


        return view;
    }


}
