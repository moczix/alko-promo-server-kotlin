package com.moczix.alkohunters.app.utils

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties

class Validator {

    inline fun < reified T : Any> isValid(target: T, rules: HashMap<String, String>, messages: HashMap<String, String>) {
        T::class.memberProperties
                .filter{ it.visibility == KVisibility.PUBLIC }
                .forEach {
                    println("${it.name} = ${it.get(target)}")
                }
    }

}