package com.example.youtubeapi.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM: BaseViewModel, VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract fun inflateViewBinding(inflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initViews()
        initViewModel()
        initListener()
    }
    open fun checkInternet()  {} //Метод для проверки интернета
    open fun initViews() {} // Инициализация View
    open fun initListener(){}
    open fun  initViewModel(){} //Все обзерверы нашего viewModel() {
    open fun initView(){}
}