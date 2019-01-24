package com.example.rviciana.inngame.domain.bo

import io.realm.RealmObject

data class Resources(
        val metal: Int,
        val fibre: Int,
        val gasoline: Int
): RealmObject()