package com.example.jsonparsingapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
class FormListActivityTest {
    @Rule
    @get: Rule
    val mNavigationActivity = ActivityTestRule(HomeActivity::class.java, true, false)

    @Test
    @Throws(Exception::class)
    fun testFragmentLaunch() {
        onView(withId(R.id.error_txt))
            .check(matches(withText("4")))
    }
}