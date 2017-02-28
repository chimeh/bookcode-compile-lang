package com.bigshoulders.JunitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({AddBookTest.class,AddBookViewTest.class,BookTest.class,FindABookTest.class,FindABookViewTest.class,LibPerfTest.class,LibraryTest.class,LibraryViewTest.class})

public class AllTests {

}
