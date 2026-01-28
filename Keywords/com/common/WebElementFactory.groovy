package com.common

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

class WebElementFactory {

    TestObject css(String selector) {
        TestObject to = new TestObject(selector)
        to.addProperty('css', ConditionType.EQUALS, selector)
        return to
    }

    TestObject xpath(String xp) {
        TestObject to = new TestObject(xp)
        to.addProperty('xpath', ConditionType.EQUALS, xp)
        return to
    }
}
