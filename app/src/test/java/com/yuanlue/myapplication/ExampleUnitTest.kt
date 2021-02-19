package com.yuanlue.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        getS({
            print("before================")
        },{
            print("after================")
        })
    }

    inline fun getS(before: () -> Unit,noinline after: () -> Unit) {
        before()
        print("================")
        after()
        printS(after)
    }

    fun printS(after: () -> Unit){
        after()
        print("---------------")
    }
}