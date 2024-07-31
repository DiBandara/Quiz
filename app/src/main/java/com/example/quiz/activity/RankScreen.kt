package com.example.quiz.activity

import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quiz.R
import com.example.quiz.adapter.LeaderAdapter
import com.example.quiz.databinding.ActivityRankScreenBinding
import com.example.quiz.domain.useModel

class RankScreen : AppCompatActivity() {
    lateinit var binding: ActivityRankScreenBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRankScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window=this@RankScreen.window
        window.statusBarColor=ContextCompat.getColor(this@RankScreen,R.color.white)

        binding.apply {
            scoreTop1txt.text=loaddata().get(0).score.toString()
            scoreTop2Txt.text=loaddata().get(1).score.toString()
            scoreTop3Txt.text=loaddata().get(2).score.toString()
            textView2.text=loaddata().get(0).name
            textView4.text=loaddata().get(1).name
            textViewthirdname.text=loaddata().get(2).name

            val drawableResourcesId1:Int=binding.root.resources.getIdentifier(
                loaddata().get(0).pic, "drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourcesId1)
                .into(imageView1)
            val drawableResourcesId2:Int=binding.root.resources.getIdentifier(
                loaddata().get(1).pic, "drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourcesId2)
                .into(imageView)

            val drawableResourcesId3:Int=binding.root.resources.getIdentifier(
                loaddata().get(2).pic, "drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourcesId3)
                .into(imageView2)

            var list:MutableList<useModel> = loaddata()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager=LinearLayoutManager(this@RankScreen)
                adapter=leaderAdapter
            }

        }

        val batch3rd: ImageView = findViewById(R.id.imageviewthree);
        val batchone : ImageView = findViewById(R.id.imageviewone);
        val batch2nd : ImageView = findViewById(R.id.imageviewtwo);
        val coin: ImageView = findViewById(R.id.imageViewcoin);
        val crown: ImageView = findViewById(R.id.backbtn);
        batch3rd.setImageResource(R.drawable.batchthree);
        batchone.setImageResource(R.drawable.batchone);
        batch2nd.setImageResource(R.drawable.batchtwo);
        coin.setImageResource(R.drawable.coin);
        crown.setImageResource(R.drawable.crownicon);

    }

    private fun loaddata():MutableList<useModel>{
        val users : MutableList<useModel> = mutableListOf()
        users.add(useModel(1,"Sopia", "persiona1", 4888))
        users.add(useModel(1,"Sopia", "persiona1", 2569))
        users.add(useModel(1,"Sopia", "persiona1", 1245))
        users.add(useModel(1,"Sopia", "persiona1", 185))
        users.add(useModel(1,"Sopia", "persiona1", 320))
        users.add(useModel(1,"Sopia", "persiona1", 8741))
        return users
    }

}