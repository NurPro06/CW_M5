package com.example.cw_m5

class CounterPresenter {

    private val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract) {
        this.contract = contract
        updateUI()

    }
    fun detachContract() {
        contract = null

    }



    fun onIncrement(){
        model.increment()
       updateUI()
    }

    private fun updateUI() {
        contract?.apply {
            showCount(model.getResult())

            when {
                model.isCountFifteen() -> setGreenTextColor()
                else -> resetTextColor()
            }

            if (model.isCountTen()) {
                showCongratulations()
            }
        }
    }

    fun onDecrement() {
        model.decrement()
        updateUI()

    }

}