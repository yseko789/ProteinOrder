package com.yseko.proteinorder.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_GRAM = 2.00
private const val PRICE_SAME_DAY = 3.00

class OrderViewModel: ViewModel() {
    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private val _amount = MutableLiveData<Int>()
    val amount: LiveData<Int> = _amount

    val dateOptions: List<String> = getPickupOptions()

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    init{
        resetOrder()
    }

    fun resetOrder(){
        _flavor.value = ""
        _amount.value = 0
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    fun setFlavor(orderFlavor: String){
        _flavor.value = orderFlavor
    }

    fun setAmount(orderAmount: Int){
        _amount.value = orderAmount
        updatePrice()
    }

    fun setDate(orderDate: String){
        _date.value = orderDate
        updatePrice()
    }

    fun setPrice(orderPrice: Double){
        _price.value = orderPrice
    }

    fun updatePrice(){
        var calculatedPrice = (amount.value?:0) * PRICE_PER_GRAM
        if(dateOptions[0] == _date.value){
            calculatedPrice += PRICE_SAME_DAY
        }
        _price.value = calculatedPrice
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }
}