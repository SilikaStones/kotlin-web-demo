/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.webdemo.test.completion;

import org.jetbrains.jet.lang.psi.JetFile;
import org.jetbrains.webdemo.JetPsiFactoryUtil;
import org.jetbrains.webdemo.responseHelpers.JsonResponseForCompletion;
import org.jetbrains.webdemo.session.SessionInfo;
import org.jetbrains.webdemo.test.BaseTest;
import org.jetbrains.webdemo.test.TestUtils;
import org.json.JSONException;

import java.io.IOException;

public class CompletionTest extends BaseTest {

    public void test$java$system() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"package\",\"name\":\"System\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"System : Object\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"SystemClassLoaderAction : PrivilegedExce...\",\"tail\":\"\"}]";
        compareResult(1, 6, expectedResult, "java");
    }

    public void test$java$out() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"property\",\"name\":\"out\",\"tail\":\"java.io.PrintStream\"}]";
        compareResult(1, 10, expectedResult, "java");
    }

    public void test$all$variable() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"property\",\"name\":\"stdin\",\"tail\":\"java.io.BufferedReader\"},{\"icon\":\"property\",\"name\":\"str\",\"tail\":\"kotlin.String\"}]";
        compareResult(14, 24, expectedResult, "java");
        compareResult(14, 24, expectedResult, "js");
    }

    public void test$all$class() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"class\",\"name\":\"Greeter : Any\",\"tail\":\"\"}]";
        compareResult(4, 3, expectedResult, "java");
        compareResult(4, 3, expectedResult, "js");
    }

    public void test$all$type$in$constructor() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"package\",\"name\":\"StrictMath\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StrictMath : Object\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"String : Comparable<String>, CharSequenc...\",\"tail\":\"\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray)\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray, charset : Char...\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray, charsetName : ...\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray, i : Int, i1 : ...\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray, offset : Int, ...\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(bytes : ByteArray, offset : Int, ...\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(chars : CharArray)\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(stringBuffer : StringBuffer)\",\"tail\":\"kotlin.String\"},{\"icon\":\"method\",\"name\":\"String(stringBuilder : StringBuilder)\",\"tail\":\"kotlin.String\"},{\"icon\":\"package\",\"name\":\"StringBuffer\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StringBuffer : AbstractStringBuilder<arg...\",\"tail\":\"\"},{\"icon\":\"package\",\"name\":\"StringBuilder\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StringBuilder : AbstractStringBuilder<ar...\",\"tail\":\"\"},{\"icon\":\"package\",\"name\":\"StringCoding\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StringCoding : Object\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StringIndexOutOfBoundsException : IndexO...\",\"tail\":\"\"},{\"icon\":\"package\",\"name\":\"StringValue\",\"tail\":\"\"},{\"icon\":\"class\",\"name\":\"StringValue : Object\",\"tail\":\"\"}]";
        compareResult(12, 28, expectedResult, "java");
        compareResult(12, 28, expectedResult, "js");
    }

    public void test$java$println() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"method\",\"name\":\"print(p0 : Any?)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Boolean)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Char)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : CharArray)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Double)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Float)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Int)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : Long)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"print(p0 : String?)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"printf(p0 : Locale?, p1 : String, p2 : A...\",\"tail\":\"java.io.PrintStream\"},{\"icon\":\"method\",\"name\":\"printf(p0 : String, p1 : Array<Any?>)\",\"tail\":\"java.io.PrintStream\"},{\"icon\":\"method\",\"name\":\"println()\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Any?)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Boolean)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Char)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : CharArray)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Double)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Float)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Int)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : Long)\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"println(p0 : String?)\",\"tail\":\"kotlin.Unit\"}]";

        compareResult(1, 15, expectedResult, "java");
    }

    public void test$js$a() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"package\",\"name\":\"annotation\",\"tail\":\"\"},{\"icon\":\"genericValue\",\"name\":\"args : Array<String>\",\"tail\":\"kotlin.Array<kotlin.String>\"},{\"icon\":\"method\",\"name\":\"array(t : Array<T>)\",\"tail\":\"kotlin.Array<T>\"},{\"icon\":\"method\",\"name\":\"arrayList(values : Array<T>)\",\"tail\":\"java.util.ArrayList<T>\"},{\"icon\":\"method\",\"name\":\"arrayListOf(values : Array<T>)\",\"tail\":\"java.util.ArrayList<T>\"},{\"icon\":\"method\",\"name\":\"arrayOfNulls(size : Int)\",\"tail\":\"kotlin.Array<T?>\"},{\"icon\":\"method\",\"name\":\"assert(value : Boolean, lazyMessage : Fu...\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"assert(value : Boolean, message : Any)\",\"tail\":\"kotlin.Unit\"}]";

        compareResult(2, 3, expectedResult, "js");
    }

    public void test$kt$a() throws IOException, JSONException {
        String expectedResult = "[{\"icon\":\"package\",\"name\":\"annotation\",\"tail\":\"\"},{\"icon\":\"genericValue\",\"name\":\"args : Array<String>\",\"tail\":\"kotlin.Array<kotlin.String>\"},{\"icon\":\"method\",\"name\":\"array(t : Array<T>)\",\"tail\":\"kotlin.Array<T>\"},{\"icon\":\"method\",\"name\":\"arrayList(values : Array<T>)\",\"tail\":\"java.util.ArrayList<T>\"},{\"icon\":\"method\",\"name\":\"arrayListOf(values : Array<T>)\",\"tail\":\"java.util.ArrayList<T>\"},{\"icon\":\"method\",\"name\":\"arrayOfNulls(size : Int)\",\"tail\":\"kotlin.Array<T?>\"},{\"icon\":\"method\",\"name\":\"assert(value : Boolean, lazyMessage : Fu...\",\"tail\":\"kotlin.Unit\"},{\"icon\":\"method\",\"name\":\"assert(value : Boolean, message : Any)\",\"tail\":\"kotlin.Unit\"}]";
        compareResult(2, 3, expectedResult, "java");
    }

    private void compareResult(int start, int end, String expectedResult, String runConfiguration) throws IOException, JSONException {
        sessionInfo.setType(SessionInfo.TypeOfRequest.COMPLETE);
        sessionInfo.setRunConfiguration(runConfiguration);
        JetFile currentPsiFile = JetPsiFactoryUtil.createFile(getProject(), TestUtils.getDataFromFile(TestUtils.TEST_SRC, "completion/root.kt"));

        JsonResponseForCompletion responseForCompletion = new JsonResponseForCompletion(start, end, currentPsiFile, sessionInfo);
        String actualResult = responseForCompletion.getResult();
        /*JSONArray expectedArray = new JSONArray(expectedResult);
        JSONArray actualArray = new JSONArray(actualResult);

//        assertEquals(expectedResult, actualResult);

        assertEquals("Incorrect count of objects in completion", expectedArray.length(), actualArray.length());


        for (int i = 0; i < expectedArray.length(); i++) {
            JSONObject expectedObject = (JSONObject) expectedArray.get(i);
            for (int j = 0; j < actualArray.length(); j++) {
                if (expectedObject.get("name").equals(((JSONObject) actualArray.get(j)).get("name"))) {
                    assertEquals(expectedObject.toString(), actualArray.get(j).toString());
                    break;
                } else {
                    if (j == actualArray.length() - 1) {
                        assertEquals("Cannot find element for " + expectedObject.toString(), true, false);
                    }
                }
            }
        }*/

        assertEquals("Wrong result: " + start + ", " + end, expectedResult, actualResult);
    }

}
