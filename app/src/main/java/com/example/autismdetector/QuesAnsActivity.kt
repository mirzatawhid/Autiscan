package com.example.autismdetector

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autismdetector.databinding.ActivityQuesAnsBinding

class QuesAnsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuesAnsBinding
    private var selectedByUser: Int? =null
    private var quesPos=0

    private lateinit var info: PatientInfo

    private val questions = listOf(
        Question("Does the patient often notice small sounds when others do not", listOf(1,1,0,0)),
        Question("Does the patient usually concentrate more on the whole picture, rather than the small details?",listOf(0,0,1,1)),
        Question("Does the patient find it easy to do more than one thing at once?",listOf(0,0,1,1)),
        Question("If there is an interruption, does the patient can switch back to what he/she was doing very quickly?",listOf(0,0,1,1)),
        Question("Does the patient  find it easy to ‘read between the lines’ when someone is talking to me?",listOf(0,0,1,1)),
        Question("Does the patient know how to tell if someone listening to me is getting bored ?",listOf(0,0,1,1)),
        Question("When the patient is reading a story he/she finds it difficult to work out the characters’ intentions?", listOf(1,1,0,0)),
        Question("Does the patient like to collect information about categories of things (e.g. types of car, types of bird, types of train, types of plant etc) ?", listOf(1,1,0,0)),
        Question("Does the patient find it easy to work out what someone is thinking or feeling just by looking at their face?",listOf(0,0,1,1)),
        Question("Does the patient find it difficult to work out people’s intentions?", listOf(1,1,0,0))
    )

    private var answer= IntArray(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuesAnsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        info = intent.getParcelableExtra<PatientInfo>("info")!!

        binding.numQues.text = "${quesPos+1} / ${questions.size}"
        binding.quesId.text = questions[quesPos].text

        binding.dAgreeOption.setOnClickListener{
            if (selectedByUser==null){
                selectedByUser = questions[quesPos].options[0]
                binding.dAgreeOption.setTextColor(Color.GRAY)
            }
        }

        binding.agreeOption.setOnClickListener{
            if (selectedByUser==null){
                selectedByUser = questions[quesPos].options[1]
                binding.agreeOption.setTextColor(Color.GRAY)
            }
        }

        binding.disagreeOption.setOnClickListener{
            if (selectedByUser==null){
                selectedByUser = questions[quesPos].options[2]
                binding.disagreeOption.setTextColor(Color.GRAY)
            }
        }

        binding.dDisagreeOption.setOnClickListener{
            if (selectedByUser==null){
                selectedByUser = questions[quesPos].options[3]
                binding.dDisagreeOption.setTextColor(Color.GRAY)
            }
        }

        binding.nextOption.setOnClickListener {
            if (selectedByUser==null){
                Toast.makeText(this,"Select an Answer",Toast.LENGTH_SHORT).show()
            }else{
                changeNextQues()
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun changeNextQues() {
        answer[quesPos]= selectedByUser!!
        quesPos++
        if ((quesPos + 1) == questions.size) {
            binding.nextOption.text = "Submit"
            selectedByUser = null
            binding.dAgreeOption.setTextColor(Color.BLACK)
            binding.agreeOption.setTextColor(Color.BLACK)
            binding.disagreeOption.setTextColor(Color.BLACK)
            binding.dDisagreeOption.setTextColor(Color.BLACK)

            binding.numQues.text = "${quesPos+1} / ${questions.size}"
            binding.quesId.text = questions[quesPos].text
        } else if (quesPos < questions.size) {
            selectedByUser = null
            binding.dAgreeOption.setTextColor(Color.BLACK)
            binding.agreeOption.setTextColor(Color.BLACK)
            binding.disagreeOption.setTextColor(Color.BLACK)
            binding.dDisagreeOption.setTextColor(Color.BLACK)

            binding.numQues.text = "${quesPos+1} / ${questions.size}"
            binding.quesId.text = questions[quesPos].text
        } else run {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("ans", answer)
            intent.putExtra("info",info)
            startActivity(intent)
            finish()
        }
    }
}