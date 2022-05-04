package kg.geektech.newsapp42;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context) { preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE); }

    public void saveState() { preferences.edit().putBoolean("isBoardShown", true).apply(); }

    public boolean isBoardShown() {
        return preferences.getBoolean("isBoardShown", false);
    }

    public void saveName(String name) { preferences.edit().putString("ProfileName", name).apply(); }

    public String getName() { return preferences.getString("ProfileName", ""); }

    public void saveAvatar(String avatarPath) { preferences.edit().putString("Avatar", avatarPath).apply(); }

    public String getAvatar() { return preferences.getString("Avatar", null); }

}
