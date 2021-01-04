package me.hgj.jetpackmvvm.callback.databind

import androidx.databinding.ObservableField

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   自定义的Byte类型 ObservableField  提供了默认值，避免取值的时候还要判空
 */
class ByteObservableField(value: Byte = 0) : ObservableField<Byte>(value) {

    override fun get(): Byte {
        return super.get()!!
    }

}