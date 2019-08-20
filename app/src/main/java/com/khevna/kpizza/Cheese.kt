package com.khevna.kpizza

class Cheese {
    var cheeseType: String
    var isChecked: Boolean = false

    constructor(cheeseType: String) {
        this.cheeseType = cheeseType
    }

    constructor(cheeseType: String, isChecked: Boolean) {
        this.cheeseType = cheeseType
        this.isChecked = isChecked
    }
}
