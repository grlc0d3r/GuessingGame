package constraints.karynboyd.com.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random n = new Random();
    int random = n.nextInt(100)+1;
    //int random = 5;
    int tries;
    EditText guessView;
    TextView msgView;
    //int guess = Integer.parseInt(guessView.getText().toString());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessView = findViewById(R.id.guessView);
        msgView = findViewById(R.id.msgView);
    }

    public void checkGuess(View view) {
        int guess = Integer.parseInt(guessView.getText().toString());
        tries++;
        if(guess == random)
        {
            msgView.setText("You got it in " + tries + " guesses!");
        } else if (guess < random)
        {
            msgView.setText("Too low!");
        } else
        {
            msgView.setText("Too high!");
        }

    }

   public void giveUp(View view){
        msgView.setText("The answer is " + random);
        tries = 0;
    }

   public void newGame(View view) {
        tries = 0;
        guessView.setText("");
        msgView.setText("");
    }

}
