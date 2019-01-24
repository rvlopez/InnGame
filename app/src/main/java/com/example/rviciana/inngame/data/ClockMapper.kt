package com.example.rviciana.inngame.data

import java.util.concurrent.TimeUnit

class ClockMapper {

    fun map(time: Long): String = String.format("%02d:%02d:%02d",
            TimeUnit.SECONDS.toHours(time),
            TimeUnit.SECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(time)),
            TimeUnit.SECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(time)))
}