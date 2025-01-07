package com.example.cw_m5

class CounterPresenter {

    private val model = CounterModel()
    private var contract : CounterContract? = null

    fun attachContract(counter: CounterContract){
        this.contract = counter
        contract?.showCount(model.getResult())
    }

    fun onIncrement(){
        model.increment()
        contract?.showCount(model.getResult())
    }
    fun onDecrement(){
        model.decrement()
        contract?.showCount(model.getResult())
    }
    fun detachContract(){
        contract = null
    }
}