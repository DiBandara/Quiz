package com.example.quiz.activity

import android.content.Intent
import android.os.Bundle

import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.quiz.R
import com.example.quiz.adapter.QuestionAdapter
import com.example.quiz.databinding.ActivityQuestionBinding
import com.example.quiz.domain.QuestionModel

class QuestionActivity : AppCompatActivity(),QuestionAdapter.score {
    private lateinit var binding: ActivityQuestionBinding
    var position:Int=0
    var receivedList : MutableList<QuestionModel> = mutableListOf()
    var allScore=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuestionBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val window: Window = this@QuestionActivity.window
        window.statusBarColor = ContextCompat.getColor(this@QuestionActivity, R.color.white)

        receivedList = intent.getParcelableArrayListExtra<QuestionModel>("List")!!.toMutableList()
        binding.apply {
            backbtn.setOnClickListener { finish() }
            progressBar.progress = 1

            questionTxt.text = receivedList[position].question
            val drawableResourceId: Int = binding.root.resources.getIdentifier(
                receivedList[position].picPath,
                "drawable", binding.root.context.packageName
            )
            Glide.with(this@QuestionActivity)

                .load(drawableResourceId)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                .into(pic)

            loadAnswers()

            rightArrow.setOnClickListener{
                if(progressBar.progress==10){
                    val intent=Intent(this@QuestionActivity,ScoreActivity::class.java)
                    intent.putExtra("Score",allScore)
                    startActivity(intent)
                    finish()
                    return@setOnClickListener
                }
                position++
                progressBar.progress=progressBar.progress + 1
                questionNumberTxt.text="Question"+ progressBar.progress + "/10"
                questionTxt.text=receivedList[position].question

                val drawableResourceId:Int=binding.root.resources.getIdentifier(
                    receivedList[position].picPath,"drawable",binding.root.context.packageName
                )
                Glide.with(this@QuestionActivity)

                    .load(drawableResourceId)
                    .centerCrop()
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                    .into(pic)

                loadAnswers()

            }
            leftArrow.setOnClickListener{
                if(progressBar.progress==1){
                    return@setOnClickListener
                }
                position--

                progressBar.progress=progressBar.progress - 1
                questionNumberTxt.text="Question"+ progressBar.progress + "/10"
                questionTxt.text=receivedList[position].question

                val drawableResourceId:Int=binding.root.resources.getIdentifier(
                    receivedList[position].picPath,"drawable",binding.root.context.packageName
                )
                Glide.with(this@QuestionActivity)

                    .load(drawableResourceId)
                    .centerCrop()
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                    .into(pic)

                loadAnswers()

            }
        }

    }
    private fun loadAnswers(){
        val users:MutableList<String> = mutableListOf()

        users.add(receivedList[position].answer_1.toString())
        users.add(receivedList[position].answer_2.toString())
        users.add(receivedList[position].answer_3.toString())
        users.add(receivedList[position].answer_4.toString())

        if (receivedList[position].clickedAnswer != null) users.add(receivedList[position].clickedAnswer.toString())

        val questionAdapter by lazy{
            QuestionAdapter(
                receivedList[position].clickedAnswer.toString(),users,this
            )

        }
        questionAdapter.differ.submitList(users)
        binding.questionList.apply {
            layoutManager=LinearLayoutManager(this@QuestionActivity)
            adapter = questionAdapter
        }
    }

    override fun amount(number: Int, clickedAnswer: String) {
        allScore+=number
        receivedList[position].clickedAnswer=clickedAnswer
    }
}