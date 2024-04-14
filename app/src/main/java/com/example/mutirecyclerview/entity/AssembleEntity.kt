package com.example.mutirecyclerview.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class AssembleEntity {
    @Parcelize
    data class TopModel(
        val name: String,
        val cardNumber: String,
        val validity: String,
        val currentMoney: String
    ): AssembleEntity(), Parcelable

    @Parcelize
    data class MiddleModel(
        val name: String,
        val cardNumber: String,
        val validity: String,
        val currentMoney: String
    ): AssembleEntity(), Parcelable

    @Parcelize
    data class BottomModel(
        val name: String,
        val cardNumber: String,
        val validity: String,
        val currentMoney: String
    ): AssembleEntity(), Parcelable
}