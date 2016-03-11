package testfacebookshare.customeratebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.textView);

        final RatingBar ratingBar_default = (RatingBar)findViewById(R.id.ratingbar_default);
        final RatingBar ratingBar_default1 = (RatingBar)findViewById(R.id.ratingbar_default1);

        final Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ratingBar_default.setRating(5);
                ratingBar_default1.setRating(5);




                text.setText("Rating Large:" + String.valueOf(ratingBar_default.getRating())+"\nRating Small:"+String.valueOf(ratingBar_default1.getRating()));
            }
        });

        ratingBar_default.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO Auto-generated method stub
                text.setText("Rating Large:" + String.valueOf(rating) + "\nRating Small:" + String.valueOf(ratingBar_default1.getRating()));
            }
        });
        ratingBar_default1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO Auto-generated method stub
                text.setText("Rating Large:" +String.valueOf(ratingBar_default.getRating()) +"\n Rating Small:"+String.valueOf(rating));
            }
        });

    }
}
