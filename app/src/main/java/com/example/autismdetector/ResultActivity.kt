package com.example.autismdetector

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.autismdetector.databinding.ActivityResultBinding
import com.example.autismdetector.model.ASDRequest
import com.example.autismdetector.model.ASDResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.retryBtn.setOnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val ans = intent.getIntArrayExtra("ans")
        val info = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("info",PatientInfo::class.java)
        } else {
            intent.getParcelableExtra<PatientInfo>("info")
        }

        Log.d("dataflow", "onCreate: "+info+ " \n ans: "+ans!![9])

        // Example input data
        val requestData = ASDRequest(
            A1_Score = ans[0], A2_Score = ans[1], A3_Score = ans[2], A4_Score = ans[3], A5_Score = ans[4],
            A6_Score = ans[5], A7_Score = ans[6], A8_Score = ans[7], A9_Score = ans[8], A10_Score = ans[9],
            age = info!!.age, result = ans.sum(), gender = info.gender, ethnicity = info.ethnicity,
            jundice = info.jaundice, austim = info.autism, contry_of_res = info.country,
            used_app_before = info.app, relation = info.relation
        )

        // Call API
        RetrofitClient.instance.predictASD(requestData)
            .enqueue(object : Callback<ASDResponse> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<ASDResponse>, response: Response<ASDResponse>) {
                    if (response.isSuccessful) {
                        val risk = response.body()?.ASD_Risk
                        if(risk!!<0.5){
                            binding.detectTv.text = "NOT\nDETECTED"
                            binding.detectTv.setTextColor(Color.GREEN)
                        }else{
                            binding.detectTv.text = "DETECTED"
                            binding.detectTv.setTextColor(Color.RED)
                        }
                        val percentage = (risk * 100).toInt()
                        binding.percentageId.text = "${percentage}%"
                    } else {
                        Log.d("API Error", "onResponse: "+response.errorBody()?.string())
                        Toast.makeText(this@ResultActivity, "API Error: ${response.errorBody()?.string()}", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ASDResponse>, t: Throwable) {
                    Log.d("Network Error", "onResponse: "+t.message)
                    Toast.makeText(this@ResultActivity, "Network Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })

    }
}