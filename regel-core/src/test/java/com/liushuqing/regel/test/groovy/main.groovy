package com.liushuqing.regel.test.groovy

/**
 * Created by liushuqing on 2017/8/14.
 */

app = new GroovyActionScript();
app.name = "i'm your father";
app.ids = [1, 2, 3, 4, 5]
app.hello();
for (int i = 0; i < 4; i++) {
    println("i:" + i);
}
assert app instanceof GroovyActionScript

def javaCode = "println(\"fuck you\");"