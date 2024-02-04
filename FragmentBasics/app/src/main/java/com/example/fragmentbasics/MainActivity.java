package com.example.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] DATA = new String[]{"QUIZ 1","QUIZ 2","QUIZ 3","QUIZ 4","QUIZ 5"};
    int QUIZ_COUNT = DATA.length;
    int currentPage = -1;

    TextView pageNumber;
    Button nextBtn,prevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageNumber = findViewById(R.id.pageNumber);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuiz();
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevQuiz();
            }
        });
    }
    public void nextQuiz(){
        currentPage += 1;
        if(currentPage >= QUIZ_COUNT-1){
            currentPage = QUIZ_COUNT-1;
        }

        String title = DATA[currentPage];

        createPage(title);
        updatePageCount();
    }
    public void prevQuiz(){
        currentPage -= 1;
        if(currentPage < 0){
            currentPage = 0;
        }

        String title = DATA[currentPage];

        createPage(title);
        updatePageCount();
    }

    public void createPage(String title){

//        1.create an fragment manager
//        2.Setup Transaction
//        3.Commit Transaction

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

//        create an fragment
        Quiz_Fragment quizFragment = Quiz_Fragment.getInstance(title);
//        add to transaction
        transaction.replace(R.id.quizContainer,quizFragment,title);

        transaction.commit();

    }

    public void updatePageCount(){
        String pageCount = "" + ( currentPage + 1 ) + "/" + QUIZ_COUNT;
        pageNumber.setText(pageCount);
    }

}