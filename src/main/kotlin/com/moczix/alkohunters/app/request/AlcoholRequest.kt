package com.moczix.alkohunters.app.request

data class UpdateAlcohol(
        val rules: HashMap<String, String> = hashMapOf(
                "name" to "required|string|min:3",
                "capacity" to "required|integer",
                "voltage" to "required|numeric",
                "selectedTags" to "array",
                "accepted" to "required|boolean"
        ),
        val messages: HashMap<String, String> = hashMapOf(
                "name.required" to "Nazwa alkoholu wymagana",
                "name.string" to "Nazwa musi byc ciągiem znaków",
                "name.min" to "Nazwa musi zawierać minimum 3 znaki",
                "voltage.required" to "Procent alkoholu wymagany",
                "voltage.numeric" to "Procent alkoholu musi być liczbą",
                "capacity.required" to "Pojemność wymagana",
                "capacity.integer" to "Pojemność musi być liczbą",
                "selectedTags" to "Tagi muszą być tablicą"
        )
)