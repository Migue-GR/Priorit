package pizziirreverent.priorit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Animation animation = new AnimationUtils().loadAnimation(this, R.anim.scale_item_menu_left);
        final Animation animation1 = new AnimationUtils().loadAnimation(this, R.anim.scale_item_menu_right);


    }
}
