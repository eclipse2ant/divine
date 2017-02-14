package com.apress.gerber.divine;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.apress.gerber.divine.R.id.textName;


/**
 * Created by hiroko on 2016/12/13.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SubActivityTest {

    public static final String TO_BE_TYPED_NAME = "hiroko";
    public SubActivity subActivity;


    @Rule
    public ActivityTestRule<SubActivity> sActivityRule = new ActivityTestRule(SubActivity.class);

    @Test
    public void name(){
        subActivity = sActivityRule.getActivity();




        //  subActivity.setname(TO_BE_TYPED_NAME);
       // TextView textName = (TextView) subActivity.findViewById(R.id.textName);

       // onView(withId(textName))
            //    .check(matches(withText(TO_BE_TYPED_NAME)));
    }



}
