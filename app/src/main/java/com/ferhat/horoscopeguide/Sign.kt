package com.ferhat.horoscopeguide

import java.io.Serializable

data class Sign(
    var zodiacIcon: Int,
    var zodiacName: String,
    var zodiacDate: String,
    var zodiacGroup: String,
    var zodiacBanner: Int,
    var zodiacDescription: String
): Serializable