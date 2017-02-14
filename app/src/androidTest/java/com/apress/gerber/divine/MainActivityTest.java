package com.apress.gerber.divine;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    public static final String STRING_TO_BE_TYPED = "1019";



    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void listsGoesOver() {
        onView(withText("誕生日を入力")).check(matches(isDisplayed()));


    }

    @Test
    public  void activityResult(){
        Intent resultData = new Intent();
        String inputbirthday ="1019";
        resultData.putExtra("birthday",inputbirthday);
        Instrumentation.ActivityResult result
                = new Instrumentation.ActivityResult(Activity.RESULT_OK,resultData);


    }
//    @Test @Ignore
  //  public void click_test(){
     //   onView(withId(R.id.editText_birthday))
       //         .perform(typeText(STRING_TO_BE_TYPED),closeSoftKeyboard());
    //    onView(withId(R.id.activityChangeTextBtn)).perform(click());
      //  onView(withId(R.id.textName))
        //        .check(matches(withText(STRING_TO_BE_TYPED)));
    //}


}
