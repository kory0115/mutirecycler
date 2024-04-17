package com.example.mutirecyclerview.repository

import com.example.mutirecyclerview.entity.AssembleEntity
import java.text.DecimalFormat

class AssembleRepository {

    private val itemList = ArrayList<AssembleEntity>()
    private val decimal2 = DecimalFormat("#,###.00")


    fun getAll() : List<AssembleEntity> {
        itemList.add(AssembleEntity.TopModel(name = "Anderson", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
        itemList.add(AssembleEntity.MiddleModel(name = "Andrew", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
        itemList.add(AssembleEntity.BottomModel(name = "SMITH", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
        return itemList
    }

    private fun resultView(s : String) : String{
        var re : String = ""
        val result: Array<String> = s.toCharArray().map { it.toString() }.toTypedArray()
        for(i in result.indices) {
            re += result[i]
            if(i == 1) {
                re += "/"
            }
        }
        return re
    }

    private fun cardNumberView(s : String) : String {
        var card : String = ""
        val result: Array<String> = s.toCharArray().map { it.toString() }.toTypedArray()
        for(i in result.indices) {
            card += result[i]
            if(i == 3 || i == 7 || i == 11 || i == 15) {
                card += "  "
            }
        }
        return card
    }
}