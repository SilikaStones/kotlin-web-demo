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

/**
 * Created with IntelliJ IDEA.
 * User: Natalia.Ukhorskaya
 * Date: 3/30/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */


var ProblemsView = (function () {

    function ProblemsView() {

        var instance = {
            processHighlighting:function (status, data) {
                if (status) updateProblemView(data);
            },
            clear: function() {
                $("#problems").html("");
            }/*,
            processOutput: function(status, data) {
                if (!status && data == "errors") {
                    $("#tabs").tabs("select", 0);
                }
            }*/
        };


        return instance;
    }

    function updateProblemView(data) {
        $("#problems").html("");
        $("#tabs").tabs("select", 0);
        var i = 0;
        var problems = document.createElement("div");

        function processError(i, p, f) {
            if (typeof data[i] == "undefined") {
                if (i > 0) {
                }
                $("#problems").html(problems.innerHTML);
                return;
            }

            var title = unEscapeString(data[i].titleName);
            var start = eval('(' + data[i].x + ')');
            var severity = data[i].severity;

            var problem = createElementForProblemView(severity, start, title);
            p.appendChild(problem);
            i++;

            setTimeout(function (i, problems) {
                return function () {
                    f(i, problems, processError);
                }
            }(i, problems), 10);
        }

        processError(i, problems, processError);
    }

    function createElementForProblemView(severity, start, title) {
        var p = document.createElement("p");
        var img = document.createElement("img");
        if (severity == 'WARNING') {
            img.src = "/static/icons/warning.png";
            if (title.indexOf("is never used") > 0) {
                p.className = "problemsViewWarningNeverUsed";
            } else {
                p.className = "problemsViewWarning";
            }

        } else if (severity == 'STACKTRACE') {
            p.className = "problemsViewStacktrace";
        } else {
            img.src = "/static/icons/error.png";
            p.className = "problemsViewError";
        }
        p.appendChild(img);
        var titleDiv = document.createElement("span");
        if (start == null) {
            titleDiv.innerHTML = " " + unEscapeString(title);
        } else {

            titleDiv.innerHTML = "(" + (start.line + 1) + ", " + (start.ch + 1) + ") : " + unEscapeString(title);
        }
        p.appendChild(titleDiv);
        return p;
    }

    return ProblemsView;
})();