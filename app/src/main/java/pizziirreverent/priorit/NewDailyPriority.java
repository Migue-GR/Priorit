package pizziirreverent.priorit;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class NewDailyPriority extends AppCompatActivity{
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    /*
     * UI OBJECTS
     */
    @BindView(R.id.txt_priority)
    public EditText txt_priority;

    /*
     * FINAL VARS
     */
    private static final String TAG = "NewDailyPriority";

    /*
     * ACTIVITY VARS/OBJECTS
     */
    private String priority;
    private Intent saveIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_daily_priority);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_save)
    public void savePriority(){
        saveIntent = new Intent();

        /*
         * If there is not text, we set the result as CANCELED
         * Else we save the text and set the result as OK.
         */
        if (TextUtils.isEmpty(txt_priority.getText())) {
            setResult(RESULT_CANCELED, saveIntent);

        }else{
            priority = txt_priority.getText().toString();
            saveIntent.putExtra(EXTRA_REPLY, priority);
            setResult(RESULT_OK, saveIntent);
        }

        finish();
    }
}
