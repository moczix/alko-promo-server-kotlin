package com.moczix.alkohunters.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.TimeZone
import javax.annotation.PostConstruct


@SpringBootApplication
class AlkoHuntersApplication


fun main(args: Array<String>) {
    runApplication<AlkoHuntersApplication>(*args)
}
