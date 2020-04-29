package Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Room.User;
import Room.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
