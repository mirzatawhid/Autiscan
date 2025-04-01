package com.example.autismdetector

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import com.example.autismdetector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextbutton.setOnClickListener {
            if (validateInputs()) {
                //saveToViewModel()

                val info = PatientInfo(binding.ageEt.text.toString().toInt(),
                    when (binding.genderRadioGroup.checkedRadioButtonId) {
                        binding.maleRadioBtn.id -> "m"
                        binding.femaleRadioBtn.id -> "f"
                        else -> ""
                    },
                    binding.ethnicityMenu.editText?.text.toString(),
                    when (binding.jaundiceRadioGroup.checkedRadioButtonId) {
                        binding.yesRadioBtn.id -> "yes"
                        binding.noRadioBtn.id -> "no"
                        else -> ""
                    },
                    when (binding.autismRadioGroup.checkedRadioButtonId) {
                        binding.yesAutismRadioBtn.id -> "yes"
                        binding.noAutismRadioBtn.id -> "no"
                        else -> ""
                    },
                    binding.countryMenu.editText?.text.toString(),
                    when (binding.appUsedRadioGroup.checkedRadioButtonId) {
                        binding.yesAppUsedRadioBtn.id -> "yes"
                        binding.noAppUsedRadioBtn.id -> "no"
                        else -> ""
                    },
                    when (binding.relationRadioGroup.checkedRadioButtonId) {
                        binding.yesRelationRadioBtn.id -> "Self"
                        binding.noRelationRadioBtn.id -> "Parent"
                        binding.otherRelationRadioBtn.id -> "Others"
                        else -> ""
                    })

                Log.d("infop", "onCreate: "+info)

                // Navigate to the next screen or perform the next action
                Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,QuesAnsActivity::class.java)
                intent.putExtra("info",info)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateInputs(): Boolean {
        // Validate Age
        if (binding.ageEt.text.isNullOrEmpty()) {
            Toast.makeText(this, "Age is required", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Gender
        if (binding.genderRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Ethnicity
        if (binding.ethnicityMenu.editText?.text.isNullOrEmpty()) {
            Toast.makeText(this, "Ethnicity is required", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Jaundice
        if (binding.jaundiceRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select jaundice status", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Autism Diagnosis
        if (binding.autismRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select autism diagnosis status", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Country
        if (binding.countryMenu.editText?.text.isNullOrEmpty()) {
            Toast.makeText(this, "Country is required", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate App Usage
        if (binding.appUsedRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select app usage status", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate Relation
        if (binding.relationRadioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select who made the answers", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

//    private fun saveToViewModel() {
//        // Save Age
//        autismViewModel.setAge(binding.ageEt.text.toString().toInt())
//
//        // Save Gender
//        val gender = when (binding.genderRadioGroup.checkedRadioButtonId) {
//            binding.maleRadioBtn.id -> "m"
//            binding.femaleRadioBtn.id -> "f"
//            else -> ""
//        }
//        autismViewModel.setGender(gender)
//
//        // Save Ethnicity
//        autismViewModel.setEthnicity(binding.ethnicityMenu.editText?.text.toString())
//
//        // Save Jaundice
//        val jaundice = when (binding.jaundiceRadioGroup.checkedRadioButtonId) {
//            binding.yesRadioBtn.id -> "yes"
//            binding.noRadioBtn.id -> "no"
//            else -> ""
//        }
//        autismViewModel.setJaundice(jaundice)
//
//        // Save Autism Diagnosis
//        val autismDiagnosis = when (binding.autismRadioGroup.checkedRadioButtonId) {
//            binding.yesAutismRadioBtn.id -> "yes"
//            binding.noAutismRadioBtn.id -> "no"
//            else -> ""
//        }
//        autismViewModel.setAutism(autismDiagnosis)
//
//        // Save Country
//        autismViewModel.setCountry(binding.countryMenu.editText?.text.toString())
//
//        // Save App Usage
//        val appUsage = when (binding.appUsedRadioGroup.checkedRadioButtonId) {
//            binding.yesAppUsedRadioBtn.id -> "yes"
//            binding.noAppUsedRadioBtn.id -> "no"
//            else -> ""
//        }
//        autismViewModel.setApp(appUsage)
//
//        // Save Relation
//        val relation = when (binding.relationRadioGroup.checkedRadioButtonId) {
//            binding.yesRelationRadioBtn.id -> "Self"
//            binding.noRelationRadioBtn.id -> "Parent"
//            binding.otherRelationRadioBtn.id -> "Others"
//            else -> ""
//        }
//        autismViewModel.setRelation(relation)
//    }
}
