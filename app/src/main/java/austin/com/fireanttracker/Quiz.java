package austin.com.fireanttracker;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private RelativeLayout mLayout;
    private TextView answers;
    private Button mButton;
    private View answerLine;
    private View toast;
    private Toast toast1;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Sets ActionBar (title bar at the top) color to red
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cc0000")));

        RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radiogroup1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radiogroup2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup)findViewById(R.id.radiogroup3);
        radioGroup3.clearCheck();

        RadioGroup radioGroup4 = (RadioGroup)findViewById(R.id.radiogroup4);
        radioGroup4.clearCheck();

        RadioGroup radioGroup5 = (RadioGroup)findViewById(R.id.radiogroup5);
        radioGroup5.clearCheck();

        RadioGroup radioGroup6 = (RadioGroup)findViewById(R.id.radiogroup6);
        radioGroup6.clearCheck();

        RadioGroup radioGroup7 = (RadioGroup)findViewById(R.id.radiogroup7);
        radioGroup7.clearCheck();

        RadioGroup radioGroup8 = (RadioGroup)findViewById(R.id.radiogroup8);
        radioGroup8.clearCheck();

        RadioGroup radioGroup9 = (RadioGroup)findViewById(R.id.radiogroup9);
        radioGroup9.clearCheck();

        RadioGroup radioGroup10 = (RadioGroup)findViewById(R.id.radiogroup10);
        radioGroup10.clearCheck();

        mLayout = (RelativeLayout) findViewById(R.id.quizRelativeLayout);
        answers = (TextView) findViewById(R.id.answersView);
        answerLine = (View) findViewById(R.id.answerLine);
        answers.setVisibility(View.GONE);
        answerLine.setVisibility(View.GONE);
        //mButton = (Button) findViewById(R.id.submitButton);
        //mButton.setOnClickListener(onClick());
        //TextView textView = new TextView(this);
        //textView.setText("New text");

        // Action listener for when the submit button is clicked
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Quiz.this, QuizAnswers.class));
                //Toast mytoast= Toast.makeText(getApplicationContext(), "Scroll down below 'Submit Quiz' button to see correct answers" , Toast.LENGTH_LONG);
                //Html.fromHtml("<font color='#e3f2fd' ><b>" + Scroll down below 'Submit Quiz' button to see correct answers+ "</b></font>")
               //mytoast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                //mytoast.getView().setBackgroundColor(Color.WHITE);
                //mytoast.setTextColor(Color.rgb(0, 132, 219));
                //mytoast.show();

                /*// Toast message code
                Context context = getApplicationContext();
                // Create layout inflator object to inflate toast.xml file
                LayoutInflater inflater = getLayoutInflater();

                // Call toast.xml file for toast layout
                View toast = inflater.inflate(R.layout.toast, null);

                Toast toast1 = new Toast(context);

                // Set layout to toast
                toast1.setView(toast);
                toast1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
                        0, 0);
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.show();*/

                answerLine.setVisibility(View.VISIBLE);
                answers.setVisibility(View.VISIBLE);
                //answers.requestFocus();

                int counterScore = 0;

                RadioButton question1Radio2 = (RadioButton)findViewById(R.id.question1Radio2);
                if(question1Radio2.isChecked()) {
                    Log.d("myTag", "q1r2 has been checked");
                    counterScore++;
                }

                RadioButton question2Radio3 = (RadioButton)findViewById(R.id.question2Radio3);
                if(question2Radio3.isChecked()) {
                    Log.d("myTag", "q2r3 has been checked");
                    counterScore++;
                }

                RadioButton question3Radio1 = (RadioButton)findViewById(R.id.question3Radio1);
                if(question3Radio1.isChecked()) {
                    Log.d("myTag", "q3r1 has been checked");
                    counterScore++;
                }

                RadioButton question4Radio4 = (RadioButton)findViewById(R.id.question4Radio4);
                if(question4Radio4.isChecked()) {
                    Log.d("myTag", "q4r4 has been checked");
                    counterScore++;
                }

                RadioButton question5Radio3 = (RadioButton)findViewById(R.id.question5Radio3);
                if(question5Radio3.isChecked()) {
                    Log.d("myTag", "q5r3 has been checked");
                    counterScore++;
                }

                RadioButton question6Radio2 = (RadioButton)findViewById(R.id.question6Radio2);
                if(question6Radio2.isChecked()) {
                    Log.d("myTag", "q6r2 has been checked");
                    counterScore++;
                }

                RadioButton question7Radio4 = (RadioButton)findViewById(R.id.question7Radio4);
                if(question7Radio4.isChecked()) {
                    Log.d("myTag", "q7r4 has been checked");
                    counterScore++;
                }

                RadioButton question8Radio2 = (RadioButton)findViewById(R.id.question8Radio2);
                if(question8Radio2.isChecked()) {
                    Log.d("myTag", "q8r2 has been checked");
                    counterScore++;
                }

                RadioButton question9Radio2 = (RadioButton)findViewById(R.id.question9Radio2);
                if(question9Radio2.isChecked()) {
                    Log.d("myTag", "q9r2 has been checked");
                    counterScore++;
                }

                RadioButton question10Radio3 = (RadioButton)findViewById(R.id.question10Radio3);
                if(question10Radio3.isChecked()) {
                    Log.d("myTag", "q10r3 has been checked");
                    counterScore++;
                }

                answers.setText("Answers:\n\n" +
                       String.format("You got %d out of 10 questions correct\n\n", counterScore) +
                        "1. Correct answer: B. Solenopsis invicta\n\n" +
                        "2. Correct answer: C. Red Imported Fire Ant\n\n" +
                        "3. Correct answer: A. Brazil\n\n" +
                        "4. Correct answer: D. Humans\n\n" +
                        "5. Correct answer: C. Polygyny\n\n" +
                        "6. Correct answer: B. Mobile, Alabama\n\n" +
                        "7. Correct answer: D. Pouring hot boiling water onto the mound\n\n" +
                        "8. Correct answer: B. Formic acid\n\n" +
                        "9. Correct answer: B. United States, Australia, China, Taiwan\n\n" +
                        "10. Correct answer: C. Phorid Fly\n");


                scrollView = (ScrollView) findViewById(R.id.scrollView);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //public void pressedSubmitButton() {
        //Button submitButton = (Button) findViewById(R.id.submitButton);
        //submitButton.setOnClickListener(new Button.OnClickListener() {
            //public void onClick(View v) {

            //}
        //});
    //}
}
