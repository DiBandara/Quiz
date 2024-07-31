package com.example.quiz.activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.R
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.domain.QuestionModel
import com.google.android.material.bottomnavigation.BottomNavigationMenuView


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.white)

        binding.apply {

            singleBtn.setOnClickListener{
                val intent=Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("List",ArrayList(questionList()))
                startActivity(intent)
            }
        }

        val imageView23: ImageView = findViewById(R.id.imageView23)

        imageView23.setOnClickListener {
            val intent = Intent(this, RankScreen::class.java)
            startActivity(intent)
        }

        val imageView24: ImageView = findViewById(R.id.imageView24)

        imageView24.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }


    }

    //question list and for example that i can get api service
    private fun questionList(): MutableList<QuestionModel> {
        val questions: MutableList<QuestionModel> = mutableListOf()
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        questions.add(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            )


        )
        return questions




    }
}