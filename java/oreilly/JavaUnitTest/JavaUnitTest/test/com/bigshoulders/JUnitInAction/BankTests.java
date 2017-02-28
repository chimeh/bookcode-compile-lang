package com.bigshoulders.JUnitInAction;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({AccountTest.class,BankTest.class,OwnerTest.class})

public class BankTests {

}
