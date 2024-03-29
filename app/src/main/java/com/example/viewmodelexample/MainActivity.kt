package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("check","onCreate")
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//        //Without ViewModel
//        binding.textView.text = "0"
//        binding.button.setOnClickListener {
//            binding.textView.text = (binding.textView.text.toString().toInt()+1).toString()
//        }

//        //With ViewModel for configurations changes like rotation,switching dark,light modes in phone settings
//        val viewModel:ViewModelDemo = ViewModelProvider(this).get(ViewModelDemo::class.java)
//        binding.textView.text = viewModel.num.toString()
//        binding.button.setOnClickListener {
//            viewModel.increment()
//            binding.textView.text = viewModel.num.toString()
//        }

//        //With MutableLiveData
//        val viewModel:ViewModelDemo = ViewModelProvider(this).get(ViewModelDemo::class.java)
//        viewModel.number.observe(this, Observer {
//            binding.textView.text = it.toString()
//        })
//        viewModel.str.observe(this, Observer {
//            binding.textView2.text = it
//        })
//        binding.button.setOnClickListener {
//            viewModel.increment()
//        }

        //With Immutable LiveData
        val viewModel:ViewModelDemo = ViewModelProvider(this).get(ViewModelDemo::class.java)
        viewModel.numberLiveData.observe(this, Observer {
            binding.textView.text = it.toString()
        })
        binding.button.setOnClickListener {
            viewModel.increment()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("check","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("check","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("check","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("check","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("check","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("check","onDestroy")
    }

}