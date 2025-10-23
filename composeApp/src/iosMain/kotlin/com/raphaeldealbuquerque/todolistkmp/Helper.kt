package com.raphaeldealbuquerque.todolistkmp

import com.raphaeldealbuquerque.todolistkmp.injection.appModule
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule)
    }
}