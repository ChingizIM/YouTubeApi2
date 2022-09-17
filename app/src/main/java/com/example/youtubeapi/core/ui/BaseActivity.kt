package com.example.youtubeapi.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM: BaseViewModel, VB: ViewBinding> : AppCompatActivity() {
    protected  lateinit var binding : VB
    protected abstract val  viewModel : VM

    protected abstract fun inflateViewBinding(inflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        checkInternet()
        initView()
        initViewModel()
        initListener()

    }
    open fun initView(){}
    open fun initListener(){}
    open fun checkInternet()  {} //Метод для проверки интернета
    open fun initViews() {} // Инициализация View
    open fun  initViewModel(){} //Все обзерверы нашего viewModel() {

}