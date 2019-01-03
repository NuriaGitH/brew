package com.example.nuriaperalta.kotlinstart3.BeerDetailFragment

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue()
    }
}